package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.plugin.Plugin
import org.allaymc.api.plugin.PluginContainer
import org.allaymc.api.plugin.PluginManager

/**
 * 包装PluginManager对象，暴露给JavaScript脚本使用。
 */
class PluginManagerWrapper(private val pluginManager: PluginManager) {
    fun getPluginCount(): Int = pluginManager.plugins.size
    /*fun getPlugin(name: String): PluginWrapper? {
        val container = pluginManager.getPlugin(name)
        return if (container != null) PluginWrapper(container.pluginInstance) else null
    }
    fun getEnabledPlugin(name: String): PluginWrapper? {
        val container = pluginManager.getEnabledPlugin(name)
        return if (container != null) PluginWrapper(container.pluginInstance) else null
    }*/
    fun getEnabledPluginCount(): Int = pluginManager.enabledPlugins.size
    fun isPluginEnabled(name: String): Boolean = pluginManager.isPluginEnabled(name)
    fun getPluginManager(): PluginManager = pluginManager
}