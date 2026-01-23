# 脚本示例

本页面提供了使用 BlocklyAllay 可以创建的脚本的实际示例。每个示例展示了 API 的不同方面，可以作为自己脚本的起点。

## 基础示例

### 欢迎消息

**描述**：玩家加入服务器时向他们发送欢迎消息。

```javascript
// 当玩家加入时
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    player.sendMessage("§a欢迎来到 BlocklyAllay 服务器！");
    player.sendMessage("§7输入 /help 查看命令列表。");
});
```

### 简单命令

**描述**：注册一个简单命令，向玩家发送消息。

```javascript
// 注册一个简单的 hello 命令
allay.getCommandAPI().registerCommand(
    "hello",
    "向服务器问好",
    "",
    (context) => {
        const sender = context.getSender();
        sender.sendMessage("你好！这是一个简单命令。");
    }
);
```

## 中级示例

### 传送命令

**描述**：创建一个命令，将玩家传送到坐标或其他玩家。

```javascript
allay.getCommandAPI().registerCommand(
    "tp",
    "传送命令",
    "blocklyallay.teleport",
    (context) => {
        const sender = context.getSender();
        const args = context.getArgs();

        if (!sender.isPlayer()) {
            sender.sendMessage("此命令只能由玩家使用。");
            return;
        }

        const player = sender.asPlayer();

        if (args.length === 1) {
            // 传送到另一个玩家
            const targetPlayer = allay.getPlayer(args[0]);
            if (targetPlayer) {
                player.teleport(targetPlayer.getX(), targetPlayer.getY(), targetPlayer.getZ());
                player.sendMessage(`已传送到 ${targetPlayer.getName()}`);
            } else {
                player.sendMessage(`未找到玩家 ${args[0]}。`);
            }
        } else if (args.length === 3) {
            // 传送到坐标
            const x = parseFloat(args[0]);
            const y = parseFloat(args[1]);
            const z = parseFloat(args[2]);

            player.teleport(x, y, z);
            player.sendMessage(`已传送到 ${x}, ${y}, ${z}`);
        } else {
            player.sendMessage("用法：/tp <玩家> 或 /tp <x> <y> <z>");
        }
    }
);
```

### Boss 血条计时器

**描述**：创建一个作为倒计时计时器的 Boss 血条。

```javascript
// 创建一个 Boss 血条计时器
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    const bossBar = allay.getBossBar().create("倒计时器");

    bossBar.setColor("blue");
    bossBar.setStyle("segmented_10");
    bossBar.setProgress(1.0);
    bossBar.show(player);

    let timeLeft = 10; // 10 秒

    const timer = allay.getScheduler().runRepeating(() => {
        timeLeft--;
        bossBar.setProgress(timeLeft / 10);
        bossBar.setTitle(`剩余时间：${timeLeft}秒`);

        if (timeLeft <= 0) {
            bossBar.hide(player);
            player.sendMessage("§c时间到！");
            timer.cancel();
        }
    }, 1000); // 每秒运行一次
});
```

### 简单表单

**描述**：创建一个简单表单，允许玩家从多个选项中进行选择。

```javascript
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();

    // 创建一个简单表单
    const form = allay.getForms().createSimpleForm();
    form.setTitle("欢迎菜单");
    form.setContent("请选择一个选项：");

    // 添加按钮
    form.addButton("获取信息", "textures/ui/info_icon.png");
    form.addButton("传送到出生点", "textures/ui/home_icon.png");
    form.addButton("领取奖励", "textures/ui/gift_icon.png");

    // 设置响应处理程序
    form.setHandler((player, response) => {
        if (response === -1) {
            return; // 表单已关闭
        }

        switch (response) {
            case 0:
                player.sendMessage("§a服务器信息：BlocklyAllay v1.0");
                player.sendMessage(`§7在线玩家：${allay.getOnlinePlayers().length}`);
                break;
            case 1:
                player.teleport(0, 64, 0);
                player.sendMessage("§a已传送到出生点！");
                break;
            case 2:
                player.sendMessage("§a奖励已领取！享受您的物品！");
                // 在此处添加奖励逻辑
                break;
        }
    });

    // 显示表单
    form.show(player);
});
```

## 高级示例

### 带输入的自定义表单

**描述**：创建一个收集玩家输入的自定义表单。

