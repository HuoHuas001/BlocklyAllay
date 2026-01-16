package cn.huohuas001.blocklyallay.script.api.event.scoreboard

import org.allaymc.api.eventbus.event.scoreboard.ScoreboardAddEvent

/**
 * 包装ScoreboardAddEvent（计分板添加），暴露给JavaScript脚本使用。
 */
class ScoreboardAddEventData(private val event: ScoreboardAddEvent) {
    fun getScoreboardName(): String = event.scoreboard.objectiveName
    fun getDisplayName(): String = event.scoreboard.displayName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
