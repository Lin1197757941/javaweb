<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/12/3
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input{
            width: 150px;
            height: 25px;
        }
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
    <form method="post" action="register">
        用户名:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit">
    </form>
    <p style="color: red">${requestScope.remsg}</p>
</div>
</body>
</html>
