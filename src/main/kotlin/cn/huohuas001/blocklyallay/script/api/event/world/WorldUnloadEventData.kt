package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.WorldUnloadEvent

/**
 * 包装WorldUnloadEvent（世界卸载），暴露给JavaScript脚本使用。
 */
class WorldUnloadEventData(private val event: WorldUnloadEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getWorldName(): String = event.world.name
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
