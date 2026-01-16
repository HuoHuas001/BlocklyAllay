package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ContainerViewerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ContainerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.AnvilTakeResultEvent

/**
 * 包装AnvilTakeResultEvent（从铁砧取出结果），暴露给JavaScript脚本使用。
 */
class AnvilTakeResultEventData(private val event: AnvilTakeResultEvent) {
    fun getViewer(): ContainerViewerWrapper = ContainerViewerWrapper(event.viewer)
    fun getContainer(): ContainerWrapper = ContainerWrapper(event.container)
    fun getResultItem(): ItemWrapper = ItemWrapper(event.resultItem)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
