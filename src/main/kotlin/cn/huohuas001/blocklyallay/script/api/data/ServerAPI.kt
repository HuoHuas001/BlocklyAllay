package cn.huohuas001.blocklyallay.script.api.data

import cn.huohuas001.blocklyallay.script.api.wrapper.*
import cn.huohuas001.blocklyallay.script.api.wrapper.world.PlayerManagerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.world.ScoreboardManagerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.server.Server

/**
 * 提供服务器相关API，暴露给JavaScript脚本使用。
 */
class ServerAPI {
    fun getOnlineCount(): Int = Server.getInstance().playerManager.playerCount

    fun getMaxPlayers(): Int = Server.getInstance().playerManager.maxPlayerCount

    fun getCurrentTick(): Long = Server.getInstance().tick

    fun getPlayerManager(): PlayerManagerWrapper = PlayerManagerWrapper(Server.getInstance().playerManager)

    fun getPluginManager(): PluginManagerWrapper = PluginManagerWrapper(Server.getInstance().pluginManager)

    fun getScoreboardManager(): ScoreboardManagerWrapper =
        ScoreboardManagerWrapper(Server.getInstance().scoreboardManager)

    fun getWorld(name: String): WorldWrapper? {
        val world = Server.getInstance().worldPool.getWorld(name)
        return if (world != null) WorldWrapper(world) else null
    }

    fun getDefaultWorld(): WorldWrapper? {
        val world = Server.getInstance().worldPool.defaultWorld
        return if (world != null) WorldWrapper(world) else null
    }
}
