package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockRandomUpdateEvent

/**
 * 包装BlockRandomUpdateEvent（方块随机刻更新，如作物生长、树叶腐烂），暴露给JavaScript脚本使用。
 */
class BlockRandomUpdateEventData(private val event: BlockRandomUpdateEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
