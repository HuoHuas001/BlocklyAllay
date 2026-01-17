package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.container.ContainerWrapper
import org.allaymc.api.eventbus.event.container.ContainerItemMoveEvent

/**
 * 包装ContainerItemMoveEvent（物品在容器间移动，如漏斗），暴露给JavaScript脚本使用。
 */
class ContainerItemMoveEventData(private val event: ContainerItemMoveEvent) {
    fun getSource(): ContainerWrapper = ContainerWrapper(event.source)
    fun getSourceSlot(): Int = event.sourceSlot
    fun getDestination(): ContainerWrapper = ContainerWrapper(event.destination)
    fun getDestinationSlot(): Int = event.destinationSlot
    fun getItemType(): String = event.itemType.identifier.toString()
    fun getCount(): Int = event.count
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
