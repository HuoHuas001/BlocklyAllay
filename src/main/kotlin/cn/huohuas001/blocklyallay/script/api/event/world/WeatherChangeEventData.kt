package cn.huohuas001.blocklyallay.script.api.event.world

import cn.huohuas001.blocklyallay.script.api.wrapper.world.WorldWrapper
import org.allaymc.api.eventbus.event.world.WeatherChangeEvent

/**
 * 包装WeatherChangeEvent（天气变更），暴露给JavaScript脚本使用。
 */
class WeatherChangeEventData(private val event: WeatherChangeEvent) {
    fun getWorld(): WorldWrapper = WorldWrapper(event.world)
    fun getOldWeather(): String = event.oldWeather.name.lowercase()
    fun getNewWeather(): String = event.newWeather.name.lowercase()
    fun cancel() { event.isCancelled = true }
    fun isCancelled(): Boolean = event.isCancelled
}
