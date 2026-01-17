package cn.huohuas001.blocklyallay.script.api.wrapper.world

import org.allaymc.api.world.Dimension

/**
 * 包装Dimension对象，暴露给JavaScript脚本使用。
 */
class DimensionWrapper(private val dimension: Dimension) {
    fun getDimensionId(): Int = dimension.dimensionInfo.dimensionId
    fun getDimensionName(): String = dimension.dimensionInfo.dimensionId.let {
        when (it) {
            0 -> "overworld"
            1 -> "nether"
            2 -> "the_end"
            else -> "unknown"
        }
    }
    fun getWorldName(): String = dimension.world.name
    fun getWorld(): WorldWrapper = WorldWrapper(dimension.world)
    fun getDimension(): Dimension = dimension
}
