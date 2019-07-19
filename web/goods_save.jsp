<%--
  Created by IntelliJ IDEA.
  User: ashu
  Date: 2019/7/17
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加页面</title>
</head>
<body>
    <form action="goodsInsertServlet" method="post" enctype="multipart/form-data">
        <table border="1">
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="goodsInfo_name"></td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td><input type="file" name="goodsInfo_pic"></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="goodsInfo_price"></td>
            </tr>
            <tr>
                <td>商品描述</td>
                <td><input type="text" name="goodsInfo_description"></td>
            </tr>
            <tr>
                <td>商品库存</td>
                <td><input type="text" name="goods_stock"></td>
            </tr>
            <tr>
                <td>商品状态</td>
                <td><select name="flag">
                    <option disabled selected>请选择</option>.
                    <option value="0">激活</option>
                    <option value="1">禁用</option>
                </select></td>
            </tr>
            <tr>
                <input type="submit" value="保存">
            </tr>
        </table>
    </form>
</body>
</html>
