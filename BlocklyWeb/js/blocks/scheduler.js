/**
 * Scheduler Blocks Definition
 */

// Run Later
Blockly.Blocks['scheduler_run_later'] = {
    init: function() {
        this.appendValueInput('DELAY')
            .setCheck('Number')
            .appendField('延迟');
        this.appendDummyInput()
            .appendField('刻后执行');
        this.appendStatementInput('DO')
            .setCheck(null);
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA5A5');
        this.setTooltip('延迟指定刻数后执行一次（20刻=1秒）');
        this.setHelpUrl('');
    }
};

// Run Repeating
Blockly.Blocks['scheduler_run_repeating'] = {
    init: function() {
        this.appendValueInput('PERIOD')
            .setCheck('Number')
            .appendField('每隔');
        this.appendDummyInput()
            .appendField('刻重复执行');
        this.appendStatementInput('DO')
            .setCheck(null);
        this.setInputsInline(true);
        this.setPreviousStatement(true, null);
        this.setNextStatement(true, null);
        this.setColour('#5BA5A5');
        this.setTooltip('每隔指定刻数重复执行（20刻=1秒）');
        this.setHelpUrl('');
    }
};
