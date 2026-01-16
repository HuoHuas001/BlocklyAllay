package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.item.ItemStack

/**
 * 包装ItemStack对象，暴露给JavaScript脚本使用。
 */
class ItemWrapper(private val item: ItemStack) {
    fun getType(): String = item.itemType.identifier.toString()
    fun getTypeName(): String = item.itemType.identifier.path()
    fun getCount(): Int = item.count
    fun setCount(count: Int) { item.count = count }
    fun getMeta(): Int = item.meta
    fun setMeta(meta: Int) { item.meta = meta }
    fun getDamage(): Int = item.damage
    fun setDamage(damage: Int) { item.damage = damage }
    fun getMaxDamage(): Int = item.maxDamage
    fun isBroken(): Boolean = item.isBroken
    fun getCustomName(): String = item.customName
    fun setCustomName(name: String) { item.customName = name }
    fun getLore(): List<String> = item.lore
    fun setLore(lore: List<String>) { item.lore = lore }
    fun hasEnchantments(): Boolean = item.hasEnchantments()
    fun getAttackDamage(): Float = item.calculateAttackDamage()
    fun isEmptyOrAir(): Boolean = item.isEmptyOrAir
    fun getItem(): ItemStack = item
}
