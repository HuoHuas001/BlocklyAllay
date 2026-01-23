package cn.huohuas001.blocklyallay.script.api.event

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value

/**
 * 存储注册的事件处理器及其上下文。
 */
data class RegisteredHandler(
    val function: Value,
    val context: Context
)