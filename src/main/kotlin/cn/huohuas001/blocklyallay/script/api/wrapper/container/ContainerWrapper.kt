package cn.huohuas001.blocklyallay.script.api.wrapper.container

import cn.huohuas001.blocklyallay.script.api.wrapper.ItemWrapper
import org.allaymc.api.container.Container

/**
 * 包装Container对象，暴露给JavaScript脚本使用。
 */
class ContainerWrapper(private val container: Container) {
    fun getType(): String = container.javaClass.simpleName
    fun getSize(): Int = container.itemStackArray.size
    fun isEmpty(): Boolean = container.isEmpty
    fun isFull(): Boolean = container.isFull
    fun getItem(slot: Int): ItemWrapper? {
        val item = container.getItemStack(slot)
        return if (item.isEmptyOrAir) null else ItemWrapper(item)
    }
    fun isSlotEmpty(slot: Int): Boolean = container.isEmpty(slot)
    fun getViewerCount(): Int = container.viewers.size
    fun clearSlot(slot: Int) { container.clearSlot(slot) }
    fun clearAll() { container.clearAllSlots() }
    fun getContainer(): Container = container
}
