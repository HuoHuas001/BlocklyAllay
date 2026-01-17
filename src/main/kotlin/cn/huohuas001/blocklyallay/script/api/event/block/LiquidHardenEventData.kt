package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import org.allaymc.api.eventbus.event.block.LiquidHardenEvent

/**
 * 包装LiquidHardenEvent（液体�ite化，如水遇岩浆生成石头），暴露给JavaScript脚本使用。
 */
class LiquidHardenEventData(private val event: LiquidHardenEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getCauseBlockType(): String = event.cause.blockType.identifier.toString()
    fun getHardenedBlockType(): String = event.hardenedBlockState.blockType.identifier.toString()
    fun getHardenedX(): Int = event.hardenedBlockPosition.x()
    fun getHardenedY(): Int = event.hardenedBlockPosition.y()
    fun getHardenedZ(): Int = event.hardenedBlockPosition.z()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
