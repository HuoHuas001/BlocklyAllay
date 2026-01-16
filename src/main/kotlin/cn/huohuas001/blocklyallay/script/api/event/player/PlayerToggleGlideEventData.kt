package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerToggleGlideEvent

/**
 * 包装PlayerToggleGlideEvent（玩家切换滑翔状态），暴露给JavaScript脚本使用。
 */
class PlayerToggleGlideEventData(private val event: PlayerToggleGlideEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun isGliding(): Boolean = event.isValue
}
