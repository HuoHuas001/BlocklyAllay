package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerPunchAirEvent

/**
 * 包装PlayerPunchAirEvent（玩家空挥），暴露给JavaScript脚本使用。
 */
class PlayerPunchAirEventData(private val event: PlayerPunchAirEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
}
