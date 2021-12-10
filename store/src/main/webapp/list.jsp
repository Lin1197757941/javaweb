<%@ page import="Dao.Dao" %>
<%@ page import="bean.Orders" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/12/10
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username= session.getAttribute("username").toString();
    String sql="select * from list where username=?";
    Dao dao=new Dao();
    List<Orders> listList = dao.getSult(Orders.class, sql, username);
    session.setAttribute("listList",listList);
    listList.forEach(System.out::println);
%>
<html>
<head>
    <title>Title</title>
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
<div class="main">
    <a href="index.jsp">首页</a>
<table>
    <tr>
        <th>商品名称</th>
        <th>购买数量</th>
        <th>商品单价</th>
        <th>订单时间</th>
    </tr>
    <tbody>
    <c:forEach items="${listList}" var="list">
        <tr>
            <td>${list.goods_name}</td>
            <td>${list.order_num}</td>
            <td>${list.price}</td>
            <td>${list.order_time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

</body>
</html>
