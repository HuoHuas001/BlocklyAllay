package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.DifficultyChangeEvent

/**
 * 包装DifficultyChangeEvent（难度变更），暴露给JavaScript脚本使用。
 */
class DifficultyChangeEventData(private val event: DifficultyChangeEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getOldDifficulty(): Int = event.oldDifficulty.ordinal
    fun getOldDifficultyName(): String = event.oldDifficulty.name.lowercase()
    fun getNewDifficulty(): Int = event.newDifficulty.ordinal
    fun getNewDifficultyName(): String = event.newDifficulty.name.lowercase()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
