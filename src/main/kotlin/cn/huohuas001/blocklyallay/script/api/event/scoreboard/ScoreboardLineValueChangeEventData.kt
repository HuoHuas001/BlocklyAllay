package cn.huohuas001.blocklyallay.script.api.event.scoreboard

import org.allaymc.api.eventbus.event.scoreboard.ScoreboardLineValueChangeEvent

/**
 * 包装ScoreboardLineValueChangeEvent（计分板行分数改变），暴露给JavaScript脚本使用。
 */
class ScoreboardLineValueChangeEventData(private val event: ScoreboardLineValueChangeEvent) {
    fun getScoreboardName(): String = event.scoreboard.objectiveName
    fun getScorerName(): String = event.line.scorer.name
    fun getOldValue(): Int = event.oldValue
    fun getNewValue(): Int = event.newValue
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
