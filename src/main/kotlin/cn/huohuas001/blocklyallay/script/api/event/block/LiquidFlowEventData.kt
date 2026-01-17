package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import org.allaymc.api.eventbus.event.block.LiquidFlowEvent

/**
 * 包装LiquidFlowEvent（液体流动），暴露给JavaScript脚本使用。
 */
class LiquidFlowEventData(private val event: LiquidFlowEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getIntoX(): Int = event.into.x()
    fun getIntoY(): Int = event.into.y()
    fun getIntoZ(): Int = event.into.z()
    fun getReplacedBlockType(): String = event.replacedBlockState.blockType.identifier.toString()
    fun isFormingSource(): Boolean = event.isFormingSource
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
