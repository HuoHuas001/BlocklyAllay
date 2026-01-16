package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.BlockWrapper
import org.allaymc.api.eventbus.event.block.AnvilDamageEvent

/**
 * 包装AnvilDamageEvent（铁砧损坏），暴露给JavaScript脚本使用。
 */
class AnvilDamageEventData(private val event: AnvilDamageEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getNewBlockType(): String = event.newState.blockType.identifier.toString()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
