package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerCraftItemEvent

/**
 * 包装PlayerCraftItemEvent（玩家合成物品），暴露给JavaScript脚本使用。
 */
class PlayerCraftItemEventData(private val event: PlayerCraftItemEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
