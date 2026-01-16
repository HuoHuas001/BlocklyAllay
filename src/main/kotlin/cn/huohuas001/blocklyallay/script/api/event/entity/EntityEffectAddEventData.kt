package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityEffectAddEvent

/**
 * 包装EntityEffectAddEvent（实体获得效果），暴露给JavaScript脚本使用。
 */
class EntityEffectAddEventData(private val event: EntityEffectAddEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getEffectType(): String = event.effect.type.identifier.toString()
    fun getEffectLevel(): Int = event.effect.amplifier
    fun getEffectDuration(): Int = event.effect.duration
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
