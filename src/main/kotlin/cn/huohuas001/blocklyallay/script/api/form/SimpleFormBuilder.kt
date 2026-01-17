package cn.huohuas001.blocklyallay.script.api.form

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.form.FormCancelReason
import org.allaymc.api.form.Forms
import org.allaymc.api.form.type.SimpleForm
import org.allaymc.api.player.Player
import org.mozilla.javascript.Context
import org.mozilla.javascript.Function
import org.mozilla.javascript.Scriptable
import java.util.function.Consumer

/**
 * 简单表单构建器
 */
class SimpleFormBuilder {
    private val form: SimpleForm = Forms.simple()
    private var onResponseCallback: Function? = null
    private var onCloseCallback: Function? = null
    private var scope: Scriptable? = null
    private val buttonCallbacks = mutableMapOf<Int, Function>()
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

    fun buttonWithCallback(text: String, callback: Function, scope: Scriptable): SimpleFormBuilder {
        form.button(text)
        buttonCallbacks[buttonIndex] = callback
        this.scope = scope
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

    fun onResponse(callback: Function, scope: Scriptable): SimpleFormBuilder {
        this.onResponseCallback = callback
        this.scope = scope
        return this
    }

    fun onClose(callback: Function, scope: Scriptable): SimpleFormBuilder {
        this.onCloseCallback = callback
        this.scope = scope
        return this
    }

    fun show(player: EntityPlayerWrapper): Int {
        val p = player.getEntity().controller ?: return -1
        return showToPlayer(p)
    }

    fun showToPlayer(player: Player): Int {
        form.onResponse { button ->
            val cx = Context.enter()
            try {
                cx.optimizationLevel = -1
                val idx = form.elements.indexOf(button)
                buttonCallbacks[idx]?.let { callback ->
                    scope?.let { s ->
                        callback.call(cx, s, s, arrayOf(button.text, idx))
                    }
                }
                onResponseCallback?.let { callback ->
                    scope?.let { s ->
                        callback.call(cx, s, s, arrayOf(button.text, idx))
                    }
                }
            } finally {
                Context.exit()
            }
        }

        form.onClose(Consumer<FormCancelReason> { _ ->
            val cx = Context.enter()
            try {
                cx.optimizationLevel = -1
                onCloseCallback?.let { callback ->
                    scope?.let { s ->
                        callback.call(cx, s, s, arrayOf())
                    }
                }
            } finally {
                Context.exit()
            }
        })

        return player.viewForm(form)
    }
}