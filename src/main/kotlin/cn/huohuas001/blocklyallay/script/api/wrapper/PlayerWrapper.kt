package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.math.location.Location3d
import org.allaymc.api.player.Player

/**
 * 包装Player对象，暴露给JavaScript脚本使用。
 */
class PlayerWrapper(private val player: Player) {
    fun getName(): String = player.originName
    fun sendMessage(message: String) = player.sendMessage(message)
    fun sendTip(message: String) = player.sendTip(message)
    fun sendPopup(message: String) = player.sendPopup(message)
    fun sendTitle(title: String) = player.sendTitle(title)
    fun sendSubtitle(subtitle: String) = player.sendSubtitle(subtitle)
    fun sendActionBar(message: String) = player.sendActionBar(message)
    fun getHealth(): Float = player.controlledEntity?.health ?: 0f
    fun setHealth(health: Float) { player.controlledEntity?.health = health }
    fun getX(): Double = player.controlledEntity?.location?.x() ?: 0.0
    fun getY(): Double = player.controlledEntity?.location?.y() ?: 0.0
    fun getZ(): Double = player.controlledEntity?.location?.z() ?: 0.0
    fun teleport(x: Double, y: Double, z: Double) {
        player.controlledEntity?.let { entity ->
            entity.teleport(Location3d(x, y, z, entity.location.dimension()))
        }
    }
    fun kick(reason: String) = player.disconnect(reason)
    fun isOnGround(): Boolean = player.controlledEntity?.isOnGround ?: false
    fun getGameMode(): String = player.controlledEntity?.gameMode?.name ?: "UNKNOWN"
    fun getDisplayName(): String = player.controlledEntity?.displayName ?: player.originName
    fun getPing(): Int = player.ping
    fun getPlayer(): Player = player
}
