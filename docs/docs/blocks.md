# Blockly Blocks

BlocklyAllay provides a variety of Blockly blocks that you can use to create scripts for your Minecraft-like server. These blocks are organized into categories based on their functionality.

## Block Categories

### Events

Events blocks allow you to respond to various server and player events:

- **Script Load**: Runs when the script is first loaded
- **Script Unload**: Runs when the script is unloaded
- **Player Join**: Runs when a player joins the server
- **Player Leave**: Runs when a player leaves the server
- **Player Chat**: Runs when a player sends a chat message
- **Player Interact**: Runs when a player interacts with the world

### Forms

Forms blocks allow you to create interactive forms for players:

- **Create Simple Form**: Creates a simple form with text and buttons
- **Create Modal Form**: Creates a yes/no confirmation dialog
- **Create Custom Form**: Creates a form with various input fields
- **Show Form to Player**: Displays a form to a specific player
- **Form Submit Handler**: Handles form submissions from players

### World

World blocks allow you to interact with the game world:

- **Get All Worlds**: Retrieves all available worlds on the server
- **Get World by Name**: Gets a specific world by its name
- **Get World Time**: Retrieves the current time of day in a world
- **Set World Time**: Changes the time of day in a world
- **Get World Weather**: Retrieves the current weather in a world
- **Set World Weather**: Changes the weather in a world

### Players

Players blocks allow you to interact with players on the server:

- **Get Online Players**: Retrieves all currently online players
- **Get Player by Name**: Gets a specific player by their username
- **Send Message to Player**: Sends a chat message to a player
- **Kick Player**: Removes a player from the server
- **Give Item to Player**: Gives an item to a player
- **Get Player Position**: Retrieves a player's current position
- **Teleport Player**: Moves a player to a specific location

### Scheduler

Scheduler blocks allow you to schedule tasks to run at specific times:

- **Run Later**: Runs a task once after a delay
- **Run Repeating**: Runs a task repeatedly with a fixed interval
- **Run Delayed Repeating**: Runs a task repeatedly after an initial delay

### BossBar

BossBar blocks allow you to create and manage boss bars:

- **Create BossBar**: Creates a new boss bar with a title
- **Set BossBar Title**: Changes the title of an existing boss bar
- **Set BossBar Progress**: Sets the progress of a boss bar (0.0-1.0)
- **Set BossBar Color**: Changes the color of a boss bar
- **Set BossBar Style**: Changes the style of a boss bar
- **Show BossBar to Player**: Displays a boss bar to a player
- **Hide BossBar from Player**: Hides a boss bar from a player

### Commands

Commands blocks allow you to register custom commands:

- **Register Simple Command**: Registers a basic command with a handler
- **Register Command with Aliases**: Registers a command with alternate names
- **Command Sender Check**: Checks if the command sender is a player or console
- **Send Message to Command Sender**: Sends a message to whoever ran the command

### Entities

Entities blocks allow you to interact with entities in the world:

- **Get Entity Type**: Retrieves the type of an entity
- **Get Entity Position**: Gets the coordinates of an entity
- **Get Entity Health**: Retrieves an entity's health
- **Set Entity Health**: Changes an entity's health

### Items

Items blocks allow you to interact with items:

- **Get Item Type**: Retrieves the type of an item
- **Get Item Count**: Gets the number of items in a stack
- **Get Item Custom Name**: Retrieves the custom name of an item

### Utils

Utils blocks provide various utility functions:

- **Log Message**: Writes a message to the server logs
- **Read File**: Reads content from a file
- **Write File**: Writes content to a file
- **HTTP Request**: Makes an HTTP request to a URL
- **Parse JSON**: Converts a JSON string to an object
- **Stringify JSON**: Converts an object to a JSON string

## Blockly Workspace

When you open BlocklyAllay, you'll see the Blockly workspace where you can drag and drop blocks to create scripts. The blocks are organized into categories in the toolbox on the left side of the screen.

To create a script:

1. Drag blocks from the toolbox onto the workspace
2. Connect blocks together to form a logical sequence
3. Configure block properties by clicking on them
4. Test your script by running it on the server

## Example Block Script

Here's a simple example of a Blockly script that sends a welcome message to players when they join:

```
when player joins
    get event player
    send message "Welcome to the server!" to player
```

This script uses the "Player Join" event block, the "Get Event Player" block, and the "Send Message to Player" block to create a simple welcome message system.

## Best Practices

- Keep your scripts organized by using comments and logical grouping
- Test your scripts thoroughly before deploying them to a production server
- Use descriptive variable names to make your scripts more readable
- Take advantage of events to create responsive gameplay experiences
- Use forms to create interactive interfaces for players
