package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.block.BlockBreakEvent

/**
 * 包装BlockBreakEvent，暴露给JavaScript脚本使用。
 */
class BlockBreakEventData(private val event: BlockBreakEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getEntity(): EntityWrapper? = event.entity?.let { EntityWrapper(it) }
    fun getUsedItem(): ItemWrapper? = event.usedItem?.let { ItemWrapper(it) }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
