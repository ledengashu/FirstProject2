<%--
  Created by IntelliJ IDEA.
  User: ashu
  Date: 2019/7/15
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript">
    function onLogin() {
        window.location.href = "login.jsp"
    }
    
    function onRegister() {
        window.location.href = "register.jsp"
    }
    </script>
</head>
<body>
    <h2>首页</h2>
    <input type="button" value="登录" name="login" onclick="onLogin()">
    <input type="button" value="注册" name="register" onclick="onRegister()">
</body>
</html>
