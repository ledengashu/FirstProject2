<%--
  Created by IntelliJ IDEA.
  User: ashu
  Date: 2019/7/16
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表页面</title>
    <script type="text/javascript">
        function onLoadData(id) {
            window.location.href = "goodsLoadDataServlet?id="+id;
        }
        function onDelete(id) {
            var flag = confirm("你确定删除此商品吗？");
            if(flag){
                window.location.href = "goodsDeleteServlet?id="+id;
            }
        }
        function onInsert() {
            window.location.href = "goods_save.jsp";
        }
        function onView(id) {
            window.location.href = "goodsViewServlet?id="+id;
        }
    </script>
</head>
<body>
    <form>
        <table border="1">
            <caption>商品列表</caption>
            <thead>
            <input type="button" value="添加商品" onclick="onInsert()">
                <tr>
                    <td>商品编号</td>
                    <td>商品名称</td>
                    <td>商品图片</td>
                    <td>商品价格</td>
                    <td>商品描述</td>
                    <td>商品库存</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            <!-- 遍历商品集合 -->
            <c:forEach items="${list}" var="goods" varStatus="s">
                <tr>
                    <td>${goods.id}</td>
                    <td>${goods.goodsInfo_name}</td>
                    <td><img src="upload/${goods.goodsInfo_pic}" width="100px" height="100px"></td>
                    <td>${goods.goodsInfo_price}</td>
                    <td>${goods.goodsInfo_description}</td>
                    <td>${goods.goods_stock}</td>
                    <td>
                        <input type="button" value="编辑" onclick="onLoadData('${goods.id}')">
                        <input type="button" value="删除" onclick="onDelete('${goods.id}')">&nbsp;
                        <a href="#" onclick="onView('${goods.id}')">详情</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</body>
</html>
