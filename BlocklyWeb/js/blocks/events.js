/**
 * Event Blocks Definition
 */

// Player Join Event
Blockly.Blocks['event_player_join'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家加入服务器');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家加入服务器时触发');
        this.setHelpUrl('');
    }
};

// Player Quit Event
Blockly.Blocks['event_player_quit'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家离开服务器');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家离开服务器时触发');
        this.setHelpUrl('');
    }
};

// Player Chat Event
Blockly.Blocks['event_player_chat'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家发送聊天消息');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家发送聊天消息时触发，可获取player和message');
        this.setHelpUrl('');
    }
};

// Player Command Event
Blockly.Blocks['event_player_command'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家执行命令');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家执行命令时触发，可获取player和command');
        this.setHelpUrl('');
    }
};

// Player Move Event
Blockly.Blocks['event_player_move'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家移动');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家移动时触发');
        this.setHelpUrl('');
    }
};

// Player Interact Block Event
Blockly.Blocks['event_player_interact_block'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家交互方块');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家交互方块时触发，可获取player和block');
        this.setHelpUrl('');
    }
};

// Block Break Event
Blockly.Blocks['event_block_break'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块被破坏');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块被破坏时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Block Place Event
Blockly.Blocks['event_block_place'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块被放置');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块被放置时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Entity Damage Event
Blockly.Blocks['event_entity_damage'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体受伤');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体受到伤害时触发，可获取entity和damage');
        this.setHelpUrl('');
    }
};

// Entity Die Event
Blockly.Blocks['event_entity_die'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体死亡');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体死亡时触发，可获取entity');
        this.setHelpUrl('');
    }
};

// Player Connect Event
Blockly.Blocks['event_player_connect'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家连接服务器');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家连接服务器时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Disconnect Event
Blockly.Blocks['event_player_disconnect'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家断开连接');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家断开连接时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Login Event
Blockly.Blocks['event_player_login'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家登录成功');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家登录成功时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Kick Event
Blockly.Blocks['event_player_kick'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家被踢出');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家被踢出时触发，可获取player和reason');
        this.setHelpUrl('');
    }
};

// Player Spawn Event
Blockly.Blocks['event_player_spawn'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家即将生成');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家即将生成时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Ban Event
Blockly.Blocks['event_player_ban'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家被封禁');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家被封禁时触发，可获取uuidOrName');
        this.setHelpUrl('');
    }
};

// Player Unban Event
Blockly.Blocks['event_player_unban'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家被解封');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家被解封时触发，可获取uuidOrName');
        this.setHelpUrl('');
    }
};

// IP Ban Event
Blockly.Blocks['event_ip_ban'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当IP被封禁');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当IP被封禁时触发，可获取ip');
        this.setHelpUrl('');
    }
};

// IP Unban Event
Blockly.Blocks['event_ip_unban'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当IP被解封');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当IP被解封时触发，可获取ip');
        this.setHelpUrl('');
    }
};

// Server Stop Event
Blockly.Blocks['event_server_stop'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当服务器停止');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当服务器停止时触发');
        this.setHelpUrl('');
    }
};

// Whitelist Add Player Event
Blockly.Blocks['event_whitelist_add_player'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家添加到白名单');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家添加到白名单时触发，可获取uuidOrName');
        this.setHelpUrl('');
    }
};

// Whitelist Remove Player Event
Blockly.Blocks['event_whitelist_remove_player'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家从白名单移除');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家从白名单移除时触发，可获取uuidOrName');
        this.setHelpUrl('');
    }
};

// Player Drop Item Event
Blockly.Blocks['event_player_drop_item'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家丢弃物品');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家丢弃物品时触发，可获取player和item');
        this.setHelpUrl('');
    }
};

// Player Block Pick Event
Blockly.Blocks['event_player_block_pick'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家中键选取方块');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家中键选取方块时触发，可获取player和block');
        this.setHelpUrl('');
    }
};

// Player Book Edit Event
Blockly.Blocks['event_player_book_edit'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家编辑书');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家编辑书时触发，可获取player和action');
        this.setHelpUrl('');
    }
};

