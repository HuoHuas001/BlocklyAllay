# 表单API

表单API允许脚本创建和显示各种类型的表单，用于与玩家进行交互，收集玩家输入或显示选项。

## 表单类型

BlocklyAllay支持三种类型的表单：

1. **SimpleForm** - 简单表单，用于显示文本和按钮选项
2. **ModalForm** - 模态表单，用于显示确认对话框（确定/取消）
3. **CustomForm** - 自定义表单，用于收集玩家输入（输入框、开关、滑块等）

## 表单API基础

### allay.getForms()

获取表单管理器对象。

**返回值：**
- 表单管理器对象

**示例：**
```javascript
function onEnable() {
    var forms = allay.getForms();
    console.log("表单管理器已获取");
}
```

## SimpleForm（简单表单）

SimpleForm用于显示文本内容和多个按钮选项，适合用于菜单系统。

### allay.getForms().createSimpleForm()

创建一个新的简单表单。

**返回值：**
- 简单表单对象

**示例：**
```javascript
var form = allay.getForms().createSimpleForm();
```

### form.title(title)

设置表单的标题。

**参数：**
- `title` - 表单标题（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("主菜单");
```

### form.content(content)

设置表单的内容文本。

**参数：**
- `content` - 表单内容（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("主菜单")
    .content("请选择一个选项：");
```

### form.button(text)

添加一个按钮。

**参数：**
- `text` - 按钮文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("主菜单")
    .content("请选择一个选项：")
    .button("查看信息")
    .button("领取奖励")
    .button("退出");
```

### form.buttonWithPathImage(text, path)

添加一个带本地图片的按钮。

**参数：**
- `text` - 按钮文本（String）
- `path` - 图片路径（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("物品商店")
    .content("请选择要购买的物品：")
    .buttonWithPathImage("钻石剑", "textures/items/diamond_sword")
    .buttonWithPathImage("钻石镐", "textures/items/diamond_pickaxe");
```

### form.buttonWithUrlImage(text, url)

添加一个带URL图片的按钮。

**参数：**
- `text` - 按钮文本（String）
- `url` - 图片URL（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("图片示例")
    .content("请选择一个图片：")
    .buttonWithUrlImage("图片1", "https://example.com/image1.png")
    .buttonWithUrlImage("图片2", "https://example.com/image2.png");
```

### form.label(text)

添加一个标签文本。

**参数：**
- `text` - 标签文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("信息表单")
    .label("这是一个标签")
    .content("表单内容");
```

### form.header(text)

添加一个标题文本。

**参数：**
- `text` - 标题文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("标题示例")
    .header("这是一个标题")
    .content("表单内容");
```

### form.divider()

添加一个分隔线。

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("分隔线示例")
    .content("上方内容")
    .divider()
    .content("下方内容");
```

### form.onResponse(callback, thisArg)

设置表单响应回调函数。

**参数：**
- `callback` - 按钮点击时的回调函数，接收两个参数：按钮文本（String）和按钮索引（Number）
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("主菜单")
    .content("请选择一个选项：")
    .button("查看信息")
    .button("领取奖励")
    .button("退出")
    .onResponse(function(buttonText, buttonIndex) {
        console.log("按钮文本: " + buttonText);
        console.log("按钮索引: " + buttonIndex);
        switch(buttonIndex) {
            case 0:
                player.sendMessage("查看信息");
                break;
            case 1:
                player.sendMessage("领取奖励");
                break;
            case 2:
                player.sendMessage("退出菜单");
                break;
        }
    }, this);
```

### form.onClose(callback, thisArg)

设置表单关闭时的回调函数。

**参数：**
- `callback` - 表单关闭时的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("测试表单")
    .content("请关闭表单")
    .onClose(function() {
        console.log("表单已关闭");
    }, this);
```

### form.show(player)

显示表单给玩家。

**参数：**
- `player` - 玩家对象

**示例：**
```javascript
var form = allay.getForms().createSimpleForm()
    .title("主菜单")
    .content("请选择一个选项：")
    .button("选项1")
    .button("选项2")
    .onResponse(function(buttonText, buttonIndex) {
        player.sendMessage("你选择了: " + buttonText);
    }, this);

form.show(player);
```

