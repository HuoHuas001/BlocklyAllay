package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerToggleSwimEvent

/**
 * 包装PlayerToggleSwimEvent（玩家切换游泳状态），暴露给JavaScript脚本使用。
 */
class PlayerToggleSwimEventData(private val event: PlayerToggleSwimEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun isSwimming(): Boolean = event.isValue
}
