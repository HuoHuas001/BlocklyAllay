package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockFallEvent

/**
 * 包装BlockFallEvent（方块因重力开始下落，如沙子、沙砾、铁砧），暴露给JavaScript脚本使用。
 */
class BlockFallEventData(private val event: BlockFallEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
}