// Player Bucket Empty Event
Blockly.Blocks['event_player_bucket_empty'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家倒空桶');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家倒空桶时触发，可获取player和bucket');
        this.setHelpUrl('');
    }
};

// Player Bucket Fill Event
Blockly.Blocks['event_player_bucket_fill'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家装满桶');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家装满桶时触发，可获取player和bucket');
        this.setHelpUrl('');
    }
};

// Player Change Skin Event
Blockly.Blocks['event_player_change_skin'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家更换皮肤');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家更换皮肤时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Craft Item Event
Blockly.Blocks['event_player_craft_item'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家合成物品');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家合成物品时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Eat Event
Blockly.Blocks['event_player_eat'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家吃东西');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家吃东西时触发，可获取player和edible');
        this.setHelpUrl('');
    }
};

// Player Enchant Item Event
Blockly.Blocks['event_player_enchant_item'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家附魔物品');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家附魔物品时触发，可获取player和item');
        this.setHelpUrl('');
    }
};

// Player Experience Level Change Event
Blockly.Blocks['event_player_experience_level_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家经验等级改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家经验等级改变时触发，可获取player、oldLevel和newLevel');
        this.setHelpUrl('');
    }
};

// Player Food Level Change Event
Blockly.Blocks['event_player_food_level_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家饥饿值改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家饥饿值改变时触发，可获取player、oldFoodLevel和newFoodLevel');
        this.setHelpUrl('');
    }
};

// Player Interact Entity Event
Blockly.Blocks['event_player_interact_entity'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家交互实体');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家交互实体时触发，可获取player、entity和item');
        this.setHelpUrl('');
    }
};

// Player Item Held Event
Blockly.Blocks['event_player_item_held'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家切换手持物品');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家切换手持物品时触发，可获取player、oldItem和newItem');
        this.setHelpUrl('');
    }
};

// Player Punch Air Event
Blockly.Blocks['event_player_punch_air'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家空挥');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家空挥时触发，可获取player');
        this.setHelpUrl('');
    }
};

// Player Punch Block Event
Blockly.Blocks['event_player_punch_block'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家敲击方块');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家敲击方块时触发，可获取player和block');
        this.setHelpUrl('');
    }
};

// Player Toggle Crawl Event
Blockly.Blocks['event_player_toggle_crawl'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家切换爬行状态');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家切换爬行状态时触发，可获取player和isCrawling');
        this.setHelpUrl('');
    }
};

// Player Toggle Flight Event
Blockly.Blocks['event_player_toggle_flight'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家切换飞行状态');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家切换飞行状态时触发，可获取player和isFlying');
        this.setHelpUrl('');
    }
};

// Player Toggle Glide Event
Blockly.Blocks['event_player_toggle_glide'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家切换滑翔状态');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家切换滑翔状态时触发，可获取player和isGliding');
        this.setHelpUrl('');
    }
};

// Player Toggle Swim Event
Blockly.Blocks['event_player_toggle_swim'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家切换游泳状态');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家切换游泳状态时触发，可获取player和isSwimming');
        this.setHelpUrl('');
    }
};

// Player Use Item In Air Event
Blockly.Blocks['event_player_use_item_in_air'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当玩家在空中使用物品');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当玩家在空中使用物品时触发，可获取player和usingTime');
        this.setHelpUrl('');
    }
};

// Block Burn Event
Blockly.Blocks['event_block_burn'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块被火烧毁');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块被火烧毁时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Block Explode Event
Blockly.Blocks['event_block_explode'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块爆炸');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块爆炸时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Block Fade Event
Blockly.Blocks['event_block_fade'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块消退');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块消退时触发，可获取block和newBlockType');
        this.setHelpUrl('');
    }
};

// Block Fall Event
Blockly.Blocks['event_block_fall'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块因重力下落');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块因重力下落时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Block Grow Event
Blockly.Blocks['event_block_grow'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块生长');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块生长时触发，可获取block和newBlockType');
        this.setHelpUrl('');
    }
};

// Block Ignite Event
Blockly.Blocks['event_block_ignite'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块被点燃');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块被点燃时触发，可获取block和cause');
        this.setHelpUrl('');
    }
};

