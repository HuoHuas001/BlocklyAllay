# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

BlocklyAllay is a visual script editor plugin for the Allay Minecraft Bedrock server. It integrates Google's Blockly visual programming tool with Allay, allowing players and admins to create game scripts by dragging and dropping blocks without writing complex code.

The plugin uses GraalJS as a JavaScript engine to execute Blockly-generated scripts on the server.

## Build Commands

```bash
# Build the project (creates shadow JAR)
./gradlew build

# Run tests
./gradlew test

# Generate Javadoc
./gradlew javadoc

# On Windows, use gradlew.bat instead
gradlew.bat build
```

The built JAR is located at `build/libs/BlocklyAllay-<version>.jar`.

## Development Workflow

### Querying AllayMC API

When you need to query the AllayMC API (for commands, events, permissions, etc.), use the `allaymc-plugin-dev` skill:

```
Use the allaymc-plugin-dev skill to look up AllayMC API documentation and examples.
```

This skill provides access to:
- Official Java plugin template
- AllayMC API documentation
- Command registration tutorials
- Event listener tutorials
- Permission system tutorials
- And more AllayMC development resources

### Verification After Changes

**IMPORTANT**: After completing any code changes, always verify the build succeeds:
**IMPORTANT**: Please read the file again before modifying it.

```bash
# On Windows (use cmd)
./gradlew shadowJar

# Or on Linux/macOS
./gradlew shadowJar
```

This ensures there are no compilation errors before considering the task complete.

## Internationalization (i18n)

BlocklyAllay uses AllayMC's i18n system to support multiple languages. All user-facing messages and log messages should use translation keys instead of hardcoded strings.

### Translation Keys

All translation keys follow the format `blocklyallay:category.subcategory.key`:

- `blocklyallay:command.reload.success` - Command reload success message
- `blocklyallay:command.load.failed` - Command load failure message
- `blocklyallay:script.error.notfound` - Script not found error

### Translation Keys Constants

Use the `TrKeys` object for all translation keys to avoid typos and enable refactoring:

```kotlin
import cn.huohuas001.blocklyallay.TrKeys

// Good - use TrKeys constant
sender.sendTranslatable(TrKeys.COMMAND_RELOAD_SUCCESS, scriptName)

// Bad - hardcoded string
sender.sendTranslatable("blocklyallay:command.reload.success", scriptName)
```

### Language Files

Language files are located in `src/main/resources/assets/lang/`:

- `en_US.json` - English (fallback, required)
- `zh_CN.json` - Simplified Chinese

When adding new translation keys:
1. Add the key to `TrKeys.kt` as a constant
2. Add the English translation to `en_US.json`
3. Add the Chinese translation to `zh_CN.json`

### Sending Translatable Messages

```kotlin
import org.allaymc.api.command.CommandSender
import org.allaymc.api.message.I18n

// Send translatable message (auto-translates to player's language)
sender.sendTranslatable(TrKeys.COMMAND_LIST_HEADER, scriptCount)

// For log messages (server-side translation)
plugin.pluginLogger.info(I18n.get().tr(TrKeys.SCRIPT_LOADED, scriptName))

// With multiple parameters
sender.sendTranslatable(TrKeys.SCRIPT_ERROR, scriptName, errorMessage)
```

### Parameter Placeholders

Use ordered placeholders (`%1`, `%2`, etc.) for better cross-language support:

```json
{
  "blocklyallay:command.reload.success": "Reloaded script: %1",
  "blocklyallay:command.reload.all": "Reloaded %1 scripts"
}
```

### Available Translation Keys

#### Command Related
- `COMMAND_DESCRIPTION` - Main command description
- `COMMAND_RELOAD_DESCRIPTION`, `COMMAND_LOAD_DESCRIPTION`, `COMMAND_UNLOAD_DESCRIPTION`, `COMMAND_LIST_DESCRIPTION` - Subcommand descriptions
- `COMMAND_RELOAD_ALL`, `COMMAND_RELOAD_SUCCESS`, `COMMAND_RELOAD_FAILED` - Reload messages
- `COMMAND_LOAD_SUCCESS`, `COMMAND_LOAD_FAILED` - Load messages
- `COMMAND_UNLOAD_SUCCESS`, `COMMAND_UNLOAD_FAILED` - Unload messages
- `COMMAND_LIST_EMPTY`, `COMMAND_LIST_HEADER`, `COMMAND_LIST_ITEM` - List messages
- `COMMAND_HELP_HEADER`, `COMMAND_HELP_RELOAD`, `COMMAND_HELP_LOAD`, `COMMAND_HELP_UNLOAD`, `COMMAND_HELP_LIST` - Help messages
- `COMMAND_LOAD_USAGE`, `COMMAND_UNLOAD_USAGE` - Usage messages
- `COMMAND_UNKNOWN` - Unknown subcommand error

#### Script Related
- `SCRIPT_LOADED`, `SCRIPT_UNLOADED` - Script lifecycle messages
- `SCRIPT_DIR_CREATED` - Script directory creation message
- `SCRIPT_ERROR_NOTFOUND`, `SCRIPT_ERROR_NOTLOADED`, `SCRIPT_ERROR_LOAD`, `SCRIPT_ERROR_UNLOAD` - Script error messages
- `SCRIPT_ERROR_CLOSE` - Script context close error
- `SCRIPT_ERROR_FUNCTION_CALL` - Function call error message

