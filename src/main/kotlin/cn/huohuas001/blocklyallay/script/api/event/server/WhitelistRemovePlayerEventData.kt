package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.WhitelistRemovePlayerEvent

/**
 * 包装WhitelistRemovePlayerEvent（玩家从白名单移除），暴露给JavaScript脚本使用。
 */
class WhitelistRemovePlayerEventData(private val event: WhitelistRemovePlayerEvent) {
    fun getUuidOrName(): String = event.uuidOrName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
