package cn.huohuas001.blocklyallay.script.api.event.server

import cn.huohuas001.blocklyallay.script.api.wrapper.PlayerWrapper
import org.allaymc.api.eventbus.event.server.PlayerKickEvent

/**
 * 包装PlayerKickEvent（玩家被踢出），暴露给JavaScript脚本使用。
 */
class PlayerKickEventData(private val event: PlayerKickEvent) {
    fun getPlayer(): PlayerWrapper = PlayerWrapper(event.player)
    fun getReason(): String = event.reason
    fun setReason(reason: String) { event.reason = reason }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
