<%--
  Created by IntelliJ IDEA.
  User: zahui
  Date: 2019-07-28
  Time: 下午 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>layui/css/login.css">
    <link rel="icon" href="/favicon.ico">

    <script type="text/javascript" src="<%=basePath %>layui/layui.js"></script>
    <title>客户信息管理系统</title>
</head>
<body class="login-wrap">
<div class="login-container">
    <form class="login-form layui-form">
        <div class="input-group">
            <%--@declare id="username"--%><input type="text" id="mid"  name="mid" class="input-field">
            <label for="username" class="input-label">
                <span class="label-title">用户名</span>
            </label>
        </div>
        <div class="input-group">
            <input type="password" id="password" name="password" class="input-field">
            <label for="password" class="input-label">
                <span class="label-title">密码</span>
            </label>
        </div>
        <input type="button" class="login-button" lay-submit value="登录" lay-filter="submitBtn">
    </form>
</div>
</body>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>js/login.js"></script>
<script src="<%=basePath%>js/index.js" data-main="login"></script>
</html>
