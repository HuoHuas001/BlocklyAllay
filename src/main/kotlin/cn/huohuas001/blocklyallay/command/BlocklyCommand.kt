package cn.huohuas001.blocklyallay.command

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.TrKeys
import org.allaymc.api.command.Command
import org.allaymc.api.command.tree.CommandTree

/**
 * BlocklyAllay 脚本管理命令
 * 支持: reload, load, unload, list 子命令
 *
 * 用法:
 * /blockly reload [script] - 重载指定脚本或所有脚本
 * /blockly load <script> - 加载指定脚本
 * /blockly unload <script> - 卸载指定脚本
 * /blockly list - 列出已加载的脚本
 */
class BlocklyCommand(
    private val plugin: BlocklyAllay
) : Command("blockly", TrKeys.COMMAND_DESCRIPTION, "blockly.command") {

    init {
        aliases.addAll(listOf("ba"))
    }

    override fun prepareCommandTree(tree: CommandTree) {
        val root = tree.getRoot()

        // /blockly help - 显示帮助
        root.key("help")
            .exec { context ->
                sendHelp(context.getSender())
                context.success()
            }

        // /blockly reload [script] - 重载指定脚本或所有脚本
        root.key("reload")
            .permission("blockly.reload")
            .str("script")
            .optional()
            .exec { context ->
                val scriptName = context.getResult<String>(0)
                val scriptManager = plugin.scriptManager

                if (scriptName.isBlank()) {
                    // 重载所有脚本
                    scriptManager.reloadAllScripts()
                    context.getSender().sendTranslatable(
                        TrKeys.COMMAND_RELOAD_ALL,
                        scriptManager.loadedScriptNames.size
                    )
                } else {
                    // 重载指定脚本
                    val normalizedName = normalizeScriptName(scriptName)
                    if (scriptManager.reloadScript(normalizedName)) {
                        context.getSender().sendTranslatable(TrKeys.COMMAND_RELOAD_SUCCESS, normalizedName)
                    } else {
                        context.getSender().sendTranslatable(TrKeys.COMMAND_RELOAD_FAILED, normalizedName)
                    }
                }
                context.success()
            }

        // /blockly load <script> - 加载指定脚本
        root.key("load")
            .permission("blockly.load")
            .str("script")
            .exec { context ->
                val scriptName = normalizeScriptName(context.getResult<String>(0))
                val scriptManager = plugin.scriptManager

                if (scriptManager.loadScriptByName(scriptName)) {
                    context.getSender().sendTranslatable(TrKeys.COMMAND_LOAD_SUCCESS, scriptName)
                } else {
                    context.getSender().sendTranslatable(TrKeys.COMMAND_LOAD_FAILED, scriptName)
                }
                context.success()
            }

        // /blockly unload <script> - 卸载指定脚本
        root.key("unload")
            .permission("blockly.unload")
            .str("script")
            .exec { context ->
                val scriptName = normalizeScriptName(context.getResult<String>(0))
                val scriptManager = plugin.scriptManager

                if (scriptManager.unloadScriptByName(scriptName)) {
                    context.getSender().sendTranslatable(TrKeys.COMMAND_UNLOAD_SUCCESS, scriptName)
                } else {
                    context.getSender().sendTranslatable(TrKeys.COMMAND_UNLOAD_FAILED, scriptName)
                }
                context.success()
            }

        // /blockly list - 列出已加载的脚本
        root.key("list")
            .permission("blockly.list")
            .exec { context ->
                val scripts = plugin.scriptManager.loadedScriptNames
                if (scripts.isEmpty()) {
                    context.getSender().sendTranslatable(TrKeys.COMMAND_LIST_EMPTY)
                } else {
                    context.getSender().sendTranslatable(TrKeys.COMMAND_LIST_HEADER, scripts.size)
                    scripts.forEach { name ->
                        context.getSender().sendTranslatable(TrKeys.COMMAND_LIST_ITEM, name)
                    }
                }
                context.success()
            }
    }

    private fun sendHelp(sender: org.allaymc.api.command.CommandSender) {
        sender.sendTranslatable(TrKeys.COMMAND_HELP_HEADER)
        sender.sendTranslatable(TrKeys.COMMAND_HELP_RELOAD)
        sender.sendTranslatable(TrKeys.COMMAND_HELP_LOAD)
        sender.sendTranslatable(TrKeys.COMMAND_HELP_UNLOAD)
        sender.sendTranslatable(TrKeys.COMMAND_HELP_LIST)
    }

    private fun normalizeScriptName(name: String): String {
        return if (name.endsWith(".js")) name else "$name.js"
    }
}