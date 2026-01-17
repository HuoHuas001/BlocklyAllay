package cn.huohuas001.blocklyallay.script.api.wrapper.container

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.container.ContainerViewer
import org.allaymc.api.entity.interfaces.EntityPlayer

/**
 * 包装ContainerViewer对象，暴露给JavaScript脚本使用。
 */
class ContainerViewerWrapper(private val viewer: ContainerViewer) {
    fun isPlayer(): Boolean = viewer is EntityPlayer
    fun asPlayer(): EntityPlayerWrapper? = if (viewer is EntityPlayer) EntityPlayerWrapper(viewer) else null
    fun getOpenedContainerCount(): Int = viewer.openedContainers.size
    fun closeAllContainers() { viewer.closeAllOpenedContainers() }
    fun getViewer(): ContainerViewer = viewer
}
