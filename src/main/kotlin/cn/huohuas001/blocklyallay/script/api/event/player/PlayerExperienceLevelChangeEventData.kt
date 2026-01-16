package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerExperienceLevelChangeEvent

/**
 * 包装PlayerExperienceLevelChangeEvent（玩家经验等级改变），暴露给JavaScript脚本使用。
 */
class PlayerExperienceLevelChangeEventData(private val event: PlayerExperienceLevelChangeEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getOldExperienceLevel(): Int = event.oldExperienceLevel
    fun getNewExperienceLevel(): Int = event.newExperienceLevel
    fun setNewExperienceLevel(level: Int) { event.newExperienceLevel = level }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
