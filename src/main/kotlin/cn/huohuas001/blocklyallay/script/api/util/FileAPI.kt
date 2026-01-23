package cn.huohuas001.blocklyallay.script.api.util

import cn.huohuas001.blocklyallay.BlocklyAllay
import cn.huohuas001.blocklyallay.TrKeys
import org.allaymc.api.message.I18n
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets

/**
 * 文件读写工具类
 * 提供基本的文件操作功能，如读取、写入、追加等
 * 所有操作都在插件数据目录下进行，确保安全性
 */
class FileAPI(private val plugin: BlocklyAllay) {
    
    /**
     * 获取插件数据目录
     */
    private val dataDir: File
        get() = File("plugins", "BlocklyAllay")
    
    /**
     * 读取文件内容
     * @param path 文件路径，相对于插件数据目录
     * @return 文件内容，如果文件不存在则返回null
     */
    fun readFile(path: String): String? {
        val file = File(dataDir, path)
        return try {
            if (file.exists() && file.isFile) {
                file.readText(StandardCharsets.UTF_8)
            } else {
                null
            }
        } catch (e: IOException) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.FILE_READ_ERROR, path), e)
            null
        }
    }
    
    /**
     * 写入文件内容
     * @param path 文件路径，相对于插件数据目录
     * @param content 要写入的内容
     * @param overwrite 是否覆盖现有文件，true表示覆盖，false表示追加
     * @return 是否写入成功
     */
    fun writeFile(path: String, content: String, overwrite: Boolean = true): Boolean {
        val file = File(dataDir, path)
        return try {
            // 确保父目录存在
            file.parentFile?.mkdirs()
            
            if (overwrite) {
                file.writeText(content, StandardCharsets.UTF_8)
            } else {
                file.appendText(content, StandardCharsets.UTF_8)
            }
            true
        } catch (e: IOException) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.FILE_WRITE_ERROR, path), e)
            false
        }
    }

    /**
     * 检查文件是否存在
     * @param path 文件路径，相对于插件数据目录
     * @return 文件是否存在
     */
    fun fileExists(path: String): Boolean {
        val file = File(dataDir, path)
        return file.exists() && file.isFile
    }

    /**
     * 删除文件
     * @param path 文件路径，相对于插件数据目录
     * @return 是否删除成功
     */
    fun deleteFile(path: String): Boolean {
        val file = File(dataDir, path)
        return try {
            file.delete()
        } catch (e: Exception) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.FILE_DELETE_ERROR, path), e)
            false
        }
    }

    /**
     * 列出目录中的文件
     * @param path 目录路径，相对于插件数据目录
     * @return 文件列表，如果目录不存在则返回空列表
     */
    fun listFiles(path: String): Array<String>? {
        val dir = File(dataDir, path)
        return try {
            if (dir.exists() && dir.isDirectory) {
                dir.list()
            } else {
                null
            }
        } catch (e: Exception) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.FILE_LIST_ERROR, path), e)
            null
        }
    }

    /**
     * 创建目录
     * @param path 目录路径，相对于插件数据目录
     * @return 是否创建成功
     */
    fun mkdir(path: String): Boolean {
        val dir = File(dataDir, path)
        return try {
            dir.mkdirs()
        } catch (e: Exception) {
            plugin.pluginLogger.error(I18n.get().tr(TrKeys.FILE_MKDIR_ERROR, path), e)
            false
        }
    }
    
    /**
     * 获取文件大小
     * @param path 文件路径，相对于插件数据目录
     * @return 文件大小（字节），如果文件不存在则返回-1
     */
    fun getFileSize(path: String): Long {
        val file = File(dataDir, path)
        return if (file.exists() && file.isFile) {
            file.length()
        } else {
            -1
        }
    }
}
