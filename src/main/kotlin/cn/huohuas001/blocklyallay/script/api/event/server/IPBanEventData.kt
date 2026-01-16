package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.IPBanEvent

/**
 * 包装IPBanEvent（IP被封禁），暴露给JavaScript脚本使用。
 */
class IPBanEventData(private val event: IPBanEvent) {
    fun getIP(): String = event.ip
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
