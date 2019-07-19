<%--
  Created by IntelliJ IDEA.
  User: ashu
  Date: 2019/7/17
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品详情页面</title>
</head>
<body>
<form action="goodsQueryServlet" method="post">
    <table border="1">
        <tr>
            <td>商品编号</td>
            <td>${goods.id}</td>
        </tr>
        <tr>
            <td>商品姓名</td>
            <td>${goods.goodsInfo_name}</td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><img src="upload/${goods.goodsInfo_pic}" width="100px" height="100px"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td>${goods.goodsInfo_price}</td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td>${goods.goodsInfo_description}</td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td>${goods.goods_stock}</td>
        </tr>
        <tr>
            <th colspan="2"><input type="submit" value="返回"></th>
        </tr>
    </table>
</form>
</body>
</html>
