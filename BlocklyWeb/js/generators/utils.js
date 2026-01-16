/**
 * Utility Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['util_log'] = function(block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `allay.log(${message});\n`;
    };

    generator.forBlock['util_info'] = function(block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `allay.info(${message});\n`;
    };

    generator.forBlock['util_warn'] = function(block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `allay.warn(${message});\n`;
    };

    generator.forBlock['util_error'] = function(block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `allay.error(${message});\n`;
    };

    generator.forBlock['util_debug'] = function(block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `allay.debug(${message});\n`;
    };

    generator.forBlock['util_cancel_event'] = function(block, gen) {
        return `event.cancel();\n`;
    };

    generator.forBlock['scheduler_run_later'] = function(block, gen) {
        const delay = gen.valueToCode(block, 'DELAY', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runLater(${delay}, function() {\n${statements}}, this);\n`;
    };

    generator.forBlock['scheduler_run_repeating'] = function(block, gen) {
        const period = gen.valueToCode(block, 'PERIOD', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runRepeating(${period}, function() {\n${statements}}, this);\n`;
    };

    generator.forBlock['scheduler_run_delayed_repeating'] = function(block, gen) {
        const delay = gen.valueToCode(block, 'DELAY', Order) || '20';
        const period = gen.valueToCode(block, 'PERIOD', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runDelayedRepeating(${delay}, ${period}, function() {\n${statements}}, this);\n`;
    };

    generator.forBlock['event_off'] = function(block, gen) {
        const eventType = gen.valueToCode(block, 'EVENT_TYPE', Order) || '""';
        return `allay.off(${eventType});\n`;
    };

    generator.forBlock['event_cleanup'] = function(block, gen) {
        return `allay.cleanup();\n`;
    };
})();
