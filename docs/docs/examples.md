# Script Examples

This page provides practical examples of scripts you can create using BlocklyAllay. Each example demonstrates different aspects of the API and can be used as a starting point for your own scripts.

## Basic Examples

### Welcome Message

**Description**: Sends a welcome message to players when they join the server.

```javascript
// When a player joins
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    player.sendMessage("§aWelcome to the BlocklyAllay Server!");
    player.sendMessage("§7Type /help for a list of commands.");
});
```

### Simple Command

**Description**: Registers a simple command that sends a message to the player.

```javascript
// Register a simple hello command
allay.getCommandAPI().registerCommand(
    "hello",
    "Say hello to the server",
    "",
    (context) => {
        const sender = context.getSender();
        sender.sendMessage("Hello! This is a simple command.");
    }
);
```

## Intermediate Examples

### Teleport Command

**Description**: Creates a command that teleports a player to coordinates or another player.

```javascript
allay.getCommandAPI().registerCommand(
    "tp",
    "Teleport command",
    "blocklyallay.teleport",
    (context) => {
        const sender = context.getSender();
        const args = context.getArgs();
        
        if (!sender.isPlayer()) {
            sender.sendMessage("This command can only be used by players.");
            return;
        }
        
        const player = sender.asPlayer();
        
        if (args.length === 1) {
            // Teleport to another player
            const targetPlayer = allay.getPlayer(args[0]);
            if (targetPlayer) {
                player.teleport(targetPlayer.getX(), targetPlayer.getY(), targetPlayer.getZ());
                player.sendMessage(`Teleported to ${targetPlayer.getName()}`);
            } else {
                player.sendMessage(`Player ${args[0]} not found.`);
            }
        } else if (args.length === 3) {
            // Teleport to coordinates
            const x = parseFloat(args[0]);
            const y = parseFloat(args[1]);
            const z = parseFloat(args[2]);
            
            player.teleport(x, y, z);
            player.sendMessage(`Teleported to ${x}, ${y}, ${z}`);
        } else {
            player.sendMessage("Usage: /tp <player> OR /tp <x> <y> <z>");
        }
    }
);
```

### Boss Bar Timer

**Description**: Creates a boss bar that acts as a countdown timer.

```javascript
// Create a boss bar timer
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    const bossBar = allay.getBossBar().create("Countdown Timer");
    
    bossBar.setColor("blue");
    bossBar.setStyle("segmented_10");
    bossBar.setProgress(1.0);
    bossBar.show(player);
    
    let timeLeft = 10; // 10 seconds
    
    const timer = allay.getScheduler().runRepeating(() => {
        timeLeft--;
        bossBar.setProgress(timeLeft / 10);
        bossBar.setTitle(`Time Left: ${timeLeft}s`);
        
        if (timeLeft <= 0) {
            bossBar.hide(player);
            player.sendMessage("§cTime's up!");
            timer.cancel();
        }
    }, 1000); // Run every second
});
```

### Simple Form

**Description**: Creates a simple form that allows players to select from multiple options.

```javascript
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    
    // Create a simple form
    const form = allay.getForms().createSimpleForm();
    form.setTitle("Welcome Menu");
    form.setContent("Please select an option:");
    
    // Add buttons
    form.addButton("Get Info", "textures/ui/info_icon.png");
    form.addButton("Teleport to Spawn", "textures/ui/home_icon.png");
    form.addButton("Claim Reward", "textures/ui/gift_icon.png");
    
    // Set response handler
    form.setHandler((player, response) => {
        if (response === -1) {
            return; // Form was closed
        }
        
        switch (response) {
            case 0:
                player.sendMessage("§aServer Info: BlocklyAllay v1.0");
                player.sendMessage(`§7Players online: ${allay.getOnlinePlayers().length}`);
                break;
            case 1:
                player.teleport(0, 64, 0);
                player.sendMessage("§aTeleported to spawn!");
                break;
            case 2:
                player.sendMessage("§aReward claimed! Enjoy your items!");
                // Add reward logic here
                break;
        }
    });
    
    // Show the form
    form.show(player);
});
```

## Advanced Examples

### Custom Form with Input

**Description**: Creates a custom form that collects player input.

