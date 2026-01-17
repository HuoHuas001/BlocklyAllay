package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerPunchBlockEvent

/**
 * 包装PlayerPunchBlockEvent（玩家敲击方块），暴露给JavaScript脚本使用。
 */
class PlayerPunchBlockEventData(private val event: PlayerPunchBlockEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getBlockFace(): String = event.blockFace.name
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
