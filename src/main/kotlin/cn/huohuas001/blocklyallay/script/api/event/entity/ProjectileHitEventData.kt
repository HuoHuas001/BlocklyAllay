package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.ProjectileHitEvent

/**
 * 包装ProjectileHitEvent（投射物命中），暴露给JavaScript脚本使用。
 */
class ProjectileHitEventData(private val event: ProjectileHitEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getHitX(): Double = event.hitPos.x()
    fun getHitY(): Double = event.hitPos.y()
    fun getHitZ(): Double = event.hitPos.z()
    fun getVictim(): EntityWrapper? = event.victim?.let { EntityWrapper(it) }
    fun getBlock(): BlockWrapper? = event.block?.let { BlockWrapper(it) }
    fun hasHitEntity(): Boolean = event.victim != null
    fun hasHitBlock(): Boolean = event.block != null
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
