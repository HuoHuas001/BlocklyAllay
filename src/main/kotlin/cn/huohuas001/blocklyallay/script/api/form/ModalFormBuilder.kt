package cn.huohuas001.blocklyallay.script.api.form

import cn.huohuas001.blocklyallay.script.api.wrapper.EntityPlayerWrapper
import org.allaymc.api.form.FormCancelReason
import org.allaymc.api.form.Forms
import org.allaymc.api.form.type.ModalForm
import org.allaymc.api.player.Player
import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Value
import java.util.function.Consumer

/**
 * 模态表单构建器（确认/取消对话框）
 */
class ModalFormBuilder {
    private val form: ModalForm = Forms.modal()
    private var onTrueCallback: Value? = null
    private var onFalseCallback: Value? = null
    private var onCloseCallback: Value? = null
    private var context: Context? = null

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

    fun onTrue(callback: Value, ctx: Context): ModalFormBuilder {
        this.onTrueCallback = callback
        this.context = ctx
        return this
    }

    fun onFalse(callback: Value, ctx: Context): ModalFormBuilder {
        this.onFalseCallback = callback
        this.context = ctx
        return this
    }

    fun onClose(callback: Value, ctx: Context): ModalFormBuilder {
        this.onCloseCallback = callback
        this.context = ctx
        return this
    }

    fun show(player: EntityPlayerWrapper): Int {
        val p = player.getEntity().controller ?: return -1
        return showToPlayer(p)
    }

    fun showToPlayer(player: Player): Int {
        form.onTrue {
            onTrueCallback?.let { callback ->
                if (callback.canExecute()) {
                    try {
                        callback.execute()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }

        form.onFalse {
            onFalseCallback?.let { callback ->
                if (callback.canExecute()) {
                    try {
                        callback.execute()
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