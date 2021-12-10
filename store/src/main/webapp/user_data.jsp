<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page import="Dao.Dao" %>
<%@ page import="bean.Orders" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/12/6
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username= session.getAttribute("username").toString();
    String sql="select * from orders where username=?";
    Dao dao=new Dao();
    List<Orders> ordersList = dao.getSult(Orders.class, sql, username);
    session.setAttribute("ordersList",ordersList);
    int sum=0;
    for(int i=0;i<ordersList.size();i++){
        sum+=ordersList.get(i).getOrder_num()*ordersList.get(i).getPrice();
    }
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
<a href="index.jsp">首页</a>
<P>用户个人信息</P><br>
<p>购物车</p>
<a href="list.jsp">历史订单</a>
<div class="main">
    <table>
        <tr>
            <th>商品名称</th>
            <th>购买数量</th>
            <th>商品单价</th>
        </tr>
      <tbody>
        <c:forEach items="${ordersList}" var="orders">
            <tr>
                <td>${orders.goods_name}</td>
                <td>${orders.order_num}</td>
                <td>${orders.price}</td>
                <td>
                    <a href="deleteOrder?id=${orders.goods_id}">
                    <input type="submit" value="删除" style="color: red">
                    </a>
                </td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
    商品总价：<%=sum%>
    <a href="payment.jsp">去结账</a>
</div>
</body>
</html>
