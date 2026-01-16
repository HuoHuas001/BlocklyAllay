package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.FurnaceSmeltEvent

/**
 * 包装FurnaceSmeltEvent（熔炉完成冶炼），暴露给JavaScript脚本使用。
 */
class FurnaceSmeltEventData(private val event: FurnaceSmeltEvent) {
    fun getFurnaceX(): Int = event.furnace.position.x()
    fun getFurnaceY(): Int = event.furnace.position.y()
    fun getFurnaceZ(): Int = event.furnace.position.z()
    fun getIngredient(): ItemWrapper = ItemWrapper(event.ingredient)
    fun getOutput(): ItemWrapper = ItemWrapper(event.output)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
