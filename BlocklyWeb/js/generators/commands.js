/**
 * Commands Code Generators
 */

(function () {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['command_register_simple'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);
        const description = gen.valueToCode(block, 'DESCRIPTION', Order) || '""';
        const handler = gen.valueToCode(block, 'HANDLER', Order);

        return `allay.getCommandAPI().registerCommand(${name}, ${description}, ${handler});\n`;
    };

    generator.forBlock['command_register_with_permission'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);
        const description = gen.valueToCode(block, 'DESCRIPTION', Order) || '""';
        const permission = gen.valueToCode(block, 'PERMISSION', Order) || '""';
        const handler = gen.valueToCode(block, 'HANDLER', Order);

        return `allay.getCommandAPI().registerCommand(${name}, ${description}, ${permission}, ${handler});\n`;
    };

    generator.forBlock['command_register_with_aliases'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);
        const description = gen.valueToCode(block, 'DESCRIPTION', Order) || '""';
        const aliases = gen.valueToCode(block, 'ALIASES', Order) || '[]';
        const handler = gen.valueToCode(block, 'HANDLER', Order);

        return `allay.getCommandAPI().registerCommand(${name}, ${description}, ${aliases}, ${handler});\n`;
    };

    generator.forBlock['command_unregister'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);

        return `allay.getCommandAPI().unregisterAll();\n`; // 目前只支持注销所有命令
    };

    generator.forBlock['command_context_sender'] = function (block, gen) {
        return [`context.getSender()`, Order];
    };

    generator.forBlock['command_context_command'] = function (block, gen) {
        return [`context.getCommandName()`, Order]; // 假設有此方法
    };

    generator.forBlock['command_context_args'] = function (block, gen) {
        return [`context.getArgs()`, Order]; // 假設有此方法
    };

    generator.forBlock['command_context_get_arg'] = function (block, gen) {
        const index = gen.valueToCode(block, 'INDEX', Order);

        return [`context.getArg(${index})`, Order]; // 假設有此方法
    };

    generator.forBlock['command_send_message'] = function (block, gen) {
        const sender = gen.valueToCode(block, 'SENDER', Order);
        const message = gen.valueToCode(block, 'MESSAGE', Order);

        return `${sender}.sendMessage(${message});\n`;
    };

    generator.forBlock['command_has_permission'] = function (block, gen) {
        const sender = gen.valueToCode(block, 'SENDER', Order);
        const permission = gen.valueToCode(block, 'PERMISSION', Order);

        return `${sender}.hasPermission(${permission});\n`;
    };

    generator.forBlock['command_is_player'] = function (block, gen) {
        const sender = gen.valueToCode(block, 'SENDER', Order);

        return `${sender}.isPlayer();\n`;
    };

    generator.forBlock['command_is_console'] = function (block, gen) {
        const sender = gen.valueToCode(block, 'SENDER', Order);

        return `${sender}.isConsole();\n`;
    };

    generator.forBlock['command_handler_function'] = function (block, gen) {
        const body = gen.statementToCode(block, 'DO');

        const code = `function(context) {
${body}}
`;
        return [code, Order];
    };

    generator.forBlock['command_get_player'] = function (block, gen) {
        const sender = gen.valueToCode(block, 'SENDER', Order);

        return `${sender}.asPlayer();\n`;
    };
})();
