package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityDieEvent

/**
 * 包装EntityDieEvent，暴露给JavaScript脚本使用。
 */
class EntityDieEventData(private val event: EntityDieEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
}
