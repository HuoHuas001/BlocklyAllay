package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerEatEvent

/**
 * 包装PlayerEatEvent（玩家吃东西），暴露给JavaScript脚本使用。
 */
class PlayerEatEventData(private val event: PlayerEatEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getEdible(): ItemWrapper = ItemWrapper(event.edible)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
