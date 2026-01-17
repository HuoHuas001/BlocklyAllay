package cn.huohuas001.blocklyallay.script.api.wrapper.block

import org.allaymc.api.block.dto.Block

/**
 * 包装Block对象，暴露给JavaScript脚本使用。
 */
class BlockWrapper(private val block: Block) {
    fun getX(): Int = block.position.x()
    fun getY(): Int = block.position.y()
    fun getZ(): Int = block.position.z()
    fun getType(): String = block.blockState.blockType.identifier.toString()
    fun getTypeName(): String = block.blockState.blockType.identifier.path()
    fun isAir(): Boolean = block.isAir
    fun isPowered(): Boolean = block.isPowered
    fun getPower(): Int = block.power
    fun breakBlock(): Boolean = block.breakBlock()
    fun getDimensionId(): Int = block.dimension.dimensionInfo.dimensionId
    fun getBlock(): Block = block
}
