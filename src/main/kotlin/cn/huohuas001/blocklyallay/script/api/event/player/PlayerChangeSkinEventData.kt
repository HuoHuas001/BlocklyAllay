package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerChangeSkinEvent

/**
 * 包装PlayerChangeSkinEvent（玩家更换皮肤），暴露给JavaScript脚本使用。
 */
class PlayerChangeSkinEventData(private val event: PlayerChangeSkinEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
