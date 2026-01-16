package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.ProjectileLaunchEvent

/**
 * 包装ProjectileLaunchEvent（投射物发射），暴露给JavaScript脚本使用。
 */
class ProjectileLaunchEventData(private val event: ProjectileLaunchEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getShooter(): EntityWrapper? = event.shooter?.let { EntityWrapper(it) }
    fun getThrowForce(): Double = event.throwForce
    fun setThrowForce(force: Double) { event.throwForce = force }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
