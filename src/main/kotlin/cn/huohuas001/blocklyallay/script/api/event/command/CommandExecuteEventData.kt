package cn.huohuas001.blocklyallay.script.api.event.command

import cn.huohuas001.blocklyallay.script.api.wrapper.CommandSenderWrapper
import org.allaymc.api.eventbus.event.command.CommandExecuteEvent

/**
 * 包装CommandExecuteEvent（命令执行），暴露给JavaScript脚本使用。
 */
class CommandExecuteEventData(private val event: CommandExecuteEvent) {
    fun getSender(): CommandSenderWrapper = CommandSenderWrapper(event.commandSender)
    fun getCommand(): String = event.command
    fun setCommand(command: String) { event.command = command }
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
