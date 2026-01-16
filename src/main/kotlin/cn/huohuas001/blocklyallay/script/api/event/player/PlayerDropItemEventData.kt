package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerDropItemEvent

/**
 * 包装PlayerDropItemEvent，暴露给JavaScript脚本使用。
 */
class PlayerDropItemEventData(private val event: PlayerDropItemEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getItem(): ItemWrapper = ItemWrapper(event.itemStack)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
