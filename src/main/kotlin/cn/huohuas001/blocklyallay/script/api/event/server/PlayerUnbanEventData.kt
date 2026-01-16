package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.PlayerUnbanEvent

/**
 * 包装PlayerUnbanEvent（玩家被解封），暴露给JavaScript脚本使用。
 */
class PlayerUnbanEventData(private val event: PlayerUnbanEvent) {
    fun getUuidOrName(): String = event.uuidOrName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
