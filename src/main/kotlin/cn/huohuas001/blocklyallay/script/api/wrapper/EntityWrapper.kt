package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.entity.Entity
import org.allaymc.api.math.location.Location3d

/**
 * 包装Entity对象，暴露给JavaScript脚本使用。
 */
class EntityWrapper(private val entity: Entity) {
    fun getType(): String = entity.entityType.identifier.toString()
    fun getTypeName(): String = entity.entityType.identifier.path()
    fun getDisplayName(): String = entity.displayName
    fun setDisplayName(name: String) { entity.displayName = name }
    fun getNameTag(): String? = entity.nameTag
    fun setNameTag(tag: String?) { entity.nameTag = tag }
    fun isNameTagAlwaysShow(): Boolean = entity.isNameTagAlwaysShow
    fun setNameTagAlwaysShow(show: Boolean) { entity.isNameTagAlwaysShow = show }
    fun isInvisible(): Boolean = entity.isInvisible
    fun setInvisible(invisible: Boolean) { entity.isInvisible = invisible }
    fun isImmobile(): Boolean = entity.isImmobile
    fun setImmobile(immobile: Boolean) { entity.isImmobile = immobile }
    fun getScale(): Double = entity.scale
    fun setScale(scale: Double) { entity.scale = scale }
    fun getX(): Double = entity.location.x()
    fun getY(): Double = entity.location.y()
    fun getZ(): Double = entity.location.z()
    fun getYaw(): Double = entity.location.yaw()
    fun getPitch(): Double = entity.location.pitch()
    fun teleport(x: Double, y: Double, z: Double): Boolean {
        return entity.teleport(Location3d(x, y, z, entity.location.dimension()))
    }
    fun getRuntimeId(): Long = entity.runtimeId
    fun isSpawned(): Boolean = entity.isSpawned
    fun isAlive(): Boolean = entity.isAlive
    fun isDead(): Boolean = entity.isDead
    fun getDimensionId(): Int = entity.dimension.dimensionInfo.dimensionId()
    fun getWorldName(): String = entity.world?.worldData?.displayName ?: "unknown"
    fun getEntity(): Entity = entity
}
