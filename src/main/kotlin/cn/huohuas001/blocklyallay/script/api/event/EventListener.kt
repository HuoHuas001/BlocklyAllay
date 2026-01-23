package cn.huohuas001.blocklyallay.script.api.event

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.script.api.event.block.*
import cn.huohuas001.blocklyallay.script.api.event.command.CommandExecuteEventData
import cn.huohuas001.blocklyallay.script.api.event.container.*
import cn.huohuas001.blocklyallay.script.api.event.entity.*
import cn.huohuas001.blocklyallay.script.api.event.player.*
import cn.huohuas001.blocklyallay.script.api.event.plugin.*
import cn.huohuas001.blocklyallay.script.api.event.scoreboard.*
import cn.huohuas001.blocklyallay.script.api.event.server.*
import cn.huohuas001.blocklyallay.script.api.event.world.*
import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import cn.huohuas001.blocklyallay.script.api.wrapper.PlayerWrapper
import org.allaymc.api.eventbus.EventHandler
import org.allaymc.api.eventbus.event.block.*
import org.allaymc.api.eventbus.event.command.CommandExecuteEvent
import org.allaymc.api.eventbus.event.container.*
import org.allaymc.api.eventbus.event.entity.*
import org.allaymc.api.eventbus.event.player.*
import org.allaymc.api.eventbus.event.plugin.*
import org.allaymc.api.eventbus.event.scoreboard.*
import org.allaymc.api.eventbus.event.server.*
import org.allaymc.api.eventbus.event.world.*
import org.graalvm.polyglot.Value
import java.util.concurrent.ConcurrentHashMap

/**
 * 事件监听器，将Allay事件分发到JavaScript脚本。
 */
