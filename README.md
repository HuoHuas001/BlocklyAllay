# BlocklyAllay

English | [简体中文](README_zh.md)

A visual script editor plugin for Allay servers based on Blockly, allowing you to create powerful game scripts without writing complex code!

## 📋 Project Introduction

BlocklyAllay is a visual script editor plugin designed for Allay servers. It integrates Google's Blockly visual programming tool into the Allay server, allowing players and administrators to create game scripts by dragging and dropping blocks without writing complex code.

## ✨ Features

### 🎮 Visual Programming
- Intuitive drag-and-drop programming interface based on Blockly
- Supports multiple block types: events, players, world, entities, items, etc.
- Real-time JavaScript code generation
- Supports code copying and exporting

### 🎯 Rich API
- **Event System**: Supports 60+ server event listeners
- **Player Management**: Get player info, send messages, set properties, etc.
- **World Operations**: Set time, broadcast messages, get world info
- **Entity Management**: Get entity info, set properties
- **Item System**: Get item info, manage items
- **Form System**: Create simple forms, modal forms, custom forms
- **BossBar**: Create and manage boss bars
- **Scheduler**: Supports delayed execution, repeating execution, etc.
- **Utility Functions**: Logging, event cancellation, etc.

### 🔧 Development Tools
- Built-in Web editor for editing scripts directly in the browser
- Supports script saving, loading, and exporting
- Real-time code generation and syntax checking
- Supports multiple script lifecycle events

## 📦 Installation

### Prerequisites
- Allay Server
- Java 17 or higher

### Installation Steps
1. Download the latest version of the BlocklyAllay plugin JAR file
2. Place the JAR file in the server's `plugins/BlocklyAllay/scripts/` directory
3. Start the server, the plugin will initialize automatically
4. Visit `https://blocklyallay.txssb.cn` to access the Web editor

## 🚀 Usage

### 1. Access the Web Editor
Enter `https://blocklyallay.txssb.cn` in your browser to access the BlocklyAllay editor.

### 2. Create a New Script
- Click the "New" button in the top toolbar
- Drag blocks from the left toolbox to the workspace
- Connect blocks to create logic

### 3. Save and Export Scripts
- Click the "Save" button to save the script to the server
- Click the "Export JS" button to export the script as a JavaScript file
- Click the "Load" button to load a saved script

### 4. View Generated Code
- Click the toggle button on the right code panel to view the generated JavaScript code
- Click the "Copy Code" button to copy the code to clipboard

## 📖 Block Categories

### 🎬 Events
- **Server Events**: Player connect, disconnect, login, etc.
- **Player Events**: Join, leave, chat, command, etc.
- **Block Events**: Break, place, burn, explode, etc.
- **Command Events**: Command execution
- **Container Events**: Open, close, item move, etc.
- **Entity Events**: Damage, death, spawn, move, etc.
- **Scoreboard Events**: Add, remove, value change, etc.
- **World Events**: Chunk load/unload, time change, etc.
- **Plugin Events**: Plugin enable/disable, script lifecycle, etc.

### 🧑 Players
- Get Player Info: Name, display name, location, etc.
- Player Operations: Send message, teleport, set health, etc.
- Player Management: Get online players, get player by name, etc.

### 🌍 World
- World Info: Get world list, get world by name
- World Operations: Set time, broadcast message
- Server Info: Online player count, max players, current tick

### 🧟 Entities
- Entity Info: Get type, location, health
- Entity Operations: Set health

### 🎒 Items
- Item Info: Get type, count, name

### 📋 Forms
- Simple Forms: Add buttons, labels, titles, etc.
- Modal Forms: Confirmation dialogs
- Custom Forms: Input fields, toggles, dropdowns, sliders, etc.

### 📊 BossBar
- Create BossBar: Set title, progress, color
- BossBar Operations: Show, hide, get info

### ⏰ Scheduler
- Delayed Execution: Execute after specified ticks
- Repeating Execution: Repeat every specified ticks
- Delayed Repeating: Start repeating after specified ticks

### 🛠️ Utilities
- Logging: Print logs at different levels
- Event Handling: Cancel events, remove event listeners
- Resource Cleanup: Clean up all event listeners and timers

## 📝 Script Examples

### Welcome Script
```javascript
function onEnable() {
    console.log("Welcome script enabled!");
}

function onDisable() {
    console.log("Welcome script disabled!");
}

allay.on('playerJoin', function(player) {
    player.sendMessage("Welcome to the server!");
});
```

### Chat Filter
```javascript
allay.on('playerChat', function(event) {
    var player = event.getPlayer();
    var message = event.getMessage();
    if (message.includes("badword")) {
        event.cancel();
        player.sendMessage("Please speak politely!");
    }
});
```

### Scheduled Task
```javascript
function onEnable() {
    allay.runRepeating(200, function() {
        allay.broadcast("Server is running normally!");
    }, this);
}
```

## 🔧 Development Guide

### Project Structure
```
BlocklyAllay/
├── BlocklyWeb/          # Web editor frontend code
│   ├── css/             # Style files
│   ├── js/              # JavaScript code
│   │   ├── blocks/      # Block definitions
│   │   ├── generators/  # Code generators
│   │   ├── main.js      # Main program
│   │   └── toolbox.js   # Toolbox configuration
│   └── index.html       # Main page
├── src/                 # Backend Kotlin code
│   ├── main/            # Main source
│   │   ├── kotlin/      # Kotlin code
│   │   └── resources/   # Resource files
│   └── test/            # Test code
├── build.gradle.kts     # Gradle configuration
└── README.md            # Project documentation
```

### Building the Project
```bash
# Build the project
./gradlew build

# Run tests
./gradlew test

# Generate documentation
./gradlew javadoc
```

### Adding New Blocks
1. Create new block definitions in the `BlocklyWeb/js/blocks/` directory
2. Create corresponding code generators in the `BlocklyWeb/js/generators/` directory
3. Add to the toolbox in `BlocklyWeb/js/toolbox.js`

## 🤝 Contributing

Welcome to contribute to BlocklyAllay!

### Contribution Steps
1. Fork this repository
2. Create a new branch `git checkout -b feature/your-feature`
3. Commit your changes `git commit -m "Add your feature"`
4. Push to the branch `git push origin feature/your-feature`
5. Create a Pull Request

### Code Standards
- Follow Kotlin code standards
- Clear code comments
- Add appropriate tests
- Update documentation

## 📄 License

This project is licensed under the [GNU General Public License v3.0](LICENSE).

## 📞 Contact

- **Author**: HuoHuas001
- **GitHub**: https://github.com/HuoHuas001/BlocklyAllay
- **Issue Tracker**: https://github.com/HuoHuas001/BlocklyAllay/issues

## 🙏 Acknowledgments

- [Allay Project](https://allaymc.org/) - Open source server based on Minecraft Bedrock protocol
- [Blockly Project](https://developers.google.com/blockly) - Google's open source visual programming tool
- [Cloudflare Pages](https://pages.cloudflare.com/) - Web editor deployment platform

---

**BlocklyAllay - Making Allay server programming easier!** 🎉