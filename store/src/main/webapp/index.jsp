<%@ page import="Dao.Dao" %>
<%@ page import="bean.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String sql="select * from goods";
    Dao dao=new Dao();
    List<Goods> goodsList=dao.getSult(Goods.class,sql);
    request.setAttribute("goodsList",goodsList);
%>
<!DOCTYPE html>
<html>
<head>
    <title>电商</title>
</head>
<body>
<h2 align="center">商店
</h2>
<br/>

<div align="right">
    <button type="button" >
        <%
            if(session.getAttribute("username")!=null){
        %>
        <a href="user_data.jsp">${sessionScope.username}</a>
        <%
            }
            if(session.getAttribute("username")==null){
        %><a href="login.jsp">登录</a>
        <%
            }
        %>
    </button>
    <button type="button" >
        <%
            if(session.getAttribute("username")!=null){
        %>
        <a href="logout">注销</a>
        <%
            }
            if(session.getAttribute("username")==null){
        %><a href="register.jsp">注册</a>
        <%
            }
        %>
    </button>
</div>
<%--<a href="http://localhost:8080/store/goods_list.jsp"><input type="button" value="查看商品"></a>--%>


<div class="row" style="width: 1210px; margin: 0 auto;">
    <div class="col-md-12">
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
        </ol>
    </div>
    <c:forEach items="${goodsList }" var="goods">
        <div class="col-md-1" style="height:250px;display: inline-block;padding: 5px;">
            <a href="info?id=${goods.goods_id}">
                <img src="1.jpg" width="170" height="170" style="display: inline-block;">
                <p> ${goods.goods_name } </p>

            </a>
            <p>
                <span style="color: #ff0000; ">价格：${goods.price}</span><br>
                <span>库存：${goods.stock}</span>
            </p>
        </div>
    </c:forEach>
</div>
<div>

</div>
</body>
</html>