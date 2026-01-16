package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerCommandEvent

/**
 * 包装PlayerCommandEvent，暴露给JavaScript脚本使用。
 */
class PlayerCommandEventData(private val event: PlayerCommandEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getCommand(): String = event.command
    fun setCommand(command: String) { event.command = command }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
