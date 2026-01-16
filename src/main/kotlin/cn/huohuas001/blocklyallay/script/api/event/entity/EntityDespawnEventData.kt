package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityDespawnEvent

/**
 * 包装EntityDespawnEvent（实体消失），暴露给JavaScript脚本使用。
 */
class EntityDespawnEventData(private val event: EntityDespawnEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
}
