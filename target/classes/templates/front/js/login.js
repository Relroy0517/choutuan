function login() {
    var name = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    // 创建JSON数据
    const userData = {
        name: name,
        password: password
    };

    // 转换为JSON字符串
    const jsonData = JSON.stringify(userData);
    // 发送POST请求到后端
    fetch('/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'success') {
                alert('注册成功！');
                // 这里可以添加重定向到登录页面的代码
                // // 假设这里你已经验证了用户名和密码，现在将它们存储到Session Storage
                // sessionStorage.setItem('username', username);
                // sessionStorage.setItem('password', password);

                alert('登录成功，欢迎 ' + username);
                // 重定向到主页或其他页面
                window.location.href = 'home.html';
            } else {
                alert('注册失败：' + data.message);
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('注册时发生错误，请稍后再试');
        });
}

// 当页面加载时，检查Session Storage是否有登录信息
window.onload = function() {
    var username = sessionStorage.getItem('username');
    if (username) {
        alert('欢迎回来，' + username);
    }



};