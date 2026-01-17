package cn.huohuas001.blocklyallay.script.api.wrapper.world

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityWrapper
import org.allaymc.api.world.manager.EntityManager

/**
 * 包装EntityManager对象，暴露给JavaScript脚本使用。
 */
class EntityManagerWrapper(private val entityManager: EntityManager) {
    fun getEntityCount(): Int = entityManager.entities.size
    fun getEntity(runtimeId: Long): EntityWrapper? {
        val entity = entityManager.getEntity(runtimeId)
        return if (entity != null) EntityWrapper(entity) else null
    }
    fun getPlayersInChunk(chunkX: Int, chunkZ: Int): List<EntityPlayerWrapper> {
        return entityManager.getPlayersInChunk(chunkX, chunkZ).values.map { EntityPlayerWrapper(it) }
    }
    fun checkAutoSaveImmediately() { entityManager.checkAutoSaveImmediately() }
    fun getEntityManager(): EntityManager = entityManager
}