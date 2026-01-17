package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.SpawnPointChangeEvent
import org.joml.Vector3i

/**
 * 包装SpawnPointChangeEvent（出生点变更），暴露给JavaScript脚本使用。
 */
class SpawnPointChangeEventData(private val event: SpawnPointChangeEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getOldX(): Int = event.oldPos.x()
    fun getOldY(): Int = event.oldPos.y()
    fun getOldZ(): Int = event.oldPos.z()
    fun getNewX(): Int = event.newPos.x()
    fun getNewY(): Int = event.newPos.y()
    fun getNewZ(): Int = event.newPos.z()
    fun setNewPos(x: Int, y: Int, z: Int) { event.newPos = Vector3i(x, y, z) }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
