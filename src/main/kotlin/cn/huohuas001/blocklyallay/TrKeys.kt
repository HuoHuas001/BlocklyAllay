package cn.huohuas001.blocklyallay

/**
 * BlocklyAllay 翻译键常量
 * 集中管理所有国际化翻译键
 */
object TrKeys {
    // 命令相关
    const val COMMAND_DESCRIPTION = "blocklyallay:command.description"
    const val COMMAND_RELOAD_DESCRIPTION = "blocklyallay:command.reload.description"
    const val COMMAND_LOAD_DESCRIPTION = "blocklyallay:command.load.description"
    const val COMMAND_UNLOAD_DESCRIPTION = "blocklyallay:command.unload.description"
    const val COMMAND_LIST_DESCRIPTION = "blocklyallay:command.list.description"

    const val COMMAND_RELOAD_ALL = "blocklyallay:command.reload.all"
    const val COMMAND_RELOAD_SUCCESS = "blocklyallay:command.reload.success"
    const val COMMAND_RELOAD_FAILED = "blocklyallay:command.reload.failed"

    const val COMMAND_LOAD_SUCCESS = "blocklyallay:command.load.success"
    const val COMMAND_LOAD_FAILED = "blocklyallay:command.load.failed"

    const val COMMAND_UNLOAD_SUCCESS = "blocklyallay:command.unload.success"
    const val COMMAND_UNLOAD_FAILED = "blocklyallay:command.unload.failed"

    const val COMMAND_LIST_EMPTY = "blocklyallay:command.list.empty"
    const val COMMAND_LIST_HEADER = "blocklyallay:command.list.header"
    const val COMMAND_LIST_ITEM = "blocklyallay:command.list.item"

    const val COMMAND_HELP_HEADER = "blocklyallay:command.help.header"
    const val COMMAND_HELP_RELOAD = "blocklyallay:command.help.reload"
    const val COMMAND_HELP_LOAD = "blocklyallay:command.help.load"
    const val COMMAND_HELP_UNLOAD = "blocklyallay:command.help.unload"
    const val COMMAND_HELP_LIST = "blocklyallay:command.help.list"

    const val COMMAND_LOAD_USAGE = "blocklyallay:command.load.usage"
    const val COMMAND_UNLOAD_USAGE = "blocklyallay:command.unload.usage"
    const val COMMAND_UNKNOWN = "blocklyallay:command.unknown"

    // 脚本相关
    const val SCRIPT_LOADED = "blocklyallay:script.loaded"
    const val SCRIPT_UNLOADED = "blocklyallay:script.unloaded"
    const val SCRIPT_ERROR_NOTFOUND = "blocklyallay:script.error.notfound"
    const val SCRIPT_ERROR_NOTLOADED = "blocklyallay:script.error.notloaded"
    const val SCRIPT_ERROR_LOAD = "blocklyallay:script.error.load"
    const val SCRIPT_ERROR_UNLOAD = "blocklyallay:script.error.unload"
    const val SCRIPT_DIR_CREATED = "blocklyallay:script.dir.created"
    const val SCRIPT_ERROR_CLOSE = "blocklyallay:script.error.close"
    const val SCRIPT_ERROR_FUNCTION_CALL = "blocklyallay:script.error.function.call"

    // 插件相关
    const val PLUGIN_LOADING = "blocklyallay:plugin.loading"
    const val PLUGIN_ENABLED = "blocklyallay:plugin.enabled"
    const val PLUGIN_ENABLE_FAILED = "blocklyallay:plugin.enable.failed"
    const val PLUGIN_DISABLED = "blocklyallay:plugin.disabled"

    // 命令注册相关
    const val COMMAND_REGISTER_SUCCESS = "blocklyallay:command.register.success"
    const val COMMAND_REGISTER_ERROR = "blocklyallay:command.register.error"
    const val COMMAND_EXECUTE_ERROR = "blocklyallay:command.execute.error"

    // 文件操作相关
    const val FILE_READ_ERROR = "blocklyallay:file.read.error"
    const val FILE_WRITE_ERROR = "blocklyallay:file.write.error"
    const val FILE_DELETE_ERROR = "blocklyallay:file.delete.error"
    const val FILE_LIST_ERROR = "blocklyallay:file.list.error"
    const val FILE_MKDIR_ERROR = "blocklyallay:file.mkdir.error"

    // HTTP请求相关
    const val HTTP_GET_FAILED = "blocklyallay:http.get.failed"
    const val HTTP_GET_ERROR = "blocklyallay:http.get.error"
    const val HTTP_POST_FAILED = "blocklyallay:http.post.failed"
    const val HTTP_POST_ERROR = "blocklyallay:http.post.error"

    // Logger相关
    const val LOGGER_PREFIX = "blocklyallay:logger.prefix"

    // 事件处理相关
    const val EVENT_HANDLER_ERROR = "blocklyallay:event.handler.error"

    // 定时任务相关
    const val SCHEDULED_TASK_ERROR = "blocklyallay:scheduled.task.error"
    const val REPEATING_TASK_ERROR = "blocklyallay:repeating.task.error"
}
