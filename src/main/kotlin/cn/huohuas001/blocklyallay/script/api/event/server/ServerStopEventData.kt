package cn.huohuas001.blocklyallay.script.api.event.server

import org.allaymc.api.eventbus.event.server.ServerStopEvent

/**
 * 包装ServerStopEvent（服务器停止），暴露给JavaScript脚本使用。
 */
class ServerStopEventData(private val event: ServerStopEvent)
