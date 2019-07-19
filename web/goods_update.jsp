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
    <script type="text/javascript">
        function onResetImg(_obj) {
            var td = _obj.parentElement;
            var content = '<input type="file" name="goodsInfo_pic"/>';
            content+='<input type="button" value="取消上传" onclick="onCancelImg(this)"/>';
            td.innerHTML = content;
        }
        function onCancelImg(_obj) {
            var td= _obj.parentElement;
            var content='<img src="upload/${goods.goodsInfo_pic}" width="100px" height="50px" />';
            content+='<input type="button" value="重新上传" onclick="onResetImg(this)">';
            content+='<input type="hidden" name="goodsInfo_pic" value="${goods.goodsInfo_pic}">';
            td.innerHTML = content;
        }
    </script>
</head>
<body>
<form action="goodsUpdateServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${goods.id}">
    <table border="1">
        <tr>
            <td>商品姓名</td>
            <td><input type="text" name="goodsInfo_name" value="${goods.goodsInfo_name}"></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:choose>
                    <c:when test="${goods.goodsInfo_pic!=null}">
                <img src="upload/${goods.goodsInfo_pic}" width="100px" height="100px">
                <input type="button" value="重新上传" onclick="onResetImg(this)">
                <input type="hidden" name="goodsInfo_pic" value="${goods.goodsInfo_pic}">
                    </c:when>
                    <c:otherwise>
                        <input type="file"  name="goodsInfo_pic"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name="goodsInfo_price" value="${goods.goodsInfo_price}"></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><input type="text" name="goodsInfo_description" value="${goods.goodsInfo_description}"></td>
        </tr>
        <tr>
            <td>商品库存</td>
            <td><input type="text" name="goods_stock" value="${goods.goods_stock}"></td>
        </tr>
        <tr>
            <th colspan="2"><input type="submit" value="保存"></th>
        </tr>
    </table>
</form>
</body>
</html>
