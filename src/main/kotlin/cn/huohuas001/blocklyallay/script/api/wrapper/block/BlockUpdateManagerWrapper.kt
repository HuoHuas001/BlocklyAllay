package cn.huohuas001.blocklyallay.script.api.wrapper.block

import org.allaymc.api.block.data.BlockFace
import org.allaymc.api.world.manager.BlockUpdateManager
import org.joml.Vector3i

/**
 * 包装BlockUpdateManager对象，暴露给JavaScript脚本使用。
 */
class BlockUpdateManagerWrapper(private val blockUpdateManager: BlockUpdateManager) {
    fun scheduleBlockUpdate(x: Int, y: Int, z: Int, time: Long) {
        val pos = Vector3i(x, y, z)
        blockUpdateManager.scheduleBlockUpdate(pos, time)
    }
    fun scheduleBlockUpdateInDelay(x: Int, y: Int, z: Int, delay: Long) {
        val pos = Vector3i(x, y, z)
        blockUpdateManager.scheduleBlockUpdateInDelay(pos, delay)
    }
    fun scheduleRandomBlockUpdateInDelay(x: Int, y: Int, z: Int, delay: Long) {
        val pos = Vector3i(x, y, z)
        blockUpdateManager.scheduleRandomBlockUpdateInDelay(pos, delay)
    }
    fun hasScheduledBlockUpdate(x: Int, y: Int, z: Int): Boolean {
        val pos = Vector3i(x, y, z)
        return blockUpdateManager.hasScheduledBlockUpdate(pos)
    }
    fun neighborBlockUpdate(x: Int, y: Int, z: Int, neighborX: Int, neighborY: Int, neighborZ: Int, face: String) {
        val pos = Vector3i(x, y, z)
        val changedNeighbour = Vector3i(neighborX, neighborY, neighborZ)
        val blockFace = try {
            BlockFace.valueOf(face.uppercase())
        } catch (e: IllegalArgumentException) {
            return
        }
        blockUpdateManager.neighborBlockUpdate(pos, changedNeighbour, blockFace)
    }
    fun getBlockUpdateManager(): BlockUpdateManager = blockUpdateManager
}