package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.ChunkWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.DimensionWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.WorldWrapper
import org.allaymc.api.eventbus.event.world.ChunkUnloadEvent

/**
 * 包装ChunkUnloadEvent（区块卸载），暴露给JavaScript脚本使用。
 */
class ChunkUnloadEventData(private val event: ChunkUnloadEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getDimension(): DimensionWrapper = DimensionWrapper(event.dimension)
    fun getChunk(): ChunkWrapper = ChunkWrapper(event.chunk)
    fun getChunkX(): Int = event.chunk.x
    fun getChunkZ(): Int = event.chunk.z
}
