package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.chunk.ChunkWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.world.DimensionWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.ChunkLoadEvent

/**
 * 包装ChunkLoadEvent（区块加载），暴露给JavaScript脚本使用。
 */
class ChunkLoadEventData(private val event: ChunkLoadEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getDimension(): DimensionWrapper = DimensionWrapper(event.dimension)
    fun getChunk(): ChunkWrapper = ChunkWrapper(event.chunk)
    fun getChunkX(): Int = event.chunk.x
    fun getChunkZ(): Int = event.chunk.z
}
