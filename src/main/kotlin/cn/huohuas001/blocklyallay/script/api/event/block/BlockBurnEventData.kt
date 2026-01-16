package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockBurnEvent

/**
 * 包装BlockBurnEvent（方块被火烧毁），暴露给JavaScript脚本使用。
 */
class BlockBurnEventData(private val event: BlockBurnEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
