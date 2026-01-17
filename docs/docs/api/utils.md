# 工具 API

工具 API 提供了各种实用功能，包括日志记录、事件处理、调度器、文件操作、HTTP 请求、JSON 处理和对象操作等。

## 日志记录

BlocklyAllay 使用标准的 JavaScript `console` 对象进行日志记录。

### console.log(message)

在控制台打印日志消息。

**参数：**

- `message` - 要打印的消息（任意类型）

**示例：**

```javascript
console.log("这是一条日志消息");
console.log(123);
console.log({ key: "value" });
```

### console.info(message)

在控制台打印信息消息。

**参数：**

- `message` - 要打印的消息（任意类型）

**示例：**

```javascript
console.info("这是一条信息消息");
```

### console.warn(message)

在控制台打印警告消息。

**参数：**

- `message` - 要打印的消息（任意类型）

**示例：**

```javascript
console.warn("这是一条警告消息");
```

### console.error(message)

在控制台打印错误消息。

**参数：**

- `message` - 要打印的消息（任意类型）

**示例：**

```javascript
console.error("这是一条错误消息");
```

### console.debug(message)

在控制台打印调试消息。

**参数：**

- `message` - 要打印的消息（任意类型）

**示例：**

```javascript
console.debug("这是一条调试消息");
```

## 事件处理

事件处理 API 通过 `allay` 对象实现。

### event.cancel()

取消当前事件（仅在可取消的事件中有效）。

**示例：**

```javascript
function onPlayerChat(player, message) {
  if (message.includes("敏感词")) {
    player.sendMessage("请不要使用敏感词!");
    event.cancel(); // 取消聊天消息发送
  }
}
```

### allay.off(eventType)

取消监听指定事件。

**参数：**

- `eventType` - 事件类型字符串

**示例：**

```javascript
allay.off("player.join"); // 取消监听玩家加入事件
```

### allay.cleanup()

清理所有事件监听和定时任务。

**示例：**

```javascript
allay.cleanup(); // 清理所有事件监听和定时任务
```

## 调度器

调度器 API 通过 `allay` 对象实现。

### allay.runLater(delay, callback, thisArg)

在指定 tick 数后执行一次回调函数。

**参数：**

- `delay` - 延迟的 tick 数（Number）
- `callback` - 要执行的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**示例：**

```javascript
allay.runLater(
  20,
  function () {
    console.log("1秒后执行");
  },
  this
);
```

### allay.runRepeating(period, callback, thisArg)

每隔指定 tick 数重复执行回调函数。

**参数：**

- `period` - 重复执行的间隔 tick 数（Number）
- `callback` - 要执行的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**示例：**

```javascript
allay.runRepeating(
  20,
  function () {
    console.log("每秒执行一次");
  },
  this
);
```

### allay.runDelayedRepeating(delay, period, callback, thisArg)

在延迟后每隔指定 tick 数重复执行回调函数。

**参数：**

- `delay` - 初始延迟的 tick 数（Number）
- `period` - 重复执行的间隔 tick 数（Number）
- `callback` - 要执行的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**示例：**

```javascript
allay.runDelayedRepeating(
  40,
  20,
  function () {
    console.log("2秒后开始，每秒执行一次");
  },
  this
);
```

## 文件操作

文件操作 API 通过 `allay.getFiles()` 对象实现。

### allay.getFiles().readFile(path)

读取文件内容。

**参数：**

- `path` - 文件路径（String）

**返回值：**

- 文件内容字符串，或 null（如果读取失败）

**示例：**

```javascript
var content = allay.getFiles().readFile("config.json");
if (content) {
  console.log("文件内容：" + content);
}
```

### allay.getFiles().writeFile(path, content, overwrite)

写入内容到文件。

**参数：**

- `path` - 文件路径（String）
- `content` - 要写入的内容（String）
- `overwrite` - 是否覆盖现有文件（Boolean，默认为 true）

**返回值：**

- 是否写入成功（Boolean）

**示例：**

```javascript
allay.getFiles().writeFile("test.txt", "Hello World", true);
```

### allay.getFiles().fileExists(path)

检查文件是否存在。

**参数：**

- `path` - 文件路径（String）

**返回值：**

- 文件是否存在（Boolean）

**示例：**

```javascript
if (allay.getFiles().fileExists("config.json")) {
    console.log("配置文件存在");
} else {
    console.log("配置文件不存在");
}
```

### allay.getFiles().deleteFile(path)

删除指定文件。

**参数：**
- `path` - 文件路径（String）

**示例：**
```javascript
allay.getFiles().deleteFile("temp.txt");
```

### allay.getFiles().listFiles(path)

列出目录中的文件。

**参数：**
- `path` - 目录路径（String）

**返回值：**
- 文件列表数组（Array）

**示例：**
```javascript
var files = allay.getFiles().listFiles(".");
files.forEach(function(file) {
    console.log("文件：" + file);
});
```

## HTTP请求

HTTP请求API通过 `allay.getHttp()` 对象实现。

### allay.getHttp().get(url)

发送HTTP GET请求。

**参数：**
- `url` - 请求URL（String）

**返回值：**
- 响应内容字符串，或null（如果请求失败）

**示例：**
```javascript
var response = allay.getHttp().get("https://api.example.com/data");
if (response) {
    console.log("GET响应：" + response);
}
```

### allay.getHttp().post(url, body, contentType)

发送HTTP POST请求。

**参数：**
- `url` - 请求URL（String）
- `body` - 请求正文（String）
- `contentType` - 请求内容类型（String，默认："application/json"）

**返回值：**
- 响应内容字符串，或null（如果请求失败）

**示例：**
```javascript
var response = allay.getHttp().post(
    "https://api.example.com/data", 
    JSON.stringify({key: "value"}), 
    "application/json"
);
if (response) {
    console.log("POST响应：" + response);
}
```

## JSON处理

JSON处理API使用标准的JavaScript `JSON` 对象。

### JSON.parse(text)

将JSON字符串转换为JavaScript对象。

**参数：**
- `text` - JSON字符串（String）

**返回值：**
- 解析后的JavaScript对象

**示例：**
```javascript
var jsonStr = '{"name": "测试", "value": 123}';
var obj = JSON.parse(jsonStr);
console.log(obj.name); // 输出：测试
```

### JSON.stringify(value)

将JavaScript对象转换为JSON字符串。

**参数：**
- `value` - 要转换的JavaScript对象

**返回值：**
- JSON字符串

**示例：**
```javascript
var obj = {name: "测试", value: 123};
var jsonStr = JSON.stringify(obj);
console.log(jsonStr); // 输出：{"name":"测试","value":123}
```

## 对象操作

对象操作使用JavaScript原生语法。

### 创建对象

创建一个新的空对象。

**示例：**
```javascript
var obj = {};
var objWithProps = {name: "测试", value: 123};
```

### 获取对象属性

获取对象的属性值。

**示例：**
```javascript
var obj = {name: "测试"};
var name = obj.name; // 或 obj["name"]
console.log(name); // 输出：测试
```

### 设置对象属性

设置对象的属性值。

**示例：**
```javascript
var obj = {};
obj.name = "测试"; // 或 obj["name"] = "测试"
```

### 检查对象属性

检查对象是否包含指定属性。

**示例：**
```javascript
var obj = {name: "测试"};
if ("name" in obj) {
    console.log("对象包含name属性");
}
```

### 删除对象属性

删除对象的指定属性。

**示例：**
```javascript
var obj = {name: "测试"};
delete obj.name;
```