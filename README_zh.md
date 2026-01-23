# BlocklyAllay

基于 Blockly 的 Allay 服务器可视化脚本编辑器，让你无需编写复杂代码即可创建强大的游戏脚本！

## 📋 项目介绍

BlocklyAllay 是一个为 Allay 服务器设计的可视化脚本编辑插件，它将 Google 的 Blockly 可视化编程工具集成到 Allay 服务器中，让玩家和管理员可以通过拖拽积木块的方式创建游戏脚本，无需编写复杂的代码。

## ✨ 功能特性

### 🎮 可视化编程
- 基于 Blockly 的直观拖拽式编程界面
- 支持多种积木块类型：事件、玩家、世界、实体、物品等
- 实时生成 JavaScript 代码
- 支持代码复制和导出

### 🎯 丰富的 API
- **事件系统**：支持 60+ 种服务器事件监听
- **玩家管理**：获取玩家信息、发送消息、设置属性等
- **世界操作**：设置时间、广播消息、获取世界信息
- **实体管理**：获取实体信息、设置属性
- **物品系统**：获取物品信息、管理物品
- **表单系统**：创建简单表单、模态表单、自定义表单
- **BossBar**：创建和管理 Boss 血条
- **定时器**：支持延迟执行、重复执行等
- **工具函数**：日志记录、事件取消等

### 🔧 开发工具
- 内置 Web 编辑器，可直接在浏览器中编辑脚本
- 支持脚本的保存、加载和导出
- 实时代码生成和语法检查
- 支持多种脚本生命周期事件

## 📦 安装方法

### 前置条件
- Allay 服务器
- Java 17 或更高版本

### 安装步骤
1. 下载最新版本的 BlocklyAllay 插件 JAR 文件
2. 将 JAR 文件放入服务器的 `plugins/BlocklyAllay/scripts/` 目录
3. 启动服务器，插件会自动初始化
4. 访问 `https://blocklyallay.txssb.cn` 进入 Web 编辑器

## 🚀 使用说明

### 1. 访问 Web 编辑器
在浏览器中输入 `https://blocklyallay.txssb.cn` 访问 BlocklyAllay 编辑器。

### 2. 创建新脚本
- 点击顶部工具栏的 "新建" 按钮
- 从左侧工具箱拖拽积木块到工作区
- 连接积木块创建逻辑

### 3. 保存和导出脚本
- 点击 "保存" 按钮保存脚本到服务器
- 点击 "导出JS" 按钮导出脚本为 JavaScript 文件
- 点击 "加载" 按钮加载已保存的脚本

### 4. 查看生成的代码
- 点击右侧代码面板的切换按钮查看生成的 JavaScript 代码
- 点击 "复制代码" 按钮复制代码到剪贴板

## 📖 积木块分类

### 🎬 事件
- **服务器事件**：玩家连接、断开连接、登录等
- **玩家事件**：加入、离开、聊天、命令等
- **方块事件**：破坏、放置、燃烧、爆炸等
- **命令事件**：命令执行
- **容器事件**：打开、关闭、物品移动等
- **实体事件**：伤害、死亡、生成、移动等
- **计分板事件**：添加、移除、值变化等
- **世界事件**：区块加载、卸载、时间变化等
- **插件事件**：插件启用、禁用、脚本生命周期等

### 🧑 玩家
- 获取玩家信息：名称、显示名称、位置等
- 玩家操作：发送消息、传送、设置生命值等
- 玩家管理：获取在线玩家、根据名称获取玩家等

### 🌍 世界
- 世界信息：获取世界列表、根据名称获取世界
- 世界操作：设置时间、广播消息
- 服务器信息：在线玩家数量、最大玩家数、当前 tick

### 🧟 实体
- 实体信息：获取类型、位置、生命值
- 实体操作：设置生命值

### 🎒 物品
- 物品信息：获取类型、数量、名称

### 📋 表单
- 简单表单：添加按钮、标签、标题等
- 模态表单：确认对话框
- 自定义表单：输入框、开关、下拉菜单、滑块等

### 📊 BossBar
- 创建 BossBar：设置标题、进度、颜色
- BossBar 操作：显示、隐藏、获取信息

### ⏰ 定时器
- 延迟执行：延迟指定 tick 后执行
- 重复执行：每隔指定 tick 重复执行
- 延迟后重复执行：延迟指定 tick 后开始重复执行

### 🛠️ 工具
- 日志记录：打印不同级别日志
- 事件处理：取消事件、移除事件监听
- 资源清理：清理所有事件监听和定时器

## 📝 脚本示例

### 欢迎脚本
```javascript
function onEnable() {
    console.log("欢迎脚本已启用!");
}

function onDisable() {
    console.log("欢迎脚本已禁用!");
}

allay.on('playerJoin', function(player) {
    player.sendMessage("欢迎来到服务器!");
});
```

### 聊天过滤
```javascript
allay.on('playerChat', function(event) {
    var player = event.getPlayer();
    var message = event.getMessage();
    if (message.includes("badword")) {
        event.cancel();
        player.sendMessage("请文明发言!");
    }
});
```

### 定时任务
```javascript
function onEnable() {
    allay.runRepeating(200, function() {
        allay.broadcast("服务器运行正常!");
    }, this);
}
```

## 🔧 开发指南

### 项目结构
```
BlocklyAllay/
├── BlocklyWeb/          # Web 编辑器前端代码
│   ├── css/             # 样式文件
│   ├── js/              # JavaScript 代码
│   │   ├── blocks/      # 积木块定义
│   │   ├── generators/  # 代码生成器
│   │   ├── main.js      # 主程序
│   │   └── toolbox.js   # 工具箱配置
│   └── index.html       # 主页面
├── src/                 # 后端 Kotlin 代码
│   ├── main/            # 主源码
│   │   ├── kotlin/      # Kotlin 代码
│   │   └── resources/   # 资源文件
│   └── test/            # 测试代码
├── build.gradle.kts     # Gradle 配置
└── README.md            # 项目文档
```

### 编译项目
```bash
# 编译项目
./gradlew build

# 运行测试
./gradlew test

# 生成文档
./gradlew javadoc
```

### 添加新的积木块
1. 在 `BlocklyWeb/js/blocks/` 目录下创建新的积木块定义
2. 在 `BlocklyWeb/js/generators/` 目录下创建对应的代码生成器
3. 在 `BlocklyWeb/js/toolbox.js` 中添加到工具箱

## 🤝 贡献方式

欢迎参与 BlocklyAllay 的开发！

### 贡献步骤
1. Fork 本仓库
2. 创建新的分支 `git checkout -b feature/your-feature`
3. 提交你的更改 `git commit -m "Add your feature"`
4. 推送到分支 `git push origin feature/your-feature`
5. 创建 Pull Request

### 代码规范
- 遵循 Kotlin 代码规范
- 代码注释清晰
- 添加适当的测试
- 更新文档

## 📄 许可证

本项目采用 [GNU General Public License v3.0](LICENSE) 许可证。

## 📞 联系方式

- **作者**: HuoHuas001
- **GitHub**: https://github.com/HuoHuas001/BlocklyAllay
- **Issue 跟踪**: https://github.com/HuoHuas001/BlocklyAllay/issues

## 🙏 致谢

- [Allay 项目](https://allaymc.org/) - 基于 Minecraft Bedrock 协议的开源服务器
- [Blockly 项目](https://developers.google.com/blockly) - Google 开源的可视化编程工具
- [Cloudflare Pages](https://pages.cloudflare.com/) - Web 编辑器部署平台

---

**BlocklyAllay - 让 Allay 服务器编程更简单！** 🎉
