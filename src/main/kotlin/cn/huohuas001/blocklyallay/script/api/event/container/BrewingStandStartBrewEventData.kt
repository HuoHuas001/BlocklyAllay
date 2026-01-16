package cn.huohuas001.blocklyallay.script.api.event.container

import org.allaymc.api.eventbus.event.container.BrewingStandStartBrewEvent

/**
 * 包装BrewingStandStartBrewEvent（酿造台开始酿造），暴露给JavaScript脚本使用。
 */
class BrewingStandStartBrewEventData(private val event: BrewingStandStartBrewEvent) {
    fun getBrewingStandX(): Int = event.brewingStand.position.x()
    fun getBrewingStandY(): Int = event.brewingStand.position.y()
    fun getBrewingStandZ(): Int = event.brewingStand.position.z()
    fun getBrewingTime(): Int = event.brewingTime
    fun setBrewingTime(time: Int) { event.brewingTime = time }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
