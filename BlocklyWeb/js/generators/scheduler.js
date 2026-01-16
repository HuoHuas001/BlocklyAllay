/**
 * Scheduler Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;

    generator.forBlock['scheduler_run_later'] = function(block, gen) {
        const delay = gen.valueToCode(block, 'DELAY', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runLater(function() {\n${statements}}, ${delay});\n`;
    };

    generator.forBlock['scheduler_run_repeating'] = function(block, gen) {
        const period = gen.valueToCode(block, 'PERIOD', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runRepeating(function() {\n${statements}}, ${period});\n`;
    };
})();
