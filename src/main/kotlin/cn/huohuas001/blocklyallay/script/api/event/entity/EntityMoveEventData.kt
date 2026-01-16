package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityMoveEvent

/**
 * 包装EntityMoveEvent（实体移动），暴露给JavaScript脚本使用。
 */
class EntityMoveEventData(private val event: EntityMoveEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getFromX(): Double = event.from.x()
    fun getFromY(): Double = event.from.y()
    fun getFromZ(): Double = event.from.z()
    fun getToX(): Double = event.to.x()
    fun getToY(): Double = event.to.y()
    fun getToZ(): Double = event.to.z()
}
