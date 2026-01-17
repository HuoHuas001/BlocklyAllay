package cn.huohuas001.blocklyallay.script.api.bossbar

import cn.huohuas001.blocklyallay.script.api.wrapper.BossBarWrapper
import org.allaymc.api.bossbar.BossBar
import org.allaymc.api.bossbar.BossBarColor

/**
 * BossBar API for JavaScript scripts.
 * Boss血条API，暴露给JavaScript脚本使用。
 */
class BossBarAPI {

    /**
     * 创建新的BossBar
     */
    fun create(): BossBarWrapper = BossBarWrapper(BossBar.create())

    /**
     * 创建带标题的BossBar
     */
    fun create(title: String): BossBarWrapper {
        val bar = BossBar.create()
        bar.title = title
        return BossBarWrapper(bar)
    }

    /**
     * 创建完整配置的BossBar
     */
    fun create(title: String, progress: Float, color: String): BossBarWrapper {
        val bar = BossBar.create()
        bar.title = title
        bar.progress = progress.coerceIn(0f, 1f)
        bar.color = parseColor(color)
        return BossBarWrapper(bar)
    }

    private fun parseColor(color: String): BossBarColor {
        return try {
            BossBarColor.valueOf(color.uppercase())
        } catch (e: Exception) {
            BossBarColor.PINK
        }
    }
}


