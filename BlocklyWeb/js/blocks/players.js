/**
 * Player Blocks Definition
 */

// Get Player Name
Blockly.Blocks['player_get_name'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('获取玩家');
        this.appendDummyInput()
            .appendField('的名称');
        this.setInputsInline(true);
        this.setOutput(true, 'String');
        this.setColour('#5BA55B');
        this.setTooltip('获取玩家的名称');
        this.setHelpUrl('');
    }
};

// Get Player Display Name
Blockly.Blocks['player_get_display_name'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('获取玩家');
        this.appendDummyInput()
            .appendField('的显示名称');
        this.setInputsInline(true);
        this.setOutput(true, 'String');
        this.setColour('#5BA55B');
        this.setTooltip('获取玩家的显示名称');
        this.setHelpUrl('');
    }
};

// Send Message to Player
Blockly.Blocks['player_send_message'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('向玩家');
        this.appendValueInput('MESSAGE')
            .setCheck('String')
            .appendField('发送消息');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA55B');
        this.setTooltip('向指定玩家发送消息');
        this.setHelpUrl('');
    }
};

// Get Player Position
Blockly.Blocks['player_get_position'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('获取玩家');
        this.appendDummyInput()
            .appendField('的')
            .appendField(new Blockly.FieldDropdown([
                ['X坐标', 'X'],
                ['Y坐标', 'Y'],
                ['Z坐标', 'Z']
            ]), 'COORD');
        this.setInputsInline(true);
        this.setOutput(true, 'Number');
        this.setColour('#5BA55B');
        this.setTooltip('获取玩家的坐标');
        this.setHelpUrl('');
    }
};

// Teleport Player
Blockly.Blocks['player_teleport'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('传送玩家');
        this.appendValueInput('X')
            .setCheck('Number')
            .appendField('到 X:');
        this.appendValueInput('Y')
            .setCheck('Number')
            .appendField('Y:');
        this.appendValueInput('Z')
            .setCheck('Number')
            .appendField('Z:');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA55B');
        this.setTooltip('传送玩家到指定坐标');
        this.setHelpUrl('');
    }
};

// Get Player Health
Blockly.Blocks['player_get_health'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('获取玩家');
        this.appendDummyInput()
            .appendField('的生命值');
        this.setInputsInline(true);
        this.setOutput(true, 'Number');
        this.setColour('#5BA55B');
        this.setTooltip('获取玩家的当前生命值');
        this.setHelpUrl('');
    }
};

// Set Player Health
Blockly.Blocks['player_set_health'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('设置玩家');
        this.appendValueInput('HEALTH')
            .setCheck('Number')
            .appendField('的生命值为');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA55B');
        this.setTooltip('设置玩家的生命值');
        this.setHelpUrl('');
    }
};

// Kick Player
Blockly.Blocks['player_kick'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('踢出玩家');
        this.appendValueInput('REASON')
            .setCheck('String')
            .appendField('原因');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA55B');
        this.setTooltip('将玩家踢出服务器');
        this.setHelpUrl('');
    }
};

// Get Player Gamemode
Blockly.Blocks['player_get_gamemode'] = {
    init: function() {
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .appendField('获取玩家');
        this.appendDummyInput()
            .appendField('的游戏模式');
        this.setInputsInline(true);
        this.setOutput(true, 'String');
        this.setColour('#5BA55B');
        this.setTooltip('获取玩家的游戏模式');
        this.setHelpUrl('');
    }
};

// Get Online Players
Blockly.Blocks['player_get_online'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('获取所有在线玩家');
        this.setOutput(true, 'Array');
        this.setColour('#5BA55B');
        this.setTooltip('获取服务器上所有在线玩家的列表');
        this.setHelpUrl('');
    }
};

// Get Player by Name
Blockly.Blocks['player_get_by_name'] = {
    init: function() {
        this.appendValueInput('NAME')
            .setCheck('String')
            .appendField('根据名称获取玩家');
        this.setOutput(true, 'Player');
        this.setColour('#5BA55B');
        this.setTooltip('根据玩家名称获取玩家对象');
        this.setHelpUrl('');
    }
};
