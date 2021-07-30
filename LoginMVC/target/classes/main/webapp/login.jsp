<%--
  Created by IntelliJ IDEA.
  User: 62459
  Date: 2021/7/6
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
    <div style="text-align: center">
        <form action="loginServlet" method="post" id="loginForm">
            姓名：<input type="text" name="userName" id="userName" value="${messageModel.object.userName}">
            <br>
            密码：<input type="text" name="userPassword" id="userPassword" value="${messageModel.object.userPassword}">
            <br>
            <span id="message" style="font-size: 12px; color: red"> ${messageModel.message} </span>
            <br>
            <button type="button" onclick="login();">登录</button>
            <button type="button">注册</button>
        </form>
    </div>
</body>
<script>
    function login() {
        var userName = $("#userName").val();
        var userPassword = $("#userPassword").val();
    //    判断姓名是否为空
        if(isEmpty(userName)) {
            $("#message").html("用户名不能为空");
            return ;
        }
        if(isEmpty(userPassword)) {
            $("#message").html("用户密码不能为空");
            return ;
        }
    //    提交表单
        $("#loginForm").submit();
    }
    // 判断字符串是否为空
    function isEmpty(str) {
        if(str == null || str.trim() == "") {
            return true;
        }
        return false;
    }
</script>
</html>
