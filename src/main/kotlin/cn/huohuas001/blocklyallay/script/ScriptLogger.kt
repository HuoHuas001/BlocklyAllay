package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.TrKeys
import org.allaymc.api.message.I18n

/**
 * 脚本插件的专属Logger。
 * 每个脚本插件都有自己的logger实例，日志输出时包含插件名称前缀。
 */
class ScriptLogger(
    private val plugin: BlocklyAllay,
    private var pluginName: String
) {

    /**
     * 更新插件名称
     */
    fun setPluginName(name: String) {
        this.pluginName = name
    }

    /**
     * 输出INFO级别日志
     */
    fun log(vararg args: Any?) {
        plugin.pluginLogger.info("[$pluginName] ${formatArgs(args)}")
    }

    /**
     * 输出INFO级别日志
     */
    fun info(vararg args: Any?) {
        plugin.pluginLogger.info("[$pluginName] ${formatArgs(args)}")
    }

    /**
     * 输出WARN级别日志
     */
    fun warn(vararg args: Any?) {
        plugin.pluginLogger.warn("[$pluginName] ${formatArgs(args)}")
    }

    /**
     * 输出ERROR级别日志
     */
    fun error(vararg args: Any?) {
        plugin.pluginLogger.error("[$pluginName] ${formatArgs(args)}")
    }

    /**
     * 输出ERROR级别日志（带异常堆栈）
     */
    fun error(message: String, throwable: Throwable) {
        plugin.pluginLogger.error("[$pluginName] $message", throwable)
    }

    /**
     * 输出DEBUG级别日志
     */
    fun debug(vararg args: Any?) {
        plugin.pluginLogger.debug("[$pluginName] ${formatArgs(args)}")
    }

    /**
     * 格式化日志参数
     */
    private fun formatArgs(args: Array<out Any?>): String {
        return args.joinToString(" ") { it?.toString() ?: "null" }
    }
}