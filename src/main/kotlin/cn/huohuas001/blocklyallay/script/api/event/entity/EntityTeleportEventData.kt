package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityTeleportEvent

/**
 * 包装EntityTeleportEvent（实体传送），暴露给JavaScript脚本使用。
 */
class EntityTeleportEventData(private val event: EntityTeleportEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getFromX(): Double = event.from.x()
    fun getFromY(): Double = event.from.y()
    fun getFromZ(): Double = event.from.z()
    fun getToX(): Double = event.to.x()
    fun getToY(): Double = event.to.y()
    fun getToZ(): Double = event.to.z()
    fun getReason(): String = event.reason.name
    fun isTeleportBetweenWorlds(): Boolean = event.isTeleportBetweenWorlds
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
