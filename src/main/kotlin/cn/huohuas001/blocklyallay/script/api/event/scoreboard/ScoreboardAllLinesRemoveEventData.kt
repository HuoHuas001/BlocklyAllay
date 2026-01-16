package cn.huohuas001.blocklyallay.script.api.event.scoreboard

import org.allaymc.api.eventbus.event.scoreboard.ScoreboardAllLinesRemoveEvent

/**
 * 包装ScoreboardAllLinesRemoveEvent（计分板清空所有行），暴露给JavaScript脚本使用。
 */
class ScoreboardAllLinesRemoveEventData(private val event: ScoreboardAllLinesRemoveEvent) {
    fun getScoreboardName(): String = event.scoreboard.objectiveName
    fun getDisplayName(): String = event.scoreboard.displayName
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
