package cn.huohuas001.blocklyallay.script.api.command

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.script.AllayScriptAPI
import cn.huohuas001.blocklyallay.script.ConsoleAPI
import org.allaymc.api.command.Command
import org.allaymc.api.command.SenderType
import org.allaymc.api.command.tree.CommandContext
import org.allaymc.api.command.tree.CommandNode
import org.allaymc.api.command.tree.CommandTree
import org.allaymc.api.registry.Registries
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value

/**
 * 命令注册 API，用于在 JavaScript 脚本中注册和创建命令。
 */
class CommandAPI(private val plugin: BlocklyAllay) {

    private val registeredCommands = mutableListOf<JSCommand>()

    /**
     * 注册一个简单的命令
     */
    fun registerCommand(name: String, description: String, callback: Value) {
        val command = JSCommand(name, description, callback)
        registeredCommands.add(command)
        try{
            Registries.COMMANDS.register(command)
            plugin.pluginLogger.info("已注册命令: $name - $description")
        } catch (e: Exception) {
            plugin.pluginLogger.error("命令注册出错: $name", e)
        }
    }

    /**
     * 注册一个带权限的命令
     */
    fun registerCommand(name: String, description: String, permission: String, callback: Value) {
        val command = JSCommand(name, description, permission, callback)
        registeredCommands.add(command)
        try{
            Registries.COMMANDS.register(command)
            plugin.pluginLogger.info("已注册命令: $name - $description")
        } catch (e: Exception) {
            plugin.pluginLogger.error("命令注册出错: $name", e)
        }
    }

    /**
     * 注册一个带别名的命令
     */
    fun registerCommand(name: String, description: String, aliases: List<String>, callback: Value) {
        val command = JSCommand(name, description, aliases, callback)
        registeredCommands.add(command)
        try{
            Registries.COMMANDS.register(command)
            plugin.pluginLogger.info("已注册命令: $name - $description")
        } catch (e: Exception) {
            plugin.pluginLogger.error("命令注册出错: $name", e)
        }
    }

    /**
     * 注册一个完整配置的命令
     */
    fun registerCommand(config: CommandConfig) {
        val command = JSCommand(config)
        registeredCommands.add(command)
        val name = config.name
        val description = config.description
        try{
            Registries.COMMANDS.register(command)
            plugin.pluginLogger.info("已注册命令: $name - $description")
        } catch (e: Exception) {
            plugin.pluginLogger.error("命令注册出错: $name", e)
        }
    }

    /**
     * 注销所有已注册的命令
     */
    fun unregisterAll() {
        registeredCommands.forEach { command ->
            Registries.COMMANDS.unregister(command.name)
        }
        registeredCommands.clear()
    }

    /**
     * JavaScript 命令配置
     */
    data class CommandConfig(
        val name: String,
        val description: String = "",
        val permission: String? = null,
        val aliases: List<String> = emptyList(),
        val callback: Value? = null,
        val requirePlayer: Boolean = false,
        val requireActualPlayer: Boolean = false
    )

    /**
     * JavaScript 包装的命令类
     */
    inner class JSCommand(
        name: String,
        description: String = "",
        permission: String? = null,
        aliases: List<String> = emptyList(),
        private val callback: Value? = null,
        private val requirePlayer: Boolean = false,
        private val requireActualPlayer: Boolean = false
    ) : Command(name, description, permission ?: "") {

        constructor(name: String, description: String, callback: Value) : this(name, description, null, emptyList(), callback, false, false)
        constructor(name: String, description: String, permission: String, callback: Value) : this(name, description, permission, emptyList(), callback, false, false)
        constructor(name: String, description: String, aliases: List<String>, callback: Value) : this(name, description, null, aliases, callback, false, false)

        constructor(config: CommandConfig) : this(
            config.name,
            config.description,
            config.permission,
            config.aliases,
            config.callback,
            config.requirePlayer,
            config.requireActualPlayer
        )

        init {
            if (aliases.isNotEmpty()) {
                this.aliases.addAll(aliases)
            }
        }

        override fun prepareCommandTree(tree: CommandTree) {
            val root = tree.getRoot()

            when {
                requireActualPlayer -> {
                    root.exec({ context, player ->
                        executeCallback(context)
                        context.success()
                    }, SenderType.ACTUAL_PLAYER)
                }
                requirePlayer -> {
                    root.exec({ context, player ->
                        executeCallback(context)
                        context.success()
                    }, SenderType.PLAYER)
                }
                else -> {
                    root.exec { context ->
                        executeCallback(context)
                        context.success()
                    }
                }
            }
        }

        private fun executeCallback(context: CommandContext) {
            if (callback != null && callback.canExecute()) {
                // 为了使命令能够访问相同的API，我们使用插件实例中已有的API实例
                val cx = Context.newBuilder("js")
                    .allowAllAccess(true)
                    .build()

                try {
                    // 创建命令上下文对象传递给 JavaScript
                    val jsContext = JSCommandContext(context)

                    // 创建AllayScriptAPI实例以便命令回调中可以访问API
                    val api = AllayScriptAPI(plugin)
                    val bindings = cx.getBindings("js")
                    bindings.putMember("allay", api)

                    // 创建控制台API
                    val consoleApi = ConsoleAPI(plugin)
                    bindings.putMember("console", consoleApi)

                    callback.execute(jsContext)
                } catch (e: Exception) {
                    plugin.pluginLogger.error("命令执行出错: $name", e)
                } finally {
                    cx.close()
                }
            }
        }
    }

    /**
     * JavaScript 命令上下文包装
     */
    class JSCommandContext(private val context: CommandContext) {
        fun getSender(): Any? = context.sender
        fun getSenderName(): String = context.sender.commandSenderName
        fun getCommandName(): String = context.command.name
        fun getArgs(): Array<String> = context.args
        fun getArg(index: Int): String? {
            return if (index >= 0 && index < context.args.size) {
                context.args[index]
            } else {
                null
            }
        }
        fun sendMessage(message: String) {
            context.sender.sendMessage(message)
        }
        fun addOutput(message: String) {
            context.addOutput(message)
        }
        fun addError(message: String) {
            context.addError(message)
        }
        fun fail(): Int = context.fail().status()
        fun success(): Int = context.success().status()
    }
}