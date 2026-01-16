package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityCombustEvent

/**
 * 包装EntityCombustEvent（实体着火），暴露给JavaScript脚本使用。
 */
class EntityCombustEventData(private val event: EntityCombustEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getCombusterType(): String = event.combusterType.name
    fun getOnFireTicks(): Int = event.onFireTicks
    fun setOnFireTicks(ticks: Int) { event.onFireTicks = ticks }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
