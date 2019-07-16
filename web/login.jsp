<%--
  Created by IntelliJ IDEA.
  User: ashu
  Date: 2019/7/15
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script type="text/javascript">
    function login() {
        window.location.href = "loginServlet";
    }
    </script>
</head>
<body>
    <form action="loginServlet" method="post" />
        用户名：<input type="text" name="username" /><br/>
        密码：<input type="password" name="password" /><br/>
        <input type="submit" value="登录" name="login" onclick="login()"/>
    </form>
</body>
</html>
