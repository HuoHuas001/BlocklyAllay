package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityHealthChangeEvent

/**
 * 包装EntityHealthChangeEvent（实体血量变化），暴露给JavaScript脚本使用。
 */
class EntityHealthChangeEventData(private val event: EntityHealthChangeEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getOldHealth(): Float = event.oldHealth
    fun getNewHealth(): Float = event.newHealth
    fun setNewHealth(health: Float) { event.newHealth = health }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
