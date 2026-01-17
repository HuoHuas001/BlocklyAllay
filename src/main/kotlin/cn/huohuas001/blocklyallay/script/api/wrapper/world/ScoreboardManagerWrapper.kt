package cn.huohuas001.blocklyallay.script.api.wrapper.world

import org.allaymc.api.scoreboard.Scoreboard
import org.allaymc.api.scoreboard.ScoreboardManager
import org.allaymc.api.scoreboard.data.DisplaySlot

/**
 * 包装ScoreboardManager对象，暴露给JavaScript脚本使用。
 */
class ScoreboardManagerWrapper(private val scoreboardManager: ScoreboardManager) {
    fun getScoreboardCount(): Int = scoreboardManager.scoreboards.size
    fun getScoreboard(objectiveName: String): Any? = scoreboardManager.get(objectiveName)
    fun containsScoreboard(name: String): Boolean = scoreboardManager.contain(name)
    fun getDisplaySlot(slot: String): Any? {
        val displaySlot = try {
            DisplaySlot.valueOf(slot.uppercase())
        } catch (e: IllegalArgumentException) {
            return null
        }
        return scoreboardManager.getDisplaySlot(displaySlot)
    }
    fun setDisplaySlot(slot: String, scoreboard: Any): Boolean {
        val displaySlot = try {
            DisplaySlot.valueOf(slot.uppercase())
        } catch (e: IllegalArgumentException) {
            return false
        }
        if (scoreboard !is Scoreboard) return false
        scoreboardManager.setDisplaySlot(displaySlot, scoreboard)
        return true
    }
    fun clearDisplaySlot(slot: String): Boolean {
        val displaySlot = try {
            DisplaySlot.valueOf(slot.uppercase())
        } catch (e: IllegalArgumentException) {
            return false
        }
        scoreboardManager.clearDisplaySlot(displaySlot)
        return true
    }
    fun getViewerCount(): Int = scoreboardManager.viewers.size
    fun save() { scoreboardManager.save() }
    fun read() { scoreboardManager.read() }
    fun getScoreboardManager(): ScoreboardManager = scoreboardManager
}