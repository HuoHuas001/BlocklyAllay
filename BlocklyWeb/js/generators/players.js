/**
 * Player Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['player_get_name'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        return [`${player}.getName()`, OrderCall];
    };

    generator.forBlock['player_get_display_name'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        return [`${player}.getDisplayName()`, OrderCall];
    };

    generator.forBlock['player_send_message'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `${player}.sendMessage(${message});\n`;
    };

    generator.forBlock['player_get_position'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const coord = block.getFieldValue('COORD');
        return [`${player}.get${coord}()`, OrderCall];
    };

    generator.forBlock['player_teleport'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const x = gen.valueToCode(block, 'X', Order) || '0';
        const y = gen.valueToCode(block, 'Y', Order) || '0';
        const z = gen.valueToCode(block, 'Z', Order) || '0';
        return `${player}.teleport(${x}, ${y}, ${z});\n`;
    };

    generator.forBlock['player_get_health'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        return [`${player}.getHealth()`, OrderCall];
    };

    generator.forBlock['player_set_health'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const health = gen.valueToCode(block, 'HEALTH', Order) || '20';
        return `${player}.setHealth(${health});\n`;
    };

    generator.forBlock['player_kick'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const reason = gen.valueToCode(block, 'REASON', Order) || '"Kicked"';
        return `${player}.kick(${reason});\n`;
    };

    generator.forBlock['player_get_gamemode'] = function(block, gen) {
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        return [`${player}.getGameMode()`, OrderCall];
    };

    generator.forBlock['player_get_online'] = function(block, gen) {
        return ['allay.getOnlinePlayers()', OrderCall];
    };

    generator.forBlock['player_get_by_name'] = function(block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order) || '""';
        return [`allay.getPlayer(${name})`, OrderCall];
    };
})();
