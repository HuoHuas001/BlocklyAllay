package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.CampfireSmeltEvent

/**
 * 包装CampfireSmeltEvent（营火完成烹饪），暴露给JavaScript脚本使用。
 */
class CampfireSmeltEventData(private val event: CampfireSmeltEvent) {
    fun getCampfireX(): Int = event.campfire.position.x()
    fun getCampfireY(): Int = event.campfire.position.y()
    fun getCampfireZ(): Int = event.campfire.position.z()
    fun getIngredient(): ItemWrapper = ItemWrapper(event.ingredient)
    fun getOutput(): ItemWrapper = ItemWrapper(event.output)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
