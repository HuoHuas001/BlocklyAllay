package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.WorldWrapper
import org.allaymc.api.eventbus.event.world.WorldDataSaveEvent

/**
 * 包装WorldDataSaveEvent（世界数据保存），暴露给JavaScript脚本使用。
 */
class WorldDataSaveEventData(private val event: WorldDataSaveEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getWorldName(): String = event.world.name
}
