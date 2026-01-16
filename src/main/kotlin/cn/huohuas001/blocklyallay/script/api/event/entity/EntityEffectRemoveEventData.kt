package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityEffectRemoveEvent

/**
 * 包装EntityEffectRemoveEvent（实体失去效果），暴露给JavaScript脚本使用。
 */
class EntityEffectRemoveEventData(private val event: EntityEffectRemoveEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getEffectType(): String = event.effect.type.identifier.toString()
    fun getEffectLevel(): Int = event.effect.amplifier
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
