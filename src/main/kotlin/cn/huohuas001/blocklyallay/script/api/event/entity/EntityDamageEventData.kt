package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.entity.Entity
import org.allaymc.api.eventbus.event.entity.EntityDamageEvent

/**
 * 包装EntityDamageEvent，暴露给JavaScript脚本使用。
 */
class EntityDamageEventData(private val event: EntityDamageEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getDamage(): Float = event.damageContainer.finalDamage
    fun getBaseDamage(): Float = event.damageContainer.sourceDamage
    fun getAttacker(): EntityWrapper? {
        val attacker: Entity? = event.damageContainer.getAttacker()
        return attacker?.let { EntityWrapper(it) }
    }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
