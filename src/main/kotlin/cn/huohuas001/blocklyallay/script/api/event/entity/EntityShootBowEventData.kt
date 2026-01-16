package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.entity.EntityShootBowEvent

/**
 * 包装EntityShootBowEvent（实体用弓射箭），暴露给JavaScript脚本使用。
 */
class EntityShootBowEventData(private val event: EntityShootBowEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getBow(): ItemWrapper = ItemWrapper(event.bow)
    fun getArrow(): EntityWrapper = EntityWrapper(event.arrow)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
