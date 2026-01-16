package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.plugin.Plugin

/**
 * 包装Plugin对象，暴露给JavaScript脚本使用。
 */
class PluginWrapper(private val plugin: Plugin) {
    fun getName(): String = plugin.pluginContainer.descriptor().name
    fun getVersion(): String = plugin.pluginContainer.descriptor().version
    fun getDescription(): String = plugin.pluginContainer.descriptor().description
    fun getAuthors(): List<String> = plugin.pluginContainer.descriptor().authors
    fun isReloadable(): Boolean = plugin.isReloadable
    fun getPlugin(): Plugin = plugin
}
