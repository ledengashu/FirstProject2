<%--
  Created by IntelliJ IDEA.
  User: ashu
  Date: 2019/7/15
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script type="text/javascript">
        function register() {
            window.location.href = "registerServlet"
            // var elementById = document.getElementById("username");
            // var elementsByName = document.getElementsByName("password");
            // if(elementById.value===""||elementsByName[0].value===""
            //         ||elementsByName[1].value===""){
            //     alert("用户名、密码、确认密码不能为空");
            // }else if(elementsByName[0].value!=elementsByName[1].value){
            //     alert("密码与确认密码不一致");
            // }else{
            //     alert("注册成功")
            // }
        }
    </script>
</head>
<body>
    <form action="registerServlet" method="post">
        请输入用户名：<input type="text" name="username"><br/>
        请输入密码：<input type="password" name="password"><br/>
        请确认密码：<input type="password" name="confirm"><br/>
        <input type="submit" value="提交" name="register" onclick="register()">
    </form>
</body>
</html>
