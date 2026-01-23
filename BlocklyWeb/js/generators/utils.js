/**
 * Utility Code Generators
 */

(function () {
    const generator = Blockly.JavaScript;
    const Order = generator.ORDER_ATOMIC;
    const OrderCall = generator.ORDER_FUNCTION_CALL;

    generator.forBlock['util_log'] = function (block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `logger.log(${message});\n`;
    };

    generator.forBlock['util_info'] = function (block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `logger.info(${message});\n`;
    };

    generator.forBlock['util_warn'] = function (block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `logger.warn(${message});\n`;
    };

    generator.forBlock['util_error'] = function (block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `logger.error(${message});\n`;
    };

    generator.forBlock['util_debug'] = function (block, gen) {
        const message = gen.valueToCode(block, 'MESSAGE', Order) || '""';
        return `logger.debug(${message});\n`;
    };

    generator.forBlock['util_cancel_event'] = function (block, gen) {
        return `event.cancel();\n`;
    };

    generator.forBlock['scheduler_run_later'] = function (block, gen) {
        const delay = gen.valueToCode(block, 'DELAY', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runLater(${delay}, function() {\n${statements}}, this);\n`;
    };

    generator.forBlock['scheduler_run_repeating'] = function (block, gen) {
        const period = gen.valueToCode(block, 'PERIOD', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runRepeating(${period}, function() {\n${statements}}, this);\n`;
    };

    generator.forBlock['scheduler_run_delayed_repeating'] = function (block, gen) {
        const delay = gen.valueToCode(block, 'DELAY', Order) || '20';
        const period = gen.valueToCode(block, 'PERIOD', Order) || '20';
        const statements = gen.statementToCode(block, 'DO');
        return `allay.runDelayedRepeating(${delay}, ${period}, function() {\n${statements}}, this);\n`;
    };

    generator.forBlock['event_off'] = function (block, gen) {
        const eventType = gen.valueToCode(block, 'EVENT_TYPE', Order) || '""';
        return `allay.off(${eventType});\n`;
    };

    generator.forBlock['event_cleanup'] = function (block, gen) {
        return `allay.cleanup();\n`;
    };

    // ==================== Command API 生成器 ====================

    generator.forBlock['command_register_simple'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);
        const description = gen.valueToCode(block, 'DESCRIPTION', Order) || '';
        const permission = gen.valueToCode(block, 'PERMISSION', Order) || '';
        const handler = gen.statementToCode(block, 'HANDLER', Order);

        return `allay.getCommandAPI().registerCommand(${name}, ${description}, ${permission}, ${handler});\n`;
    };

    generator.forBlock['command_register_with_aliases'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);
        const description = gen.valueToCode(block, 'DESCRIPTION', Order) || '';
        const permission = gen.valueToCode(block, 'PERMISSION', Order) || '';
        const aliases = gen.valueToCode(block, 'ALIASES', Order) || '[]';
        const handler = gen.statementToCode(block, 'HANDLER', Order);

        return `allay.getCommandAPI().registerCommand(${name}, ${description}, ${aliases}, ${handler});\n`;
    };

    generator.forBlock['command_unregister'] = function (block, gen) {
        const name = gen.valueToCode(block, 'NAME', Order);

        return `allay.getCommandAPI().unregisterAll();\n`;
    };

    generator.forBlock['command_context_sender'] = function (block, gen) {
        return `allay.getCommandAPI().getCommandAPI().registerSimpleCommand();\n`;
    };

    generator.forBlock['command_context_command'] = function (block, gen) {
        return `allay.getCommandAPI().getCommandAPI().registerSimpleCommand();\n`;
    };

    generator.forBlock['command_send_message'] = function (block, gen) {
        const sender = gen.valueToCode(block, 'SENDER', Order);
        const message = gen.valueToCode(block, 'MESSAGE', Order);

        return `${sender}.sendMessage(${message});\n`;
    };

    // ==================== 文件 API 生成器 ====================

    generator.forBlock['file_read'] = function (block, gen) {
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        return [`allay.getFiles().readFile(${path})`, gen.ORDER_NONE];
    };

    generator.forBlock['file_write'] = function (block, gen) {
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        const content = gen.valueToCode(block, 'CONTENT', Order) || '""';
        const overwrite = block.getFieldValue('OVERWRITE') === 'TRUE';
        return `allay.getFiles().writeFile(${path}, ${content}, ${overwrite});\n`;
    };

    generator.forBlock['file_exists'] = function (block, gen) {
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        return [`allay.getFiles().fileExists(${path})`, gen.ORDER_NONE];
    };

    generator.forBlock['file_delete'] = function (block, gen) {
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        return `allay.getFiles().deleteFile(${path});\n`;
    };

    generator.forBlock['file_list'] = function (block, gen) {
        const path = gen.valueToCode(block, 'PATH', Order) || '""';
        return [`allay.getFiles().listFiles(${path})`, gen.ORDER_NONE];
    };

    // ==================== HTTP API 生成器 ====================

    generator.forBlock['http_get'] = function (block, gen) {
        const url = gen.valueToCode(block, 'URL', Order) || '""';
        return [`allay.getHttp().get(${url})`, gen.ORDER_NONE];
    };

    generator.forBlock['http_post'] = function (block, gen) {
        const url = gen.valueToCode(block, 'URL', Order) || '""';
        const body = gen.valueToCode(block, 'BODY', Order) || '""';
        return [`allay.getHttp().post(${url}, ${body})`, gen.ORDER_NONE];
    };

    generator.forBlock['http_get_with_headers'] = function (block, gen) {
        const url = gen.valueToCode(block, 'URL', Order) || '""';
        const headers = gen.valueToCode(block, 'HEADERS', Order) || '{}';
        return [`allay.getHttp().getWithHeaders(${url}, ${headers})`, gen.ORDER_NONE];
    };

    generator.forBlock['http_post_with_headers'] = function (block, gen) {
        const url = gen.valueToCode(block, 'URL', Order) || '""';
        const body = gen.valueToCode(block, 'BODY', Order) || '""';
        const headers = gen.valueToCode(block, 'HEADERS', Order) || '{}';
        return [`allay.getHttp().postWithHeaders(${url}, ${body}, "application/json", ${headers})`, gen.ORDER_NONE];
    };

    // ==================== JSON 处理生成器 ====================

    generator.forBlock['json_parse'] = function (block, gen) {
        const jsonText = gen.valueToCode(block, 'JSON_TEXT', Order) || '"{}"';
        return [`JSON.parse(${jsonText})`, gen.ORDER_NONE];
    };

    generator.forBlock['json_stringify'] = function (block, gen) {
        const jsonObj = gen.valueToCode(block, 'JSON_OBJ', Order) || '{}';
        return [`JSON.stringify(${jsonObj})`, gen.ORDER_NONE];
    };

    // ==================== 对象操作生成器 ====================

    generator.forBlock['object_create'] = function (block, gen) {
        return [`{}`, gen.ORDER_NONE];
    };

    generator.forBlock['object_get_property'] = function (block, gen) {
        const obj = gen.valueToCode(block, 'OBJECT', Order) || '{}';
        const prop = gen.valueToCode(block, 'PROPERTY', Order) || '""';
        return [`${obj}[${prop}]`, gen.ORDER_MEMBER];
    };

    generator.forBlock['object_set_property'] = function (block, gen) {
        const obj = gen.valueToCode(block, 'OBJECT', Order) || '{}';
        const prop = gen.valueToCode(block, 'PROPERTY', Order) || '""';
        const value = gen.valueToCode(block, 'VALUE', Order) || 'undefined';
        return `${obj}[${prop}] = ${value};\n`;
    };

    generator.forBlock['object_has_property'] = function (block, gen) {
        const obj = gen.valueToCode(block, 'OBJECT', Order) || '{}';
        const prop = gen.valueToCode(block, 'PROPERTY', Order) || '""';
        return [`${prop} in ${obj}`, gen.ORDER_RELATIONAL];
    };

    generator.forBlock['object_delete_property'] = function (block, gen) {
        const obj = gen.valueToCode(block, 'OBJECT', Order) || '{}';
        const prop = gen.valueToCode(block, 'PROPERTY', Order) || '""';
        return `delete ${obj}[${prop}];\n`;
    };

    // ==================== 插件注册生成器 ====================

    generator.forBlock['plugin_register'] = function (block, gen) {
        const pluginName = gen.valueToCode(block, 'PLUGIN_NAME', Order) || '"Unknown"';
        const pluginVersion = gen.valueToCode(block, 'PLUGIN_VERSION', Order) || '"1.0.0"';
        const author = gen.valueToCode(block, 'AUTHOR', Order) || '"Unknown"';

        return `allay.registerPlugin(${pluginName}, ${pluginVersion}, ${author});\n`;
    };
})();
