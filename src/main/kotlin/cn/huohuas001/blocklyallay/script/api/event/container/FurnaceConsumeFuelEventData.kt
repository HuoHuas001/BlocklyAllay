package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.FurnaceConsumeFuelEvent

/**
 * 包装FurnaceConsumeFuelEvent（熔炉消耗燃料），暴露给JavaScript脚本使用。
 */
class FurnaceConsumeFuelEventData(private val event: FurnaceConsumeFuelEvent) {
    fun getFurnaceX(): Int = event.furnace.position.x()
    fun getFurnaceY(): Int = event.furnace.position.y()
    fun getFurnaceZ(): Int = event.furnace.position.z()
    fun getFuel(): ItemWrapper = ItemWrapper(event.fuel)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
