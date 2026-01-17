package cn.huohuas001.blocklyallay.script.api.event.entity

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.eventbus.event.entity.EntityTrampleFarmlandEvent

/**
 * 包装EntityTrampleFarmlandEvent（实体踩踏耕地），暴露给JavaScript脚本使用。
 */
class EntityTrampleFarmlandEventData(private val event: EntityTrampleFarmlandEvent) {
    fun getEntity(): EntityWrapper = EntityWrapper(event.entity)
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
