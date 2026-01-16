/**
 * Entity Blocks Definition
 */

// Get Entity Type
Blockly.Blocks['entity_get_type'] = {
    init: function() {
        this.appendValueInput('ENTITY')
            .setCheck('Entity')
            .appendField('获取实体');
        this.appendDummyInput()
            .appendField('的类型');
        this.setInputsInline(true);
        this.setOutput(true, 'String');
        this.setColour('#A5745B');
        this.setTooltip('获取实体的类型');
        this.setHelpUrl('');
    }
};

// Get Entity Position
Blockly.Blocks['entity_get_position'] = {
    init: function() {
        this.appendValueInput('ENTITY')
            .setCheck('Entity')
            .appendField('获取实体');
        this.appendDummyInput()
            .appendField('的')
            .appendField(new Blockly.FieldDropdown([
                ['X坐标', 'X'],
                ['Y坐标', 'Y'],
                ['Z坐标', 'Z']
            ]), 'COORD');
        this.setInputsInline(true);
        this.setOutput(true, 'Number');
        this.setColour('#A5745B');
        this.setTooltip('获取实体的坐标');
        this.setHelpUrl('');
    }
};

// Get Entity Health
Blockly.Blocks['entity_get_health'] = {
    init: function() {
        this.appendValueInput('ENTITY')
            .setCheck('Entity')
            .appendField('获取实体');
        this.appendDummyInput()
            .appendField('的生命值');
        this.setInputsInline(true);
        this.setOutput(true, 'Number');
        this.setColour('#A5745B');
        this.setTooltip('获取实体的当前生命值');
        this.setHelpUrl('');
    }
};

// Set Entity Health
Blockly.Blocks['entity_set_health'] = {
    init: function() {
        this.appendValueInput('ENTITY')
            .setCheck('Entity')
            .appendField('设置实体');
        this.appendValueInput('HEALTH')
            .setCheck('Number')
            .appendField('的生命值为');
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#A5745B');
        this.setTooltip('设置实体的生命值');
        this.setHelpUrl('');
    }
};
