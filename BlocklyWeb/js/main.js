/**
 * BlocklyAllay Main Application
 */

let workspace = null;

// Initialize Blockly
function initBlockly() {
    const blocklyArea = document.getElementById('blockly-area');
    const blocklyDiv = document.getElementById('blockly-div');

    workspace = Blockly.inject(blocklyDiv, {
        toolbox: TOOLBOX,
        theme: Blockly.Themes.Dark,
        grid: {
            spacing: 20,
            length: 3,
            colour: '#3c3c3c',
            snap: true
        },
        zoom: {
            controls: true,
            wheel: true,
            startScale: 1.0,
            maxScale: 3,
            minScale: 0.3,
            scaleSpeed: 1.2
        },
        trashcan: true,
        move: {
            scrollbars: true,
            drag: true,
            wheel: true
        },
        renderer: 'zelos'
    });

    // Update code on change
    workspace.addChangeListener(onWorkspaceChange);

    // Resize handler
    window.addEventListener('resize', onResize);
    onResize();
}

// Handle workspace changes
function onWorkspaceChange(event) {
    // Update code preview
    updateCodePreview();

    // Update block count
    const blockCount = workspace.getAllBlocks(false).length;
    document.getElementById('block-count').textContent = `方块: ${blockCount}`;
}

// Update code preview
function updateCodePreview() {
    const code = generateCode();
    const codeElement = document.querySelector('#code-output code');
    codeElement.textContent = code;
}

// Generate JavaScript code
function generateCode() {
    if (!workspace) {
        return '// 工作区未初始化';
    }

    // Check if JavaScript generator exists
    if (!Blockly.JavaScript) {
        console.error('Blockly.JavaScript generator not loaded');
        return '// 错误: JavaScript 生成器未加载';
    }

    try {
        // Generate JavaScript code from blocks
        const code = Blockly.JavaScript.workspaceToCode(workspace);

        // Wrap in script template
        return `// BlocklyAllay 生成的脚本
// 生成时间: ${new Date().toLocaleString()}

${code}`;
    } catch (err) {
        console.error('代码生成失败:', err);
        return '// 代码生成失败: ' + err.message;
    }
}

// Resize Blockly to fit container
function onResize() {
    const blocklyArea = document.getElementById('blockly-area');
    const blocklyDiv = document.getElementById('blockly-div');

    blocklyDiv.style.width = blocklyArea.offsetWidth + 'px';
    blocklyDiv.style.height = blocklyArea.offsetHeight + 'px';

    Blockly.svgResize(workspace);
}

// New project
function newProject() {
    if (workspace.getAllBlocks(false).length > 0) {
        if (!confirm('确定要新建项目吗？当前项目将被清除。')) {
            return;
        }
    }
    workspace.clear();
    setStatus('已新建项目');
}

// Save project
function saveProject() {
    try {
        const xml = Blockly.Xml.workspaceToDom(workspace);
        const xmlText = Blockly.Xml.domToText(xml);

        downloadFile(xmlText, `blockly_script_${Date.now()}.xml`, 'text/xml');
        setStatus('项目已保存');
    } catch (err) {
        console.error('保存失败:', err);
        setStatus('保存失败: ' + err.message);
    }
}

// Helper function to download file
function downloadFile(content, filename, mimeType) {
    const blob = new Blob([content], { type: mimeType });

    // Try using URL.createObjectURL first
    if (window.navigator.msSaveOrOpenBlob) {
        // IE/Edge
        window.navigator.msSaveOrOpenBlob(blob, filename);
    } else {
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = filename;
        a.style.display = 'none';
        document.body.appendChild(a);
        a.click();

        // Cleanup
        setTimeout(() => {
            document.body.removeChild(a);
            URL.revokeObjectURL(url);
        }, 100);
    }
}

// Load project
function loadProject() {
    document.getElementById('file-input').click();
}

function handleFileLoad(event) {
    const file = event.target.files[0];
    if (!file) return;

    const reader = new FileReader();
    reader.onload = function(e) {
        try {
            const xml = Blockly.utils.xml.textToDom(e.target.result);
            workspace.clear();
            Blockly.Xml.domToWorkspace(xml, workspace);
            setStatus(`已加载: ${file.name}`);
        } catch (err) {
            alert('加载文件失败: ' + err.message);
            setStatus('加载失败');
        }
    };
    reader.readAsText(file);

    // Reset file input
    event.target.value = '';
}

// Export JavaScript code
function exportCode() {
    try {
        const code = generateCode();

        if (code.includes('错误:') || code.includes('失败:')) {
            alert(code);
            return;
        }

        downloadFile(code, `script_${Date.now()}.js`, 'text/javascript');
        setStatus('脚本已导出');
    } catch (err) {
        console.error('导出失败:', err);
        setStatus('导出失败: ' + err.message);
        alert('导出失败: ' + err.message);
    }
}

// Copy code to clipboard
function copyCode() {
    const code = generateCode();
    navigator.clipboard.writeText(code).then(() => {
        setStatus('代码已复制到剪贴板');
    }).catch(err => {
        setStatus('复制失败');
    });
}

// Toggle code panel
function toggleCodePanel() {
    const panel = document.getElementById('code-panel');
    const btn = document.getElementById('btn-toggle-code');

    panel.classList.toggle('collapsed');
    btn.textContent = panel.classList.contains('collapsed') ? '◀' : '▶';

    // Trigger resize after animation
    setTimeout(onResize, 300);
}

// Set status message
function setStatus(message) {
    document.getElementById('status').textContent = message;
}

// Initialize on DOM ready
document.addEventListener('DOMContentLoaded', function() {
    // Check Blockly is loaded
    if (typeof Blockly === 'undefined') {
        alert('Blockly 库未加载，请检查网络连接');
        return;
    }

    // Check JavaScript generator
    if (!Blockly.JavaScript) {
        console.error('Blockly JavaScript 生成器未加载');
        setStatus('警告: JavaScript 生成器未加载');
    }

    initBlockly();

    // Button handlers
    document.getElementById('btn-new').addEventListener('click', newProject);
    document.getElementById('btn-save').addEventListener('click', saveProject);
    document.getElementById('btn-load').addEventListener('click', loadProject);
    document.getElementById('btn-export').addEventListener('click', exportCode);
    document.getElementById('btn-copy-code').addEventListener('click', copyCode);
    document.getElementById('btn-toggle-code').addEventListener('click', toggleCodePanel);
    document.getElementById('file-input').addEventListener('change', handleFileLoad);

    setStatus('就绪');
});
