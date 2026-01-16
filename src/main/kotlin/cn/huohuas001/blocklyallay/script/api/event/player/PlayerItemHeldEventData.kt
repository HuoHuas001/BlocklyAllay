package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerItemHeldEvent

/**
 * 包装PlayerItemHeldEvent（玩家切换手持物品），暴露给JavaScript脚本使用。
 */
class PlayerItemHeldEventData(private val event: PlayerItemHeldEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getOldItem(): ItemWrapper = ItemWrapper(event.oldItemStack)
    fun getOldHandSlot(): Int = event.oldHandSlot
    fun getNewItem(): ItemWrapper = ItemWrapper(event.newItemStack)
    fun getNewHandSlot(): Int = event.newHandSlot
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
