package cn.huohuas001.blocklyallay.script.api.event

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerChatEvent

/**
 * 包装PlayerChatEvent，暴露给JavaScript脚本使用。
 */
class ChatEventData(private val event: PlayerChatEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getMessage(): String = event.message
    fun setMessage(message: String) { event.message = message }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
