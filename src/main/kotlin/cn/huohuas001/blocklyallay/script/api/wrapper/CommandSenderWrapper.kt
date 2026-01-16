package cn.huohuas001.blocklyallay.script.api.wrapper

import org.allaymc.api.command.CommandSender
import org.allaymc.api.permission.Tristate

/**
 * 包装CommandSender对象，暴露给JavaScript脚本使用。
 */
class CommandSenderWrapper(private val sender: CommandSender) {
    fun getName(): String = sender.commandSenderName
    fun getX(): Double = sender.commandExecuteLocation.x()
    fun getY(): Double = sender.commandExecuteLocation.y()
    fun getZ(): Double = sender.commandExecuteLocation.z()
    fun isPlayer(): Boolean = sender.isPlayer
    fun isEntity(): Boolean = sender.isEntity
    fun asPlayer(): EntityPlayerWrapper? = if (sender.isPlayer) EntityPlayerWrapper(sender.asPlayer()) else null
    fun asEntity(): EntityWrapper? = if (sender.isEntity) EntityWrapper(sender.asEntity()) else null
    fun sendMessage(message: String) { sender.sendMessage(message) }
    fun hasPermission(permission: String): Boolean = sender.hasPermission(permission).asBoolean()
    fun getSender(): CommandSender = sender
}
