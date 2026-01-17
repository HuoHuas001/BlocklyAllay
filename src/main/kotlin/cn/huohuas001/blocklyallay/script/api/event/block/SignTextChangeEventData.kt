package cn.huohuas001.blocklyallay.script.api.event.block

import cn.huohuas001.blocklyallay.script.api.wrapper.block.BlockWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.eventbus.event.block.SignTextChangeEvent

/**
 * 包装SignTextChangeEvent（玩家修改告示牌文本），暴露给JavaScript脚本使用。
 */
class SignTextChangeEventData(private val event: SignTextChangeEvent) {
    fun getBlock(): BlockWrapper = BlockWrapper(event.block)
    fun getEditor(): EntityPlayerWrapper = EntityPlayerWrapper(event.editor)
    fun getText(): Array<String> = event.text
    fun getLine(index: Int): String = if (index in 0..3) event.text.getOrElse(index) { "" } else ""
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}