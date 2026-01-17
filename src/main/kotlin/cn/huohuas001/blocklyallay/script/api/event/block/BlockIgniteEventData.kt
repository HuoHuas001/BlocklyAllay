package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.block.BlockIgniteEvent

/**
 * 包装BlockIgniteEvent（方块被点燃），暴露给JavaScript脚本使用。
 */
class BlockIgniteEventData(private val event: BlockIgniteEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getSource(): BlockWrapper? = event.source?.let { BlockWrapper(it) }
    fun getEntity(): EntityWrapper? = event.entity?.let { EntityWrapper(it) }
    fun getCause(): String = event.cause.name
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
