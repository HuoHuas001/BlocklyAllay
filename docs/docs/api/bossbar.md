# BossBar API

BossBar API 允许您创建和管理显示在玩家屏幕顶部的 boss 栏。

## 开始使用

要使用 BossBar API，您首先需要获取 BossBar 管理器：

```javascript
const bossBarManager = allay.getBossBar();
```

## BossBar 方法

### 创建 BossBar

```javascript
bossBarManager.create(title)
```

**参数：**
- `title` (string): 显示在 boss 栏上的标题文本

**返回值：**
- 一个可操作的 BossBar 对象

**示例：**
```javascript
const myBossBar = allay.getBossBar().create("Boss Battle!");
```

### BossBar 属性

#### 标题

```javascript
// 设置标题
bossBar.setTitle(title)

// 获取标题
bossBar.getTitle()
```

**参数：**
- `title` (string): 新的标题文本

**返回值：**
- (string): 当前标题文本

#### 进度

```javascript
// 设置进度 (0.0 到 1.0)
bossBar.setProgress(progress)

// 获取进度
bossBar.getProgress()
```

**参数：**
- `progress` (number): 进度值，范围在 0.0（空）到 1.0（满）之间

**返回值：**
- (number): 当前进度值

#### 颜色

```javascript
// 设置颜色
bossBar.setColor(color)

// 获取颜色
bossBar.getColor()
```

**参数：**
- `color` (string): 颜色名称 ("blue", "green", "pink", "purple", "red", "white", "yellow")

**返回值：**
- (string): 当前颜色

#### 样式

```javascript
// 设置样式
bossBar.setStyle(style)

// 获取样式
bossBar.getStyle()
```

**参数：**
- `style` (string): 样式名称 ("solid", "segmented_6", "segmented_10", "segmented_12", "segmented_20")

**返回值：**
- (string): 当前样式

#### 变暗天空

```javascript
// 设置变暗天空效果
bossBar.setDarkenSky(darken)

// 检查是否启用变暗天空
bossBar.isDarkenSky()
```

**参数：**
- `darken` (boolean): 是否变暗天空

**返回值：**
- (boolean): 是否启用变暗天空

### 玩家管理

```javascript
// 向玩家显示 boss 栏
bossBar.show(player)

// 向玩家隐藏 boss 栏
bossBar.hide(player)

// 移除所有观察者
bossBar.removeAllViewers()

// 获取观察者数量
bossBar.getViewerCount()
```

**参数：**
- `player` (Player): 要显示/隐藏 boss 栏的玩家

**返回值：**
- (number): 使用 getViewerCount() 时返回观察者数量

## 示例用法

```javascript
// 创建一个 boss 栏
const bossBar = allay.getBossBar().create("Epic Battle");

// 设置 boss 栏属性
bossBar.setProgress(0.5);
bossBar.setColor("red");
bossBar.setStyle("segmented_10");
bossBar.setDarkenSky(true);

// 获取在线玩家
const players = allay.getOnlinePlayers();

// 向所有在线玩家显示 boss 栏
players.forEach(player => {
    bossBar.show(player);
});

// 一段时间后更新 boss 栏
allay.getScheduler().runLater(() => {
    bossBar.setProgress(0.75);
    bossBar.setTitle("Almost Done!");
}, 5000);
```
