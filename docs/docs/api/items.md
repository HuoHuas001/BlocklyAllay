# 物品 API

物品 API 允许您与游戏中的物品交互，包括获取物品信息和操作物品。

## 物品方法

### 获取物品信息

#### 类型

```javascript
item.getType()
```

**返回值：**
- (string): 物品类型（例如："minecraft:diamond_sword", "minecraft:apple"）

**示例：**
```javascript
// 假设 'item' 是一个物品对象
const itemType = item.getType();
allay.log(`物品类型: ${itemType}`);
```

#### 数量

```javascript
item.getCount()
```

**返回值：**
- (number): 堆叠中的物品数量

**示例：**
```javascript
const count = item.getCount();
allay.log(`物品数量: ${count}`);
```

#### 自定义名称

```javascript
item.getCustomName()
```

**返回值：**
- (string): 物品的自定义名称，如果没有设置自定义名称则返回空字符串

**示例：**
```javascript
const customName = item.getCustomName();
if (customName) {
    allay.log(`物品名称: ${customName}`);
} else {
    allay.log("物品没有自定义名称");
}
```

## 示例用法

```javascript
// 示例：获取玩家手持物品的信息
allay.onPlayerInteract((event) => {
    const player = event.getPlayer();
    const heldItem = player.getHeldItem();
    
    if (heldItem) {
        const type = heldItem.getType();
        const count = heldItem.getCount();
        const name = heldItem.getCustomName();
        
        player.sendMessage(`你手持的是: ${type}`);
        player.sendMessage(`数量: ${count}`);
        if (name) {
            player.sendMessage(`自定义名称: ${name}`);
        }
    } else {
        player.sendMessage("你没有手持任何物品");
    }
});
```

## 注意事项

- 物品对象通常从玩家物品栏、掉落物品或合成事件中获取
- 可用的 API 方法可能因物品类型而异
- 可堆叠物品的 getCount() 返回值会大于 1
