package cn.huohuas001.blocklyallay.script.api.event.scoreboard

import org.allaymc.api.eventbus.event.scoreboard.ScoreboardRemoveEvent

/**
 * 包装ScoreboardRemoveEvent（计分板删除），暴露给JavaScript脚本使用。
 */
class ScoreboardRemoveEventData(private val event: ScoreboardRemoveEvent) {
    fun getScoreboardName(): String = event.scoreboard.objectiveName
    fun getDisplayName(): String = event.scoreboard.displayName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
