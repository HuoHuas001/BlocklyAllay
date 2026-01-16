package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.WhitelistAddPlayerEvent

/**
 * 包装WhitelistAddPlayerEvent（玩家添加到白名单），暴露给JavaScript脚本使用。
 */
class WhitelistAddPlayerEventData(private val event: WhitelistAddPlayerEvent) {
    fun getUuidOrName(): String = event.uuidOrName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
