package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.container.ContainerViewerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.container.ContainerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.GrindstoneTakeResultEvent

/**
 * 包装GrindstoneTakeResultEvent（从砂轮取出结果），暴露给JavaScript脚本使用。
 */
class GrindstoneTakeResultEventData(private val event: GrindstoneTakeResultEvent) {
    fun getViewer(): ContainerViewerWrapper = ContainerViewerWrapper(event.viewer)
    fun getContainer(): ContainerWrapper = ContainerWrapper(event.container)
    fun getResultItem(): ItemWrapper = ItemWrapper(event.resultItem)
    fun getExperienceAmount(): Int = event.experienceAmount
    fun setExperienceAmount(amount: Int) { event.experienceAmount = amount }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
