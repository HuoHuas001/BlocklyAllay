### refactor(script): 将JavaScript引擎从Mozilla Rhino替换为GraalJS
- 修改事件处理器、命令API和表单构建器适配新的JavaScript引擎
- 更新脚本管理器使用GraalJS上下文执行和管理脚本
- 优化脚本执行性能并简化API绑定过程

### feat(core): 添加插件注册API和国际化支持
- 实现插件注册API，允许脚本注册插件信息和获取专属Logger
- 添加国际化支持，将所有日志消息替换为翻译键
- 新增 http_get_with_headers 和 http_post_with_headers 区块
- 实现脚本重载功能和单个脚本管理方法