```javascript
allay.getCommandAPI().registerCommand(
    "customform",
    "Show a custom form",
    "",
    (context) => {
        const sender = context.getSender();
        
        if (!sender.isPlayer()) {
            sender.sendMessage("This command can only be used by players.");
            return;
        }
        
        const player = sender.asPlayer();
        
        // Create a custom form
        const form = allay.getForms().createCustomForm();
        form.setTitle("Player Profile");
        
        // Add form elements
        form.addInput("What's your name?", player.getName());
        form.addToggle("Do you like this server?", true);
        form.addSlider("How many hours have you played?", 0, 100, 1, 10);
        form.addDropdown("What's your favorite game mode?", ["Survival", "Creative", "Adventure", "Spectator"], 0);
        form.addInput("Any feedback?", "");
        
        // Set response handler
        form.setHandler((player, response) => {
            if (!response) {
                return; // Form was closed
            }
            
            const name = response[0];
            const likesServer = response[1];
            const hours = response[2];
            const gameMode = response[3];
            const feedback = response[4];
            
            // Process the responses
            player.sendMessage("§aThank you for completing the profile!");
            player.sendMessage(`§7Name: ${name}`);
            player.sendMessage(`§7Likes server: ${likesServer ? "Yes" : "No"}`);
            player.sendMessage(`§7Hours played: ${hours}`);
            player.sendMessage(`§7Favorite game mode: ${gameMode}`);
            
            if (feedback) {
                player.sendMessage(`§7Feedback: ${feedback}`);
                // Save feedback to file
                allay.writeFile("feedback.txt", `[${new Date().toISOString()}] ${player.getName()}: ${feedback}\n`, true);
            }
        });
        
        // Show the form
        form.show(player);
    }
);
```

### Event-Based Minigame

**Description**: Creates a simple event-based minigame where players earn points by breaking blocks.

```javascript
// Simple block breaking minigame
const playerScores = new Map();

// Initialize score when player joins
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    playerScores.set(player.getName(), 0);
    player.sendMessage("§aBlock Breaking Minigame Started!");
    player.sendMessage("§7Break blocks to earn points!");
});

// Track block breaks
allay.onBlockBreak((event) => {
    const player = event.getPlayer();
    const playerName = player.getName();
    
    if (playerScores.has(playerName)) {
        const currentScore = playerScores.get(playerName);
        const newScore = currentScore + 1;
        playerScores.set(playerName, newScore);
        
        // Update player with new score
        player.sendMessage(`§eScore: ${newScore}`);
        
        // Give reward at milestones
        if (newScore % 10 === 0) {
            player.sendMessage(`§6Milestone reached! +${newScore/10} bonus points!`);
            playerScores.set(playerName, newScore + Math.floor(newScore/10));
        }
    }
});

// Show leaderboard command
allay.getCommandAPI().registerCommand(
    "leaderboard",
    "Show block breaking leaderboard",
    "",
    (context) => {
        const sender = context.getSender();
        
        // Sort players by score
        const sortedPlayers = Array.from(playerScores.entries())
            .sort(([,a], [,b]) => b - a);
        
        sender.sendMessage("§6=== Block Breaking Leaderboard ===");
        
        sortedPlayers.forEach(([name, score], index) => {
            sender.sendMessage(`${index + 1}. ${name}: §e${score} points`);
        });
        
        sender.sendMessage("§6==============================");
    }
);
```

## Utility Examples

### File I/O Example

**Description**: Demonstrates reading from and writing to files.

```javascript
// Write data to a file
allay.writeFile("player_data.txt", "Player data storage\n", false);

// When a player joins, append their info to the file
allay.onPlayerJoin((event) => {
    const player = event.getPlayer();
    const playerInfo = `${player.getName()},${player.getX()},${player.getY()},${player.getZ()},${new Date().toISOString()}\n`;
    
    allay.writeFile("player_data.txt", playerInfo, true);
});

// Command to read the player data
allay.getCommandAPI().registerCommand(
    "readdata",
    "Read player data from file",
    "blocklyallay.readdata",
    (context) => {
        const sender = context.getSender();
        
        try {
            const data = allay.readFile("player_data.txt");
            sender.sendMessage("§6Player Data:");
            sender.sendMessage(data);
        } catch (error) {
            sender.sendMessage("§cError reading file: " + error.message);
        }
    }
);
```

### HTTP Request Example

**Description**: Makes an HTTP request to an external API.

```javascript
allay.getCommandAPI().registerCommand(
    "joke",
    "Get a random joke from an API",
    "",
    (context) => {
        const sender = context.getSender();
        
        // Make HTTP request to a joke API
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
                sender.sendMessage("§cFailed to get joke: " + response.status);
            }
        });
    }
);
```

## Best Practices

When creating scripts, consider the following best practices:

1. **Error Handling**: Always add proper error handling to your scripts
2. **Permissions**: Check permissions before allowing players to use commands
3. **Performance**: Avoid expensive operations in frequently called events
4. **Cleanup**: Properly cleanup resources like timers and boss bars
5. **Documentation**: Add comments to explain complex logic
6. **Testing**: Test your scripts thoroughly before deployment

These examples should give you a good starting point for creating your own scripts with BlocklyAllay. Remember to experiment and combine different API features to create unique gameplay experiences!