```javascript
allay.getCommandAPI().registerCommand(
    "customform",
    "显示自定义表单",
    "",
    (context) => {
        const sender = context.getSender();

        if (!sender.isPlayer()) {
            sender.sendMessage("此命令只能由玩家使用。");
            return;
        }

        const player = sender.asPlayer();

        // 创建一个自定义表单
        const form = allay.getForms().createCustomForm();
        form.setTitle("玩家资料");

        // 添加表单元素
        form.addInput("您的名字是什么？", player.getName());
        form.addToggle("您喜欢这个服务器吗？", true);
        form.addSlider("您玩了多少小时？", 0, 100, 1, 10);
        form.addDropdown("您最喜欢的游戏模式是什么？", ["生存", "创造", "冒险", "旁观"], 0);
        form.addInput("有什么反馈吗？", "");

        // 设置响应处理程序
        form.setHandler((player, response) => {
            if (!response) {
                return; // 表单已关闭
            }

            const name = response[0];
            const likesServer = response[1];
            const hours = response[2];
            const gameMode = response[3];
            const feedback = response[4];

            // 处理响应
            player.sendMessage("§a感谢您完成资料！");
            player.sendMessage(`§7姓名：${name}`);
            player.sendMessage(`§7喜欢服务器：${likesServer ? "是" : "否"}`);
            player.sendMessage(`§7游戏时长：${hours} 小时`);
            player.sendMessage(`§7最喜欢的游戏模式：${gameMode}`);

            if (feedback) {
                player.sendMessage(`§7反馈：${feedback}`);
                // 将反馈保存到文件
                allay.writeFile("feedback.txt", `[${new Date().toISOString()}] ${player.getName()}: ${feedback}\n`, true);
            }
        });

        // 显示表单
        form.show(player);
    }
);
```

### 基于事件的小游戏

**描述**：创建一个简单的基于事件的小游戏，玩家通过破坏方块获得积分。

```javascript
// 简单的方块破坏小游戏
const playerScores = new Map();

// 玩家加入时初始化分数
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    playerScores.set(player.getName(), 0);
    player.sendMessage("§a方块破坏小游戏已开始！");
    player.sendMessage("§7破坏方块以获得积分！");
});

// 跟踪方块破坏
allay.onBlockBreak((event) => {
    const player = event.getPlayer();
    const playerName = player.getName();

    if (playerScores.has(playerName)) {
        const currentScore = playerScores.get(playerName);
        const newScore = currentScore + 1;
        playerScores.set(playerName, newScore);

        // 用新分数更新玩家
        player.sendMessage(`§e分数：${newScore}`);

        // 在里程碑时给予奖励
        if (newScore % 10 === 0) {
            player.sendMessage(`§6达到里程碑！+${newScore/10} 奖励积分！`);
            playerScores.set(playerName, newScore + Math.floor(newScore/10));
        }
    }
});

// 显示排行榜命令
allay.getCommandAPI().registerCommand(
    "leaderboard",
    "显示方块破坏排行榜",
    "",
    (context) => {
        const sender = context.getSender();

        // 按分数对玩家进行排序
        const sortedPlayers = Array.from(playerScores.entries())
            .sort(([,a], [,b]) => b - a);

        sender.sendMessage("§6=== 方块破坏排行榜 ===");

        sortedPlayers.forEach(([name, score], index) => {
            sender.sendMessage(`${index + 1}. ${name}: §e${score} 分`);
        });

        sender.sendMessage("§6==============================");
    }
);
```

## 实用示例

### 文件 I/O 示例

**描述**：演示读取和写入文件。

```javascript
// 将数据写入文件
allay.writeFile("player_data.txt", "玩家数据存储\n", false);

// 当玩家加入时，将其信息追加到文件
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    const playerInfo = `${player.getName()},${player.getX()},${player.getY()},${player.getZ()},${new Date().toISOString()}\n`;

    allay.writeFile("player_data.txt", playerInfo, true);
});

// 读取玩家数据的命令
allay.getCommandAPI().registerCommand(
    "readdata",
    "从文件读取玩家数据",
    "blocklyallay.readdata",
    (context) => {
        const sender = context.getSender();

        try {
            const data = allay.readFile("player_data.txt");
            sender.sendMessage("§6玩家数据：");
            sender.sendMessage(data);
        } catch (error) {
            sender.sendMessage("§c读取文件错误：" + error.message);
        }
    }
);
```

### HTTP 请求示例

**描述**：向外部 API 发出 HTTP 请求。

```javascript
allay.getCommandAPI().registerCommand(
    "joke",
    "从 API 获取随机笑话",
    "",
    (context) => {
        const sender = context.getSender();

        // 向笑话 API 发出 HTTP 请求
        allay.httpRequest({
            url: "https://official-joke-api.appspot.com/random_joke",
            method: "GET",
            headers: { "Content-Type": "application/json" }
        }, (response) => {
            if (response.success) {
                const joke = JSON.parse(response.data);
                sender.sendMessage("§6" + joke.setup);
                sender.sendMessage("§e" + joke.punchline);
            } else {
                sender.sendMessage("§c获取笑话失败：" + response.status);
            }
        });
    }
);
```

## 最佳实践

创建脚本时，请考虑以下最佳实践：

1. **错误处理**：始终为脚本添加适当的错误处理
2. **权限**：在允许玩家使用命令之前检查权限
3. **性能**：避免在频繁调用的事件中进行昂贵的操作
4. **清理**：正确清理计时器和 Boss 血条等资源
5. **文档**：添加注释以解释复杂逻辑
6. **测试**：在部署之前彻底测试脚本

这些示例应该为您使用 BlocklyAllay 创建自己的脚本提供了一个很好的起点。记住要实验并结合不同的 API 功能来创建独特的游戏体验！