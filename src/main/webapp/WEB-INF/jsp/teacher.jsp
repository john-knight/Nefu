<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/16 0016
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.4.1.js"></script>
    <title>teacher</title>
</head>
<body>
<P>尊敬的${hello}，欢迎您！</P>
<table border="1">
   <p>以下是您的个人信息</p>
    <p>姓名为：${hello} ---密码为：${ps}</p>
    <p>您可以修改个人的信息;</p>
    请输入您原来的姓名<input type="text" id="yxm"><br>
    请输入新的姓名：<input type="text" id="xm"><br>
    请输入新的密码：<input type="text" id="mm"><br>
    <button id="xg">点击确认修改您的个人信息</button>
    <br>
    <p>以下是您的所有监考信息</p>
    <table border="1">
        <tr>
            <th>姓名</th>
            <th>密码</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
        <c:forEach items="${exams}" var="li">
            <tr>
                <td>${li.name}</td>
                <td>${li.place}</td>
                <td>${li.start}</td>
                <td>${li.end}</td>
            </tr>
        </c:forEach>
    </table>
    <script>
        <%--0=0=0=0=0=0=0=0=0=0=0=0=00=0=0=0000=0=00=0=0=--%>
        <%--调用ajax一定要注意：
        ajax的方法，一定要封到$(function({}))中
        --%>
        $(function () {
            $("#xg").click(function () {
                var pc="/teacher/alter";
                $.post(pc,{"yxm":$("#yxm").val(),"xm":$("#xm").val(),"mm":$("#mm").val()},alert("恭喜你，修改成功"))
            })
        });
    </script>
</table>
</body>
</html>
