package cn.huohuas001.blocklyallay.script.api.event.server

import cn.huohuas001.blocklyallay.script.api.wrapper.PlayerWrapper
import org.allaymc.api.eventbus.event.server.PlayerSpawnEvent

/**
 * 包装PlayerSpawnEvent（玩家即将生成），暴露给JavaScript脚本使用。
 */
class PlayerSpawnEventData(private val event: PlayerSpawnEvent) {
    fun getPlayer(): PlayerWrapper = PlayerWrapper(event.player)
    fun getDisconnectReason(): String = event.disconnectReason
    fun setDisconnectReason(reason: String) { event.disconnectReason = reason }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
