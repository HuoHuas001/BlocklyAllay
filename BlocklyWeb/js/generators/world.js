/**
 * World Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['world_broadcast'] = function(block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `allay.broadcast(${message});\n`;
    };

    generator.forBlock['world_get_worlds'] = function(block, gen) {
        return ['allay.getWorlds()', OrderCall];
    };

    generator.forBlock['world_get_by_name'] = function(block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order) || '""';
        return [`allay.getWorld(${name})`, OrderCall];
    };

    generator.forBlock['world_get_time'] = function(block, gen) {
        const world = gen.valueToCode(block, 'WORLD', Order) || 'world';
        return [`${world}.getTimeOfDay()`, OrderCall];
    };

    generator.forBlock['world_set_time'] = function(block, gen) {
        const world = gen.valueToCode(block, 'WORLD', Order) || 'world';
        const time = gen.valueToCode(block, 'TIME', Order) || '0';
        return `${world}.setTimeOfDay(${time});\n`;
    };

    generator.forBlock['world_get_online_count'] = function(block, gen) {
        return ['allay.getServer().getOnlineCount()', OrderCall];
    };

    generator.forBlock['world_get_max_players'] = function(block, gen) {
        return ['allay.getServer().getMaxPlayers()', OrderCall];
    };

    generator.forBlock['world_get_current_tick'] = function(block, gen) {
        return ['allay.getServer().getCurrentTick()', OrderCall];
    };
})();
