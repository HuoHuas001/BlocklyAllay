package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.TimeChangeEvent

/**
 * 包装TimeChangeEvent（时间变更），暴露给JavaScript脚本使用。
 */
class TimeChangeEventData(private val event: TimeChangeEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getOldTime(): Int = event.oldTime
    fun getNewTime(): Int = event.newTime
    fun setNewTime(time: Int) { event.newTime = time }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