## Architecture

### Core Components

**BlocklyAllay.kt** - Main plugin entry point extending Allay's `Plugin` class. Manages plugin lifecycle and delegates to `ScriptManager`.

**ScriptManager** - Manages JavaScript script loading, execution, and lifecycle. Uses GraalJS with shared `Engine` for better performance. Each script gets its own `Context` and `AllayScriptAPI` instance.

**AllayScriptAPI** - The main JavaScript API exposed to scripts. Provides access to:
- Server operations (`broadcast`, `getOnlinePlayers`, `getPlayer`)
- World operations (`getWorlds`, `getWorld`)
- Event system (`on(eventName, callback)`, `off(eventName)`) - callbacks are GraalJS `Value` objects
- Scheduler (`runLater(callback, delay)`, `runRepeating(callback, period)`, `runDelayedRepeating(callback, delay, period)`)
- Form API (`getForms`, `getFormAPI`)
- BossBar API (`getBossBar`, `getBossBarAPI`)
- Command API (`getCommandAPI`)
- File API (`getFiles`)
- HTTP API (`getHttp`, `getHttpAPI`)

### Event System

**EventListener** - Central event dispatcher registered with Allay's EventBus. Contains `@EventHandler` annotated methods for 60+ server events across categories:
- Server events (player connect/disconnect/login/kick/ban, server stop, whitelist)
- Player events (chat, command, move, interact, inventory, etc.)
- Block events (break, place, burn, explode, grow, etc.)
- Command events (execute)
- Container events (open, close, item move, furnace, brewing stand, etc.)
- Entity events (damage, die, spawn, move, etc.)
- Scoreboard events (add, remove, line changes)
- World events (chunk load/unload, time change, weather, etc.)
- Plugin events (enable/disable)

Each event handler calls `dispatchEvent()` which:
1. Looks up the registered JavaScript handler for the event name
2. Wraps event data via `EventData` classes
3. Executes the registered JavaScript callback (GraalJS handles Java object interop automatically)

### Event Data Wrappers

Each Allay event type has a corresponding `EventData` class that wraps the native Allay event object and exposes properties as getter methods. These are organized by category under `script/api/event/` (server, player, block, entity, container, scoreboard, world, plugin, command).

### Object Wrappers

Wrapper classes under `script/api/wrapper/` expose Allay server objects to JavaScript:
- `PlayerWrapper`, `EntityPlayerWrapper` - Player properties and actions
- `EntityWrapper` - Generic entity properties
- `ItemWrapper` - Item properties
- `WorldWrapper` - World information and dimensions
- `DimensionWrapper` - Dimension-specific operations
- `BossBarWrapper` - Boss bar management
- `CommandSenderWrapper` - Command sender operations

### Command System

**CommandAPI** - Allows JavaScript scripts to register custom commands. Supports:
- Simple commands with callback
- Commands with permissions
- Commands with aliases
- Full configuration via `CommandConfig` data class

Commands are registered via `Registries.COMMANDS.register()` and execute in a fresh Rhino context with access to the Allay API.

### Form System

**FormAPI** - Builder pattern API for creating UI forms:
- `SimpleFormBuilder` - Button-based menus
- `ModalFormBuilder` - Confirmation dialogs
- `CustomFormBuilder` - Forms with inputs, toggles, sliders, dropdowns

Located at `script/api/form/FormAPI.kt`.

### Web Editor

The `BlocklyWeb/` directory contains the frontend visual editor:
- `js/blocks/` - Block definitions (events, players, world, entities, items, commands, forms, bossbar, scheduler, utils)
- `js/generators/` - JavaScript code generators for each block type
- `js/toolbox.js` - Toolbox configuration organizing blocks into categories
- `index.html` - Main editor page

The web editor is deployed separately (https://blocklyallay.txssb.cn) and communicates with the plugin to save/load scripts.

## Script Lifecycle

Scripts are loaded from `plugins/BlocklyAllay/scripts/*.js` on server startup:

1. `onLoad()` - Called when script is first loaded
2. `onEnable()` - Called when plugin is enabled
3. `onDisable()` - Called when plugin is disabled
4. `onUnload()` - Called when script is unloaded

## Adding New Blocks

To add a new block type:

1. Create block definition in `BlocklyWeb/js/blocks/<category>.js`
2. Create corresponding generator in `BlocklyWeb/js/generators/<category>.js`
3. Add block to `toolbox.js` in the appropriate category

## Adding New Events

To add support for a new Allay event:

1. Create `EventData` wrapper class in `script/api/event/<category>/`
2. Add `@EventHandler` method to `EventListener.kt`
3. Create block definition and generator in `BlocklyWeb/js/blocks/events.js` and `generators/events.js`
4. Add to toolbox under the appropriate event category

## Dependencies

- **Allay API**: `org.allaymc:allay-api:0.22.0` (configured via AllayGradle plugin)
- **GraalJS**: `org.graalvm.polyglot:polyglot:25.0.2` and `org.graalvm.polyglot:js:25.0.2` - JavaScript engine
- **Java**: 21
- **Kotlin**: 2.1.0