// Block Neighbor Update Event
Blockly.Blocks['event_block_neighbor_update'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块邻居更新');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块邻居更新时触发，可获取block和neighbor');
        this.setHelpUrl('');
    }
};

// Block Random Update Event
Blockly.Blocks['event_block_random_update'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块随机更新');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块随机更新时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Block Schedule Update Event
Blockly.Blocks['event_block_schedule_update'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块计划更新');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块计划更新时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Block Spread Event
Blockly.Blocks['event_block_spread'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当方块蔓延');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当方块蔓延时触发，可获取block和spreadBlock');
        this.setHelpUrl('');
    }
};

// Item Frame Use Event
Blockly.Blocks['event_item_frame_use'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当物品展示框被使用');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当物品展示框被使用时触发，可获取block、entity和action');
        this.setHelpUrl('');
    }
};

// Liquid Decay Event
Blockly.Blocks['event_liquid_decay'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当液体消退');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当液体消退时触发，可获取block和newBlockType');
        this.setHelpUrl('');
    }
};

// Liquid Flow Event
Blockly.Blocks['event_liquid_flow'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当液体流动');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当液体流动时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Liquid Harden Event
Blockly.Blocks['event_liquid_harden'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当液体硬化');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当液体硬化时触发，可获取block');
        this.setHelpUrl('');
    }
};

// Sign Text Change Event
Blockly.Blocks['event_sign_text_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当告示牌文本改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当告示牌文本改变时触发，可获取block、editor和text');
        this.setHelpUrl('');
    }
};

// Sign Wax Event
Blockly.Blocks['event_sign_wax'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当告示牌被打蜡');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当告示牌被打蜡时触发，可获取block和player');
        this.setHelpUrl('');
    }
};

// Anvil Damage Event
Blockly.Blocks['event_anvil_damage'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当铁砧损坏');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当铁砧损坏时触发，可获取block和newBlockType');
        this.setHelpUrl('');
    }
};

// Command Execute Event
Blockly.Blocks['event_command_execute'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当命令执行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当命令执行时触发，可获取sender和command');
        this.setHelpUrl('');
    }
};

// Container Open Event
Blockly.Blocks['event_container_open'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当容器打开');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当容器打开时触发，可获取viewer和container');
        this.setHelpUrl('');
    }
};

// Container Close Event
Blockly.Blocks['event_container_close'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当容器关闭');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当容器关闭时触发，可获取viewer和container');
        this.setHelpUrl('');
    }
};

// Container Item Move Event
Blockly.Blocks['event_container_item_move'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当物品在容器间移动');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当物品在容器间移动时触发，可获取source和destination');
        this.setHelpUrl('');
    }
};

// Container Item Pickup Event
Blockly.Blocks['event_container_item_pickup'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当掉落物被容器拾取');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当掉落物被容器拾取时触发，可获取item和destination');
        this.setHelpUrl('');
    }
};

// Anvil Take Result Event
Blockly.Blocks['event_anvil_take_result'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当从铁砧取出结果');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当从铁砧取出结果时触发，可获取viewer和resultItem');
        this.setHelpUrl('');
    }
};

// Brewing Stand Brew Event
Blockly.Blocks['event_brewing_stand_brew'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当酿造台完成酿造');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当酿造台完成酿造时触发，可获取resultCount');
        this.setHelpUrl('');
    }
};

// Brewing Stand Consume Fuel Event
Blockly.Blocks['event_brewing_stand_consume_fuel'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当酿造台消耗燃料');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当酿造台消耗燃料时触发，可获取fuel');
        this.setHelpUrl('');
    }
};

// Brewing Stand Start Brew Event
Blockly.Blocks['event_brewing_stand_start_brew'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当酿造台开始酿造');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当酿造台开始酿造时触发，可获取brewTime');
        this.setHelpUrl('');
    }
};

// Campfire Smelt Event
Blockly.Blocks['event_campfire_smelt'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当营火完成烹饪');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当营火完成烹饪时触发，可获取ingredient和output');
        this.setHelpUrl('');
    }
};

