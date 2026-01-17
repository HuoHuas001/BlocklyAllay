package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockScheduleUpdateEvent

/**
 * 包装BlockScheduleUpdateEvent（方块计划刻更新），暴露给JavaScript脚本使用。
 */
class BlockScheduleUpdateEventData(private val event: BlockScheduleUpdateEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
