package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerBookEditEvent

/**
 * 包装PlayerBookEditEvent（玩家编辑书），暴露给JavaScript脚本使用。
 */
class PlayerBookEditEventData(private val event: PlayerBookEditEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getAction(): String = event.action.name
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
