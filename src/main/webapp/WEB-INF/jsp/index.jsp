<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/15 0015
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.4.1.js"></script>
    <title>index</title>
</head>
<body>
<div id="app">
    <h1 style="background-color: aqua;text-align: center">欢迎来到东北林业大学监考系统！</h1>
    <br>
    <br>
    <hr>
    <p>我是老师</p>
    <form action="/tlogin" method="post">
        姓名<input type="text" name="username">
        密码<input type="password" name="password">
        <button type="submit">登录</button>
        <button type="reset">重置</button>
    </form>
    <br>
    <br>
    <br>
    <br>
    <hr>
    <p>我是管理员</p>
    <form action="/mlogin" method="post">
        姓名<input type="text" name="username">
        密码<input type="password" name="password">
        <button type="submit">登录</button>
        <button type="reset">重置</button>
    </form>
</div>
</body>
</html>