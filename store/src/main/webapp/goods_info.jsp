<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/12/4
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.goods.goods_name}</title>
    <style>
        .main{
            text-align: center;
            background-color: #fff;
            border-radius: 20px;
            width: 300px;
            height: 350px;
            position: absolute;
            left: 45%;
            top: 40%;
            transform: translate(-50%,-50%);
        }
    </style>
</head>
<body>
<div>
    <a href="index.jsp">首页</a>
    <a href="user_data.jsp" style="text-align: right">购物车</a>
</div>
<div class="main">
    <img src="1.jpg" width="500" height="500" style="display: inline-block;">
    <p>
    <span style="color: black">${sessionScope.goods.goods_name}</span><br>
    <span style="color: #ff0000; ">价格：${sessionScope.goods.price}</span><br>
    <span>库存：${sessionScope.goods.stock}</span>
    </p>
    <a href="addOrder?id=${sessionScope.goods.goods_id}">
        <input type="submit" value="加入购物车">
    </a>

    ${requestScope.msg}
</div>


</body>
</html>