// Furnace Smelt Event
Blockly.Blocks['event_furnace_smelt'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当熔炉完成冶炼');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当熔炉完成冶炼时触发，可获取ingredient和output');
        this.setHelpUrl('');
    }
};

// Furnace Consume Fuel Event
Blockly.Blocks['event_furnace_consume_fuel'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当熔炉消耗燃料');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当熔炉消耗燃料时触发，可获取fuel');
        this.setHelpUrl('');
    }
};

// Grindstone Take Result Event
Blockly.Blocks['event_grindstone_take_result'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当从砂轮取出结果');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当从砂轮取出结果时触发，可获取viewer、resultItem和experienceAmount');
        this.setHelpUrl('');
    }
};

// Entity Spawn Event
Blockly.Blocks['event_entity_spawn'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体生成');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体生成时触发，可获取entity');
        this.setHelpUrl('');
    }
};

// Entity Despawn Event
Blockly.Blocks['event_entity_despawn'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体消失');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体消失时触发，可获取entity');
        this.setHelpUrl('');
    }
};

// Entity Combust Event
Blockly.Blocks['event_entity_combust'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体着火');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体着火时触发，可获取entity、combusterType和onFireTicks');
        this.setHelpUrl('');
    }
};

// Entity Effect Add Event
Blockly.Blocks['event_entity_effect_add'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体获得效果');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体获得效果时触发，可获取entity、effectType、effectLevel和effectDuration');
        this.setHelpUrl('');
    }
};

// Entity Effect Remove Event
Blockly.Blocks['event_entity_effect_remove'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体失去效果');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体失去效果时触发，可获取entity、effectType和effectLevel');
        this.setHelpUrl('');
    }
};

// Entity Explode Event
Blockly.Blocks['event_entity_explode'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体爆炸');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体爆炸时触发，可获取entity和explosionSize');
        this.setHelpUrl('');
    }
};

// Entity Fall Event
Blockly.Blocks['event_entity_fall'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体落地');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体落地时触发，可获取entity和fallDistance');
        this.setHelpUrl('');
    }
};

// Entity Health Change Event
Blockly.Blocks['event_entity_health_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体血量改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体血量改变时触发，可获取entity、oldHealth和newHealth');
        this.setHelpUrl('');
    }
};

// Entity Move Event
Blockly.Blocks['event_entity_move'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体移动');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体移动时触发，可获取entity');
        this.setHelpUrl('');
    }
};

// Entity Set Motion Event
Blockly.Blocks['event_entity_set_motion'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体速度改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体速度改变时触发，可获取entity');
        this.setHelpUrl('');
    }
};

// Entity Shoot Bow Event
Blockly.Blocks['event_entity_shoot_bow'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体用弓射箭');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体用弓射箭时触发，可获取entity、bow和arrow');
        this.setHelpUrl('');
    }
};

// Entity Shoot Crossbow Event
Blockly.Blocks['event_entity_shoot_crossbow'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体用弩射击');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体用弩射击时触发，可获取entity、crossbow和projectileCount');
        this.setHelpUrl('');
    }
};

// Entity Teleport Event
Blockly.Blocks['event_entity_teleport'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体传送');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体传送时触发，可获取entity和reason');
        this.setHelpUrl('');
    }
};

// Entity Trample Farmland Event
Blockly.Blocks['event_entity_trample_farmland'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当实体踩踏耕地');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当实体踩踏耕地时触发，可获取entity和block');
        this.setHelpUrl('');
    }
};

// Firework Explode Event
Blockly.Blocks['event_firework_explode'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当烟花爆炸');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当烟花爆炸时触发，可获取entity和force');
        this.setHelpUrl('');
    }
};

// Projectile Hit Event
Blockly.Blocks['event_projectile_hit'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当投射物命中');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当投射物命中时触发，可获取entity、victim和block');
        this.setHelpUrl('');
    }
};

// Projectile Launch Event
Blockly.Blocks['event_projectile_launch'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当投射物发射');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当投射物发射时触发，可获取entity、shooter和throwForce');
        this.setHelpUrl('');
    }
};

