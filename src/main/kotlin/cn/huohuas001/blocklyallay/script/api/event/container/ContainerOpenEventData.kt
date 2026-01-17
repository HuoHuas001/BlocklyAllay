package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.container.ContainerViewerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.container.ContainerWrapper
import org.allaymc.api.eventbus.event.container.ContainerOpenEvent

/**
 * 包装ContainerOpenEvent（打开容器），暴露给JavaScript脚本使用。
 */
class ContainerOpenEventData(private val event: ContainerOpenEvent) {
    fun getViewer(): ContainerViewerWrapper = ContainerViewerWrapper(event.viewer)
    fun getContainer(): ContainerWrapper = ContainerWrapper(event.container)
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
