package cn.huohuas001.blocklyallay.script.api.event.scoreboard

import org.allaymc.api.eventbus.event.scoreboard.ScoreboardLineRemoveEvent

/**
 * 包装ScoreboardLineRemoveEvent（计分板删除行），暴露给JavaScript脚本使用。
 */
class ScoreboardLineRemoveEventData(private val event: ScoreboardLineRemoveEvent) {
    fun getScoreboardName(): String = event.scoreboard.objectiveName
    fun getScorerName(): String = event.line.scorer.name
    fun getScore(): Int = event.line.score
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
