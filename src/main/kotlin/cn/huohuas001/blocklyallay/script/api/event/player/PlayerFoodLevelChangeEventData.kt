package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerFoodLevelChangeEvent

/**
 * 包装PlayerFoodLevelChangeEvent（玩家饥饿值改变），暴露给JavaScript脚本使用。
 */
class PlayerFoodLevelChangeEventData(private val event: PlayerFoodLevelChangeEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getOldFoodLevel(): Int = event.oldFoodLevel
    fun getNewFoodLevel(): Int = event.newFoodLevel
    fun setNewFoodLevel(level: Int) { event.newFoodLevel = level }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
