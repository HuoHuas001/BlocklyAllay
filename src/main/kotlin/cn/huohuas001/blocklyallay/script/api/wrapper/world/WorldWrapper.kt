package cn.huohuas001.blocklyallay.script.api.wrapper.world

import org.allaymc.api.world.World

/**
 * 包装World对象，暴露给JavaScript脚本使用。
 */
class WorldWrapper(private val world: World) {
    fun getName(): String = world.name
    fun getDisplayName(): String = world.worldData.displayName
    fun getTimeOfDay(): Int = world.worldData.timeOfDay
    fun setTimeOfDay(time: Int) { world.worldData.timeOfDay = time }
    fun getTotalTime(): Long = world.worldData.totalTime
    fun getDifficulty(): Int = world.worldData.difficulty.ordinal
    fun getSpawnX(): Int = world.worldData.spawnPoint.x()
    fun getSpawnY(): Int = world.worldData.spawnPoint.y()
    fun getSpawnZ(): Int = world.worldData.spawnPoint.z()

    fun getOverWorld(): DimensionWrapper? {
        val dimension = world.getOverWorld()
        return if (dimension != null) DimensionWrapper(dimension) else null
    }

    fun getNether(): DimensionWrapper? {
        val dimension = world.getNether()
        return if (dimension != null) DimensionWrapper(dimension) else null
    }

    fun getTheEnd(): DimensionWrapper? {
        val dimension = world.getTheEnd()
        return if (dimension != null) DimensionWrapper(dimension) else null
    }

    fun getDimension(dimensionId: Int): DimensionWrapper? {
        val dimension = world.getDimension(dimensionId)
        return if (dimension != null) DimensionWrapper(dimension) else null
    }

    fun getWorld(): World = world
}
