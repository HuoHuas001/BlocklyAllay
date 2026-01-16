package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.PlayerConnectEvent

/**
 * 包装PlayerConnectEvent（玩家连接服务器），暴露给JavaScript脚本使用。
 */
class PlayerConnectEventData(private val event: PlayerConnectEvent) {
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
