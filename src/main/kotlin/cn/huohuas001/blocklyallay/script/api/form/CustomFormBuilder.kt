package cn.huohuas001.blocklyallay.script.api.form

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.form.FormCancelReason
import org.allaymc.api.form.Forms
import org.allaymc.api.form.type.CustomForm
import org.allaymc.api.player.Player
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value
import java.util.function.Consumer

/**
 * 自定义表单构建器（可包含多种输入控件）
 */
class CustomFormBuilder {
    private val form: CustomForm = Forms.custom()
    private var onResponseCallback: Value? = null
    private var onCloseCallback: Value? = null
    private var context: Context? = null

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

    fun onResponse(callback: Value, ctx: Context): CustomFormBuilder {
        this.onResponseCallback = callback
        this.context = ctx
        return this
    }

    fun onClose(callback: Value, ctx: Context): CustomFormBuilder {
        this.onCloseCallback = callback
        this.context = ctx
        return this
    }

    fun show(player: EntityPlayerWrapper): Int {
        val p = player.getEntity().controller ?: return -1
        return showToPlayer(p)
    }

    fun showToPlayer(player: Player): Int {
        form.onResponse { responses ->
            onResponseCallback?.let { callback ->
                if (callback.canExecute()) {
                    try {
                        callback.execute(responses.toTypedArray())
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