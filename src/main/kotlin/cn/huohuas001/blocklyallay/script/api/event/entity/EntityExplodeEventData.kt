package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityExplodeEvent

/**
 * 包装EntityExplodeEvent（实体爆炸，如TNT、苦力怕），暴露给JavaScript脚本使用。
 */
class EntityExplodeEventData(private val event: EntityExplodeEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getX(): Double = event.entity.location.x()
    fun getY(): Double = event.entity.location.y()
    fun getZ(): Double = event.entity.location.z()
    fun getExplosionSize(): Float = event.explosion.size
    fun setExplosionSize(size: Float) { event.explosion.size = size }
    fun isSpawnFire(): Boolean = event.explosion.isSpawnFire
    fun setSpawnFire(spawnFire: Boolean) { event.explosion.isSpawnFire = spawnFire }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
