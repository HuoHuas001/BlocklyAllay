package cn.huohuas001.blocklyallay.script.api.event.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ContainerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.eventbus.event.container.ContainerItemPickupEvent

/**
 * 包装ContainerItemPickupEvent（掉落物被容器拾取，如漏斗），暴露给JavaScript脚本使用。
 */
class ContainerItemPickupEventData(private val event: ContainerItemPickupEvent) {
    fun getItemType(): String = event.itemEntity.itemStack.itemType.identifier.toString()
    fun getItem(): ItemWrapper = ItemWrapper(event.itemEntity.itemStack)
    fun getDestination(): ContainerWrapper = ContainerWrapper(event.destination)
    fun getDestinationSlot(): Int = event.destinationSlot
    fun getCount(): Int = event.count
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
