# 事件API

事件API允许脚本响应游戏中的各种事件，如玩家加入、方块破坏、实体移动等。通过监听这些事件，脚本可以实现复杂的交互逻辑。

## 脚本生命周期事件

### onLoad()

当脚本加载时触发。

**示例：**
```javascript
function onLoad() {
    console.log("脚本已加载");
}
```

### onEnable()

当脚本启用时触发。

**示例：**
```javascript
function onEnable() {
    console.log("脚本已启用");
}
```

### onDisable()

当脚本禁用时触发。

**示例：**
```javascript
function onDisable() {
    console.log("脚本已禁用");
}
```

### onUnload()

当脚本卸载时触发。

**示例：**
```javascript
function onUnload() {
    console.log("脚本已卸载");
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
    // 可以修改消息内容或取消消息
}
```

### onPlayerCommand(player, command)

当玩家执行命令时触发。

**参数：**
- `player` - 玩家对象
- `command` - 命令内容（String）

**示例：**
```javascript
function onPlayerCommand(player, command) {
    console.log(player.getName() + " 执行了命令: " + command);
    // 可以修改命令或取消命令执行
}
```

### onPlayerMove(player)

当玩家移动时触发。

**参数：**
- `player` - 玩家对象

**示例：**
```javascript
function onPlayerMove(player) {
    var pos = player.getPosition();
    console.log(player.getName() + " 移动到了: " + pos.x + ", " + pos.y + ", " + pos.z);
}
```

## 事件处理

### event.cancel()

取消当前事件的默认行为（仅在可取消的事件中有效）。

**示例：**
```javascript
function onPlayerChat(player, message) {
    if (message.includes("敏感词")) {
        player.sendMessage("请不要使用敏感词!");
        event.cancel(); // 取消消息发送
    }
}
```

### allay.off(eventType)

取消监听指定事件类型。

**参数：**
- `eventType` - 事件类型字符串

**示例：**
```javascript
// 取消监听玩家加入事件
allay.off("player.join");
```

### allay.cleanup()

清理所有事件监听和定时任务。

**示例：**
```javascript
// 清理所有事件监听和定时任务
allay.cleanup();
```

## 事件类型参考

以下是所有可用事件类型的参考：

### 玩家事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| playerJoin | onPlayerJoin | 当玩家加入服务器时触发 |
| playerQuit | onPlayerQuit | 当玩家离开服务器时触发 |
| playerChat | onPlayerChat | 当玩家发送聊天消息时触发 |
| playerCommand | onPlayerCommand | 当玩家执行命令时触发 |
| playerMove | onPlayerMove | 当玩家移动时触发 |
| playerInteractBlock | onPlayerInteractBlock | 当玩家与方块交互时触发 |
| playerConnect | onPlayerConnect | 当玩家连接到服务器时触发 |
| playerDisconnect | onPlayerDisconnect | 当玩家断开连接时触发 |
| playerLogin | onPlayerLogin | 当玩家登录时触发 |
| playerKick | onPlayerKick | 当玩家被踢出时触发 |
| playerSpawn | onPlayerSpawn | 当玩家生成时触发 |
| playerDropItem | onPlayerDropItem | 当玩家丢出物品时触发 |
| playerBlockPick | onPlayerBlockPick | 当玩家捡起方块时触发 |
| playerBookEdit | onPlayerBookEdit | 当玩家编辑书时触发 |
| playerBucketEmpty | onPlayerBucketEmpty | 当玩家倒空水桶时触发 |
| playerBucketFill | onPlayerBucketFill | 当玩家装满水桶时触发 |
| playerChangeSkin | onPlayerChangeSkin | 当玩家改变皮肤时触发 |
| playerCraftItem | onPlayerCraftItem | 当玩家合成物品时触发 |
| playerEat | onPlayerEat | 当玩家吃东西时触发 |
| playerEnchantItem | onPlayerEnchantItem | 当玩家附魔物品时触发 |
| playerExperienceLevelChange | onPlayerExperienceLevelChange | 当玩家经验等级改变时触发 |
| playerFoodLevelChange | onPlayerFoodLevelChange | 当玩家饥饿值改变时触发 |
| playerInteractEntity | onPlayerInteractEntity | 当玩家与实体交互时触发 |
| playerItemHeld | onPlayerItemHeld | 当玩家切换手持物品时触发 |
| playerPunchAir | onPlayerPunchAir | 当玩家空手攻击时触发 |
| playerPunchBlock | onPlayerPunchBlock | 当玩家攻击方块时触发 |
| playerToggleCrawl | onPlayerToggleCrawl | 当玩家开始/停止爬行时触发 |
| playerToggleFlight | onPlayerToggleFlight | 当玩家开始/停止飞行时触发 |
| playerToggleGlide | onPlayerToggleGlide | 当玩家开始/停止滑翔时触发 |
| playerToggleSwim | onPlayerToggleSwim | 当玩家开始/停止游泳时触发 |
| playerUseItemInAir | onPlayerUseItemInAir | 当玩家在空中使用物品时触发 |

