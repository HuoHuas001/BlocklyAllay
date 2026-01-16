package cn.huohuas001.blocklyallay.script.api.event.scoreboard

import org.allaymc.api.eventbus.event.scoreboard.ScoreboardLineAddEvent

/**
 * 包装ScoreboardLineAddEvent（计分板添加行），暴露给JavaScript脚本使用。
 */
class ScoreboardLineAddEventData(private val event: ScoreboardLineAddEvent) {
    fun getScoreboardName(): String = event.scoreboard.objectiveName
    fun getScorerName(): String = event.line.scorer.name
    fun getScore(): Int = event.line.score
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
