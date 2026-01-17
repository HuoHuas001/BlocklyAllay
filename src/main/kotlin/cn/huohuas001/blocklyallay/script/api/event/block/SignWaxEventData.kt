package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.block.SignWaxEvent

/**
 * 包装SignWaxEvent（玩家给告示牌打蜡防止编辑），暴露给JavaScript脚本使用。
 */
class SignWaxEventData(private val event: SignWaxEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
