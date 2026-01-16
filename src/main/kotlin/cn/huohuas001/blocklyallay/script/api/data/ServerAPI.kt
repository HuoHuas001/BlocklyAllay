package cn.huohuas001.blocklyallay.script.api.data

import org.allaymc.api.server.Server

/**
 * 提供服务器相关API，暴露给JavaScript脚本使用。
 */
class ServerAPI {
    fun getOnlineCount(): Int = Server.getInstance().playerManager.playerCount

    fun getMaxPlayers(): Int = Server.getInstance().playerManager.maxPlayerCount

    fun getCurrentTick(): Long = Server.getInstance().tick
}
