package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockSpreadEvent

/**
 * 包装BlockSpreadEvent（方块蔓延，如草蔓延到泥土），暴露给JavaScript脚本使用。
 */
class BlockSpreadEventData(private val event: BlockSpreadEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getSpreadBlock(): BlockWrapper = BlockWrapper(event.spreadBlock)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
