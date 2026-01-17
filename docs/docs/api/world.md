# 世界 API

世界 API 提供了管理和操作游戏世界的各种功能，包括获取世界信息、设置时间、广播消息等。

## 服务器信息

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

获取服务器当前的 tick 数。

**返回值：**

- 当前 tick 数（Number）

**示例：**

```javascript
function onEnable() {
  // 每20tick（1秒）执行一次
  allay.runRepeating(20, function () {
    var tick = allay.getServer().getCurrentTick();
    console.log("当前tick: " + tick);
  });
}
```

## 世界管理

### allay.getWorlds()

获取服务器上所有世界的列表。

**返回值：**

- 世界对象数组（Array）

**示例：**

```javascript
function onLoad() {
  var worlds = allay.getWorlds();
  console.log("服务器上的世界数量: " + worlds.length);
  worlds.forEach(function (world) {
    console.log("世界名称: " + world.getName());
  });
}
```

### allay.getWorld(name)

根据世界名称获取世界对象。

**参数：**

- `name` - 世界名称（String）

**返回值：**

- 世界对象，如果世界不存在则返回 null

**示例：**

```javascript
function onEnable() {
  var mainWorld = allay.getWorld("world");
  if (mainWorld) {
    console.log("主世界时间: " + mainWorld.getTimeOfDay());
  } else {
    console.log("主世界不存在!");
  }
}
```

### world.getName()

获取世界的名称。

**返回值：**

- 世界名称（String）

**示例：**

```javascript
function onWorldLoad(world) {
  console.log("世界 " + world.getName() + " 已加载");
}
```

### world.getTimeOfDay()

获取世界的时间。

**返回值：**

- 世界时间（Number），范围：0-24000

**示例：**

```javascript
function onEnable() {
  var worlds = allay.getWorlds();
  worlds.forEach(function (world) {
    var time = world.getTimeOfDay();
    console.log(world.getName() + " 的时间: " + time);
  });
}
```

### world.setTimeOfDay(time)

设置世界的时间。

**参数：**

- `time` - 时间值（Number），范围：0-24000

\*\*时间值说明
：**
- 0 - 日出
- 6000 - 中午
- 12000 - 日落
- 18000 - 午夜

**示例：**
```javascript
function onPlayerCommand(player, command) {
    if (command === "/setday") {
        var world = player.getWorld();
        world.setTimeOfDay(6000); // 设置为中午
        allay.broadcast("时间已设置为白天!");
        event.cancel();
    } else if (command === "/setnight") {
        var world = player.getWorld();
        world.setTimeOfDay(18000); // 设置为午夜
        allay.broadcast("时间已设置为夜晚!");
        event.cancel();
    }
}
```

## 消息广播

### allay.broadcast(message)

向所有在线玩家广播消息。

**参数：**
- `message` - 要广播的消息（String）

**示例：**
```javascript
function onServerStop() {
    allay.broadcast("服务器即将停止，请做好准备!");
    // 延迟10秒后关闭服务器
    allay.runLater(200, function() {
        allay.broadcast("服务器正在关闭...")
    });
}
```

## 示例：世界时间管理系统

```javascript
// 世界时间管理系统示例

var timeSettings = {
    dayStart: 0,
    dayEnd: 12000,
    nightStart: 12000,
    nightEnd: 24000
};

function onLoad() {
    console.log("世界时间管理系统已加载");
}

function onEnable() {
    console.log("世界时间管理系统已启用");
    
    // 每100tick（5秒）检查一次时间
    allay.runRepeating(100, function() {
        checkWorldTimes();
    });
}

function onDisable() {
    console.log("世界时间管理系统已禁用");
    allay.cleanup();
}

function checkWorldTimes() {
    var worlds = allay.getWorlds();
    worlds.forEach(function(world) {
        var time = world.getTimeOfDay();
        var worldName = world.getName();
        
        if (time >= timeSettings.dayStart && time < timeSettings.dayEnd) {
            console.log(worldName + " 现在是白天");
            // 可以在这里添加白天的特殊效果
        } else {
            console.log(worldName + " 现在是夜晚");
            // 可以在这里添加夜晚的特殊效果
        }
    });
}
```

## 注意事项

1. 不同世界的时间是独立的，可以分别设置
2. 时间值范围为0-24000，超过范围会自动循环
3. 世界对象在世界卸载后会失效，注意检查世界是否存在
4. 广播消息会发送给所有在线玩家，包括控制台
5. 使用`getWorld(name)`获取世界时，建议检查返回值是否为null
6. 世界相关操作可能会影响服务器性能，避免频繁执行复杂的世界操作