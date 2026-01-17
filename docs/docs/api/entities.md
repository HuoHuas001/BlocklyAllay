# 实体 API

实体 API 允许您与世界中的各种实体交互，包括玩家、生物和其他游戏对象。

## 实体方法

### 获取实体信息

#### 类型

```javascript
entity.getType()
```

**返回值：**
- (string): 实体类型（例如："player", "zombie", "creeper"）

**示例：**
```javascript
// 假设 'entity' 是一个实体对象
const entityType = entity.getType();
allay.log(entityType); // 输出: "zombie"
```

#### 位置

```javascript
// 获取 X 坐标
entity.getX()

// 获取 Y 坐标  
entity.getY()

// 获取 Z 坐标
entity.getZ()
```

**返回值：**
- (number): 相应的坐标值

**示例：**
```javascript
const x = entity.getX();
const y = entity.getY();
const z = entity.getZ();
allay.log(`实体位置: ${x}, ${y}, ${z}`);
```

#### 生命值

```javascript
// 获取生命值
entity.getHealth()

// 设置生命值
entity.setHealth(health)
```

**参数：**
- `health` (number): 要设置的新生命值

**返回值：**
- (number): 使用 getHealth() 时返回当前生命值

**示例：**
```javascript
// 获取当前生命值
const currentHealth = entity.getHealth();
allay.log(`当前生命值: ${currentHealth}`);

// 设置生命值为满
entity.setHealth(20);
```

## 示例用法

```javascript
// 获取玩家实体（玩家也是实体）
const player = allay.getPlayer("Steve");

if (player) {
    // 获取玩家实体信息
    const type = player.getType();
    const health = player.getHealth();
    const x = player.getX();
    const y = player.getY();
    const z = player.getZ();
    
    allay.log(`玩家 ${player.getName()} 是一个 ${type}，生命值为 ${health}，位置在 ${x}, ${y}, ${z}`);
    
    // 如果生命值低，治疗玩家
    if (health < 10) {
        player.setHealth(20);
        allay.log("玩家已治疗!");
    }
}
```

## 注意事项

- 玩家是一种特殊的实体，因此所有实体方法也适用于玩家
- 可用的 API 方法可能因实体类型而异
- 实体对象通常从事件或其他 API 方法中获取