class EventListener(
    private val plugin: BlocklyAllay,
    private val eventHandlers: ConcurrentHashMap<String, RegisteredHandler>
) {
    // ==================== 服务器事件 ====================

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        dispatchEvent("playerJoin", PlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        dispatchEvent("playerQuit", PlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerConnect(event: PlayerConnectEvent) {
        dispatchEvent("playerConnect", PlayerConnectEventData(event))
    }

    @EventHandler
    fun onPlayerDisconnect(event: PlayerDisconnectEvent) {
        dispatchEvent("playerDisconnect", PlayerDisconnectEventData(event))
    }

    @EventHandler
    fun onPlayerLogin(event: PlayerLoginEvent) {
        dispatchEvent("playerLogin", PlayerLoginEventData(event))
    }

    @EventHandler
    fun onPlayerKick(event: PlayerKickEvent) {
        dispatchEvent("playerKick", PlayerKickEventData(event))
    }

    @EventHandler
    fun onPlayerSpawn(event: PlayerSpawnEvent) {
        dispatchEvent("playerSpawn", PlayerSpawnEventData(event))
    }

    @EventHandler
    fun onPlayerBan(event: PlayerBanEvent) {
        dispatchEvent("playerBan", PlayerBanEventData(event))
    }

    @EventHandler
    fun onPlayerUnban(event: PlayerUnbanEvent) {
        dispatchEvent("playerUnban", PlayerUnbanEventData(event))
    }

    @EventHandler
    fun onIPBan(event: IPBanEvent) {
        dispatchEvent("ipBan", IPBanEventData(event))
    }

    @EventHandler
    fun onIPUnban(event: IPUnbanEvent) {
        dispatchEvent("ipUnban", IPUnbanEventData(event))
    }

    @EventHandler
    fun onServerStop(event: ServerStopEvent) {
        dispatchEvent("serverStop", ServerStopEventData(event))
    }

    @EventHandler
    fun onWhitelistAddPlayer(event: WhitelistAddPlayerEvent) {
        dispatchEvent("whitelistAddPlayer", WhitelistAddPlayerEventData(event))
    }

    @EventHandler
    fun onWhitelistRemovePlayer(event: WhitelistRemovePlayerEvent) {
        dispatchEvent("whitelistRemovePlayer", WhitelistRemovePlayerEventData(event))
    }

    // ==================== 玩家事件 ====================

    @EventHandler
    fun onPlayerChat(event: PlayerChatEvent) {
        dispatchEvent("playerChat", ChatEventData(event))
    }

    @EventHandler
    fun onPlayerCommand(event: PlayerCommandEvent) {
        dispatchEvent("playerCommand", PlayerCommandEventData(event))
    }

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        dispatchEvent("playerMove", PlayerMoveEventData(event))
    }

    @EventHandler
    fun onPlayerInteractBlock(event: PlayerInteractBlockEvent) {
        dispatchEvent("playerInteractBlock", PlayerInteractBlockEventData(event))
    }

    @EventHandler
    fun onPlayerDropItem(event: PlayerDropItemEvent) {
        dispatchEvent("playerDropItem", PlayerDropItemEventData(event))
    }

    @EventHandler
    fun onPlayerJump(event: PlayerJumpEvent) {
        dispatchEvent("playerJump", EntityPlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerToggleSneak(event: PlayerToggleSneakEvent) {
        dispatchEvent("playerToggleSneak", EntityPlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerToggleSprint(event: PlayerToggleSprintEvent) {
        dispatchEvent("playerToggleSprint", EntityPlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerRespawn(event: PlayerRespawnEvent) {
        dispatchEvent("playerRespawn", EntityPlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerGameModeChange(event: PlayerGameModeChangeEvent) {
        dispatchEvent("playerGameModeChange", EntityPlayerWrapper(event.player))
    }

    @EventHandler
    fun onPlayerBlockPick(event: PlayerBlockPickEvent) {
        dispatchEvent("playerBlockPick", PlayerBlockPickEventData(event))
    }

    @EventHandler
    fun onPlayerBookEdit(event: PlayerBookEditEvent) {
        dispatchEvent("playerBookEdit", PlayerBookEditEventData(event))
    }

    @EventHandler
    fun onPlayerBucketEmpty(event: PlayerBucketEmptyEvent) {
        dispatchEvent("playerBucketEmpty", PlayerBucketEmptyEventData(event))
    }

    @EventHandler
    fun onPlayerBucketFill(event: PlayerBucketFillEvent) {
        dispatchEvent("playerBucketFill", PlayerBucketFillEventData(event))
    }

    @EventHandler
    fun onPlayerChangeSkin(event: PlayerChangeSkinEvent) {
        dispatchEvent("playerChangeSkin", PlayerChangeSkinEventData(event))
    }

    @EventHandler
    fun onPlayerCraftItem(event: PlayerCraftItemEvent) {
        dispatchEvent("playerCraftItem", PlayerCraftItemEventData(event))
    }

    @EventHandler
    fun onPlayerEat(event: PlayerEatEvent) {
        dispatchEvent("playerEat", PlayerEatEventData(event))
    }

    @EventHandler
    fun onPlayerEnchantItem(event: PlayerEnchantItemEvent) {
        dispatchEvent("playerEnchantItem", PlayerEnchantItemEventData(event))
    }

    @EventHandler
    fun onPlayerExperienceLevelChange(event: PlayerExperienceLevelChangeEvent) {
        dispatchEvent("playerExperienceLevelChange", PlayerExperienceLevelChangeEventData(event))
    }

    @EventHandler
    fun onPlayerFoodLevelChange(event: PlayerFoodLevelChangeEvent) {
        dispatchEvent("playerFoodLevelChange", PlayerFoodLevelChangeEventData(event))
    }

    @EventHandler
    fun onPlayerInteractEntity(event: PlayerInteractEntityEvent) {
        dispatchEvent("playerInteractEntity", PlayerInteractEntityEventData(event))
    }

    @EventHandler
    fun onPlayerItemHeld(event: PlayerItemHeldEvent) {
        dispatchEvent("playerItemHeld", PlayerItemHeldEventData(event))
    }

    @EventHandler
    fun onPlayerPunchAir(event: PlayerPunchAirEvent) {
        dispatchEvent("playerPunchAir", PlayerPunchAirEventData(event))
    }

    @EventHandler
    fun onPlayerPunchBlock(event: PlayerPunchBlockEvent) {
        dispatchEvent("playerPunchBlock", PlayerPunchBlockEventData(event))
    }

    @EventHandler
    fun onPlayerToggleCrawl(event: PlayerToggleCrawlEvent) {
        dispatchEvent("playerToggleCrawl", PlayerToggleCrawlEventData(event))
    }

    @EventHandler
    fun onPlayerToggleFlight(event: PlayerToggleFlightEvent) {
        dispatchEvent("playerToggleFlight", PlayerToggleFlightEventData(event))
    }

    @EventHandler
    fun onPlayerToggleGlide(event: PlayerToggleGlideEvent) {
        dispatchEvent("playerToggleGlide", PlayerToggleGlideEventData(event))
    }

    @EventHandler
    fun onPlayerToggleSwim(event: PlayerToggleSwimEvent) {
        dispatchEvent("playerToggleSwim", PlayerToggleSwimEventData(event))
    }

    @EventHandler
    fun onPlayerUseItemInAir(event: PlayerUseItemInAirEvent) {
        dispatchEvent("playerUseItemInAir", PlayerUseItemInAirEventData(event))
    }

    // ==================== 方块事件 ====================

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        dispatchEvent("blockBreak", BlockBreakEventData(event))
    }

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        dispatchEvent("blockPlace", BlockPlaceEventData(event))
    }

    @EventHandler
    fun onBlockBurn(event: BlockBurnEvent) {
        dispatchEvent("blockBurn", BlockBurnEventData(event))
    }

    @EventHandler
    fun onBlockExplode(event: BlockExplodeEvent) {
        dispatchEvent("blockExplode", BlockExplodeEventData(event))
    }

    @EventHandler
    fun onBlockFade(event: BlockFadeEvent) {
        dispatchEvent("blockFade", BlockFadeEventData(event))
    }

    @EventHandler
    fun onBlockIgnite(event: BlockIgniteEvent) {
        dispatchEvent("blockIgnite", BlockIgniteEventData(event))
    }

    @EventHandler
    fun onBlockGrow(event: BlockGrowEvent) {
        dispatchEvent("blockGrow", BlockGrowEventData(event))
    }

    @EventHandler
    fun onBlockSpread(event: BlockSpreadEvent) {
        dispatchEvent("blockSpread", BlockSpreadEventData(event))
    }

    @EventHandler
    fun onLiquidFlow(event: LiquidFlowEvent) {
        dispatchEvent("liquidFlow", LiquidFlowEventData(event))
    }

    @EventHandler
    fun onSignTextChange(event: SignTextChangeEvent) {
        dispatchEvent("signTextChange", SignTextChangeEventData(event))
    }

    @EventHandler
    fun onAnvilDamage(event: AnvilDamageEvent) {
        dispatchEvent("anvilDamage", AnvilDamageEventData(event))
    }

    @EventHandler
    fun onBlockFall(event: BlockFallEvent) {
        dispatchEvent("blockFall", BlockFallEventData(event))
    }

    @EventHandler
    fun onBlockNeighborUpdate(event: BlockNeighborUpdateEvent) {
        dispatchEvent("blockNeighborUpdate", BlockNeighborUpdateEventData(event))
    }

    @EventHandler
    fun onBlockRandomUpdate(event: BlockRandomUpdateEvent) {
        dispatchEvent("blockRandomUpdate", BlockRandomUpdateEventData(event))
    }

    @EventHandler
    fun onBlockScheduleUpdate(event: BlockScheduleUpdateEvent) {
        dispatchEvent("blockScheduleUpdate", BlockScheduleUpdateEventData(event))
    }

    @EventHandler
    fun onItemFrameUse(event: ItemFrameUseEvent) {
        dispatchEvent("itemFrameUse", ItemFrameUseEventData(event))
    }

    @EventHandler
    fun onLiquidDecay(event: LiquidDecayEvent) {
        dispatchEvent("liquidDecay", LiquidDecayEventData(event))
    }

    @EventHandler
    fun onLiquidHarden(event: LiquidHardenEvent) {
        dispatchEvent("liquidHarden", LiquidHardenEventData(event))
    }

    @EventHandler
    fun onSignWax(event: SignWaxEvent) {
        dispatchEvent("signWax", SignWaxEventData(event))
    }

    // ==================== 命令事件 ====================

    @EventHandler
    fun onCommandExecute(event: CommandExecuteEvent) {
        dispatchEvent("commandExecute", CommandExecuteEventData(event))
    }

    // ==================== 容器事件 ====================

    @EventHandler
    fun onContainerOpen(event: ContainerOpenEvent) {
        dispatchEvent("containerOpen", ContainerOpenEventData(event))
    }

    @EventHandler
    fun onContainerClose(event: ContainerCloseEvent) {
        dispatchEvent("containerClose", ContainerCloseEventData(event))
    }

    @EventHandler
    fun onContainerItemMove(event: ContainerItemMoveEvent) {
        dispatchEvent("containerItemMove", ContainerItemMoveEventData(event))
    }

    @EventHandler
    fun onContainerItemPickup(event: ContainerItemPickupEvent) {
        dispatchEvent("containerItemPickup", ContainerItemPickupEventData(event))
    }

    @EventHandler
    fun onAnvilTakeResult(event: AnvilTakeResultEvent) {
        dispatchEvent("anvilTakeResult", AnvilTakeResultEventData(event))
    }

    @EventHandler
    fun onGrindstoneTakeResult(event: GrindstoneTakeResultEvent) {
        dispatchEvent("grindstoneTakeResult", GrindstoneTakeResultEventData(event))
    }

    @EventHandler
    fun onFurnaceSmelt(event: FurnaceSmeltEvent) {
        dispatchEvent("furnaceSmelt", FurnaceSmeltEventData(event))
    }

    @EventHandler
    fun onFurnaceConsumeFuel(event: FurnaceConsumeFuelEvent) {
        dispatchEvent("furnaceConsumeFuel", FurnaceConsumeFuelEventData(event))
    }

    @EventHandler
    fun onBrewingStandBrew(event: BrewingStandBrewEvent) {
        dispatchEvent("brewingStandBrew", BrewingStandBrewEventData(event))
    }

    @EventHandler
    fun onBrewingStandConsumeFuel(event: BrewingStandConsumeFuelEvent) {
        dispatchEvent("brewingStandConsumeFuel", BrewingStandConsumeFuelEventData(event))
    }

    @EventHandler
    fun onBrewingStandStartBrew(event: BrewingStandStartBrewEvent) {
        dispatchEvent("brewingStandStartBrew", BrewingStandStartBrewEventData(event))
    }

    @EventHandler
    fun onCampfireSmelt(event: CampfireSmeltEvent) {
        dispatchEvent("campfireSmelt", CampfireSmeltEventData(event))
    }

    // ==================== 实体事件 ====================

    @EventHandler
    fun onEntityDamage(event: EntityDamageEvent) {
        dispatchEvent("entityDamage", EntityDamageEventData(event))
    }

    @EventHandler
    fun onEntityDie(event: EntityDieEvent) {
        dispatchEvent("entityDie", EntityDieEventData(event))
    }

    @EventHandler
    fun onEntitySpawn(event: EntitySpawnEvent) {
        dispatchEvent("entitySpawn", EntitySpawnEventData(event))
    }

    @EventHandler
    fun onEntityDespawn(event: EntityDespawnEvent) {
        dispatchEvent("entityDespawn", EntityDespawnEventData(event))
    }

    @EventHandler
    fun onEntityCombust(event: EntityCombustEvent) {
        dispatchEvent("entityCombust", EntityCombustEventData(event))
    }

    @EventHandler
    fun onEntityEffectAdd(event: EntityEffectAddEvent) {
        dispatchEvent("entityEffectAdd", EntityEffectAddEventData(event))
    }

    @EventHandler
    fun onEntityEffectRemove(event: EntityEffectRemoveEvent) {
        dispatchEvent("entityEffectRemove", EntityEffectRemoveEventData(event))
    }

    @EventHandler
    fun onEntityExplode(event: EntityExplodeEvent) {
        dispatchEvent("entityExplode", EntityExplodeEventData(event))
    }

    @EventHandler
    fun onEntityFall(event: EntityFallEvent) {
        dispatchEvent("entityFall", EntityFallEventData(event))
    }

    @EventHandler
    fun onEntityHealthChange(event: EntityHealthChangeEvent) {
        dispatchEvent("entityHealthChange", EntityHealthChangeEventData(event))
    }

    @EventHandler
    fun onEntityMove(event: EntityMoveEvent) {
        dispatchEvent("entityMove", EntityMoveEventData(event))
    }

    @EventHandler
    fun onEntitySetMotion(event: EntitySetMotionEvent) {
        dispatchEvent("entitySetMotion", EntitySetMotionEventData(event))
    }

    @EventHandler
    fun onEntityShootBow(event: EntityShootBowEvent) {
        dispatchEvent("entityShootBow", EntityShootBowEventData(event))
    }

    @EventHandler
    fun onEntityShootCrossbow(event: EntityShootCrossbowEvent) {
        dispatchEvent("entityShootCrossbow", EntityShootCrossbowEventData(event))
    }

    @EventHandler
    fun onEntityTeleport(event: EntityTeleportEvent) {
        dispatchEvent("entityTeleport", EntityTeleportEventData(event))
    }

    @EventHandler
    fun onEntityTrampleFarmland(event: EntityTrampleFarmlandEvent) {
        dispatchEvent("entityTrampleFarmland", EntityTrampleFarmlandEventData(event))
    }

    @EventHandler
    fun onFireworkExplode(event: FireworkExplodeEvent) {
        dispatchEvent("fireworkExplode", FireworkExplodeEventData(event))
    }

    @EventHandler
    fun onProjectileHit(event: ProjectileHitEvent) {
        dispatchEvent("projectileHit", ProjectileHitEventData(event))
    }

    @EventHandler
    fun onProjectileLaunch(event: ProjectileLaunchEvent) {
        dispatchEvent("projectileLaunch", ProjectileLaunchEventData(event))
    }

    // ==================== 计分板事件 ====================

    @EventHandler
    fun onScoreboardAdd(event: ScoreboardAddEvent) {
        dispatchEvent("scoreboardAdd", ScoreboardAddEventData(event))
    }

    @EventHandler
    fun onScoreboardRemove(event: ScoreboardRemoveEvent) {
        dispatchEvent("scoreboardRemove", ScoreboardRemoveEventData(event))
    }

    @EventHandler
    fun onScoreboardAllLinesRemove(event: ScoreboardAllLinesRemoveEvent) {
        dispatchEvent("scoreboardAllLinesRemove", ScoreboardAllLinesRemoveEventData(event))
    }

    @EventHandler
    fun onScoreboardLineAdd(event: ScoreboardLineAddEvent) {
        dispatchEvent("scoreboardLineAdd", ScoreboardLineAddEventData(event))
    }

    @EventHandler
    fun onScoreboardLineRemove(event: ScoreboardLineRemoveEvent) {
        dispatchEvent("scoreboardLineRemove", ScoreboardLineRemoveEventData(event))
    }

    @EventHandler
    fun onScoreboardLineValueChange(event: ScoreboardLineValueChangeEvent) {
        dispatchEvent("scoreboardLineValueChange", ScoreboardLineValueChangeEventData(event))
    }

    // ==================== 世界事件 ====================

    @EventHandler
    fun onChunkLoad(event: ChunkLoadEvent) {
        dispatchEvent("chunkLoad", ChunkLoadEventData(event))
    }

    @EventHandler
    fun onChunkUnload(event: ChunkUnloadEvent) {
        dispatchEvent("chunkUnload", ChunkUnloadEventData(event))
    }

    @EventHandler
    fun onDifficultyChange(event: DifficultyChangeEvent) {
        dispatchEvent("difficultyChange", DifficultyChangeEventData(event))
    }

    @EventHandler
    fun onGameRuleChange(event: GameRuleChangeEvent) {
        dispatchEvent("gameRuleChange", GameRuleChangeEventData(event))
    }

    @EventHandler
    fun onSpawnPointChange(event: SpawnPointChangeEvent) {
        dispatchEvent("spawnPointChange", SpawnPointChangeEventData(event))
    }

    @EventHandler
    fun onTimeChange(event: TimeChangeEvent) {
        dispatchEvent("timeChange", TimeChangeEventData(event))
    }

    @EventHandler
    fun onWeatherChange(event: WeatherChangeEvent) {
        dispatchEvent("weatherChange", WeatherChangeEventData(event))
    }

    @EventHandler
    fun onWorldDataSave(event: WorldDataSaveEvent) {
        dispatchEvent("worldDataSave", WorldDataSaveEventData(event))
    }

    @EventHandler
    fun onWorldLoad(event: WorldLoadEvent) {
        dispatchEvent("worldLoad", WorldLoadEventData(event))
    }

    @EventHandler
    fun onWorldUnload(event: WorldUnloadEvent) {
        dispatchEvent("worldUnload", WorldUnloadEventData(event))
    }

    // ==================== 插件事件 ====================

    @EventHandler
    fun onPluginEnable(event: PluginEnableEvent) {
        dispatchEvent("pluginEnable", PluginEnableEventData(event))
    }

    @EventHandler
    fun onPluginDisable(event: PluginDisableEvent) {
        dispatchEvent("pluginDisable", PluginDisableEventData(event))
    }

    // ==================== 事件分发 ====================

    private fun dispatchEvent(eventName: String, vararg args: Any) {
        eventHandlers[eventName]?.let { handler ->
            try {
                // GraalJS可以直接传递Java对象，无需转换
                handler.function.execute(*args)
            } catch (e: Exception) {
                plugin.pluginLogger.error("处理事件时出错: $eventName", e)
            }
        }
    }
}
