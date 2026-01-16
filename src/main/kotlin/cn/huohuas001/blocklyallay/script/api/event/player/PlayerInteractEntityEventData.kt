package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerInteractEntityEvent

/**
 * 包装PlayerInteractEntityEvent（玩家与实体交互），暴露给JavaScript脚本使用。
 */
class PlayerInteractEntityEventData(private val event: PlayerInteractEntityEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getItem(): ItemWrapper = ItemWrapper(event.itemStack)
    fun getClickX(): Float = event.clickPos.x()
    fun getClickY(): Float = event.clickPos.y()
    fun getClickZ(): Float = event.clickPos.z()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
