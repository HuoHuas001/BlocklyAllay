package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerUseItemInAirEvent

/**
 * 包装PlayerUseItemInAirEvent（玩家在空中使用物品），暴露给JavaScript脚本使用。
 */
class PlayerUseItemInAirEventData(private val event: PlayerUseItemInAirEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getUsingTime(): Long = event.usingTime
    fun setUsingTime(time: Long) { event.usingTime = time }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
