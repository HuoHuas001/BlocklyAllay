/**
 * Entity Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['entity_get_type'] = function(block, gen) {
        const entity = gen.valueToCode(block, 'ENTITY', Order) || 'entity';
        return [`${entity}.getType()`, OrderCall];
    };

    generator.forBlock['entity_get_position'] = function(block, gen) {
        const entity = gen.valueToCode(block, 'ENTITY', Order) || 'entity';
        const coord = block.getFieldValue('COORD');
        return [`${entity}.get${coord}()`, OrderCall];
    };

    generator.forBlock['entity_get_health'] = function(block, gen) {
        const entity = gen.valueToCode(block, 'ENTITY', Order) || 'entity';
        return [`${entity}.getHealth()`, OrderCall];
    };

    generator.forBlock['entity_set_health'] = function(block, gen) {
        const entity = gen.valueToCode(block, 'ENTITY', Order) || 'entity';
        const health = gen.valueToCode(block, 'HEALTH', Order) || '20';
        return `${entity}.setHealth(${health});\n`;
    };
})();
