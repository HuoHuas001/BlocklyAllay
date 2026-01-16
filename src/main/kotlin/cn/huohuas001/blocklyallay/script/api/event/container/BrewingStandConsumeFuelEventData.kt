package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.BrewingStandConsumeFuelEvent

/**
 * 包装BrewingStandConsumeFuelEvent（酿造台消耗燃料-烈焰粉），暴露给JavaScript脚本使用。
 */
class BrewingStandConsumeFuelEventData(private val event: BrewingStandConsumeFuelEvent) {
    fun getBrewingStandX(): Int = event.brewingStand.position.x()
    fun getBrewingStandY(): Int = event.brewingStand.position.y()
    fun getBrewingStandZ(): Int = event.brewingStand.position.z()
    fun getFuel(): ItemWrapper = ItemWrapper(event.fuel)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