## ModalForm（模态表单）

ModalForm用于显示确认对话框，玩家只能选择"确定"或"取消"。

### allay.getForms().createModalForm()

创建一个新的模态表单。

**返回值：**
- 模态表单对象

**示例：**
```javascript
var form = allay.getForms().createModalForm();
```

### form.title(title)

设置表单的标题。

**参数：**
- `title` - 表单标题（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认操作");
```

### form.content(content)

设置表单的内容文本。

**参数：**
- `content` - 表单内容（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认操作")
    .content("你确定要执行这个操作吗？");
```

### form.trueButton(text)

设置确定按钮的文本。

**参数：**
- `text` - 确定按钮文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认操作")
    .content("你确定要执行这个操作吗？")
    .trueButton("确定");
```

### form.falseButton(text)

设置取消按钮的文本。

**参数：**
- `text` - 取消按钮文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认操作")
    .content("你确定要执行这个操作吗？")
    .trueButton("确定")
    .falseButton("取消");
```

### form.onTrue(callback, thisArg)

设置点击确定按钮时的回调函数。

**参数：**
- `callback` - 点击确定按钮时的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认操作")
    .content("你确定要执行这个操作吗？")
    .trueButton("确定")
    .falseButton("取消")
    .onTrue(function() {
        player.sendMessage("你点击了确定按钮");
    }, this);
```

### form.onFalse(callback, thisArg)

设置点击取消按钮时的回调函数。

**参数：**
- `callback` - 点击取消按钮时的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认操作")
    .content("你确定要执行这个操作吗？")
    .trueButton("确定")
    .falseButton("取消")
    .onTrue(function() {
        player.sendMessage("你点击了确定按钮");
    }, this)
    .onFalse(function() {
        player.sendMessage("你点击了取消按钮");
    }, this);
```

### form.onClose(callback, thisArg)

设置表单关闭时的回调函数。

**参数：**
- `callback` - 表单关闭时的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("测试表单")
    .content("请关闭表单")
    .onClose(function() {
        console.log("表单已关闭");
    }, this);
```

### form.show(player)

显示表单给玩家。

**参数：**
- `player` - 玩家对象

**示例：**
```javascript
var form = allay.getForms().createModalForm()
    .title("确认删除")
    .content("你确定要删除这个物品吗？")
    .trueButton("确定")
    .falseButton("取消")
    .onTrue(function() {
        player.sendMessage("物品已删除");
    }, this)
    .onFalse(function() {
        player.sendMessage("删除已取消");
    }, this);

form.show(player);
```

## CustomForm（自定义表单）

CustomForm用于收集玩家输入，支持多种输入组件。

### allay.getForms().createCustomForm()

创建一个新的自定义表单。

**返回值：**
- 自定义表单对象

**示例：**
```javascript
var form = allay.getForms().createCustomForm();
```

### form.title(title)

设置表单的标题。

**参数：**
- `title` - 表单标题（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("个人信息");
```

### form.input(label, placeholder, defaultValue)

添加一个输入框。

**参数：**
- `label` - 输入框标签（String）
- `placeholder` - 占位符文本（String）
- `defaultValue` - 默认值（String，可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("个人信息")
    .input("用户名", "请输入用户名", "Steve")
    .input("邮箱", "请输入邮箱");
```

### form.toggle(label, defaultValue)

添加一个开关（布尔值选择）。

**参数：**
- `label` - 开关标签（String）
- `defaultValue` - 默认值（Boolean，可选，默认false）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("设置")
    .toggle("启用通知", true)
    .toggle("启用音效");
```

### form.dropdown(label, options, defaultIndex)

添加一个下拉菜单。

**参数：**
- `label` - 下拉菜单标签（String）
- `options` - 选项数组（Array）
- `defaultIndex` - 默认选中的选项索引（Number，可选，默认0）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("选择难度")
    .dropdown("难度级别", ["简单", "普通", "困难"], 1);
