package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.BrewingStandBrewEvent

/**
 * 包装BrewingStandBrewEvent（酿造台完成酿造），暴露给JavaScript脚本使用。
 */
class BrewingStandBrewEventData(private val event: BrewingStandBrewEvent) {
    fun getBrewingStandX(): Int = event.brewingStand.position.x()
    fun getBrewingStandY(): Int = event.brewingStand.position.y()
    fun getBrewingStandZ(): Int = event.brewingStand.position.z()
    fun getResultCount(): Int = event.result.size
    fun getResult(index: Int): ItemWrapper? = event.result.getOrNull(index)?.let { ItemWrapper(it) }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
