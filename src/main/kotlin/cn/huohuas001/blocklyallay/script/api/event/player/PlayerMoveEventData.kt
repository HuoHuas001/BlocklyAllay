package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerMoveEvent

/**
 * 包装PlayerMoveEvent，暴露给JavaScript脚本使用。
 */
class PlayerMoveEventData(private val event: PlayerMoveEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getFromX(): Double = event.from.x()
    fun getFromY(): Double = event.from.y()
    fun getFromZ(): Double = event.from.z()
    fun getToX(): Double = event.to.x()
    fun getToY(): Double = event.to.y()
    fun getToZ(): Double = event.to.z()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
