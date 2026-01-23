# BlocklyAllay 文档

BlocklyAllay 是一个基于 Blockly 的可视化编程工具，用于为 AllayMC 服务器编写脚本。

## 简介

BlocklyAllay 允许玩家和开发者使用可视化积木来创建复杂的服务器脚本，无需直接编写代码。同时，它也支持手写 JavaScript 脚本，提供了丰富的 API 供开发者使用。

## 功能特性

- 可视化积木编程界面
- 完整的 JavaScript API 支持
- 事件驱动的脚本系统
- 支持玩家交互、世界操作、实体管理等
- 表单系统、BossBar 系统
- 调度器支持
- 工具类（文件 I/O、HTTP 请求、JSON 处理等）

## 快速开始

### 可视化编程

1. 打开 BlocklyAllay 网页界面
2. 从左侧工具箱拖动积木到工作区
3. 连接积木构建逻辑
4. 点击 "运行" 按钮执行脚本
5. 点击 "导出" 按钮保存脚本

### 手写 JavaScript

1. 创建 `.js` 文件
2. 使用 BlocklyAllay 提供的 API 编写脚本
3. 将脚本放入服务器的 `scripts` 目录
4. 重启服务器或使用命令重载脚本

## 目录结构

```
BlocklyAllay/
├── BlocklyWeb/          # Web 界面相关文件
├── docs/                # 项目文档
├── src/                 # 源代码
├── README.md            # 项目说明
└── build.gradle         # 构建配置
```

## 核心概念

### 脚本生命周期

每个脚本都有以下生命周期事件：

- `onLoad()` - 脚本加载时触发
- `onEnable()` - 脚本启用时触发
- `onDisable()` - 脚本禁用时触发
- `onUnload()` - 脚本卸载时触发

### 事件系统

BlocklyAllay 使用事件驱动的脚本系统，当游戏中发生特定事件时，会调用相应的回调函数：

```javascript
// 玩家加入事件
function onPlayerJoin(player) {
    player.sendMessage("欢迎来到服务器!");
}

// 玩家聊天事件
function onPlayerChat(player, message) {
    console.log(player.getName() + ": " + message);
}
```

### API 命名规范

- 所有 API 都通过 `allay` 对象访问（除了标准 JavaScript 功能）
- 事件对象通过 `event` 关键字访问
- 函数名使用驼峰命名法（如 `runLater`、`sendMessage`）

## 示例脚本

```javascript
// 简单的欢迎消息脚本
function onLoad() {
    console.log("欢迎脚本已加载");
}

function onEnable() {
    console.log("欢迎脚本已启用");
}

function onDisable() {
    console.log("欢迎脚本已禁用");
}

function onUnload() {
    console.log("欢迎脚本已卸载");
}

function onPlayerJoin(player) {
    player.sendMessage("欢迎来到服务器!");
    
    // 延迟10秒发送欢迎消息
    allay.runLater(200, function() {
        player.sendMessage("希望你在服务器玩得愉快!");
    }, this);
}

function onPlayerQuit(player) {
    console.log(player.getName() + " 已离开服务器");
}

function onPlayerChat(player, message) {
    if (message === "/hello") {
        player.sendMessage("你好，" + player.getName() + "!");
        event.cancel();
    }
}
```

## 支持与反馈

- 报告问题：[GitHub Issues](https://github.com/huohuas001/BlocklyAllay/issues)
- 讨论交流：[Discord](https://discord.gg/your-discord-link)
- 文档：[https://badoc.txssb.cn](https://docs.blocklyallay.txssb.cn)
