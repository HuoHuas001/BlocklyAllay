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

// ==================== 文件操作积木块 ====================

Blockly.Blocks['file_read'] = {
    init: function () {
        this.appendValueInput('PATH')
            .setCheck('String')
            .appendField('读取文件');
        this.setOutput(true, 'String');
        this.setColour('#2E8B57');
        this.setTooltip('读取文件内容，返回字符串或null');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['file_write'] = {
    init: function () {
        this.appendValueInput('PATH')
            .setCheck('String')
            .appendField('写入文件');
        this.appendValueInput('CONTENT')
            .setCheck('String')
            .appendField('内容');
        this.appendDummyInput()
            .appendField('覆盖')
            .appendField(new Blockly.FieldCheckbox('TRUE'), 'OVERWRITE');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#2E8B57');
        this.setTooltip('写入内容到文件，返回是否成功');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['file_exists'] = {
    init: function () {
        this.appendValueInput('PATH')
            .setCheck('String')
            .appendField('文件存在');
        this.setOutput(true, 'Boolean');
        this.setColour('#2E8B57');
        this.setTooltip('检查文件是否存在');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['file_delete'] = {
    init: function () {
        this.appendValueInput('PATH')
            .setCheck('String')
            .appendField('删除文件');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#2E8B57');
        this.setTooltip('删除指定文件');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['file_list'] = {
    init: function () {
        this.appendValueInput('PATH')
            .setCheck('String')
            .appendField('列出目录');
        this.setOutput(true, 'Array');
        this.setColour('#2E8B57');
        this.setTooltip('列出目录中的文件');
        this.setHelpUrl('');
    }
};

// ==================== HTTP请求积木块 ====================

Blockly.Blocks['http_get'] = {
    init: function () {
        this.appendValueInput('URL')
            .setCheck('String')
            .appendField('HTTP GET请求');
        this.setOutput(true, 'String');
        this.setColour('#4169E1');
        this.setTooltip('发送HTTP GET请求，返回响应内容或null');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['http_post'] = {
    init: function () {
        this.appendValueInput('URL')
            .setCheck('String')
            .appendField('HTTP POST请求');
        this.appendValueInput('BODY')
            .setCheck('String')
            .appendField('正文');
        this.setOutput(true, 'String');
        this.setColour('#4169E1');
        this.setTooltip('发送HTTP POST请求，返回响应内容或null');
        this.setHelpUrl('');
    }
};

// ==================== JSON处理积木块 ====================

Blockly.Blocks['json_parse'] = {
    init: function () {
        this.appendValueInput('JSON_TEXT')
            .setCheck('String')
            .appendField('JSON字符串转对象');
        this.setOutput(true, null);
        this.setColour('#9966FF');
        this.setTooltip('将JSON字符串转换为JavaScript对象');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['json_stringify'] = {
    init: function () {
        this.appendValueInput('JSON_OBJ')
            .setCheck(null)
            .appendField('对象转JSON字符串');
        this.setOutput(true, 'String');
        this.setColour('#9966FF');
        this.setTooltip('将JavaScript对象转换为JSON字符串');
        this.setHelpUrl('');
    }
};

// ==================== 对象操作积木块 ====================

Blockly.Blocks['object_create'] = {
    init: function () {
        this.appendDummyInput()
            .appendField('创建对象');
        this.setOutput(true, null);
        this.setColour('#FF6B6B');
        this.setTooltip('创建一个新的空对象');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['object_get_property'] = {
    init: function () {
        this.appendValueInput('OBJECT')
            .setCheck(null)
            .appendField('获取');
        this.appendValueInput('PROPERTY')
            .setCheck('String')
            .appendField('的属性');
        this.setOutput(true, null);
        this.setColour('#FF6B6B');
        this.setTooltip('获取对象的属性值');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['object_set_property'] = {
    init: function () {
        this.appendValueInput('OBJECT')
            .setCheck(null)
            .appendField('设置');
        this.appendValueInput('PROPERTY')
            .setCheck('String')
            .appendField('的属性');
        this.appendValueInput('VALUE')
            .setCheck(null)
            .appendField('为');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#FF6B6B');
        this.setTooltip('设置对象的属性值');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['object_has_property'] = {
    init: function () {
        this.appendValueInput('OBJECT')
            .setCheck(null)
            .appendField('检查');
        this.appendValueInput('PROPERTY')
            .setCheck('String')
            .appendField('是否有属性');
        this.setOutput(true, 'Boolean');
        this.setColour('#FF6B6B');
        this.setTooltip('检查对象是否包含指定属性');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['object_delete_property'] = {
    init: function () {
        this.appendValueInput('OBJECT')
            .setCheck(null)
            .appendField('删除');
        this.appendValueInput('PROPERTY')
            .setCheck('String')
            .appendField('的属性');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#FF6B6B');
        this.setTooltip('删除对象的指定属性');
        this.setHelpUrl('');
    }
};
