package cn.huohuas001.blocklyallay.script.api.util

import cn.huohuas001.blocklyallay.BlocklyAllay
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration
import java.util.concurrent.CompletableFuture

/**
 * HTTP请求工具类
 * 提供基本的HTTP请求功能，如GET、POST等
 * 支持同步和异步请求
 */
class HttpAPI(private val plugin: BlocklyAllay) {
    
    /**
     * HTTP客户端实例
     */
    private val httpClient: HttpClient = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(10))
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build()
    
    /**
     * 发送GET请求
     * @param url 请求URL
     * @return 请求结果，如果请求失败则返回null
     */
    fun get(url: String): String? {
        return try {
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "BlocklyAllay/1.0")
                .timeout(Duration.ofSeconds(15))
                .GET()
                .build()
            
            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
            if (response.statusCode() in 200..299) {
                response.body()
            } else {
                plugin.pluginLogger.warn("HTTP GET请求失败 (${response.statusCode()}): $url")
                null
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error("HTTP GET请求异常: $url", e)
            null
        }
    }
    
    /**
     * 发送POST请求
     * @param url 请求URL
     * @param body 请求体内容
     * @param contentType 请求体类型，默认为application/json
     * @return 请求结果，如果请求失败则返回null
     */
    fun post(url: String, body: String, contentType: String = "application/json"): String? {
        return try {
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "BlocklyAllay/1.0")
                .header("Content-Type", contentType)
                .timeout(Duration.ofSeconds(15))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build()
            
            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
            if (response.statusCode() in 200..299) {
                response.body()
            } else {
                plugin.pluginLogger.warn("HTTP POST请求失败 (${response.statusCode()}): $url")
                null
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error("HTTP POST请求异常: $url", e)
            null
        }
    }
    
    /**
     * 发送异步GET请求
     * @param url 请求URL
     * @param callback 回调函数，用于处理请求结果
     */
    fun getAsync(url: String, callback: (String?) -> Unit) {
        try {
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "BlocklyAllay/1.0")
                .timeout(Duration.ofSeconds(15))
                .GET()
                .build()
            
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply { response ->
                    if (response.statusCode() in 200..299) {
                        response.body()
                    } else {
                        plugin.pluginLogger.warn("HTTP GET请求失败 (${response.statusCode()}): $url")
                        null
                    }
                }
                .exceptionally { e ->
                    plugin.pluginLogger.error("HTTP GET请求异常: $url", e)
                    null
                }
                .thenAccept(callback)
        } catch (e: Exception) {
            plugin.pluginLogger.error("HTTP GET请求异常: $url", e)
            callback(null)
        }
    }
    
    /**
     * 发送异步POST请求
     * @param url 请求URL
     * @param body 请求体内容
     * @param contentType 请求体类型，默认为application/json
     * @param callback 回调函数，用于处理请求结果
     */
    fun postAsync(url: String, body: String, contentType: String = "application/json", callback: (String?) -> Unit) {
        try {
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "BlocklyAllay/1.0")
                .header("Content-Type", contentType)
                .timeout(Duration.ofSeconds(15))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build()
            
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply { response ->
                    if (response.statusCode() in 200..299) {
                        response.body()
                    } else {
                        plugin.pluginLogger.warn("HTTP POST请求失败 (${response.statusCode()}): $url")
                        null
                    }
                }
                .exceptionally { e ->
                    plugin.pluginLogger.error("HTTP POST请求异常: $url", e)
                    null
                }
                .thenAccept(callback)
        } catch (e: Exception) {
            plugin.pluginLogger.error("HTTP POST请求异常: $url", e)
            callback(null)
        }
    }
    
    /**
     * 发送带有自定义头的GET请求
     * @param url 请求URL
     * @param headers 自定义请求头
     * @return 请求结果，如果请求失败则返回null
     */
    fun getWithHeaders(url: String, headers: Map<String, String>): String? {
        return try {
            val requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "BlocklyAllay/1.0")
                .timeout(Duration.ofSeconds(15))
            
            // 添加自定义头
            headers.forEach { (key, value) ->
                requestBuilder.header(key, value)
            }
            
            val request = requestBuilder.GET().build()
            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
            
            if (response.statusCode() in 200..299) {
                response.body()
            } else {
                plugin.pluginLogger.warn("HTTP GET请求失败 (${response.statusCode()}): $url")
                null
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error("HTTP GET请求异常: $url", e)
            null
        }
    }
}
