package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ContainerViewerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ContainerWrapper
import org.allaymc.api.eventbus.event.container.ContainerCloseEvent

/**
 * 包装ContainerCloseEvent（关闭容器），暴露给JavaScript脚本使用。
 */
class ContainerCloseEventData(private val event: ContainerCloseEvent) {
    fun getViewer(): ContainerViewerWrapper = ContainerViewerWrapper(event.viewer)
    fun getContainer(): ContainerWrapper = ContainerWrapper(event.container)
}
