package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.entity.interfaces.EntityPlayer
import org.allaymc.api.math.location.Location3d

/**
 * 包装EntityPlayer对象，暴露给JavaScript脚本使用。
 */
class EntityPlayerWrapper(private val entity: EntityPlayer) {
    fun getName(): String = entity.controller?.originName ?: entity.displayName
    fun getDisplayName(): String = entity.displayName
    fun sendMessage(message: String) { entity.controller?.sendMessage(message) }
    fun getHealth(): Float = entity.health
    fun setHealth(health: Float) { entity.health = health }
    fun getX(): Double = entity.location.x()
    fun getY(): Double = entity.location.y()
    fun getZ(): Double = entity.location.z()
    fun teleport(x: Double, y: Double, z: Double) {
        entity.teleport(Location3d(x, y, z, entity.location.dimension()))
    }
    fun kick(reason: String) { entity.controller?.disconnect(reason) }
    fun isOnGround(): Boolean = entity.isOnGround
    fun getGameMode(): String = entity.gameMode.name
    fun getEntity(): EntityPlayer = entity
}
