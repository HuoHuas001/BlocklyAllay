package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerToggleFlightEvent

/**
 * 包装PlayerToggleFlightEvent（玩家切换飞行状态），暴露给JavaScript脚本使用。
 */
class PlayerToggleFlightEventData(private val event: PlayerToggleFlightEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun isFlying(): Boolean = event.isValue
}
