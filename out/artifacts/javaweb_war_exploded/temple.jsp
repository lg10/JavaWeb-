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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>layui/css/layui.css"/>
    <script type="text/javascript" src="<%=basePath %>layui/layui.js"></script>
    <title>客户信息管理系统</title>
</head>
<body>
<button class="layui-btn">测试</button>
</body>
</html>
