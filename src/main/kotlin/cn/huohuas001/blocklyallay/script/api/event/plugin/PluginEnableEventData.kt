package cn.huohuas001.blocklyallay.script.api.event.plugin

import cn.huohuas001.blocklyallay.script.api.wrapper.PluginWrapper
import org.allaymc.api.eventbus.event.plugin.PluginEnableEvent

/**
 * 包装PluginEnableEvent（插件启用），暴露给JavaScript脚本使用。
 */
class PluginEnableEventData(private val event: PluginEnableEvent) {
    fun getPlugin(): PluginWrapper = PluginWrapper(event.plugin)
    fun getPluginName(): String = event.plugin.pluginContainer.descriptor().name
    fun getPluginVersion(): String = event.plugin.pluginContainer.descriptor().version
}
