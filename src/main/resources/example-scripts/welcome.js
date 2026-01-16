/**
 * 示例脚本: 欢迎插件
 * 演示如何使用BlocklyAllay的API
 *
 * 这个脚本会:
 * - 当玩家加入时发送欢迎消息
 * - 当玩家离开时广播离开消息
 * - 监听聊天并响应特定命令
 */

// 脚本加载时调用
function onLoad() {
    console.log("欢迎脚本已加载!");
}

// 脚本启用时调用
function onEnable() {
    console.log("欢迎脚本已启用!");

    // 注册玩家加入事件
    allay.on("playerJoin", function(player) {
        // 向加入的玩家发送欢迎消息
        player.sendMessage("欢迎来到服务器, " + player.getName() + "!");

        // 向所有玩家广播
        allay.broadcast(player.getName() + " 加入了游戏!");

        // 输出玩家位置到控制台
        console.log(player.getName() + " 在位置: " +
            player.getX() + ", " + player.getY() + ", " + player.getZ());
    });

    // 注册玩家离开事件
    allay.on("playerQuit", function(player) {
        allay.broadcast(player.getName() + " 离开了游戏!");
    });

    // 注册聊天事件
    allay.on("playerChat", function(event) {
        var player = event.getPlayer();
        var message = event.getMessage();

        console.log(player.getName() + ": " + message);

        // 简单的命令响应
        if (message == "!help") {
            player.sendMessage("可用命令:");
            player.sendMessage("  !help - 显示帮助");
            player.sendMessage("  !online - 显示在线玩家数");
            player.sendMessage("  !pos - 显示你的位置");
            event.cancel(); // 取消原消息广播
        }
        else if (message == "!online") {
            var server = allay.getServer();
            player.sendMessage("在线玩家: " + server.getOnlineCount() + "/" + server.getMaxPlayers());
            event.cancel();
        }
        else if (message === "!pos") {
            player.sendMessage("你的位置: " +
                player.getX().toFixed(2) + ", " +
                player.getY().toFixed(2) + ", " +
                player.getZ().toFixed(2));
            event.cancel();
        }
    });

    // 每分钟广播一次服务器信息(1200 ticks = 60秒)
    allay.runRepeating(function() {
        var server = allay.getServer();
        console.log("服务器状态 - Tick: " + server.getCurrentTick() +
            ", 在线: " + server.getOnlineCount());
    }, 1200);
}

// 脚本禁用时调用
function onDisable() {
    console.log("欢迎脚本已禁用!");
}

// 脚本卸载时调用
function onUnload() {
    console.log("欢迎脚本已卸载!");
}
