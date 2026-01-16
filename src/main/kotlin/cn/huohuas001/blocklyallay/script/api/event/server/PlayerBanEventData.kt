package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.PlayerBanEvent

/**
 * 包装PlayerBanEvent（玩家被封禁），暴露给JavaScript脚本使用。
 */
class PlayerBanEventData(private val event: PlayerBanEvent) {
    fun getUuidOrName(): String = event.uuidOrName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
