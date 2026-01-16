/**
 * BossBar Blocks Definition
 */

Blockly.Blocks['bossbar_create'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('创建Boss血条');
        this.appendValueInput('TITLE')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('标题');
        this.setOutput(true, 'BossBar');
        this.setColour('#A55B5B');
        this.setTooltip('创建一个新的Boss血条');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_set_title'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendValueInput('TITLE')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置标题');
        this.setOutput(true, 'BossBar');
        this.setColour('#A55B5B');
        this.setTooltip('设置Boss血条的标题');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_set_progress'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendValueInput('PROGRESS')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置进度');
        this.setOutput(true, 'BossBar');
        this.setColour('#A55B5B');
        this.setTooltip('设置Boss血条的进度 (0-1)');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_set_color'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置颜色')
            .appendField(new Blockly.FieldDropdown([
                ['粉色', 'PINK'],
                ['蓝色', 'BLUE'],
                ['红色', 'RED'],
                ['绿色', 'GREEN'],
                ['黄色', 'YELLOW'],
                ['紫色', 'PURPLE'],
                ['白色', 'WHITE']
            ]), 'COLOR');
        this.setOutput(true, 'BossBar');
        this.setColour('#A55B5B');
        this.setTooltip('设置Boss血条的颜色');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_show'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('显示给玩家');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A55B5B');
        this.setTooltip('向玩家显示Boss血条');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_hide'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('从玩家隐藏');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A55B5B');
        this.setTooltip('从玩家隐藏Boss血条');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_get_title'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('获取标题');
        this.setOutput(true, 'String');
        this.setColour('#A55B5B');
        this.setTooltip('获取Boss血条的标题');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_get_progress'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('获取进度');
        this.setOutput(true, 'Number');
        this.setColour('#A55B5B');
        this.setTooltip('获取Boss血条的进度');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_get_color'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('获取颜色');
        this.setOutput(true, 'String');
        this.setColour('#A55B5B');
        this.setTooltip('获取Boss血条的颜色');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_set_style'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置样式')
            .appendField(new Blockly.FieldDropdown([
                ['进度条', 'PROGRESS'],
                ['分段', 'NOTCHED_6'],
                ['分段(10)', 'NOTCHED_10'],
                ['分段(12)', 'NOTCHED_12'],
                ['分段(20)', 'NOTCHED_20']
            ]), 'STYLE');
        this.setOutput(true, 'BossBar');
        this.setColour('#A55B5B');
        this.setTooltip('设置Boss血条的样式');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_get_style'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('获取样式');
        this.setOutput(true, 'String');
        this.setColour('#A55B5B');
        this.setTooltip('获取Boss血条的样式');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_set_darken_sky'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendValueInput('DARKEN')
            .setCheck('Boolean')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置天空变暗');
        this.setOutput(true, 'BossBar');
        this.setColour('#A55B5B');
        this.setTooltip('设置是否使天空变暗');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_is_darken_sky'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('天空是否变暗');
        this.setOutput(true, 'Boolean');
        this.setColour('#A55B5B');
        this.setTooltip('检查是否使天空变暗');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_remove_all_viewers'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('移除所有观看者');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A55B5B');
        this.setTooltip('移除所有观看此Boss血条的玩家');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['bossbar_get_viewer_count'] = {
    init: function() {
        this.appendValueInput('BOSSBAR')
            .setCheck('BossBar')
            .appendField('Boss血条');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('获取观看者数量');
        this.setOutput(true, 'Number');
        this.setColour('#A55B5B');
        this.setTooltip('获取观看此Boss血条的玩家数量');
        this.setHelpUrl('');
    }
};
