package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay

/**
 * JavaScript脚本的控制台API。
 * 提供熟悉的console.log/warn/error函数。
 * Rhino可以直接调用公共Java方法，无需注解。
 */
class ConsoleAPI(private val plugin: BlocklyAllay) {

    fun log(vararg args: Any?) {
        plugin.pluginLogger.info("[Script] ${formatArgs(args)}")
    }

    fun info(vararg args: Any?) {
        plugin.pluginLogger.info("[Script] ${formatArgs(args)}")
    }

    fun warn(vararg args: Any?) {
        plugin.pluginLogger.warn("[Script] ${formatArgs(args)}")
    }

    fun error(vararg args: Any?) {
        plugin.pluginLogger.error("[Script] ${formatArgs(args)}")
    }

    fun debug(vararg args: Any?) {
        plugin.pluginLogger.debug("[Script] ${formatArgs(args)}")
    }

    private fun formatArgs(args: Array<out Any?>): String {
        return args.joinToString(" ") { it?.toString() ?: "null" }
    }
}
