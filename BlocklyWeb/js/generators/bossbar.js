/**
 * BossBar Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['bossbar_create'] = function(block, gen) {
        const title = gen.valueToCode(block, 'TITLE', Order) || '""';
        return [`allay.getBossBar().create(${title})`, OrderCall];
    };

    generator.forBlock['bossbar_set_title'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const title = gen.valueToCode(block, 'TITLE', Order) || '""';
        return [`${bossbar}.setTitle(${title})`, OrderCall];
    };

    generator.forBlock['bossbar_set_progress'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const progress = gen.valueToCode(block, 'PROGRESS', Order) || '1';
        return [`${bossbar}.setProgress(${progress})`, OrderCall];
    };

    generator.forBlock['bossbar_set_color'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const color = block.getFieldValue('COLOR');
        return [`${bossbar}.setColor("${color}")`, OrderCall];
    };

    generator.forBlock['bossbar_show'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        return `${bossbar}.show(${player});\n`;
    };

    generator.forBlock['bossbar_hide'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        return `${bossbar}.hide(${player});\n`;
    };

    generator.forBlock['bossbar_get_title'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return [`${bossbar}.getTitle()`, OrderCall];
    };

    generator.forBlock['bossbar_get_progress'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return [`${bossbar}.getProgress()`, OrderCall];
    };

    generator.forBlock['bossbar_get_color'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return [`${bossbar}.getColor()`, OrderCall];
    };

    generator.forBlock['bossbar_set_style'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const style = block.getFieldValue('STYLE');
        return [`${bossbar}.setStyle("${style}")`, OrderCall];
    };

    generator.forBlock['bossbar_get_style'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return [`${bossbar}.getStyle()`, OrderCall];
    };

    generator.forBlock['bossbar_set_darken_sky'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        const darken = gen.valueToCode(block, 'DARKEN', Order) || 'false';
        return [`${bossbar}.setDarkenSky(${darken})`, OrderCall];
    };

    generator.forBlock['bossbar_is_darken_sky'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return [`${bossbar}.isDarkenSky()`, OrderCall];
    };

    generator.forBlock['bossbar_remove_all_viewers'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return `${bossbar}.removeAllViewers();\n`;
    };

    generator.forBlock['bossbar_get_viewer_count'] = function(block, gen) {
        const bossbar = gen.valueToCode(block, 'BOSSBAR', Order) || 'bossbar';
        return [`${bossbar}.getViewerCount()`, OrderCall];
    };
})();
