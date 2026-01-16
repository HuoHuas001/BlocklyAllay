package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.FireworkExplodeEvent

/**
 * 包装FireworkExplodeEvent（烟花爆炸），暴露给JavaScript脚本使用。
 */
class FireworkExplodeEventData(private val event: FireworkExplodeEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getForce(): Double = event.force
    fun setForce(force: Double) { event.force = force }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
