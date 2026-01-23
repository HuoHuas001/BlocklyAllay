package cn.huohuas001.blocklyallay.script.api.form

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.form.FormCancelReason
import org.allaymc.api.form.Forms
import org.allaymc.api.form.type.SimpleForm
import org.allaymc.api.player.Player
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value
import java.util.function.Consumer

/**
 * 简单表单构建器
 */
class SimpleFormBuilder {
    private val form: SimpleForm = Forms.simple()
    private var onResponseCallback: Value? = null
    private var onCloseCallback: Value? = null
    private var context: Context? = null
    private val buttonCallbacks = mutableMapOf<Int, Value>()
    private var buttonIndex = 0

    fun title(title: String): SimpleFormBuilder {
        form.title(title)
        return this
    }

    fun content(content: String): SimpleFormBuilder {
        form.content(content)
        return this
    }

    fun button(text: String): SimpleFormBuilder {
        form.button(text)
        buttonIndex++
        return this
    }

    fun buttonWithCallback(text: String, callback: Value, ctx: Context): SimpleFormBuilder {
        form.button(text)
        buttonCallbacks[buttonIndex] = callback
        this.context = ctx
        buttonIndex++
        return this
    }

    fun buttonWithPathImage(text: String, path: String): SimpleFormBuilder {
        form.buttonWithPathImage(text, path)
        buttonIndex++
        return this
    }

    fun buttonWithUrlImage(text: String, url: String): SimpleFormBuilder {
        form.buttonWithUrlImage(text, url)
        buttonIndex++
        return this
    }

    fun label(text: String): SimpleFormBuilder {
        form.label(text)
        return this
    }

    fun header(text: String): SimpleFormBuilder {
        form.header(text)
        return this
    }

    fun divider(): SimpleFormBuilder {
        form.divider()
        return this
    }

    fun onResponse(callback: Value, ctx: Context): SimpleFormBuilder {
        this.onResponseCallback = callback
        this.context = ctx
        return this
    }

    fun onClose(callback: Value, ctx: Context): SimpleFormBuilder {
        this.onCloseCallback = callback
        this.context = ctx
        return this
    }

    fun show(player: EntityPlayerWrapper): Int {
        val p = player.getEntity().controller ?: return -1
        return showToPlayer(p)
    }

    fun showToPlayer(player: Player): Int {
        form.onResponse { button ->
            val idx = form.elements.indexOf(button)
            buttonCallbacks[idx]?.let { callback ->
                if (callback.canExecute()) {
                    try {
                        callback.execute(button.text, idx)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            onResponseCallback?.let { callback ->
                if (callback.canExecute()) {
                    try {
                        callback.execute(button.text, idx)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }

        form.onClose(Consumer<FormCancelReason> { _ ->
            onCloseCallback?.let { callback ->
                if (callback.canExecute()) {
                    try {
                        callback.execute()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        })

        return player.viewForm(form)
    }
}