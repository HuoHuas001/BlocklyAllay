package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.block.BlockPlaceEvent

/**
 * 包装BlockPlaceEvent，暴露给JavaScript脚本使用。
 */
class BlockPlaceEventData(private val event: BlockPlaceEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getPlayer(): EntityPlayerWrapper? = event.interactInfo?.player?.let { EntityPlayerWrapper(it) }
    fun getReplacedBlockType(): String = event.blockStateReplaced.blockType.identifier.toString()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
