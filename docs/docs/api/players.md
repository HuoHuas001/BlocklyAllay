# 玩家API

玩家API提供了管理和操作玩家的各种功能，包括获取玩家信息、发送消息、传送玩家等。

## 获取玩家信息

### player.getName()

获取玩家的名称。

**返回值：**
- 玩家名称字符串（String）

**示例：**
```javascript
function onPlayerJoin(player) {
    var name = player.getName();
    console.log("玩家名称: " + name);
}
```

### player.getDisplayName()

获取玩家的显示名称。

**返回值：**
- 玩家显示名称字符串（String）

**示例：**
```javascript
function onPlayerJoin(player) {
    var displayName = player.getDisplayName();
    console.log("玩家显示名称: " + displayName);
}
```

### player.getHealth()

获取玩家的当前生命值。

**返回值：**
- 玩家生命值（Number）

**示例：**
```javascript
function onPlayerJoin(player) {
    var health = player.getHealth();
    player.sendMessage("你的当前生命值: " + health);
}
```

### player.getPosition()

获取玩家的当前位置。

**返回值：**
- 包含x、y、z坐标的位置对象

**示例：**
```javascript
function onPlayerMove(player) {
    var pos = player.getPosition();
    console.log(player.getName() + " 的位置: " + pos.x + ", " + pos.y + ", " + pos.z);
}
```

## 玩家交互

### player.sendMessage(message)

向玩家发送消息。

**参数：**
- `message` - 要发送的消息（String）

**示例：**
```javascript
function onPlayerJoin(player) {
    player.sendMessage("欢迎来到服务器!");
    player.sendMessage("这是第二条消息");
}
```

### player.kick(reason)

将玩家踢出服务器。

**参数：**
- `reason` - 踢出原因（String）

**示例：**
```javascript
function onPlayerChat(player, message) {
    if (message.includes("作弊")) {
        player.kick("禁止作弊!");
    }
}
```

## 玩家管理

### allay.getOnlinePlayers()

获取服务器上所有在线玩家的列表。

**返回值：**
- 在线玩家对象数组（Array）

**示例：**
```javascript
function broadcastMessage(message) {
    var onlinePlayers = allay.getOnlinePlayers();
    onlinePlayers.forEach(function(player) {
        player.sendMessage(message);
    });
    console.log("向 " + onlinePlayers.length + " 名玩家发送了广播消息");
}
```

### allay.getPlayer(name)

根据名称获取玩家对象。

**参数：**
- `name` - 玩家名称（String）

**返回值：**
- 玩家对象，如果玩家不在线则返回null

**示例：**
```javascript
function onPlayerCommand(player, command) {
    if (command.startsWith("/tpall")) {
        // 获取命令中指定的玩家名称
        var targetName = command.split(" ")[1];
        var targetPlayer = allay.getPlayer(targetName);
        
        if (targetPlayer) {
            var pos = targetPlayer.getPosition();
            // 传送所有玩家到目标玩家位置
            var onlinePlayers = allay.getOnlinePlayers();
            onlinePlayers.forEach(function(p) {
                p.teleport(pos.x, pos.y, pos.z);
                p.sendMessage("你已被传送到 " + targetName + " 位置!");
            });
        } else {
            player.sendMessage("玩家 " + targetName + " 不在线!");
        }
    }
}
```

## 玩家事件

### onPlayerJoin(player)

当玩家加入服务器时触发。

**参数：**
- `player` - 玩家对象

**示例：**
```javascript
function onPlayerJoin(player) {
    player.sendMessage("欢迎来到服务器!");
    console.log(player.getName() + " 已加入服务器");
}
```

### onPlayerQuit(player)

当玩家离开服务器时触发。

**参数：**
- `player` - 玩家对象

**示例：**
```javascript
function onPlayerQuit(player) {
    console.log(player.getName() + " 已离开服务器");
}
```

### onPlayerChat(player, message)

当玩家发送聊天消息时触发。

**参数：**
- `player` - 玩家对象
- `message` - 聊天消息内容（String）

**示例：**
```javascript
function onPlayerChat(player, message) {
    console.log(player.getName() + ": " + message);
}
```

## 示例：玩家管理系统

```javascript
// 玩家管理系统示例

var playerData = {};

function onLoad() {
    console.log("玩家管理系统已加载");
}

function onEnable() {
    console.log("玩家管理系统已启用");
    
    // 每分钟检查一次玩家数据
    allay.runRepeating(1200, function() {
        savePlayerData();
    }, this);
}

function onDisable() {
    console.log("玩家管理系统已禁用");
    savePlayerData();
    allay.cleanup();
}

function onPlayerJoin(player) {
    var name = player.getName();
    
    // 初始化玩家数据
    if (!playerData[name]) {
        playerData[name] = {
            joinCount: 0,
            totalPlayTime: 0,
            lastJoinTime: Date.now()
        };
    }
    
    playerData[name].joinCount++;
    playerData[name].lastJoinTime = Date.now();
    
    player.sendMessage("欢迎回来，" + player.getDisplayName() + "!");
    player.sendMessage("这是你第 " + playerData[name].joinCount + " 次加入服务器");
    
    console.log(name + " 已加入服务器，总加入次数: " + playerData[name].joinCount);
}

function onPlayerQuit(player) {
    var name = player.getName();
    
    if (playerData[name]) {
        // 计算本次游戏时间
        var playTime = Date.now() - playerData[name].lastJoinTime;
        playerData[name].totalPlayTime += playTime;
        
        console.log(name + " 已离开服务器，本次游戏时间: " + Math.round(playTime / 1000) + " 秒");
        console.log(name + " 总游戏时间: " + Math.round(playerData[name].totalPlayTime / 1000) + " 秒");
    }
}

function savePlayerData() {
    var data = JSON.stringify(playerData, null, 2);
    allay.getFiles().writeFile("player_data.json", data, true);
    console.log("玩家数据已保存");
}
```

## 注意事项

1. 玩家对象在玩家离线后会失效，不要长期存储玩家对象引用
2. 在处理大量玩家时，注意性能问题，避免在循环中执行复杂操作
3. 向玩家发送消息时，注意消息内容的格式和长度
4. 使用`getPlayer(name)`获取玩家时，需要检查返回值是否为null
5. 玩家的位置坐标是相对于世界的，不同世界的坐标不兼容