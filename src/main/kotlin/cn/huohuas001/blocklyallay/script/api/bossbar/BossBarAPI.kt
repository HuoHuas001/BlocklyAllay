package cn.huohuas001.blocklyallay.script.api.bossbar

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.bossbar.BossBar
import org.allaymc.api.bossbar.BossBarColor
import org.allaymc.api.bossbar.BossBarStyle
import org.allaymc.api.player.Player

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

/**
 * BossBar包装器
 */
class BossBarWrapper(private val bossBar: BossBar) {

    /**
     * 获取标题
     */
    fun getTitle(): String = bossBar.title

    /**
     * 设置标题
     */
    fun setTitle(title: String): BossBarWrapper {
        bossBar.title = title
        return this
    }

    /**
     * 获取进度（0-1）
     */
    fun getProgress(): Float = bossBar.progress

    /**
     * 设置进度（0-1）
     */
    fun setProgress(progress: Float): BossBarWrapper {
        bossBar.progress = progress.coerceIn(0f, 1f)
        return this
    }

    /**
     * 获取颜色
     */
    fun getColor(): String = bossBar.color.name.lowercase()

    /**
     * 设置颜色
     * 可用颜色: pink, blue, red, green, yellow, purple, rebecca_purple, white
     */
    fun setColor(color: String): BossBarWrapper {
        bossBar.color = try {
            BossBarColor.valueOf(color.uppercase())
        } catch (e: Exception) {
            BossBarColor.PINK
        }
        return this
    }

    /**
     * 获取样式
     */
    fun getStyle(): String = bossBar.style.name.lowercase()

    /**
     * 设置样式
     * 可用样式: solid, segmented_6, segmented_10, segmented_12, segmented_20
     */
    fun setStyle(style: String): BossBarWrapper {
        bossBar.style = try {
            BossBarStyle.valueOf(style.uppercase())
        } catch (e: Exception) {
            BossBarStyle.SOLID
        }
        return this
    }

    /**
     * 是否使天空变暗
     */
    fun isDarkenSky(): Boolean = bossBar.isDarkenSky

    /**
     * 设置是否使天空变暗
     */
    fun setDarkenSky(darken: Boolean): BossBarWrapper {
        bossBar.isDarkenSky = darken
        return this
    }

    /**
     * 添加观看者（玩家）
     */
    fun addViewer(player: EntityPlayerWrapper): BossBarWrapper {
        player.getEntity().controller?.let { bossBar.addViewer(it) }
        return this
    }

    /**
     * 添加观看者（Player对象）
     */
    fun addViewerPlayer(player: Player): BossBarWrapper {
        bossBar.addViewer(player)
        return this
    }

    /**
     * 移除观看者
     */
    fun removeViewer(player: EntityPlayerWrapper): BossBarWrapper {
        player.getEntity().controller?.let { bossBar.removeViewer(it) }
        return this
    }

    /**
     * 移除观看者（Player对象）
     */
    fun removeViewerPlayer(player: Player): BossBarWrapper {
        bossBar.removeViewer(player)
        return this
    }

    /**
     * 移除所有观看者
     */
    fun removeAllViewers(): BossBarWrapper {
        bossBar.removeAllViewers()
        return this
    }

    /**
     * 获取观看者数量
     */
    fun getViewerCount(): Int = bossBar.viewers.size

    /**
     * 显示给玩家（addViewer的别名）
     */
    fun show(player: EntityPlayerWrapper): BossBarWrapper = addViewer(player)

    /**
     * 从玩家隐藏（removeViewer的别名）
     */
    fun hide(player: EntityPlayerWrapper): BossBarWrapper = removeViewer(player)

    /**
     * 获取底层BossBar对象
     */
    fun getBossBar(): BossBar = bossBar
}
