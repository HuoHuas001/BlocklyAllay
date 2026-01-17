/**
 * Command Blocks Definition
 */

// Register Simple Command
Blockly.Blocks['command_register_simple'] = {
    init: function() {
        this.appendValueInput('NAME')
            .setCheck('String')
            .appendField('注册命令');
        this.appendDummyInput()
            .appendField('描述');
        this.appendValueInput('DESCRIPTION')
            .setCheck('String');
        this.appendValueInput('PERMISSION')
            .setCheck('String')
            .appendField('权限');
        this.appendStatementInput('HANDLER')
            .appendField('处理函数');
        this.setInputsInline(false);
        this.setColour('#A5745B');
        this.setTooltip('注册一个简单的命令');
        this.setHelpUrl('');
    }
};

// Register Command With Aliases
Blockly.Blocks['command_register_with_aliases'] = {
    init: function() {
        this.appendValueInput('NAME')
            .setCheck('String')
            .appendField('注册命令');
        this.appendValueInput('DESCRIPTION')
            .setCheck('String')
            .appendField('描述');
        this.appendValueInput('PERMISSION')
            .setCheck('String')
            .appendField('权限');
        this.appendValueInput('ALIASES')
            .setCheck('Array')
            .appendField('别名');
        this.appendStatementInput('HANDLER')
            .appendField('处理函数');
        this.setInputsInline(false);
        this.setColour('#A5745B');
        this.setTooltip('注册一个带有别名的命令');
        this.setHelpUrl('');
    }
};

// Command Get Sender
Blockly.Blocks['command_context_sender'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('命令执行者');
        this.setOutput(true, 'CommandSender');
        this.setColour('#A5745B');
        this.setTooltip('获取执行命令的发送者');
        this.setHelpUrl('');
    }
};

// Command Get Command Name
Blockly.Blocks['command_context_command'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('命令名称');
        this.setOutput(true, 'String');
        this.setColour('#A5745B');
        this.setTooltip('获取执行的命令名称');
        this.setHelpUrl('');
    }
};

// Command Get Args
Blockly.Blocks['command_context_args'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('命令参数列表');
        this.setOutput(true, 'Array');
        this.setColour('#A5745B');
        this.setTooltip('获取命令的所有参数');
        this.setHelpUrl('');
    }
};

// Command Get Arg By Index
Blockly.Blocks['command_context_get_arg'] = {
    init: function() {
        this.appendValueInput('INDEX')
            .setCheck('Number')
            .appendField('获取第');
        this.appendDummyInput()
            .appendField('个参数');
        this.setOutput(true, 'String');
        this.setColour('#A5745B');
        this.setTooltip('根据索引获取命令参数（从0开始）');
        this.setHelpUrl('');
    }
};

// Command Send Message
Blockly.Blocks['command_send_message'] = {
    init: function() {
        this.appendValueInput('SENDER')
            .setCheck('CommandSender')
            .appendField('向命令执行者');
        this.appendValueInput('MESSAGE')
            .setCheck('String')
            .appendField('发送消息');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A5745B');
        this.setTooltip('向命令执行者发送消息');
        this.setHelpUrl('');
    }
};

// Command Has Permission
Blockly.Blocks['command_has_permission'] = {
    init: function() {
        this.appendValueInput('SENDER')
            .setCheck('CommandSender')
            .appendField('命令执行者是否有权限');
        this.appendValueInput('PERMISSION')
            .setCheck('String');
        this.setInputsInline(true);
        this.setOutput(true, 'Boolean');
        this.setColour('#A5745B');
        this.setTooltip('检查命令执行者是否有指定权限');
        this.setHelpUrl('');
    }
};

// Command Is Player
Blockly.Blocks['command_is_player'] = {
    init: function() {
        this.appendValueInput('SENDER')
            .setCheck('CommandSender')
            .appendField('命令执行者是否为玩家');
        this.setOutput(true, 'Boolean');
        this.setColour('#A5745B');
        this.setTooltip('检查命令执行者是否为玩家');
        this.setHelpUrl('');
    }
};

// Command Is Console
Blockly.Blocks['command_is_console'] = {
    init: function() {
        this.appendValueInput('SENDER')
            .setCheck('CommandSender')
            .appendField('命令执行者是否为控制台');
        this.setOutput(true, 'Boolean');
        this.setColour('#A5745B');
        this.setTooltip('检查命令执行者是否为控制台');
        this.setHelpUrl('');
    }
};

// Command Get Player
Blockly.Blocks['command_get_player'] = {
    init: function() {
        this.appendValueInput('SENDER')
            .setCheck('CommandSender')
            .appendField('将命令执行者转换为玩家对象');
        this.setOutput(true, 'Player');
        this.setColour('#A5745B');
        this.setTooltip('将命令执行者转换为玩家对象（仅当执行者是玩家时有效）');
        this.setHelpUrl('');
    }
};

// Unregister Command
Blockly.Blocks['command_unregister'] = {
    init: function() {
        this.appendValueInput('NAME')
            .setCheck('String')
            .appendField('注销命令');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A5745B');
        this.setTooltip('注销已注册的命令');
        this.setHelpUrl('');
    }
};