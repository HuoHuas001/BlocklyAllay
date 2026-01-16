package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerBucketFillEvent

/**
 * 包装PlayerBucketFillEvent（玩家装满桶），暴露给JavaScript脚本使用。
 */
class PlayerBucketFillEventData(private val event: PlayerBucketFillEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getBucket(): ItemWrapper = ItemWrapper(event.bucketStack)
    fun getClickX(): Int = event.interactInfo.clickedBlockPos().x()
    fun getClickY(): Int = event.interactInfo.clickedBlockPos().y()
    fun getClickZ(): Int = event.interactInfo.clickedBlockPos().z()
    fun getBlockFace(): String = event.interactInfo.blockFace().name
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
