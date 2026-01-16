package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntitySpawnEvent

/**
 * 包装EntitySpawnEvent，暴露给JavaScript脚本使用。
 */
class EntitySpawnEventData(private val event: EntitySpawnEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
