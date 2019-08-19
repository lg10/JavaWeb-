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
    <script type="text/javascript" src="<%=basePath %>js/customer/customer_list.js"></script>
    <title>客户信息管理系统</title>
</head>
<body>
    <div class ="layui-container">
<%--        <div class="layui-col-md1">&nbsp;</div>--%>
        <div class="layui-col-md12">
            <table class="layui-table" lay-filter="listSplit"></table>
        </div>
<%--        <div class="layui-col-md1">&nbsp;</div>--%>
    </div>
<script type="text/html" id="barOption">
    <a class = "layui-btn layui-btn-sm" lay-event="edit">更新</a>
<%--    <a class = "layui-btn layui-btn-sm layui-btn-danger" lay-event="delete">锁定账户</a>--%>
</script>
</body>
</html>
