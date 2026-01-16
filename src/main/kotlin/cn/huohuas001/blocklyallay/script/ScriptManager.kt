package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay
import org.mozilla.javascript.*
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.ConcurrentHashMap
import kotlin.io.path.exists
import kotlin.io.path.extension
import kotlin.io.path.name
import kotlin.io.path.readText

/**
 * 使用Mozilla Rhino管理JavaScript脚本的执行。
 * 处理Blockly生成的脚本的加载、执行和生命周期管理。
 */
class ScriptManager(private val plugin: BlocklyAllay) {

    val scriptsDir: Path = plugin.pluginContainer.dataFolder().resolve("scripts")
    private val loadedScripts = ConcurrentHashMap<String, LoadedScript>()

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

            val cx = Context.enter()
            try {
                cx.optimizationLevel = -1 // 使用解释模式，避免类生成问题
                cx.languageVersion = Context.VERSION_ES6

                val scope = cx.initStandardObjects()

                // 为此脚本创建API实例
                val api = AllayScriptAPI(plugin)

                // 绑定API到scope
                bindAllayAPI(cx, scope, api)

                // 设置API的scope以便回调执行
                api.setScope(scope)

                // 读取并执行脚本
                val scriptContent = scriptPath.readText()
                cx.evaluateString(scope, scriptContent, scriptName, 1, null)

                // 存储已加载的脚本
                val loadedScript = LoadedScript(scriptName, scriptPath, scope, api)
                loadedScripts[scriptName] = loadedScript

                // 如果定义了onLoad则调用
                callScriptFunction(scope, "onLoad")

                plugin.pluginLogger.info("已加载脚本: $scriptName")
            } finally {
                Context.exit()
            }

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
                val cx = Context.enter()
                try {
                    callScriptFunction(script.scope, "onUnload")
                } finally {
                    Context.exit()
                }
                script.api.cleanup()
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
        val cx = Context.enter()
        try {
            loadedScripts.values.forEach { script ->
                callScriptFunction(script.scope, "onEnable")
            }
        } finally {
            Context.exit()
        }
    }

    /**
     * 禁用所有已加载的脚本(调用onDisable)。
     */
    fun disableAllScripts() {
        val cx = Context.enter()
        try {
            loadedScripts.values.forEach { script ->
                callScriptFunction(script.scope, "onDisable")
            }
        } finally {
            Context.exit()
        }
    }

    /**
     * 关闭脚本管理器。
     */
    fun shutdown() {
        disableAllScripts()
        val cx = Context.enter()
        try {
            loadedScripts.values.forEach { script ->
                try {
                    callScriptFunction(script.scope, "onUnload")
                    script.api.cleanup()
                } catch (e: Exception) {
                    plugin.pluginLogger.error("关闭脚本上下文时出错: ${script.name}", e)
                }
            }
        } finally {
            Context.exit()
        }
        loadedScripts.clear()
    }

    /**
     * 如果脚本中存在该函数则调用。
     */
    private fun callScriptFunction(scope: Scriptable, functionName: String) {
        try {
            val func = scope.get(functionName, scope)
            if (func is org.mozilla.javascript.Function) {
                func.call(Context.getCurrentContext(), scope, scope, emptyArray<Any>())
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error("调用函数 $functionName 时出错", e)
        }
    }

    /**
     * 将Allay API对象绑定到JavaScript作用域。
     */
    private fun bindAllayAPI(cx: Context, scope: Scriptable, api: AllayScriptAPI) {
        // 包装Java对象为JS可用对象
        val wrappedApi = Context.javaToJS(api, scope)
        ScriptableObject.putProperty(scope, "allay", wrappedApi)

        val consoleApi = ConsoleAPI(plugin)
        val wrappedConsole = Context.javaToJS(consoleApi, scope)
        ScriptableObject.putProperty(scope, "console", wrappedConsole)
    }

    private data class LoadedScript(
        val name: String,
        val path: Path,
        val scope: Scriptable,
        val api: AllayScriptAPI
    )
}
