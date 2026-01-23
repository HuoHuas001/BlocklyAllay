package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.TrKeys
import org.allaymc.api.message.I18n
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Engine
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.ConcurrentHashMap
import kotlin.io.path.exists
import kotlin.io.path.extension
import kotlin.io.path.name
import kotlin.io.path.readText

/**
 * 使用GraalJS管理JavaScript脚本的执行。
 * 处理Blockly生成的脚本的加载、执行和生命周期管理。
 */
class ScriptManager(private val plugin: BlocklyAllay) {

    val scriptsDir: Path = plugin.pluginContainer.dataFolder().resolve("scripts")
    private val loadedScripts = ConcurrentHashMap<String, LoadedScript>()

    // 共享引擎实例，提高性能
    private val engine: Engine = Engine.newBuilder()
        .option("engine.WarnInterpreterOnly", "false")
        .build()

    val loadedScriptNames: Set<String>
        get() = loadedScripts.keys

    /**
     * 初始化脚本管理器，创建目录并加载所有脚本。
     */
    fun init() {
        if (!scriptsDir.exists()) {
            Files.createDirectories(scriptsDir)
            plugin.pluginLogger.info(I18n.get().tr(TrKeys.SCRIPT_DIR_CREATED, scriptsDir))
        }
        loadAllScripts()
    }

    /**
     * 从脚本目录加载所有.js文件。
     */
    fun loadAllScripts() {
        Files.list(scriptsDir).use { paths ->
            paths.filter { it.extension == "js" }
                .forEach { loadScript(it) }
        }
    }

    /**
     * 加载单个脚本文件。
     */
    fun loadScript(scriptPath: Path) {
        val scriptName = scriptPath.name

        try {
            if (loadedScripts.containsKey(scriptName)) {
                unloadScript(scriptName)
            }

            // 创建GraalJS上下文
            val cx = Context.newBuilder("js")
                .engine(engine)
                .allowAllAccess(true)
                .build()

            // 为此脚本创建API实例
            val api = AllayScriptAPI(plugin)

            // 先用默认的脚本名创建logger，这样脚本执行时就可以使用
            val defaultPluginName = scriptName.removeSuffix(".js")
            api.registerPlugin(defaultPluginName, "1.0.0", "Unknown")

            // 绑定API到全局对象
            val bindings = cx.getBindings("js")
            bindings.putMember("allay", api)
            bindings.putMember("console", ConsoleAPI(plugin))

            // 将脚本的专属logger暴露给JavaScript上下文
            api.getLogger()?.let { logger ->
                bindings.putMember("logger", logger)
            }

            // 设置API的context以便回调执行
            api.setContext(cx)

            // 读取并执行脚本
            val scriptContent = scriptPath.readText()
            cx.eval("js", scriptContent)

            // 存储已加载的脚本
            val loadedScript = LoadedScript(scriptName, scriptPath, cx, api)
            loadedScripts[scriptName] = loadedScript

            // 如果定义了onLoad则调用
            callScriptFunction(cx, "onLoad")

            plugin.pluginLogger.info(I18n.get().tr(TrKeys.SCRIPT_LOADED, scriptName))

        } catch (e: Exception) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.SCRIPT_ERROR_LOAD, scriptName), e)
        }
    }

    /**
     * 按名称卸载脚本。
     */
    fun unloadScript(scriptName: String) {
        loadedScripts.remove(scriptName)?.let { script ->
            try {
                callScriptFunction(script.context, "onUnload")
                script.api.cleanup()
                script.context.close()
                plugin.pluginLogger.info(I18n.get().tr(TrKeys.SCRIPT_UNLOADED, scriptName))
            } catch (e: Exception) {
                plugin.pluginLogger.error(I18n.get().tr(TrKeys.SCRIPT_ERROR_UNLOAD, scriptName), e)
            }
        }
    }

    /**
     * 启用所有已加载的脚本(调用onEnable)。
     */
    fun enableAllScripts() {
        loadedScripts.values.forEach { script ->
            callScriptFunction(script.context, "onEnable")
        }
    }

    /**
     * 禁用所有已加载的脚本(调用onDisable)。
     */
    fun disableAllScripts() {
        loadedScripts.values.forEach { script ->
            callScriptFunction(script.context, "onDisable")
        }
    }

    /**
     * 加载指定名称的脚本
     * @param scriptName 脚本文件名（如 "test.js"）
     * @return 是否加载成功
     */
    fun loadScriptByName(scriptName: String): Boolean {
        val scriptPath = scriptsDir.resolve(scriptName)
        if (!scriptPath.exists()) {
            plugin.pluginLogger.warn(I18n.get().tr(TrKeys.SCRIPT_ERROR_NOTFOUND, scriptName))
            return false
        }
        loadScript(scriptPath)
        return true
    }

    /**
     * 卸载指定名称的脚本
     * @param scriptName 脚本名称
     * @return 是否卸载成功
     */
    fun unloadScriptByName(scriptName: String): Boolean {
        if (!loadedScripts.containsKey(scriptName)) {
            plugin.pluginLogger.warn(I18n.get().tr(TrKeys.SCRIPT_ERROR_NOTLOADED, scriptName))
            return false
        }
        unloadScript(scriptName)
        return true
    }

    /**
     * 重载单个脚本
     * @param scriptName 脚本名称
     * @return 是否重载成功
     */
    fun reloadScript(scriptName: String): Boolean {
        if (!loadedScripts.containsKey(scriptName)) {
            plugin.pluginLogger.warn(I18n.get().tr(TrKeys.SCRIPT_ERROR_NOTLOADED, scriptName))
            return false
        }
        val scriptPath = scriptsDir.resolve(scriptName)
        if (!scriptPath.exists()) {
            plugin.pluginLogger.warn(I18n.get().tr(TrKeys.SCRIPT_ERROR_NOTFOUND, scriptName))
            return false
        }
        loadScript(scriptPath)  // loadScript 内部会先卸载再加载
        return true
    }

    /**
     * 重载所有脚本
     */
    fun reloadAllScripts() {
        loadedScripts.keys.toList().forEach { scriptName ->
            reloadScript(scriptName)
        }
    }

    /**
     * 关闭脚本管理器。
     */
    fun shutdown() {
        disableAllScripts()
        loadedScripts.values.forEach { script ->
            try {
                callScriptFunction(script.context, "onUnload")
                script.api.cleanup()
                script.context.close()
            } catch (e: Exception) {
                plugin.pluginLogger.error(I18n.get().tr(TrKeys.SCRIPT_ERROR_CLOSE, script.name), e)
            }
        }
        loadedScripts.clear()
        engine.close()
    }

    /**
     * 如果脚本中存在该函数则调用。
     */
    private fun callScriptFunction(context: Context, functionName: String) {
        try {
            val bindings = context.getBindings("js")
            val func = bindings.getMember(functionName)
            // GraalJS: 需要先检查函数是否存在（非null且非undefined）
            if (func != null && !func.isNull && func.canExecute()) {
                func.execute()
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.SCRIPT_ERROR_FUNCTION_CALL, functionName), e)
        }
    }

    private data class LoadedScript(
        val name: String,
        val path: Path,
        val context: Context,
        val api: AllayScriptAPI
    )
}
