package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.player.PlayerEnchantItemEvent

/**
 * 包装PlayerEnchantItemEvent（玩家附魔物品），暴露给JavaScript脚本使用。
 */
class PlayerEnchantItemEventData(private val event: PlayerEnchantItemEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun getItem(): ItemWrapper = ItemWrapper(event.itemStack)
    fun getEnchantmentCount(): Int = event.enchantments.size
    fun getRequiredLapisLazuliCount(): Int = event.requiredLapisLazuliCount
    fun setRequiredLapisLazuliCount(count: Int) { event.requiredLapisLazuliCount = count }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
