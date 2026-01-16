package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerBlockPickEvent

/**
 * 包装PlayerBlockPickEvent（玩家中键选取方块），暴露给JavaScript脚本使用。
 */
class PlayerBlockPickEventData(private val event: PlayerBlockPickEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getClickedBlock(): BlockWrapper = BlockWrapper(event.clickedBlock)
    fun isIncludeBlockEntity(): Boolean = event.isIncludeBlockEntity
    fun setIncludeBlockEntity(include: Boolean) { event.isIncludeBlockEntity = include }
    fun getItemBlock(): ItemWrapper = ItemWrapper(event.itemBlock)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
