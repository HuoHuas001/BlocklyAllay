package cn.huohuas001.blocklyallay.script.api.event.player

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.player.PlayerToggleCrawlEvent

/**
 * 包装PlayerToggleCrawlEvent（玩家切换爬行状态），暴露给JavaScript脚本使用。
 */
class PlayerToggleCrawlEventData(private val event: PlayerToggleCrawlEvent) {
    fun getPlayer(): EntityPlayerWrapper = EntityPlayerWrapper(event.player)
    fun isCrawling(): Boolean = event.isValue
}
