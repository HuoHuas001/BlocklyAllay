/**
 * Item Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['item_get_type'] = function(block, gen) {
        const item = gen.valueToCode(block, 'ITEM', Order) || 'item';
        return [`${item}.getType()`, OrderCall];
    };

    generator.forBlock['item_get_count'] = function(block, gen) {
        const item = gen.valueToCode(block, 'ITEM', Order) || 'item';
        return [`${item}.getCount()`, OrderCall];
    };

    generator.forBlock['item_get_name'] = function(block, gen) {
        const item = gen.valueToCode(block, 'ITEM', Order) || 'item';
        return [`${item}.getCustomName()`, OrderCall];
    };
})();
