package cn.huohuas001.blocklyallay.script.api.wrapper.chunk

import org.allaymc.api.world.manager.ChunkManager

/**
 * 包装ChunkManager对象，暴露给JavaScript脚本使用。
 */
class ChunkManagerWrapper(private val chunkManager: ChunkManager) {
    fun getLoadedChunkCount(): Int = chunkManager.loadedChunks.size
    fun isChunkLoaded(x: Int, z: Int): Boolean = chunkManager.isChunkLoaded(x, z)
    fun isChunkLoaded(hash: Long): Boolean = chunkManager.isChunkLoaded(hash)
    fun isChunkLoading(x: Int, z: Int): Boolean = chunkManager.isChunkLoading(x, z)
    fun isChunkLoading(hash: Long): Boolean = chunkManager.isChunkLoading(hash)
    fun isChunkUnloaded(x: Int, z: Int): Boolean = chunkManager.isChunkUnloaded(x, z)
    fun isChunkUnloaded(hash: Long): Boolean = chunkManager.isChunkUnloaded(hash)
    fun getChunkLoaderCount(): Int = chunkManager.chunkLoaders.size
    fun removeUnusedChunksImmediately() { chunkManager.removeUnusedChunksImmediately() }
    fun getOrLoadChunk(x: Int, z: Int): ChunkWrapper? {
        val future = chunkManager.getOrLoadChunk(x, z)
        return try {
            val chunk = future.get()
            ChunkWrapper(chunk)
        } catch (e: Exception) {
            null
        }
    }
    fun getLoadedChunk(x: Int, z: Int): ChunkWrapper? {
        if (!chunkManager.isChunkLoaded(x, z)) return null
        return try {
            val future = chunkManager.getChunkFuture(x, z)
            val chunk = future.get()
            ChunkWrapper(chunk)
        } catch (e: Exception) {
            null
        }
    }
    fun getChunkManager(): ChunkManager = chunkManager
}