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
    </script>
</head>
<body>
    <form action="registerServlet" method="post">
        请输入用户名：<input type="text" name="username"><br/>
        请输入密码：<input type="password" name="password"><br/>
        请确认密码：<input type="password" name="confirm"><br/>
        性别：<select name="sex">
            <option disabled selected>请选择</option>
            <option>男</option>
            <option>女</option>
            </select><br/>
        爱好：<input type="text" name="hobbys"><br/>
        手机号码：<input type="text" name="phone"><br/>
        电子邮箱：<input type="text" name="email"><br/>
        地址：<input type="text" name="addrs"><br/>
        <input type="submit" value="提交" name="register" >
    </form>
</body>
</html>
