/**
 * World Blocks Definition
 */

Blockly.Blocks['world_broadcast'] = {
    init: function() {
        this.appendValueInput('MESSAGE')
            .setCheck('String')
            .appendField('广播消息');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A55B80');
        this.setTooltip('向所有玩家广播消息');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_get_worlds'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('获取所有世界');
        this.setOutput(true, 'Array');
        this.setColour('#A55B80');
        this.setTooltip('获取服务器上所有世界的列表');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_get_by_name'] = {
    init: function() {
        this.appendValueInput('NAME')
            .setCheck('String')
            .appendField('根据名称获取世界');
        this.setOutput(true, 'World');
        this.setColour('#A55B80');
        this.setTooltip('根据世界名称获取世界对象');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_get_time'] = {
    init: function() {
        this.appendValueInput('WORLD')
            .setCheck('World')
            .appendField('获取世界');
        this.appendDummyInput()
            .appendField('的时间');
        this.setInputsInline(true);
        this.setOutput(true, 'Number');
        this.setColour('#A55B80');
        this.setTooltip('获取世界的时间');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_set_time'] = {
    init: function() {
        this.appendValueInput('WORLD')
            .setCheck('World')
            .appendField('设置世界');
        this.appendValueInput('TIME')
            .setCheck('Number')
            .appendField('的时间为');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A55B80');
        this.setTooltip('设置世界的时间（0-24000）');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_get_online_count'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('获取在线玩家数量');
        this.setOutput(true, 'Number');
        this.setColour('#A55B80');
        this.setTooltip('获取当前在线的玩家数量');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_get_max_players'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('获取最大玩家数');
        this.setOutput(true, 'Number');
        this.setColour('#A55B80');
        this.setTooltip('获取服务器的最大玩家数');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['world_get_current_tick'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('获取当前tick');
        this.setOutput(true, 'Number');
        this.setColour('#A55B80');
        this.setTooltip('获取服务器当前的tick数');
        this.setHelpUrl('');
    }
};
