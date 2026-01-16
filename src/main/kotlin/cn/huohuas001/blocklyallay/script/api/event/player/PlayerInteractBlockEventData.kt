package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerInteractBlockEvent

/**
 * 包装PlayerInteractBlockEvent，暴露给JavaScript脚本使用。
 */
class PlayerInteractBlockEventData(private val event: PlayerInteractBlockEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getBlockX(): Int = event.interactInfo.clickedBlockPos.x()
    fun getBlockY(): Int = event.interactInfo.clickedBlockPos.y()
    fun getBlockZ(): Int = event.interactInfo.clickedBlockPos.z()
    fun getAction(): String = event.action.name
    fun isLeftClick(): Boolean = event.action == PlayerInteractBlockEvent.Action.LEFT_CLICK
    fun isRightClick(): Boolean = event.action == PlayerInteractBlockEvent.Action.RIGHT_CLICK
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
