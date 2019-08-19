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
    <script type="text/javascript" src="<%=basePath %>js/dept/add.js"></script>
    <title>客户信息管理系统</title>
</head>
<body style="padding-top: 80px;">
    <div class="layui-carousel">
        <div class="layui-col-md2">&nbsp;</div>
        <div class="layui-col-md8">
            <form method="post" class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">部门名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" lay-verify="required" class="layui-input" placeholder="请输入部门组名称">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">部门描述</label>
                    <div class="layui-input-block">
                        <textarea  class="layui-input" style="height:200px;" type="text" name="note" lay-verify="required"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="button" lay-submit lay-filter="submitBtn" value="增加" class="layui-btn  layui-col-md-offset10">
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
