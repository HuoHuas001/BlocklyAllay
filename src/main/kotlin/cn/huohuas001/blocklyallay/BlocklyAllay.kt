package cn.huohuas001.blocklyallay

import cn.huohuas001.blocklyallay.script.ScriptManager
import org.allaymc.api.plugin.Plugin

class BlocklyAllay : Plugin() {

    private lateinit var scriptManager: ScriptManager

    override fun onLoad() {
        pluginLogger.info("BlocklyAllay is loading...")
        scriptManager = ScriptManager(this)
    }

    override fun onEnable() {
        try {
            scriptManager.init()
            scriptManager.enableAllScripts()
            pluginLogger.info("BlocklyAllay enabled! Loaded ${scriptManager.loadedScriptNames.size} scripts.")
        } catch (e: Exception) {
            pluginLogger.error("Failed to enable BlocklyAllay", e)
        }
    }

    override fun onDisable() {
        scriptManager.shutdown()
        pluginLogger.info("BlocklyAllay disabled!")
    }

    fun getScriptManager(): ScriptManager = scriptManager
}
