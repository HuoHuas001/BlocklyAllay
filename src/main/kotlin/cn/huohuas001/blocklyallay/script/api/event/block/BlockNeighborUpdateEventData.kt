package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockNeighborUpdateEvent

/**
 * 包装BlockNeighborUpdateEvent（方块因邻居方块变化而更新），暴露给JavaScript脚本使用。
 */
class BlockNeighborUpdateEventData(private val event: BlockNeighborUpdateEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getNeighbor(): BlockWrapper = BlockWrapper(event.neighbor)
    fun getBlockFace(): String = event.blockFace.name
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
