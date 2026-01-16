package cn.huohuas001.blocklyallay.script.api.event

import org.mozilla.javascript.Function
import org.mozilla.javascript.Scriptable

/**
 * 存储注册的事件处理器及其作用域。
 */
data class RegisteredHandler(
    val function: Function,
    val scope: Scriptable
)
