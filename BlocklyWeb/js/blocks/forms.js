/**
 * Form Blocks Definition
 */

Blockly.Blocks['form_simple_create'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('创建简单表单');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('创建一个新的简单表单');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_title'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('TITLE')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置标题');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('设置简单表单的标题');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_content'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('CONTENT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置内容');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('设置简单表单的内容');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_button'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加按钮');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个按钮');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_button_with_image'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加按钮(路径图片)');
        this.appendValueInput('PATH')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('图片路径');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带路径图片的按钮');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_button_with_url'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加按钮(URL图片)');
        this.appendValueInput('URL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('图片URL');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带URL图片的按钮');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_label'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加标签');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个标签');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_header'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加标题');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个标题');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_divider'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加分隔线');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个分隔线');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_show'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('显示给玩家');
        this.appendStatementInput('ON_RESPONSE')
            .setCheck(null)
            .appendField('当点击按钮');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#745BA5');
        this.setTooltip('显示表单给玩家，并处理按钮点击');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_simple_on_close'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('SimpleForm')
            .appendField('简单表单');
        this.appendStatementInput('ON_CLOSE')
            .setCheck(null)
            .appendField('当关闭');
        this.setOutput(true, 'SimpleForm');
        this.setColour('#745BA5');
        this.setTooltip('设置表单关闭时的回调');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_modal_create'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('创建模态表单');
        this.setOutput(true, 'ModalForm');
        this.setColour('#745BA5');
        this.setTooltip('创建一个新的模态表单');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_modal_setup'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('ModalForm')
            .appendField('模态表单');
        this.appendValueInput('TITLE')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('标题');
        this.appendValueInput('CONTENT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('内容');
        this.appendValueInput('TRUE_BTN')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('确定按钮');
        this.appendValueInput('FALSE_BTN')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('取消按钮');
        this.setOutput(true, 'ModalForm');
        this.setColour('#745BA5');
        this.setTooltip('设置模态表单的所有属性');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_modal_show'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('ModalForm')
            .appendField('模态表单');
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('显示给玩家');
        this.appendStatementInput('ON_TRUE')
            .setCheck(null)
            .appendField('当点击确定');
        this.appendStatementInput('ON_FALSE')
            .setCheck(null)
            .appendField('当点击取消');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#745BA5');
        this.setTooltip('显示模态表单给玩家，并处理按钮点击');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_modal_on_close'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('ModalForm')
            .appendField('模态表单');
        this.appendStatementInput('ON_CLOSE')
            .setCheck(null)
            .appendField('当关闭');
        this.setOutput(true, 'ModalForm');
        this.setColour('#745BA5');
        this.setTooltip('设置模态表单关闭时的回调');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_create'] = {
    init: function() {
        this.appendDummyInput()
            .appendField('创建自定义表单');
        this.appendValueInput('TITLE')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('标题');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('创建一个新的自定义表单');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_input'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加输入框');
        this.appendValueInput('PLACEHOLDER')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('占位符');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个输入框');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_input_with_default'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加输入框');
        this.appendValueInput('PLACEHOLDER')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('占位符');
        this.appendValueInput('DEFAULT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('默认值');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带默认值的输入框');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_toggle'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加开关');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('默认')
            .appendField(new Blockly.FieldCheckbox('FALSE'), 'DEFAULT');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个开关');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_dropdown'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加下拉菜单');
        this.appendValueInput('OPTIONS')
            .setCheck('Array')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('选项');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个下拉菜单');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_dropdown_with_default'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加下拉菜单');
        this.appendValueInput('OPTIONS')
            .setCheck('Array')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('选项');
        this.appendValueInput('DEFAULT')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('默认索引');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带默认值的下拉菜单');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_slider'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加滑块');
        this.appendValueInput('MIN')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('最小值');
        this.appendValueInput('MAX')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('最大值');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个滑块');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_slider_with_step'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加滑块');
        this.appendValueInput('MIN')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('最小值');
        this.appendValueInput('MAX')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('最大值');
        this.appendValueInput('STEP')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('步长');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带步长的滑块');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_slider_with_default'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加滑块');
        this.appendValueInput('MIN')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('最小值');
        this.appendValueInput('MAX')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('最大值');
        this.appendValueInput('STEP')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('步长');
        this.appendValueInput('DEFAULT')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('默认值');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带步长和默认值的滑块');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_step_slider'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加步进滑块');
        this.appendValueInput('STEPS')
            .setCheck('Array')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('步骤');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个步进滑块');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_step_slider_with_default'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('LABEL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加步进滑块');
        this.appendValueInput('STEPS')
            .setCheck('Array')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('步骤');
        this.appendValueInput('DEFAULT')
            .setCheck('Number')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('默认步骤');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个带默认值的步进滑块');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_label'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加标签');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个标签');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_header'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('TEXT')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加标题');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个标题');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_divider'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('添加分隔线');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('添加一个分隔线');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_path_icon'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('PATH')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置路径图标');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('设置表单的路径图标');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_url_icon'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('URL')
            .setCheck('String')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('设置URL图标');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('设置表单的URL图标');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_show'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendValueInput('PLAYER')
            .setCheck('Player')
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField('显示给玩家');
        this.appendStatementInput('ON_RESPONSE')
            .setCheck(null)
            .appendField('当提交');
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#745BA5');
        this.setTooltip('显示自定义表单给玩家，并处理提交');
        this.setHelpUrl('');
    }
};

Blockly.Blocks['form_custom_on_close'] = {
    init: function() {
        this.appendValueInput('FORM')
            .setCheck('CustomForm')
            .appendField('自定义表单');
        this.appendStatementInput('ON_CLOSE')
            .setCheck(null)
            .appendField('当关闭');
        this.setOutput(true, 'CustomForm');
        this.setColour('#745BA5');
        this.setTooltip('设置自定义表单关闭时的回调');
        this.setHelpUrl('');
    }
};
