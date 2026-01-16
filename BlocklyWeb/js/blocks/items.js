/**
 * Item Blocks Definition
 */

// Get Item Type
Blockly.Blocks['item_get_type'] = {
    init: function() {
        this.appendValueInput('ITEM')
            .setCheck('Item')
            .appendField('获取物品');
        this.appendDummyInput()
            .appendField('的类型');
        this.setInputsInline(true);
        this.setOutput(true, 'String');
        this.setColour('#A5A55B');
        this.setTooltip('获取物品的类型ID');
        this.setHelpUrl('');
    }
};

// Get Item Count
Blockly.Blocks['item_get_count'] = {
    init: function() {
        this.appendValueInput('ITEM')
            .setCheck('Item')
            .appendField('获取物品');
        this.appendDummyInput()
            .appendField('的数量');
        this.setInputsInline(true);
        this.setOutput(true, 'Number');
        this.setColour('#A5A55B');
        this.setTooltip('获取物品的数量');
        this.setHelpUrl('');
    }
};

// Get Item Name
Blockly.Blocks['item_get_name'] = {
    init: function() {
        this.appendValueInput('ITEM')
            .setCheck('Item')
            .appendField('获取物品');
        this.appendDummyInput()
            .appendField('的名称');
        this.setInputsInline(true);
        this.setOutput(true, 'String');
        this.setColour('#A5A55B');
        this.setTooltip('获取物品的自定义名称');
        this.setHelpUrl('');
    }
};
