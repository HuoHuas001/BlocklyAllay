/**
 * Event Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;

    generator.forBlock['event_player_join'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerJoin', function(player) {\n${statements}});\n`;
    };

    generator.forBlock['event_player_quit'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerQuit', function(player) {\n${statements}});\n`;
    };

    generator.forBlock['event_player_chat'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerChat', function(event) {\n  var player = event.getPlayer();\n  var message = event.getMessage();\n${statements}});\n`;
    };

    generator.forBlock['event_player_command'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerCommand', function(event) {\n  var player = event.getPlayer();\n  var command = event.getCommand();\n${statements}});\n`;
    };

    generator.forBlock['event_player_move'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerMove', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_player_interact_block'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerInteractBlock', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_block_break'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockBreak', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_block_place'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockPlace', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_damage'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityDamage', function(event) {\n  var entity = event.getEntity();\n  var damage = event.getDamage();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_die'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityDie', function(event) {\n  var entity = event.getEntity();\n${statements}});\n`;
    };

    generator.forBlock['event_player_connect'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerConnect', function(event) {\n${statements}});\n`;
    };

    generator.forBlock['event_player_disconnect'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerDisconnect', function(event) {\n${statements}});\n`;
    };

    generator.forBlock['event_player_login'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerLogin', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_player_kick'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerKick', function(event) {\n  var player = event.getPlayer();\n  var reason = event.getReason();\n${statements}});\n`;
    };

    generator.forBlock['event_player_spawn'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerSpawn', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_player_ban'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerBan', function(event) {\n  var uuidOrName = event.getUuidOrName();\n${statements}});\n`;
    };

    generator.forBlock['event_player_unban'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerUnban', function(event) {\n  var uuidOrName = event.getUuidOrName();\n${statements}});\n`;
    };

    generator.forBlock['event_ip_ban'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('ipBan', function(event) {\n  var ip = event.getIP();\n${statements}});\n`;
    };

    generator.forBlock['event_ip_unban'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('ipUnban', function(event) {\n  var ip = event.getIP();\n${statements}});\n`;
    };

    generator.forBlock['event_server_stop'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('serverStop', function(event) {\n${statements}});\n`;
    };

    generator.forBlock['event_whitelist_add_player'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('whitelistAddPlayer', function(event) {\n  var uuidOrName = event.getUuidOrName();\n${statements}});\n`;
    };

    generator.forBlock['event_whitelist_remove_player'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('whitelistRemovePlayer', function(event) {\n  var uuidOrName = event.getUuidOrName();\n${statements}});\n`;
    };

    generator.forBlock['event_player_drop_item'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerDropItem', function(event) {\n  var player = event.getPlayer();\n  var item = event.getItem();\n${statements}});\n`;
    };

    generator.forBlock['event_player_block_pick'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerBlockPick', function(event) {\n  var player = event.getPlayer();\n  var block = event.getClickedBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_player_book_edit'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerBookEdit', function(event) {\n  var player = event.getPlayer();\n  var action = event.getAction();\n${statements}});\n`;
    };

    generator.forBlock['event_player_bucket_empty'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerBucketEmpty', function(event) {\n  var player = event.getPlayer();\n  var bucket = event.getBucket();\n${statements}});\n`;
    };

    generator.forBlock['event_player_bucket_fill'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerBucketFill', function(event) {\n  var player = event.getPlayer();\n  var bucket = event.getBucket();\n${statements}});\n`;
    };

    generator.forBlock['event_player_change_skin'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerChangeSkin', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_player_craft_item'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerCraftItem', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_player_eat'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerEat', function(event) {\n  var player = event.getPlayer();\n  var edible = event.getEdible();\n${statements}});\n`;
    };

    generator.forBlock['event_player_enchant_item'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerEnchantItem', function(event) {\n  var player = event.getPlayer();\n  var item = event.getItem();\n${statements}});\n`;
    };

    generator.forBlock['event_player_experience_level_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerExperienceLevelChange', function(event) {\n  var player = event.getPlayer();\n  var oldLevel = event.getOldExperienceLevel();\n  var newLevel = event.getNewExperienceLevel();\n${statements}});\n`;
    };

    generator.forBlock['event_player_food_level_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerFoodLevelChange', function(event) {\n  var player = event.getPlayer();\n  var oldFoodLevel = event.getOldFoodLevel();\n  var newFoodLevel = event.getNewFoodLevel();\n${statements}});\n`;
    };

    generator.forBlock['event_player_interact_entity'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerInteractEntity', function(event) {\n  var player = event.getPlayer();\n  var entity = event.getEntity();\n  var item = event.getItem();\n${statements}});\n`;
    };

    generator.forBlock['event_player_item_held'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerItemHeld', function(event) {\n  var player = event.getPlayer();\n  var oldItem = event.getOldItem();\n  var newItem = event.getNewItem();\n${statements}});\n`;
    };

    generator.forBlock['event_player_punch_air'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerPunchAir', function(event) {\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_player_punch_block'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerPunchBlock', function(event) {\n  var player = event.getPlayer();\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_player_toggle_crawl'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerToggleCrawl', function(event) {\n  var player = event.getPlayer();\n  var isCrawling = event.isCrawling();\n${statements}});\n`;
    };

    generator.forBlock['event_player_toggle_flight'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerToggleFlight', function(event) {\n  var player = event.getPlayer();\n  var isFlying = event.isFlying();\n${statements}});\n`;
    };

    generator.forBlock['event_player_toggle_glide'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerToggleGlide', function(event) {\n  var player = event.getPlayer();\n  var isGliding = event.isGliding();\n${statements}});\n`;
    };

    generator.forBlock['event_player_toggle_swim'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerToggleSwim', function(event) {\n  var player = event.getPlayer();\n  var isSwimming = event.isSwimming();\n${statements}});\n`;
    };

    generator.forBlock['event_player_use_item_in_air'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('playerUseItemInAir', function(event) {\n  var player = event.getPlayer();\n  var usingTime = event.getUsingTime();\n${statements}});\n`;
    };

    generator.forBlock['event_block_burn'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockBurn', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_block_explode'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockExplode', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_block_fade'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockFade', function(event) {\n  var block = event.getBlock();\n  var newBlockType = event.getNewBlockType();\n${statements}});\n`;
    };

    generator.forBlock['event_block_fall'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockFall', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_block_grow'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockGrow', function(event) {\n  var block = event.getBlock();\n  var newBlockType = event.getNewBlockType();\n${statements}});\n`;
    };

    generator.forBlock['event_block_ignite'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockIgnite', function(event) {\n  var block = event.getBlock();\n  var cause = event.getCause();\n${statements}});\n`;
    };

    generator.forBlock['event_block_neighbor_update'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockNeighborUpdate', function(event) {\n  var block = event.getBlock();\n  var neighbor = event.getNeighbor();\n${statements}});\n`;
    };

    generator.forBlock['event_block_random_update'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockRandomUpdate', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_block_schedule_update'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockScheduleUpdate', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_block_spread'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('blockSpread', function(event) {\n  var block = event.getBlock();\n  var spreadBlock = event.getSpreadBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_item_frame_use'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('itemFrameUse', function(event) {\n  var block = event.getBlock();\n  var entity = event.getEntity();\n  var action = event.getAction();\n${statements}});\n`;
    };

    generator.forBlock['event_liquid_decay'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('liquidDecay', function(event) {\n  var block = event.getBlock();\n  var newBlockType = event.getNewBlockType();\n${statements}});\n`;
    };

    generator.forBlock['event_liquid_flow'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('liquidFlow', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_liquid_harden'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('liquidHarden', function(event) {\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_sign_text_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('signTextChange', function(event) {\n  var block = event.getBlock();\n  var editor = event.getEditor();\n  var text = event.getText();\n${statements}});\n`;
    };

    generator.forBlock['event_sign_wax'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('signWax', function(event) {\n  var block = event.getBlock();\n  var player = event.getPlayer();\n${statements}});\n`;
    };

    generator.forBlock['event_anvil_damage'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('anvilDamage', function(event) {\n  var block = event.getBlock();\n  var newBlockType = event.getNewBlockType();\n${statements}});\n`;
    };

    generator.forBlock['event_command_execute'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('commandExecute', function(event) {\n  var sender = event.getSender();\n  var command = event.getCommand();\n${statements}});\n`;
    };

    generator.forBlock['event_container_open'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('containerOpen', function(event) {\n  var viewer = event.getViewer();\n  var container = event.getContainer();\n${statements}});\n`;
    };

    generator.forBlock['event_container_close'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('containerClose', function(event) {\n  var viewer = event.getViewer();\n  var container = event.getContainer();\n${statements}});\n`;
    };

    generator.forBlock['event_container_item_move'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('containerItemMove', function(event) {\n  var source = event.getSource();\n  var destination = event.getDestination();\n${statements}});\n`;
    };

    generator.forBlock['event_container_item_pickup'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('containerItemPickup', function(event) {\n  var item = event.getItem();\n  var destination = event.getDestination();\n${statements}});\n`;
    };

    generator.forBlock['event_anvil_take_result'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('anvilTakeResult', function(event) {\n  var viewer = event.getViewer();\n  var resultItem = event.getResultItem();\n${statements}});\n`;
    };

    generator.forBlock['event_brewing_stand_brew'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('brewingStandBrew', function(event) {\n  var resultCount = event.getResultCount();\n${statements}});\n`;
    };

    generator.forBlock['event_brewing_stand_consume_fuel'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('brewingStandConsumeFuel', function(event) {\n  var fuel = event.getFuel();\n${statements}});\n`;
    };

    generator.forBlock['event_brewing_stand_start_brew'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('brewingStandStartBrew', function(event) {\n  var brewTime = event.getBrewingTime();\n${statements}});\n`;
    };

    generator.forBlock['event_campfire_smelt'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('campfireSmelt', function(event) {\n  var ingredient = event.getIngredient();\n  var output = event.getOutput();\n${statements}});\n`;
    };

    generator.forBlock['event_furnace_smelt'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('furnaceSmelt', function(event) {\n  var ingredient = event.getIngredient();\n  var output = event.getOutput();\n${statements}});\n`;
    };

    generator.forBlock['event_furnace_consume_fuel'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('furnaceConsumeFuel', function(event) {\n  var fuel = event.getFuel();\n${statements}});\n`;
    };

    generator.forBlock['event_grindstone_take_result'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('grindstoneTakeResult', function(event) {\n  var viewer = event.getViewer();\n  var resultItem = event.getResultItem();\n  var experienceAmount = event.getExperienceAmount();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_spawn'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entitySpawn', function(event) {\n  var entity = event.getEntity();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_despawn'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityDespawn', function(event) {\n  var entity = event.getEntity();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_combust'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityCombust', function(event) {\n  var entity = event.getEntity();\n  var combusterType = event.getCombusterType();\n  var onFireTicks = event.getOnFireTicks();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_effect_add'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityEffectAdd', function(event) {\n  var entity = event.getEntity();\n  var effectType = event.getEffectType();\n  var effectLevel = event.getEffectLevel();\n  var effectDuration = event.getEffectDuration();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_effect_remove'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityEffectRemove', function(event) {\n  var entity = event.getEntity();\n  var effectType = event.getEffectType();\n  var effectLevel = event.getEffectLevel();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_explode'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityExplode', function(event) {\n  var entity = event.getEntity();\n  var explosionSize = event.getExplosionSize();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_fall'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityFall', function(event) {\n  var entity = event.getEntity();\n  var fallDistance = event.getFallDistance();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_health_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityHealthChange', function(event) {\n  var entity = event.getEntity();\n  var oldHealth = event.getOldHealth();\n  var newHealth = event.getNewHealth();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_move'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityMove', function(event) {\n  var entity = event.getEntity();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_set_motion'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entitySetMotion', function(event) {\n  var entity = event.getEntity();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_shoot_bow'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityShootBow', function(event) {\n  var entity = event.getEntity();\n  var bow = event.getBow();\n  var arrow = event.getArrow();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_shoot_crossbow'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityShootCrossbow', function(event) {\n  var entity = event.getEntity();\n  var crossbow = event.getCrossbow();\n  var projectileCount = event.getProjectileCount();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_teleport'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityTeleport', function(event) {\n  var entity = event.getEntity();\n  var reason = event.getReason();\n${statements}});\n`;
    };

    generator.forBlock['event_entity_trample_farmland'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('entityTrampleFarmland', function(event) {\n  var entity = event.getEntity();\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_firework_explode'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('fireworkExplode', function(event) {\n  var entity = event.getEntity();\n  var force = event.getForce();\n${statements}});\n`;
    };

    generator.forBlock['event_projectile_hit'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('projectileHit', function(event) {\n  var entity = event.getEntity();\n  var victim = event.getVictim();\n  var block = event.getBlock();\n${statements}});\n`;
    };

    generator.forBlock['event_projectile_launch'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('projectileLaunch', function(event) {\n  var entity = event.getEntity();\n  var shooter = event.getShooter();\n  var throwForce = event.getThrowForce();\n${statements}});\n`;
    };

    generator.forBlock['event_scoreboard_add'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('scoreboardAdd', function(event) {\n  var scoreboardName = event.getScoreboardName();\n  var displayName = event.getDisplayName();\n${statements}});\n`;
    };

    generator.forBlock['event_scoreboard_remove'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('scoreboardRemove', function(event) {\n  var scoreboardName = event.getScoreboardName();\n  var displayName = event.getDisplayName();\n${statements}});\n`;
    };

    generator.forBlock['event_scoreboard_all_lines_remove'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('scoreboardAllLinesRemove', function(event) {\n  var scoreboardName = event.getScoreboardName();\n  var displayName = event.getDisplayName();\n${statements}});\n`;
    };

    generator.forBlock['event_scoreboard_line_add'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('scoreboardLineAdd', function(event) {\n  var scoreboardName = event.getScoreboardName();\n  var scorerName = event.getScorerName();\n  var score = event.getScore();\n${statements}});\n`;
    };

    generator.forBlock['event_scoreboard_line_remove'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('scoreboardLineRemove', function(event) {\n  var scoreboardName = event.getScoreboardName();\n  var scorerName = event.getScorerName();\n  var score = event.getScore();\n${statements}});\n`;
    };

    generator.forBlock['event_scoreboard_line_value_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('scoreboardLineValueChange', function(event) {\n  var scoreboardName = event.getScoreboardName();\n  var scorerName = event.getScorerName();\n  var oldValue = event.getOldValue();\n  var newValue = event.getNewValue();\n${statements}});\n`;
    };

    generator.forBlock['event_chunk_load'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('chunkLoad', function(event) {\n  var world = event.getWorld();\n  var chunk = event.getChunk();\n${statements}});\n`;
    };

    generator.forBlock['event_chunk_unload'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('chunkUnload', function(event) {\n  var world = event.getWorld();\n  var chunk = event.getChunk();\n${statements}});\n`;
    };

    generator.forBlock['event_difficulty_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('difficultyChange', function(event) {\n  var world = event.getWorld();\n  var oldDifficulty = event.getOldDifficultyName();\n  var newDifficulty = event.getNewDifficultyName();\n${statements}});\n`;
    };

    generator.forBlock['event_game_rule_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('gameRuleChange', function(event) {\n  var world = event.getWorld();\n  var gameRule = event.getGameRule();\n  var oldValue = event.getOldValue();\n  var newValue = event.getNewValue();\n${statements}});\n`;
    };

    generator.forBlock['event_spawn_point_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('spawnPointChange', function(event) {\n  var world = event.getWorld();\n${statements}});\n`;
    };

    generator.forBlock['event_time_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('timeChange', function(event) {\n  var world = event.getWorld();\n  var oldTime = event.getOldTime();\n  var newTime = event.getNewTime();\n${statements}});\n`;
    };

    generator.forBlock['event_weather_change'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('weatherChange', function(event) {\n  var world = event.getWorld();\n  var oldWeather = event.getOldWeather();\n  var newWeather = event.getNewWeather();\n${statements}});\n`;
    };

    generator.forBlock['event_world_data_save'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('worldDataSave', function(event) {\n  var world = event.getWorld();\n  var worldName = event.getWorldName();\n${statements}});\n`;
    };

    generator.forBlock['event_world_load'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('worldLoad', function(event) {\n  var world = event.getWorld();\n  var worldName = event.getWorldName();\n${statements}});\n`;
    };

    generator.forBlock['event_world_unload'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('worldUnload', function(event) {\n  var world = event.getWorld();\n  var worldName = event.getWorldName();\n${statements}});\n`;
    };

    generator.forBlock['event_plugin_enable'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('pluginEnable', function(event) {\n  var plugin = event.getPlugin();\n  var pluginName = event.getPluginName();\n  var pluginVersion = event.getPluginVersion();\n${statements}});\n`;
    };

    generator.forBlock['event_plugin_disable'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `allay.on('pluginDisable', function(event) {\n  var plugin = event.getPlugin();\n  var pluginName = event.getPluginName();\n  var pluginVersion = event.getPluginVersion();\n${statements}});\n`;
    };

    generator.forBlock['event_script_load'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `function onLoad() {\n${statements}}\n`;
    };

    generator.forBlock['event_script_enable'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `function onEnable() {\n${statements}}\n`;
    };

    generator.forBlock['event_script_disable'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `function onDisable() {\n${statements}}\n`;
    };

    generator.forBlock['event_script_unload'] = function(block, gen) {
        const statements = gen.statementToCode(block, 'DO');
        return `function onUnload() {\n${statements}}\n`;
    };
})();
