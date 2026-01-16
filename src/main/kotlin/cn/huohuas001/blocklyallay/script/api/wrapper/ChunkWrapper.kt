package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.world.chunk.Chunk

/**
 * 包装Chunk对象，暴露给JavaScript脚本使用。
 */
class ChunkWrapper(private val chunk: Chunk) {
    fun getX(): Int = chunk.x
    fun getZ(): Int = chunk.z
    fun getChunk(): Chunk = chunk
}
