# 服务器API

服务器API提供了管理和操作服务器的各种功能，包括获取服务器信息、执行命令等。

## 服务器信息

### allay.getServer()

获取服务器对象。

**返回值：**
- 服务器对象

**示例：**
```javascript
function onEnable() {
    var server = allay.getServer();
    console.log("服务器名称: " + server.getName());
}
```

### allay.getServer().getName()

获取服务器的名称。

**返回值：**
- 服务器名称字符串（String）

**示例：**
```javascript
function onLoad() {
    var serverName = allay.getServer().getName();
    console.log("服务器名称: " + serverName);
}
```

### allay.getServer().getOnlineCount()

获取当前在线的玩家数量。

**返回值：**
- 在线玩家数量（Number）

**示例：**
```javascript
function onPlayerJoin(player) {
    var onlineCount = allay.getServer().getOnlineCount();
    player.sendMessage("当前在线玩家数量: " + onlineCount);
}
```

### allay.getServer().getMaxPlayers()

获取服务器的最大玩家数。

**返回值：**
- 最大玩家数（Number）

**示例：**
```javascript
function onLoad() {
    var maxPlayers = allay.getServer().getMaxPlayers();
    console.log("服务器最大玩家数: " + maxPlayers);
}
```

### allay.getServer().getCurrentTick()

获取服务器当前的tick数。

**返回值：**
- 当前tick数（Number）

**示例：**
```javascript
function onEnable() {
    // 每20tick（1秒）执行一次
    allay.runRepeating(20, function() {
        var tick = allay.getServer().getCurrentTick();
        console.log("当前tick: " + tick);
    });
}
```

### allay.getServer().getVersion()

获取服务器的版本。

**返回值：**
- 服务器版本字符串（String）

**示例：**
```javascript
function onLoad() {
    var version = allay.getServer().getVersion();
    console.log("服务器版本: " + version);
}
```

## 服务器操作

### allay.getServer().broadcast(message)

向所有在线玩家广播消息。

**参数：**
- `message` - 要广播的消息（String）

**示例：**
```javascript
function onEnable() {
    allay.getServer().broadcast("服务器已启动!");
}
```

### allay.getServer().executeCommand(command)

执行服务器命令。

**参数：**
- `command` - 要执行的命令（String）

**返回值：**
- 命令执行结果（String）

**示例：**
```javascript
function onPlayerCommand(player, command) {
    if (command == "/restart") {
        var result = allay.getServer().executeCommand("save-all");
        player.sendMessage("执行命令结果: " + result);
        event.cancel();
    }
}
```

### allay.getServer().shutdown()

关闭服务器。

**示例：**
```javascript
function onServerStop() {
    allay.getServer().broadcast("服务器即将关闭!");
    allay.runLater(200, function() {
        allay.getServer().shutdown();
    });
}
```

## 示例：服务器监控系统

```javascript
// 服务器监控系统示例

function onLoad() {
    console.log("服务器监控系统已加载");
}

function onEnable() {
    console.log("服务器监控系统已启用");
    
    // 每5分钟（6000刻）检查一次服务器状态
    allay.runRepeating(6000, function() {
        checkServerStatus();
    });
}

function onDisable() {
    console.log("服务器监控系统已禁用");
    allay.cleanup();
}

function checkServerStatus() {
    var server = allay.getServer();
    var onlineCount = server.getOnlineCount();
    var maxPlayers = server.getMaxPlayers();
    var version = server.getVersion();
    var tick = server.getCurrentTick();
    
    console.log("=== 服务器状态报告 ===");
    console.log("时间: " + new Date().toLocaleString());
    console.log("在线玩家: " + onlineCount + "/" + maxPlayers);
    console.log("服务器版本: " + version);
    console.log("当前Tick: " + tick);
    console.log("======================");
    
    // 如果在线玩家数量为0，发送警告
    if (onlineCount === 0) {
        console.log("警告: 服务器当前没有在线玩家!");
    }
}
```

## 注意事项

1. 服务器API提供了强大的功能，请谨慎使用，避免对服务器造成不必要的负担
2. 执行命令时要注意权限问题，避免执行危险命令
3. 服务器关闭操作要谨慎使用，确保已经保存了所有数据