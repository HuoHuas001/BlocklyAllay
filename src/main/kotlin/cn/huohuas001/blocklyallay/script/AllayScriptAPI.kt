package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.TrKeys
import cn.huohuas001.blocklyallay.script.api.bossbar.BossBarAPI
import cn.huohuas001.blocklyallay.script.api.command.CommandAPI
import cn.huohuas001.blocklyallay.script.api.data.PluginInfo
import cn.huohuas001.blocklyallay.script.api.data.ServerAPI
import cn.huohuas001.blocklyallay.script.api.event.EventListener
import cn.huohuas001.blocklyallay.script.api.event.RegisteredHandler
import cn.huohuas001.blocklyallay.script.api.form.FormAPI
import cn.huohuas001.blocklyallay.script.api.util.FileAPI
import org.allaymc.api.message.I18n
import cn.huohuas001.blocklyallay.script.api.util.HttpAPI
import org.allaymc.api.player.Player
import org.allaymc.api.server.Server
import org.allaymc.api.world.World
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value
import java.util.concurrent.ConcurrentHashMap

/**
 * JavaScript脚本的Allay API绑定。
 * 将核心服务器功能暴露给Blockly生成的脚本。
 * 使用GraalJS作为JavaScript引擎。
 */
class AllayScriptAPI(private val plugin: BlocklyAllay) {

    private val eventHandlers = ConcurrentHashMap<String, RegisteredHandler>()
    private val eventListener = EventListener(plugin, eventHandlers)
    private var scriptContext: Context? = null
    private var pluginInfo: PluginInfo? = null
    private var scriptLogger: ScriptLogger? = null

    /**
     * 设置脚本上下文（用于回调执行）
     */
    fun setContext(context: Context) {
        this.scriptContext = context
    }

    init {
        Server.getInstance().eventBus.registerListener(eventListener)
    }

    // ==================== API 实例 ====================

    private val fileAPI = FileAPI(plugin)
    private val httpAPI = HttpAPI(plugin)
    private val formAPI = FormAPI()
    private val bossBarAPI = BossBarAPI()

    // ==================== 服务器 API ====================

    fun getServer(): ServerAPI = ServerAPI()

    fun broadcast(message: String) {
        Server.getInstance().messageChannel.broadcastMessage(message)
    }

    fun getOnlinePlayers(): Collection<Player> =
        Server.getInstance().playerManager.players.values

    fun getPlayer(name: String): Player? =
        Server.getInstance().playerManager.getPlayerByName(name)

    // ==================== 世界 API ====================

    fun getWorlds(): Collection<World> =
        Server.getInstance().worldPool.worlds.values

    fun getWorld(name: String): World? =
        Server.getInstance().worldPool.getWorld(name)

    // ==================== 事件 API ====================

    fun on(eventName: String, callback: Value) {
        if (callback.canExecute()) {
            scriptContext?.let { context ->
                eventHandlers[eventName] = RegisteredHandler(callback, context)
            }
        }
    }

    fun off(eventName: String) {
        eventHandlers.remove(eventName)
    }

    // ==================== 调度器 API ====================

    fun runLater(callback: Value, delayTicks: Int) {
        if (callback.canExecute()) {
            val context = scriptContext ?: return
            val runnable = Runnable {
                try {
                    callback.execute()
                } catch (e: Exception) {
                    plugin.pluginLogger.error(I18n.get().tr(TrKeys.SCHEDULED_TASK_ERROR), e)
                }
            }
            Server.getInstance().scheduler.scheduleDelayed(plugin, runnable, delayTicks)
        }
    }

    fun runRepeating(callback: Value, periodTicks: Int) {
        if (callback.canExecute()) {
            val runnable = Runnable {
                try {
                    callback.execute()
                } catch (e: Exception) {
                    plugin.pluginLogger.error(I18n.get().tr(TrKeys.REPEATING_TASK_ERROR), e)
                }
            }
            Server.getInstance().scheduler.scheduleRepeating(plugin, runnable, periodTicks)
        }
    }

    fun runDelayedRepeating(callback: Value, delayTicks: Int, periodTicks: Int) {
        if (callback.canExecute()) {
            val runnable = Runnable {
                try {
                    callback.execute()
                } catch (e: Exception) {
                    plugin.pluginLogger.error(I18n.get().tr(TrKeys.REPEATING_TASK_ERROR), e)
                }
            }
            Server.getInstance().scheduler.scheduleDelayedRepeating(plugin, runnable, delayTicks, periodTicks)
        }
    }

    // ==================== 表单 API ====================

    fun getFormAPI(): FormAPI = formAPI

    fun getForms(): FormAPI = formAPI

    // ==================== BossBar API ====================

    fun getBossBarAPI(): BossBarAPI = bossBarAPI

    fun getBossBar(): BossBarAPI = bossBarAPI

    // ==================== Command API ====================

    private val commandAPI = CommandAPI(plugin)

    fun getCommandAPI(): CommandAPI = commandAPI

    fun getFiles(): FileAPI = fileAPI

    // ==================== HTTP API ====================

    fun getHttpAPI(): HttpAPI = httpAPI

    fun getHttp(): HttpAPI = httpAPI

    // ==================== Plugin Registration API ====================

    /**
     * 注册插件信息
     * @param pluginName 插件名称
     * @param pluginVersion 插件版本
     * @param author 作者
     */
    fun registerPlugin(pluginName: String, pluginVersion: String, author: String) {
        this.pluginInfo = PluginInfo(pluginName, pluginVersion, author)

        // 如果logger已存在，更新其插件名；否则创建新的logger
        if (this.scriptLogger == null) {
            this.scriptLogger = ScriptLogger(plugin, pluginName)
        } else {
            this.scriptLogger!!.setPluginName(pluginName)
        }

        // 更新CommandAPI的插件名
        commandAPI.setPluginName(pluginName)
    }

    /**
     * 获取脚本插件的专属Logger
     */
    fun getLogger(): ScriptLogger? = scriptLogger

    /**
     * 获取已注册的插件信息
     */
    fun getPluginInfo(): PluginInfo? = pluginInfo

    fun cleanup() {
        eventHandlers.clear()
        Server.getInstance().eventBus.unregisterListener(eventListener)
    }
}
