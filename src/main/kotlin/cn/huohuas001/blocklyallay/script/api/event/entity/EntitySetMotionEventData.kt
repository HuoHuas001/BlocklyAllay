package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntitySetMotionEvent

/**
 * 包装EntitySetMotionEvent（实体速度改变），暴露给JavaScript脚本使用。
 */
class EntitySetMotionEventData(private val event: EntitySetMotionEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getMotionX(): Double = event.motion.x()
    fun getMotionY(): Double = event.motion.y()
    fun getMotionZ(): Double = event.motion.z()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
