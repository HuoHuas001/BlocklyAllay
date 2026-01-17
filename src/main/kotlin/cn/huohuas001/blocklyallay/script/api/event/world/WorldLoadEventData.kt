package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.WorldLoadEvent

/**
 * 包装WorldLoadEvent（世界加载），暴露给JavaScript脚本使用。
 */
class WorldLoadEventData(private val event: WorldLoadEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getWorldName(): String = event.world.name
}
