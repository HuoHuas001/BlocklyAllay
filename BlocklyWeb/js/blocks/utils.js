/**
 * Utility Blocks Definition
 */

Blockly.Blocks['util_log'] = {
    init: function () {
        this.appendValueInput('MESSAGE')
            .setCheck(null)
            .appendField('打印日志');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#808080');
        this.setTooltip('在控制台打印日志消息');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['util_info'] = {
    init: function () {
        this.appendValueInput('MESSAGE')
            .setCheck(null)
            .appendField('打印信息');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#808080');
        this.setTooltip('在控制台打印信息消息');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['util_warn'] = {
    init: function () {
        this.appendValueInput('MESSAGE')
            .setCheck(null)
            .appendField('打印警告');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#808080');
        this.setTooltip('在控制台打印警告消息');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['util_error'] = {
    init: function () {
        this.appendValueInput('MESSAGE')
            .setCheck(null)
            .appendField('打印错误');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#808080');
        this.setTooltip('在控制台打印错误消息');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['util_debug'] = {
    init: function () {
        this.appendValueInput('MESSAGE')
            .setCheck(null)
            .appendField('打印调试');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#808080');
        this.setTooltip('在控制台打印调试消息');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['util_cancel_event'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('取消此事件');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#808080');
        this.setTooltip('取消当前事件（仅在可取消的事件中有效）');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['scheduler_run_later'] = {
    init: function () {
        this.appendValueInput('DELAY')
            .setCheck('Number')
            .appendField('延迟');
        this.appendDummyInput()
            .appendField('tick后执行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA5A5');
        this.setTooltip('在指定tick数后执行一次');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['scheduler_run_repeating'] = {
    init: function () {
        this.appendValueInput('PERIOD')
            .setCheck('Number')
            .appendField('每');
        this.appendDummyInput()
            .appendField('tick重复执行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA5A5');
        this.setTooltip('每隔指定tick数重复执行');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['scheduler_run_delayed_repeating'] = {
    init: function () {
        this.appendValueInput('DELAY')
            .setCheck('Number')
            .appendField('延迟');
        this.appendDummyInput()
            .appendField('tick后');
        this.appendValueInput('PERIOD')
            .setCheck('Number')
            .appendField('每');
        this.appendDummyInput()
            .appendField('tick重复执行');
        this.appendStatementInput('DO')
            .setCheck(null)
            .appendField('执行');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA5A5');
        this.setTooltip('在延迟后每隔指定tick数重复执行');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['event_off'] = {
    init: function () {
        this.appendValueInput('EVENT_TYPE')
            .setCheck('String')
            .appendField('取消监听');
        this.appendDummyInput()
            .appendField('事件');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5C81A6');
        this.setTooltip('取消监听指定事件');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['event_cleanup'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('清理所有事件监听');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5C81A6');
        this.setTooltip('清理所有事件监听和定时任务');
        this.setHelpUrl('');
    }
};
