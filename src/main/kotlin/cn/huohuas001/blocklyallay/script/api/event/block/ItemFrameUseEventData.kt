package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.block.ItemFrameUseEvent

/**
 * 包装ItemFrameUseEvent（物品展示框使用），暴露给JavaScript脚本使用。
 */
class ItemFrameUseEventData(private val event: ItemFrameUseEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getAction(): String = event.action.name
    fun isDrop(): Boolean = event.action == ItemFrameUseEvent.Action.DROP
    fun isPut(): Boolean = event.action == ItemFrameUseEvent.Action.PUT
    fun isRotate(): Boolean = event.action == ItemFrameUseEvent.Action.ROTATE
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