### 方块事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| blockBreak | onBlockBreak | 当方块被破坏时触发 |
| blockPlace | onBlockPlace | 当方块被放置时触发 |
| blockBurn | onBlockBurn | 当方块燃烧时触发 |
| blockExplode | onBlockExplode | 当方块爆炸时触发 |
| blockFade | onBlockFade | 当方块褪色时触发 |
| blockFall | onBlockFall | 当方块下落时触发 |
| blockGrow | onBlockGrow | 当方块生长时触发 |
| blockIgnite | onBlockIgnite | 当方块被点燃时触发 |
| blockNeighborUpdate | onBlockNeighborUpdate | 当方块邻居更新时触发 |
| blockRandomUpdate | onBlockRandomUpdate | 当方块随机更新时触发 |
| blockScheduleUpdate | onBlockScheduleUpdate | 当方块计划更新时触发 |
| blockSpread | onBlockSpread | 当方块蔓延时触发 |

### 实体事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| entityDamage | onEntityDamage | 当实体受到伤害时触发 |
| entityDie | onEntityDie | 当实体死亡时触发 |

### 物品与容器事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| itemFrameUse | onItemFrameUse | 当物品展示框被使用时触发 |
| containerOpen | onContainerOpen | 当容器被打开时触发 |
| containerClose | onContainerClose | 当容器被关闭时触发 |
| containerItemMove | onContainerItemMove | 当容器内物品移动时触发 |
| containerItemPickup | onContainerItemPickup | 当物品被放入容器时触发 |
| anvilTakeResult | onAnvilTakeResult | 当玩家从铁砧取出物品时触发 |
| anvilDamage | onAnvilDamage | 当铁砧受损时触发 |
| brewingStandBrew | onBrewingStandBrew | 当酿造台酿造完成时触发 |
| brewingStandConsumeFuel | onBrewingStandConsumeFuel | 当酿造台消耗燃料时触发 |
| brewingStandStartBrew | onBrewingStandStartBrew | 当酿造台开始酿造时触发 |
| campfireSmelt | onCampfireSmelt | 当营火熔炼完成时触发 |
| furnaceSmelt | onFurnaceSmelt | 当熔炉熔炼完成时触发 |
| furnaceConsumeFuel | onFurnaceConsumeFuel | 当熔炉消耗燃料时触发 |
| grindstoneTakeResult | onGrindstoneTakeResult | 当玩家从砂轮取出物品时触发 |

### 液体事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| liquidDecay | onLiquidDecay | 当液体衰减时触发 |
| liquidFlow | onLiquidFlow | 当液体流动时触发 |
| liquidHarden | onLiquidHarden | 当液体硬化时触发 |

### 服务器事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| serverStop | onServerStop | 当服务器停止时触发 |
| commandExecute | onCommandExecute | 当命令被执行时触发 |
| playerBan | onPlayerBan | 当玩家被封禁时触发 |
| playerUnban | onPlayerUnban | 当玩家被解封时触发 |
| ipBan | onIpBan | 当IP被封禁时触发 |
| ipUnban | onIpUnban | 当IP被解封时触发 |
| whitelistAddPlayer | onWhitelistAddPlayer | 当玩家被加入白名单时触发 |
| whitelistRemovePlayer | onWhitelistRemovePlayer | 当玩家被移出白名单时触发 |

### 其他事件

| 事件类型 | 对应的回调函数 | 描述 |
|---------|---------------|------|
| signTextChange | onSignTextChange | 当告示牌文字改变时触发 |
| signWax | onSignWax | 当告示牌被打蜡时触发 |

## 注意事项

1. 事件回调函数的名称必须与上述规定的名称完全匹配
2. 事件回调函数的参数顺序必须正确
3. 并非所有事件都可以取消，具体取决于事件类型
4. 复杂的事件处理逻辑可能会影响服务器性能，建议保持事件处理函数简洁高效
5. 在脚本卸载时，所有事件监听会自动清理，无需手动处理