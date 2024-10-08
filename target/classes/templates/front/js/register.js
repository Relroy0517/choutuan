function registerApi(data) {
    // 发送POST请求到后端
    fetch('/add/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
}
