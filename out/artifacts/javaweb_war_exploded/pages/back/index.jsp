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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>layui/css/admin.css"/>

    <title>客户信息管理系统</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/plugins/header.jsp"/>
    <!--头部导航 -->
    <jsp:include page="/pages/plugins/left.jsp"/>
    <!--left导航 -->


    <div class="layui-body">
        <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
            <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
            <div id="appTabPage" class="layui-tab-content"></div>
        </div>
    </div>

    <div class="layui-footer">
        <p>© 2019lg10<a href="http://lg10.top/" target="_blank">@lg10</a></p>
    </div>

    <div class="mobile-mask"></div>
</div>
<script type="text/javascript" src="<%=basePath %>layui/layui.js"></script>
<script src="<%=basePath %>/js/index.js" data-main="home"></script>
</body>
</html>
