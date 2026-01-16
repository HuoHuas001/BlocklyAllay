package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.entity.EntityShootCrossbowEvent

/**
 * 包装EntityShootCrossbowEvent（实体用弩射击），暴露给JavaScript脚本使用。
 */
class EntityShootCrossbowEventData(private val event: EntityShootCrossbowEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getCrossbow(): ItemWrapper = ItemWrapper(event.crossbow)
    fun getProjectileCount(): Int = event.projectiles.size
    fun getProjectile(index: Int): EntityWrapper? = event.projectiles.getOrNull(index)?.let { EntityWrapper(it) }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
