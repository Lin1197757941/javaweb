<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2021/12/8
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结账</title>
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
    <form action="payment" method="get">
        支付成功将以邮件的形式通知您。<br>
        请输入邮箱：<input type="email" name="email">
        <input type="submit">
    </form>
</div>
</body>
</html>
