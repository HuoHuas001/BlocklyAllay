package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.IPUnbanEvent

/**
 * 包装IPUnbanEvent（IP被解封），暴露给JavaScript脚本使用。
 */
class IPUnbanEventData(private val event: IPUnbanEvent) {
    fun getIP(): String = event.ip
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
