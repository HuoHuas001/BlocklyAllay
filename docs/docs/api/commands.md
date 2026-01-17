# 命令 API

命令 API 允许您为 BlocklyAllay 脚本注册和管理自定义命令。

## 开始使用

要使用命令 API，您首先需要获取命令 API 管理器：

```javascript
const commandAPI = allay.getCommandAPI();
```

## 命令注册

### 注册简单命令

```javascript
commandAPI.registerCommand(name, description, handler)
```

**参数：**
- `name` (string): 命令名称（不带斜杠）
- `description` (string): 命令描述
- `handler` (function): 命令执行时调用的处理函数

**示例：**
```javascript
allay.getCommandAPI().registerCommand(
    "hello",
    "向玩家问好",
    (context) => {
        const sender = context.getSender();
        sender.sendMessage("你好！欢迎使用 BlocklyAllay！");
    }
);
```

### 注册带别名的命令

```javascript
commandAPI.registerCommand(name, description, aliases, handler)
```

**参数：**
- `name` (string): 命令主名称
- `description` (string): 命令描述
- `aliases` (array): 命令别名数组
- `handler` (function): 命令执行时调用的处理函数

**示例：**
```javascript
allay.getCommandAPI().registerCommand(
    "info",
    "显示服务器信息",
    ["serverinfo", "about"],
    (context) => {
        const sender = context.getSender();
        sender.sendMessage("BlocklyAllay 服务器 v1.0");
    }
);
```

### 注销命令

```javascript
commandAPI.unregisterAll()
```

**描述：**
- 注销所有由命令 API 注册的命令

**示例：**
```javascript
allay.getCommandAPI().unregisterAll();
```

## 命令上下文

当命令执行时，处理函数会接收一个 `context` 对象，该对象具有以下方法：

### 获取命令发送者

```javascript
context.getSender()
```

**返回值：**
- 一个 CommandSender 对象，表示执行命令的实体

### 获取命令名称

```javascript
context.getCommandName()
```

**返回值：**
- (string): 执行的命令名称

### 获取命令参数

```javascript
// 获取所有参数
context.getArgs()

// 获取指定索引的参数
context.getArg(index)
```

**参数：**
- `index` (number): 要获取的参数索引（从 0 开始）

**返回值：**
- (array): 使用 getArgs() 时返回所有参数的字符串数组
- (string): 使用 getArg() 时返回指定索引的参数

## CommandSender 方法

### 发送消息

```javascript
commandSender.sendMessage(message)
```

**参数：**
- `message` (string): 要发送给命令发送者的消息

### 检查权限

```javascript
commandSender.hasPermission(permission)
```

**参数：**
- `permission` (string): 要检查的权限

**返回值：**
- (boolean): 发送者是否具有指定权限

### 检查发送者类型

```javascript
// 检查发送者是否为玩家
commandSender.isPlayer()

// 检查发送者是否为控制台
commandSender.isConsole()
```

**返回值：**
- (boolean): 如果发送者匹配类型则为 true，否则为 false

### 转换为玩家

```javascript
commandSender.asPlayer()
```

**返回值：**
- 如果发送者是玩家，则返回 Player 对象；否则返回 null

## 示例用法

```javascript
// 注册带参数的命令
allay.getCommandAPI().registerCommand(
    "giveitem",
    "给玩家物品",
    (context) => {
        const sender = context.getSender();
        const args = context.getArgs();
        
        if (args.length < 2) {
            sender.sendMessage("用法: /giveitem <玩家名> <物品类型>");
            return;
        }
        
        const playerName = args[0];
        const itemType = args[1];
        const player = allay.getPlayer(playerName);
        
        if (player) {
            // 给物品逻辑在这里实现
            player.sendMessage(`你收到了 ${itemType}！`);
            sender.sendMessage(`已给 ${playerName} 物品 ${itemType}`);
        } else {
            sender.sendMessage(`玩家 ${playerName} 未找到`);
        }
    }
);
```
