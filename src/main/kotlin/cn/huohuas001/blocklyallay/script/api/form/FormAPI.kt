package cn.huohuas001.blocklyallay.script.api.form

/**
 * Form API for JavaScript scripts.
 * 表单API，暴露给JavaScript脚本使用。
 */
class FormAPI {

    /**
     * 创建简单表单构建器
     */
    fun createSimpleForm(): SimpleFormBuilder = SimpleFormBuilder()

    /**
     * 创建模态表单构建器
     */
    fun createModalForm(): ModalFormBuilder = ModalFormBuilder()

    /**
     * 创建自定义表单构建器
     */
    fun createCustomForm(): CustomFormBuilder = CustomFormBuilder()
}
