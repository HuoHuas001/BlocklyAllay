package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockGrowEvent

/**
 * 包装BlockGrowEvent（作物生长），暴露给JavaScript脚本使用。
 */
class BlockGrowEventData(private val event: BlockGrowEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getNewBlockType(): String = event.newBlockState.blockType.identifier.toString()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
