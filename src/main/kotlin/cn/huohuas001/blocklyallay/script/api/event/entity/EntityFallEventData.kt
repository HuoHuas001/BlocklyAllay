package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityFallEvent

/**
 * 包装EntityFallEvent（实体落地），暴露给JavaScript脚本使用。
 */
class EntityFallEventData(private val event: EntityFallEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getFallDistance(): Double = event.fallDistance
    fun setFallDistance(distance: Double) { event.fallDistance = distance }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
