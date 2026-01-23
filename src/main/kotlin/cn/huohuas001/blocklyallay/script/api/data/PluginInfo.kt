package cn.huohuas001.blocklyallay.script.api.data

/**
 * 插件注册信息
 * 用于存储通过Blockly脚本注册的插件元数据
 */
data class PluginInfo(
    val pluginName: String,
    val pluginVersion: String,
    val author: String
)