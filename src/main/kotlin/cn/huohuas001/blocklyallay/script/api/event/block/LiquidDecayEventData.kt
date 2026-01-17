package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import org.allaymc.api.eventbus.event.block.LiquidDecayEvent

/**
 * 包装LiquidDecayEvent（液体消退），暴露给JavaScript脚本使用。
 */
class LiquidDecayEventData(private val event: LiquidDecayEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getNewBlockType(): String = event.newBlockState.blockType.identifier.toString()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
