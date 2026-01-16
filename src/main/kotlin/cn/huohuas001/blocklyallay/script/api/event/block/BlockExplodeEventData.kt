package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import org.allaymc.api.eventbus.event.block.BlockExplodeEvent

/**
 * 包装BlockExplodeEvent（方块爆炸，如床），暴露给JavaScript脚本使用。
 */
class BlockExplodeEventData(private val event: BlockExplodeEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getExplosionSize(): Float = event.explosion.size
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
