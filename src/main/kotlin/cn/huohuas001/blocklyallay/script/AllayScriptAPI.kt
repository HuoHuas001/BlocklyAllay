package cn.huohuas001.blocklyallay.script

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.script.api.bossbar.BossBarAPI
import cn.huohuas001.blocklyallay.script.api.data.ServerAPI
import cn.huohuas001.blocklyallay.script.api.event.EventListener
import cn.huohuas001.blocklyallay.script.api.event.RegisteredHandler
import cn.huohuas001.blocklyallay.script.api.form.FormAPI
import org.allaymc.api.player.Player
import org.allaymc.api.server.Server
import org.allaymc.api.world.World
import org.mozilla.javascript.Context
import org.mozilla.javascript.Function
import org.mozilla.javascript.Scriptable
import java.util.concurrent.ConcurrentHashMap

/**
 * JavaScript脚本的Allay API绑定。
 * 将核心服务器功能暴露给Blockly生成的脚本。
 * 使用Mozilla Rhino作为JavaScript引擎。
 */
class AllayScriptAPI(private val plugin: BlocklyAllay) {

    private val eventHandlers = ConcurrentHashMap<String, RegisteredHandler>()
    private val eventListener = EventListener(plugin, eventHandlers)
    private var scriptScope: Scriptable? = null

    /**
     * 设置脚本作用域（用于回调执行）
     */
    fun setScope(scope: Scriptable) {
        this.scriptScope = scope
    }

    init {
        Server.getInstance().eventBus.registerListener(eventListener)
    }

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

    fun on(eventName: String, callback: Any?) {
        if (callback is Function) {
            scriptScope?.let { scope ->
                eventHandlers[eventName] = RegisteredHandler(callback, scope)
            }
        }
    }

    fun off(eventName: String) {
        eventHandlers.remove(eventName)
    }

    // ==================== 调度器 API ====================

    fun runLater(callback: Any?, delayTicks: Int) {
        if (callback is Function) {
            val scope = scriptScope ?: return
            val func = callback
            val runnable = Runnable {
                val cx = Context.enter()
                try {
                    cx.optimizationLevel = -1
                    func.call(cx, scope, scope, emptyArray())
                } catch (e: Exception) {
                    plugin.pluginLogger.error("定时任务执行出错", e)
                } finally {
                    Context.exit()
                }
            }
            Server.getInstance().scheduler.scheduleDelayed(plugin, runnable, delayTicks)
        }
    }

    fun runRepeating(callback: Any?, periodTicks: Int) {
        if (callback is Function) {
            val scope = scriptScope ?: return
            val func = callback
            val runnable = Runnable {
                val cx = Context.enter()
                try {
                    cx.optimizationLevel = -1
                    func.call(cx, scope, scope, emptyArray())
                } catch (e: Exception) {
                    plugin.pluginLogger.error("重复任务执行出错", e)
                } finally {
                    Context.exit()
                }
            }
            Server.getInstance().scheduler.scheduleRepeating(plugin, runnable, periodTicks)
        }
    }

    fun runDelayedRepeating(callback: Any?, delayTicks: Int, periodTicks: Int) {
        if (callback is Function) {
            val scope = scriptScope ?: return
            val func = callback
            val runnable = Runnable {
                val cx = Context.enter()
                try {
                    cx.optimizationLevel = -1
                    func.call(cx, scope, scope, emptyArray())
                } catch (e: Exception) {
                    plugin.pluginLogger.error("重复任务执行出错", e)
                } finally {
                    Context.exit()
                }
            }
            Server.getInstance().scheduler.scheduleDelayedRepeating(plugin, runnable, delayTicks, periodTicks)
        }
    }

    // ==================== 表单 API ====================

    private val formAPI = FormAPI()
    private val bossBarAPI = BossBarAPI()

    fun getFormAPI(): FormAPI = formAPI

    fun getForms(): FormAPI = formAPI

    // ==================== BossBar API ====================

    fun getBossBarAPI(): BossBarAPI = bossBarAPI

    fun getBossBar(): BossBarAPI = bossBarAPI

    // ==================== 工具 API ====================

    fun log(message: String) {
        plugin.pluginLogger.info("[Script] $message")
    }

    fun cleanup() {
        eventHandlers.clear()
        Server.getInstance().eventBus.unregisterListener(eventListener)
    }
}
