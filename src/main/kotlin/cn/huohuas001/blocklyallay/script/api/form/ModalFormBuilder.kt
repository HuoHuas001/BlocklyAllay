package cn.huohuas001.blocklyallay.script.api.form

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.form.FormCancelReason
import org.allaymc.api.form.Forms
import org.allaymc.api.form.type.ModalForm
import org.allaymc.api.player.Player
import org.mozilla.javascript.Context
import org.mozilla.javascript.Function
import org.mozilla.javascript.Scriptable
import java.util.function.Consumer

/**
 * 模态表单构建器（确认/取消对话框）
 */
class ModalFormBuilder {
    private val form: ModalForm = Forms.modal()
    private var onTrueCallback: org.mozilla.javascript.Function? = null
    private var onFalseCallback: org.mozilla.javascript.Function? = null
    private var onCloseCallback: org.mozilla.javascript.Function? = null
    private var scope: Scriptable? = null

    fun title(title: String): ModalFormBuilder {
        form.title(title)
        return this
    }

    fun content(content: String): ModalFormBuilder {
        form.content(content)
        return this
    }

    fun trueButton(text: String): ModalFormBuilder {
        form.trueButton(text)
        return this
    }

    fun falseButton(text: String): ModalFormBuilder {
        form.falseButton(text)
        return this
    }

    fun onTrue(callback: org.mozilla.javascript.Function, scope: Scriptable): ModalFormBuilder {
        this.onTrueCallback = callback
        this.scope = scope
        return this
    }

    fun onFalse(callback: org.mozilla.javascript.Function, scope: Scriptable): ModalFormBuilder {
        this.onFalseCallback = callback
        this.scope = scope
        return this
    }

    fun onClose(callback: Function, scope: Scriptable): ModalFormBuilder {
        this.onCloseCallback = callback
        this.scope = scope
        return this
    }

    fun show(player: EntityPlayerWrapper): Int {
        val p = player.getEntity().controller ?: return -1
        return showToPlayer(p)
    }

    fun showToPlayer(player: Player): Int {
        form.onTrue {
            val cx = Context.enter()
            try {
                cx.optimizationLevel = -1
                onTrueCallback?.let { callback ->
                    scope?.let { s ->
                        callback.call(cx, s, s, arrayOf())
                    }
                }
            } finally {
                Context.exit()
            }
        }

        form.onFalse {
            val cx = Context.enter()
            try {
                cx.optimizationLevel = -1
                onFalseCallback?.let { callback ->
                    scope?.let { s ->
                        callback.call(cx, s, s, arrayOf())
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