```

### form.slider(label, min, max, step, defaultValue)

添加一个滑块。

**参数：**
- `label` - 滑块标签（String）
- `min` - 最小值（Number）
- `max` - 最大值（Number）
- `step` - 步长（Number，可选，默认1）
- `defaultValue` - 默认值（Number，可选，默认min）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("音量设置")
    .slider("背景音乐音量", 0, 100, 5, 50);
```

### form.stepSlider(label, steps, defaultStep)

添加一个步进滑块。

**参数：**
- `label` - 步进滑块标签（String）
- `steps` - 步骤数组（Array）
- `defaultStep` - 默认步骤索引（Number，可选，默认0）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("选择质量")
    .stepSlider("图形质量", ["低", "中", "高", "极高"], 2);
```

### form.label(text)

添加一个标签文本。

**参数：**
- `text` - 标签文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("信息表单")
    .label("请填写以下信息")
    .input("姓名", "请输入姓名");
```

### form.header(text)

添加一个标题文本。

**参数：**
- `text` - 标题文本（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("标题示例")
    .header("这是一个标题")
    .input("内容", "请输入内容");
```

### form.divider()

添加一个分隔线。

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("分隔线示例")
    .input("上方输入框", "请输入")
    .divider()
    .input("下方输入框", "请输入");
```

### form.pathIcon(path)

设置表单的路径图标。

**参数：**
- `path` - 图标路径（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("图标示例")
    .pathIcon("textures/items/diamond")
    .input("内容", "请输入内容");
```

### form.urlIcon(url)

设置表单的URL图标。

**参数：**
- `url` - 图标URL（String）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("URL图标示例")
    .urlIcon("https://example.com/icon.png")
    .input("内容", "请输入内容");
```

### form.onResponse(callback, thisArg)

设置表单响应回调函数。

**参数：**
- `callback` - 表单提交时的回调函数，接收一个参数：表单数据数组（Array）
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("个人信息")
    .input("用户名", "请输入用户名", "Steve")
    .input("年龄", "请输入年龄", "20")
    .toggle("同意条款", true)
    .dropdown("性别", ["男", "女", "其他"], 0)
    .slider("身高(cm)", 100, 250, 1, 170)
    .onResponse(function(responses) {
        var username = responses[0];
        var age = parseInt(responses[1]);
        var agree = responses[2];
        var gender = responses[3];
        var height = responses[4];
        
        player.sendMessage("用户名: " + username);
        player.sendMessage("年龄: " + age);
        player.sendMessage("同意条款: " + agree);
        player.sendMessage("性别: " + gender);
        player.sendMessage("身高: " + height + "cm");
    }, this);
```

### form.onClose(callback, thisArg)

设置表单关闭时的回调函数。

**参数：**
- `callback` - 表单关闭时的回调函数
- `thisArg` - 回调函数中的 `this` 值（可选）

**返回值：**
- 表单对象（支持链式调用）

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("测试表单")
    .content("请关闭表单")
    .onClose(function() {
        console.log("表单已关闭");
    }, this);
```

### form.show(player)

显示表单给玩家。

**参数：**
- `player` - 玩家对象

**示例：**
```javascript
var form = allay.getForms().createCustomForm()
    .title("个人信息")
    .input("用户名", "请输入用户名")
    .toggle("同意条款")
    .onResponse(function(responses) {
        player.sendMessage("你提交了表单");
    }, this);

form.show(player);
```

## 示例：完整的表单系统

