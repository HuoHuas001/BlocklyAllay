package cn.huohuas001.blocklyallay

import cn.huohuas001.blocklyallay.command.BlocklyCommand
import cn.huohuas001.blocklyallay.script.ScriptManager
import org.allaymc.api.command.CommandSender
import org.allaymc.api.message.I18n
import org.allaymc.api.plugin.Plugin
import org.allaymc.api.registry.Registries

class BlocklyAllay : Plugin() {

    lateinit var scriptManager: ScriptManager

    override fun onLoad() {
        pluginLogger.info(I18n.get().tr(TrKeys.PLUGIN_LOADING))
        scriptManager = ScriptManager(this)

        // 注册管理命令
        Registries.COMMANDS.register(BlocklyCommand(this))
    }

    override fun onEnable() {
        try {
            scriptManager.init()
            scriptManager.enableAllScripts()
            pluginLogger.info(I18n.get().tr(TrKeys.PLUGIN_ENABLED, scriptManager.loadedScriptNames.size))
        } catch (e: Exception) {
            pluginLogger.error(I18n.get().tr(TrKeys.PLUGIN_ENABLE_FAILED), e)
        }
    }

    override fun onDisable() {
        scriptManager.shutdown()
        pluginLogger.info(I18n.get().tr(TrKeys.PLUGIN_DISABLED))
    }
}
