package cn.huohuas001.blocklyallay.script.api.form

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.form.FormCancelReason
import org.allaymc.api.form.Forms
import org.allaymc.api.form.type.CustomForm
import org.allaymc.api.player.Player
import org.mozilla.javascript.Context
import org.mozilla.javascript.Function
import org.mozilla.javascript.Scriptable
import java.util.function.Consumer

/**
 * 自定义表单构建器（可包含多种输入控件）
 */
class CustomFormBuilder {
    private val form: CustomForm = Forms.custom()
    private var onResponseCallback: org.mozilla.javascript.Function? = null
    private var onCloseCallback: org.mozilla.javascript.Function? = null
    private var scope: Scriptable? = null

    fun title(title: String): CustomFormBuilder {
        form.title(title)
        return this
    }

    fun pathIcon(path: String): CustomFormBuilder {
        form.pathIcon(path)
        return this
    }

    fun urlIcon(url: String): CustomFormBuilder {
        form.urlIcon(url)
        return this
    }

    fun label(text: String): CustomFormBuilder {
        form.label(text)
        return this
    }

    fun input(text: String): CustomFormBuilder {
        form.input(text)
        return this
    }

    fun input(text: String, placeholder: String): CustomFormBuilder {
        form.input(text, placeholder)
        return this
    }

    fun input(text: String, placeholder: String, defaultText: String): CustomFormBuilder {
        form.input(text, placeholder, defaultText)
        return this
    }

    fun dropdown(text: String, options: List<String>): CustomFormBuilder {
        form.dropdown(text, options)
        return this
    }

    fun dropdown(text: String, options: List<String>, defaultIndex: Int): CustomFormBuilder {
        form.dropdown(text, options, defaultIndex)
        return this
    }

    fun slider(text: String, min: Float, max: Float): CustomFormBuilder {
        form.slider(text, min, max)
        return this
    }

    fun slider(text: String, min: Float, max: Float, step: Int): CustomFormBuilder {
        form.slider(text, min, max, step)
        return this
    }

    fun slider(text: String, min: Float, max: Float, step: Int, defaultValue: Float): CustomFormBuilder {
        form.slider(text, min, max, step, defaultValue)
        return this
    }

    fun stepSlider(text: String, steps: List<String>): CustomFormBuilder {
        form.stepSlider(text, steps)
        return this
    }

    fun stepSlider(text: String, steps: List<String>, defaultStep: Int): CustomFormBuilder {
        form.stepSlider(text, steps, defaultStep)
        return this
    }

    fun toggle(text: String): CustomFormBuilder {
        form.toggle(text)
        return this
    }

    fun toggle(text: String, defaultValue: Boolean): CustomFormBuilder {
        form.toggle(text, defaultValue)
        return this
    }

    fun header(text: String): CustomFormBuilder {
        form.header(text)
        return this
    }

    fun divider(): CustomFormBuilder {
        form.divider()
        return this
    }

    fun onResponse(callback: org.mozilla.javascript.Function, scope: Scriptable): CustomFormBuilder {
        this.onResponseCallback = callback
        this.scope = scope
        return this
    }

    fun onClose(callback: Function, scope: Scriptable): CustomFormBuilder {
        this.onCloseCallback = callback
        this.scope = scope
        return this
    }

    fun show(player: EntityPlayerWrapper): Int {
        val p = player.getEntity().controller ?: return -1
        return showToPlayer(p)
    }

    fun showToPlayer(player: Player): Int {
        form.onResponse { responses ->
            val cx = Context.enter()
            try {
                cx.optimizationLevel = -1
                onResponseCallback?.let { callback ->
                    scope?.let { s ->
                        val jsArray = cx.newArray(s, responses.toTypedArray())
                        callback.call(cx, s, s, arrayOf(jsArray))
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