```javascript
function onPlayerJoin(player) {
    showWelcomeForm(player);
}

function onPlayerCommand(player, command) {
    if (command === "/menu") {
        showMainMenu(player);
        event.cancel();
    }
}

function showWelcomeForm(player) {
    var form = allay.getForms().createSimpleForm()
        .title("欢迎来到服务器!")
        .content("请选择一个选项开始游戏：")
        .button("开始游戏")
        .button("查看规则")
        .button("退出")
        .onResponse(function(buttonText, buttonIndex) {
            switch(buttonIndex) {
                case 0:
                    player.sendMessage("游戏开始!");
                    break;
                case 1:
                    showRulesForm(player);
                    break;
                case 2:
                    player.kick("欢迎下次再来!");
                    break;
            }
        }, this);
    
    form.show(player);
}

function showRulesForm(player) {
    var form = allay.getForms().createSimpleForm()
        .title("服务器规则")
        .content("1. 禁止作弊\n2. 禁止刷屏\n3. 禁止辱骂他人\n4. 请爱护服务器环境")
        .button("我同意")
        .button("返回")
        .onResponse(function(buttonText, buttonIndex) {
            if (buttonIndex === 0) {
                player.sendMessage("感谢你遵守规则!");
                showMainMenu(player);
            } else {
                showWelcomeForm(player);
            }
        }, this);
    
    form.show(player);
}

function showMainMenu(player) {
    var form = allay.getForms().createSimpleForm()
        .title("主菜单")
        .content("请选择一个选项：")
        .button("个人信息")
        .button("设置")
        .button("商店")
        .button("退出")
        .onResponse(function(buttonText, buttonIndex) {
            switch(buttonIndex) {
                case 0:
                    showProfileForm(player);
                    break;
                case 1:
                    showSettingsForm(player);
                    break;
                case 2:
                    showShopForm(player);
                    break;
                case 3:
                    player.sendMessage("已退出菜单");
                    break;
            }
        }, this);
    
    form.show(player);
}

function showProfileForm(player) {
    var form = allay.getForms().createCustomForm()
        .title("个人信息")
        .input("昵称", "请输入昵称", player.getDisplayName())
        .input("个性签名", "请输入个性签名")
        .dropdown("职业", ["战士", "法师", "射手", "医生"], 0)
        .onResponse(function(responses) {
            var nickname = responses[0];
            var signature = responses[1];
            var profession = responses[2];
            
            player.sendMessage("个人信息已更新!");
            player.sendMessage("昵称: " + nickname);
            player.sendMessage("个性签名: " + signature);
            player.sendMessage("职业: " + profession);
        }, this);
    
    form.show(player);
}

function showSettingsForm(player) {
    var form = allay.getForms().createCustomForm()
        .title("设置")
        .toggle("启用聊天滤镜", true)
        .toggle("接收私人消息", true)
        .toggle("显示粒子效果", false)
        .slider("音效音量", 0, 100, 5, 50)
        .onResponse(function(responses) {
            var chatFilter = responses[0];
            var privateMessages = responses[1];
            var particles = responses[2];
            var volume = responses[3];
            
            player.sendMessage("设置已保存!");
            // 这里可以保存设置到文件
        }, this);
    
    form.show(player);
}

function showShopForm(player) {
    var form = allay.getForms().createSimpleForm()
        .title("商店")
        .content("请选择要购买的物品：")
        .buttonWithPathImage("钻石剑", "textures/items/diamond_sword")
        .buttonWithPathImage("钻石镐", "textures/items/diamond_pickaxe")
        .buttonWithPathImage("金苹果", "textures/items/golden_apple")
        .button("返回")
        .onResponse(function(buttonText, buttonIndex) {
            if (buttonIndex === 3) {
                showMainMenu(player);
                return;
            }
            
            var items = ["钻石剑", "钻石镐", "金苹果"];
            var item = items[buttonIndex];
            
            // 确认购买
            var confirmForm = allay.getForms().createModalForm()
                .title("确认购买")
                .content("你确定要购买 " + item + " 吗？")
                .trueButton("确定")
                .falseButton("取消")
                .onTrue(function() {
                    player.sendMessage("你已成功购买 " + item + "!");
                }, this)
                .onFalse(function() {
                    player.sendMessage("购买已取消");
                }, this);
            
            confirmForm.show(player);
        }, this);
    
    form.show(player);
}
```

## 注意事项

1. 表单组件的添加顺序会影响提交数据的顺序
2. 表单标题和内容应简洁明了，避免过长
3. 按钮文本应清晰描述其功能
4. 自定义表单的组件数量不宜过多，建议不超过10个
5. 表单显示后，玩家必须完成表单才能继续游戏
6. 表单关闭事件（onClose）会在玩家关闭表单时触发，而不是提交表单时触发