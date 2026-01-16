package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.PlayerDisconnectEvent

/**
 * 包装PlayerDisconnectEvent（玩家断开连接），暴露给JavaScript脚本使用。
 */
class PlayerDisconnectEventData(private val event: PlayerDisconnectEvent) {
    fun getDisconnectReason(): String = event.disconnectReason
}
