package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay
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
            plugin.pluginLogger.info("已创建脚本目录: $scriptsDir")
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

            // 绑定API到全局对象
            val bindings = cx.getBindings("js")
            bindings.putMember("allay", api)
            bindings.putMember("console", ConsoleAPI(plugin))

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

            plugin.pluginLogger.info("已加载脚本: $scriptName")

        } catch (e: Exception) {
            plugin.pluginLogger.error("加载脚本失败: $scriptName", e)
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
                plugin.pluginLogger.info("已卸载脚本: $scriptName")
            } catch (e: Exception) {
                plugin.pluginLogger.error("卸载脚本时出错: $scriptName", e)
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
                plugin.pluginLogger.error("关闭脚本上下文时出错: ${script.name}", e)
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
            if (func.canExecute()) {
                func.execute()
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error("调用函数 $functionName 时出错", e)
        }
    }

    private data class LoadedScript(
        val name: String,
        val path: Path,
        val context: Context,
        val api: AllayScriptAPI
    )
}
