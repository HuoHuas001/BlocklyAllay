/**
 * Form Code Generators
 */

(function() {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['form_simple_create'] = function(block, gen) {
        return ['allay.getForms().createSimpleForm()', OrderCall];
    };

    generator.forBlock['form_simple_title'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const title = gen.valueToCode(block, 'TITLE', Order) || '""';
        return [`${form}.title(${title})`, OrderCall];
    };

    generator.forBlock['form_simple_content'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const content = gen.valueToCode(block, 'CONTENT', Order) || '""';
        return [`${form}.content(${content})`, OrderCall];
    };

    generator.forBlock['form_simple_button'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        return [`${form}.button(${text})`, OrderCall];
    };

    generator.forBlock['form_simple_button_with_image'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        return [`${form}.buttonWithPathImage(${text}, ${path})`, OrderCall];
    };

    generator.forBlock['form_simple_button_with_url'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        const url = gen.valueToCode(block, 'URL', Order) || '""';
        return [`${form}.buttonWithUrlImage(${text}, ${url})`, OrderCall];
    };

    generator.forBlock['form_simple_label'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        return [`${form}.label(${text})`, OrderCall];
    };

    generator.forBlock['form_simple_header'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        return [`${form}.header(${text})`, OrderCall];
    };

    generator.forBlock['form_simple_divider'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        return [`${form}.divider()`, OrderCall];
    };

    generator.forBlock['form_simple_show'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const statements = gen.statementToCode(block, 'ON_RESPONSE');
        return `${form}.onResponse(function(buttonText, buttonIndex) {\n${statements}}, this).show(${player});\n`;
    };

    generator.forBlock['form_simple_on_close'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const statements = gen.statementToCode(block, 'ON_CLOSE');
        return [`${form}.onClose(function() {\n${statements}}, this)`, OrderCall];
    };

    generator.forBlock['form_modal_create'] = function(block, gen) {
        return ['allay.getForms().createModalForm()', OrderCall];
    };

    generator.forBlock['form_modal_setup'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const title = gen.valueToCode(block, 'TITLE', Order) || '""';
        const content = gen.valueToCode(block, 'CONTENT', Order) || '""';
        const trueBtn = gen.valueToCode(block, 'TRUE_BTN', Order) || '"确定"';
        const falseBtn = gen.valueToCode(block, 'FALSE_BTN', Order) || '"取消"';
        return [`${form}.title(${title}).content(${content}).trueButton(${trueBtn}).falseButton(${falseBtn})`, OrderCall];
    };

    generator.forBlock['form_modal_show'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const onTrue = gen.statementToCode(block, 'ON_TRUE');
        const onFalse = gen.statementToCode(block, 'ON_FALSE');
        return `${form}.onTrue(function() {\n${onTrue}}, this).onFalse(function() {\n${onFalse}}, this).show(${player});\n`;
    };

    generator.forBlock['form_modal_on_close'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const statements = gen.statementToCode(block, 'ON_CLOSE');
        return [`${form}.onClose(function() {\n${statements}}, this)`, OrderCall];
    };

    generator.forBlock['form_custom_create'] = function(block, gen) {
        const title = gen.valueToCode(block, 'TITLE', Order) || '""';
        return [`allay.getForms().createCustomForm().title(${title})`, OrderCall];
    };

    generator.forBlock['form_custom_input'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const placeholder = gen.valueToCode(block, 'PLACEHOLDER', Order) || '""';
        return [`${form}.input(${label}, ${placeholder})`, OrderCall];
    };

    generator.forBlock['form_custom_input_with_default'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const placeholder = gen.valueToCode(block, 'PLACEHOLDER', Order) || '""';
        const defaultText = gen.valueToCode(block, 'DEFAULT', Order) || '""';
        return [`${form}.input(${label}, ${placeholder}, ${defaultText})`, OrderCall];
    };

    generator.forBlock['form_custom_toggle'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const defaultVal = block.getFieldValue('DEFAULT');
        return [`${form}.toggle(${label}, ${defaultVal})`, OrderCall];
    };

    generator.forBlock['form_custom_dropdown'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const options = gen.valueToCode(block, 'OPTIONS', Order) || '[]';
        return [`${form}.dropdown(${label}, ${options})`, OrderCall];
    };

    generator.forBlock['form_custom_dropdown_with_default'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const options = gen.valueToCode(block, 'OPTIONS', Order) || '[]';
        const defaultIndex = gen.valueToCode(block, 'DEFAULT', Order) || '0';
        return [`${form}.dropdown(${label}, ${options}, ${defaultIndex})`, OrderCall];
    };

    generator.forBlock['form_custom_slider'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const min = gen.valueToCode(block, 'MIN', Order) || '0';
        const max = gen.valueToCode(block, 'MAX', Order) || '100';
        return [`${form}.slider(${label}, ${min}, ${max})`, OrderCall];
    };

    generator.forBlock['form_custom_slider_with_step'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const min = gen.valueToCode(block, 'MIN', Order) || '0';
        const max = gen.valueToCode(block, 'MAX', Order) || '100';
        const step = gen.valueToCode(block, 'STEP', Order) || '1';
        return [`${form}.slider(${label}, ${min}, ${max}, ${step})`, OrderCall];
    };

    generator.forBlock['form_custom_slider_with_default'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const min = gen.valueToCode(block, 'MIN', Order) || '0';
        const max = gen.valueToCode(block, 'MAX', Order) || '100';
        const step = gen.valueToCode(block, 'STEP', Order) || '1';
        const defaultValue = gen.valueToCode(block, 'DEFAULT', Order) || '0';
        return [`${form}.slider(${label}, ${min}, ${max}, ${step}, ${defaultValue})`, OrderCall];
    };

    generator.forBlock['form_custom_step_slider'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const steps = gen.valueToCode(block, 'STEPS', Order) || '[]';
        return [`${form}.stepSlider(${label}, ${steps})`, OrderCall];
    };

    generator.forBlock['form_custom_step_slider_with_default'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const label = gen.valueToCode(block, 'LABEL', Order) || '""';
        const steps = gen.valueToCode(block, 'STEPS', Order) || '[]';
        const defaultStep = gen.valueToCode(block, 'DEFAULT', Order) || '0';
        return [`${form}.stepSlider(${label}, ${steps}, ${defaultStep})`, OrderCall];
    };

    generator.forBlock['form_custom_label'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        return [`${form}.label(${text})`, OrderCall];
    };

    generator.forBlock['form_custom_header'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const text = gen.valueToCode(block, 'TEXT', Order) || '""';
        return [`${form}.header(${text})`, OrderCall];
    };

    generator.forBlock['form_custom_divider'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        return [`${form}.divider()`, OrderCall];
    };

    generator.forBlock['form_custom_path_icon'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        return [`${form}.pathIcon(${path})`, OrderCall];
    };

    generator.forBlock['form_custom_url_icon'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const url = gen.valueToCode(block, 'URL', Order) || '""';
        return [`${form}.urlIcon(${url})`, OrderCall];
    };

    generator.forBlock['form_custom_show'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const player = gen.valueToCode(block, 'PLAYER', Order) || 'player';
        const statements = gen.statementToCode(block, 'ON_RESPONSE');
        return `${form}.onResponse(function(responses) {\n${statements}}, this).show(${player});\n`;
    };

    generator.forBlock['form_custom_on_close'] = function(block, gen) {
        const form = gen.valueToCode(block, 'FORM', Order) || 'form';
        const statements = gen.statementToCode(block, 'ON_CLOSE');
        return [`${form}.onClose(function() {\n${statements}}, this)`, OrderCall];
    };
})();
