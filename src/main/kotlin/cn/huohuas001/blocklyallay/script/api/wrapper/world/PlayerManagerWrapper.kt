package cn.huohuas001.blocklyallay.script.api.wrapper.world

import cn.huohuas001.blocklyallay.script.api.wrapper.PlayerWrapper
import org.allaymc.api.player.PlayerManager

/**
 * 包装PlayerManager对象，暴露给JavaScript脚本使用。
 */
class PlayerManagerWrapper(private val playerManager: PlayerManager) {
    fun getPlayerCount(): Int = playerManager.playerCount
    fun getMaxPlayerCount(): Int = playerManager.maxPlayerCount
    fun setMaxPlayerCount(value: Int) { playerManager.maxPlayerCount = value }
    fun disconnectAllPlayers() { playerManager.disconnectAllPlayers() }
    fun disconnectAllPlayers(reason: String) { playerManager.disconnectAllPlayers(reason) }
    fun savePlayerData() { playerManager.savePlayerData() }
    fun getPlayerByName(playerName: String): PlayerWrapper? {
        val player = playerManager.getPlayerByName(playerName)
        return if (player != null) PlayerWrapper(player) else null
    }
    fun isBanned(uuidOrName: String): Boolean = playerManager.isBanned(uuidOrName)
    fun ban(uuidOrName: String): Boolean = playerManager.ban(uuidOrName)
    fun unban(uuidOrName: String): Boolean = playerManager.unban(uuidOrName)
    fun getBannedPlayers(): Set<String> = playerManager.bannedPlayers
    fun isIPBanned(ip: String): Boolean = playerManager.isIPBanned(ip)
    fun banIP(ip: String): Boolean = playerManager.banIP(ip)
    fun unbanIP(ip: String): Boolean = playerManager.unbanIP(ip)
    fun getBannedIPs(): Set<String> = playerManager.bannedIPs
    fun getWhitelistStatus(): Boolean = playerManager.whitelistStatus
    fun setWhitelistStatus(enable: Boolean) { playerManager.whitelistStatus = enable }
    fun isWhitelisted(uuidOrName: String): Boolean = playerManager.isWhitelisted(uuidOrName)
    fun addToWhitelist(uuidOrName: String): Boolean = playerManager.addToWhitelist(uuidOrName)
    fun removeFromWhitelist(uuidOrName: String): Boolean = playerManager.removeFromWhitelist(uuidOrName)
    fun getWhitelistedPlayers(): Set<String> = playerManager.whitelistedPlayers
    fun isOperator(uuidOrName: String): Boolean = playerManager.isOperator(uuidOrName)
    fun setOperator(uuidOrName: String, value: Boolean) { playerManager.setOperator(uuidOrName, value) }
    fun getPlayerManager(): PlayerManager = playerManager
}