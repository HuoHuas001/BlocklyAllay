package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.WorldWrapper
import org.allaymc.api.eventbus.event.world.GameRuleChangeEvent

/**
 * 包装GameRuleChangeEvent（游戏规则变更），暴露给JavaScript脚本使用。
 */
class GameRuleChangeEventData(private val event: GameRuleChangeEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getGameRule(): String = event.gameRule.name
    fun getOldValue(): Any = event.oldValue
    fun getNewValue(): Any = event.newValue
    fun setNewValue(value: Any) { event.newValue = value }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