// Scoreboard Add Event
Blockly.Blocks['event_scoreboard_add'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当计分板添加');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当计分板添加时触发，可获取scoreboardName和displayName');
        this.setHelpUrl('');
    }
};

// Scoreboard Remove Event
Blockly.Blocks['event_scoreboard_remove'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当计分板删除');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当计分板删除时触发，可获取scoreboardName和displayName');
        this.setHelpUrl('');
    }
};

// Scoreboard All Lines Remove Event
Blockly.Blocks['event_scoreboard_all_lines_remove'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当计分板清空所有行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当计分板清空所有行时触发，可获取scoreboardName和displayName');
        this.setHelpUrl('');
    }
};

// Scoreboard Line Add Event
Blockly.Blocks['event_scoreboard_line_add'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当计分板添加行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当计分板添加行时触发，可获取scoreboardName、scorerName和score');
        this.setHelpUrl('');
    }
};

// Scoreboard Line Remove Event
Blockly.Blocks['event_scoreboard_line_remove'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当计分板删除行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当计分板删除行时触发，可获取scoreboardName、scorerName和score');
        this.setHelpUrl('');
    }
};

// Scoreboard Line Value Change Event
Blockly.Blocks['event_scoreboard_line_value_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当计分板行分数改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当计分板行分数改变时触发，可获取scoreboardName、scorerName、oldValue和newValue');
        this.setHelpUrl('');
    }
};

// Chunk Load Event
Blockly.Blocks['event_chunk_load'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当区块加载');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当区块加载时触发，可获取world和chunk');
        this.setHelpUrl('');
    }
};

// Chunk Unload Event
Blockly.Blocks['event_chunk_unload'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当区块卸载');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当区块卸载时触发，可获取world和chunk');
        this.setHelpUrl('');
    }
};

// Difficulty Change Event
Blockly.Blocks['event_difficulty_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当难度改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当难度改变时触发，可获取world、oldDifficulty和newDifficulty');
        this.setHelpUrl('');
    }
};

// Game Rule Change Event
Blockly.Blocks['event_game_rule_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当游戏规则改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当游戏规则改变时触发，可获取world、gameRule、oldValue和newValue');
        this.setHelpUrl('');
    }
};

// Spawn Point Change Event
Blockly.Blocks['event_spawn_point_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当出生点改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当出生点改变时触发，可获取world');
        this.setHelpUrl('');
    }
};

// Time Change Event
Blockly.Blocks['event_time_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当时间改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当时间改变时触发，可获取world、oldTime和newTime');
        this.setHelpUrl('');
    }
};

// Weather Change Event
Blockly.Blocks['event_weather_change'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当天气改变');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当天气改变时触发，可获取world、oldWeather和newWeather');
        this.setHelpUrl('');
    }
};

// World Data Save Event
Blockly.Blocks['event_world_data_save'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当世界数据保存');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当世界数据保存时触发，可获取world和worldName');
        this.setHelpUrl('');
    }
};

// World Load Event
Blockly.Blocks['event_world_load'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当世界加载');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当世界加载时触发，可获取world和worldName');
        this.setHelpUrl('');
    }
};

// World Unload Event
Blockly.Blocks['event_world_unload'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当世界卸载');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当世界卸载时触发，可获取world和worldName');
        this.setHelpUrl('');
    }
};

// Plugin Enable Event
Blockly.Blocks['event_plugin_enable'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当插件启用');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当插件启用时触发，可获取plugin、pluginName和pluginVersion');
        this.setHelpUrl('');
    }
};

// Plugin Disable Event
Blockly.Blocks['event_plugin_disable'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当插件禁用');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#5C81A6');
        this.setTooltip('当插件禁用时触发，可获取plugin、pluginName和pluginVersion');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['event_script_load'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当脚本加载');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#808080');
        this.setTooltip('当脚本加载时触发');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['event_script_enable'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当脚本启用');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#808080');
        this.setTooltip('当脚本启用时触发');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['event_script_disable'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当脚本禁用');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#808080');
        this.setTooltip('当脚本禁用时触发');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['event_script_unload'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('当脚本卸载');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setColour('#808080');
        this.setTooltip('当脚本卸载时触发');
        this.setHelpUrl('');
    }
};
