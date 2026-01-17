# 调度器API

调度器API允许脚本在指定时间后执行代码，或者定期重复执行代码，是实现延迟操作和定时任务的重要工具。

## 基本概念

- **刻（Tick）**：游戏中的时间单位，1秒等于20刻
- **延迟执行**：在指定刻数后执行一次代码
- **重复执行**：每隔指定刻数重复执行代码
- **延迟重复执行**：在延迟指定刻数后，开始重复执行代码

## 调度器方法

调度器API通过 `allay` 对象提供。

### allay.runLater(delay, callback, thisArg)

延迟指定刻数后执行一次回调函数。

**参数：**
- `delay` - 延迟的刻数（Number），20刻=1秒
- `callback` - 延迟后要执行的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**示例：**
```javascript
function onPlayerJoin(player) {
    player.sendMessage("欢迎来到服务器!");
    
    // 延迟10秒（200刻）后发送欢迎消息
    allay.runLater(200, function() {
        player.sendMessage("希望你在服务器玩得愉快!");
    }, this);
}
```

### allay.runRepeating(period, callback, thisArg)

每隔指定刻数重复执行回调函数。

**参数：**
- `period` - 重复执行的间隔刻数（Number），20刻=1秒
- `callback` - 每隔指定刻数要执行的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**示例：**
```javascript
function onEnable() {
    console.log("服务器监控已启动");
    
    // 每分钟（1200刻）检查一次在线玩家数量
    allay.runRepeating(1200, function() {
        var onlineCount = getOnlinePlayerCount();
        var maxPlayers = getMaxPlayers();
        console.log("当前在线人数: " + onlineCount + "/" + maxPlayers);
    }, this);
}
```

### allay.runDelayedRepeating(delay, period, callback, thisArg)

延迟指定刻数后，每隔指定刻数重复执行回调函数。

**参数：**
- `delay` - 初始延迟的刻数（Number）
- `period` - 重复执行的间隔刻数（Number）
- `callback` - 要执行的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**示例：**
```javascript
function onEnable() {
    console.log("自动保存系统已启动");
    
    // 延迟10秒（200刻）后开始自动保存，然后每隔30秒（600刻）保存一次
    allay.runDelayedRepeating(200, 600, function() {
        console.log("开始自动保存数据...");
        // 这里可以添加保存数据的逻辑
        console.log("自动保存完成!");
    }, this);
}
```

### allay.cleanup()

清理所有事件监听和定时任务，包括所有调度器任务。

**示例：**
```javascript
function onDisable() {
    console.log("清理所有任务");
    allay.cleanup(); // 清理所有事件监听和定时任务
}
```

## 示例：自动广播系统

```javascript
function onEnable() {
    console.log("自动广播系统已启动");
    
    // 广播消息列表
    var messages = [
        "欢迎来到服务器！",
        "请遵守服务器规则。",
        "如有问题，请联系管理员。",
        "享受游戏时光！"
    ];
    
    var messageIndex = 0;
    
    // 每隔5分钟（6000刻）广播一条消息
    allay.runRepeating(6000, function() {
        var message = messages[messageIndex];
        broadcast(message); // 假设broadcast是一个广播函数
        console.log("广播消息: " + message);
        
        messageIndex = (messageIndex + 1) % messages.length;
    }, this);
}

function onDisable() {
    console.log("自动广播系统已禁用");
    allay.cleanup();
}
```

## 示例：倒计时系统

```javascript
function startCountdown(player, seconds, message) {
    var remaining = seconds;
    
    // 发送初始消息
    player.sendMessage(message);
    player.sendMessage("倒计时开始: " + remaining + "秒");
    
    // 每秒更新一次倒计时
    var countdownTask = allay.runRepeating(20, function() {
        remaining--;
        
        if (remaining > 0) {
            player.sendMessage("倒计时: " + remaining + "秒");
        } else {
            player.sendMessage("倒计时结束!");
            // 这里可以添加倒计时结束后的逻辑
            
            // 清理所有任务
            allay.cleanup();
        }
    }, this);
}

// 使用示例
function onPlayerCommand(player, command) {
    if (command === "/countdown") {
        startCountdown(player, 10, "准备开始活动!");
    }
}
```

## 注意事项

1. 调度器任务会在脚本禁用或卸载时自动清理，无需手动处理
2. 使用 `allay.cleanup()` 函数可以手动清理所有调度器任务和事件监听
3. 避免设置过小的延迟或间隔，这可能会影响服务器性能
4. 长时间运行的回调函数会阻塞服务器主线程，建议保持回调函数简洁高效
5. 调度器任务的执行时间可能会因为服务器负载而略有延迟
6. 重复执行的任务会一直运行，直到脚本被禁用或卸载，或者手动清理
7. 回调函数中的 `this` 值默认是全局对象，如需指定 `this` 值，可以使用 `thisArg` 参数
