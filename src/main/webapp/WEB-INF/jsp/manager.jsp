<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script type="text/javascript" src="jquery-3.4.1.js"></script>
    <title>manager</title>
</head>
<body>
<P>尊敬的${manager}，欢迎您！</P>
<p>以下是您的个人信息</p>
<p>姓名:${manager}--------密码：${ps}</p>
<p>您可以修改个人的信息;</p>
请输入您原来的姓名<input type="text" id="myxm"><br>
请输入新的姓名：<input type="text" id="mxm"><br>
请输入新的密码：<input type="text" id="mmm"><br>
<button id="mxg">点击确认修改您的个人信息</button>
<hr>
<p>以下是所有老师的信息：</p>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>密码</th>
    </tr>
    <c:forEach items="${teachers}" var="li">
    <tr>
        <td>${li.name}</td>
        <td>${li.password}</td>
    </tr>
    </c:forEach>
</table>
<p>您可以修改以上老师的基本信息：</p>
请输入老师原来的姓名<input type="text" id="yxm"><br>
请输入老师新的姓名：<input type="text" id="xm"><br>
请输入老师新的密码：<input type="text" id="mm"><br>
<button id="xg">点击确认修改老师信息</button>
<hr>
<p>当然，您也可以添加普通用户为管理员</p>
请输入您要添加的管理员：<input type="text" id="mtam"> <button id="atm">确认添加</button>
<p>以下是所有的监考信息</p>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>是否分配</th>
    </tr>
    <c:forEach items="${exams}" var="li">
        <tr>
            <td>${li.name}</td>
            <td>${li.place}</td>
            <td>${li.start}</td>
            <td>${li.end}</td>
            <td>${li.fp}</td>
        </tr>
    </c:forEach>
</table>
<p>您可以添加一条考试信息</p>
考试名字<input id="name">考试地点<input id="place"><br>
开始时间年<input id="start-y">月<input id="start-m">日<input id="start-d">时<input id="start-h">分<input id="start-s"><br>
结束时间年<input id="end-y">月<input id="end-m">日<input id="end-d">时<input id="end-h">分<input id="end-s"><button id="addexam">确定</button>
<hr>
<p>您可以添加一条监考信息</p>
监考老师:<input type="text" id="tname">
考试名字:<input type="text" id="ename">
<button id="tj">确认分配</button>
</body>
<script>
    $(function () {
        $("#xg").click(function () {
            var pc="/teacher/alter";
            $.post(pc,{"yxm":$("#yxm").val(),"xm":$("#xm").val(),"mm":$("#mm").val()},alert("恭喜你，修改成功"))
        })
    });
    $(function () {
        $("#mxg").click(function () {
            var mpc="/manager/alter";
            $.post(mpc,{"yxm":$("#myxm").val(),"xm":$("#mxm").val(),"mm":$("#mmm").val()},alert("恭喜你，修改成功"))
        })
    })
    $(function () {
        $("#atm").click(function () {
            var kmpc="/manager/add";
            $.post(kmpc,{"xm":$("#mtam").val()},alert("恭喜你，添加成功"))
        })
    })
    $(function () {
        $("#addexam").click(function () {
           var tjdz="/exam/add";
           $.post(tjdz,{"name":$("#name").val(),"place":$("#place").val(),
               "start-y":$("#start-y").val(), "start-m":$("#start-m").val(),"start-d":$("#start-d").val(),"start-h":$("#start-h").val(),"start-s":$("#start-s").val(),
               "end-y":$("#end-y").val(),"end-m":$("#end-m").val(),"end-d":$("#end-d").val(),"end-h":$("#end-h").val(),"end-s":$("#end-s").val()},alert("添加成功"))
        })
    })
    $(function () {
        $("#tj").click(function () {
         var da="/exam/fp" ;
         $.post(da,{"tname":$("#tname").val(),"ename":$("#ename").val()},alert("恭喜你，添加成功"))
        })
    })

</script>
</html>
