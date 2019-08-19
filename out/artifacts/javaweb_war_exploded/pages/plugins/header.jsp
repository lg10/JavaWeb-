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
<div class="layui-header custom-header">

    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item slide-sidebar" lay-unselect>
            <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
        </li>
    </ul>

    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">${member.name}(${member.mid})</a>
            <dl class="layui-nav-child">
                <dd><a href="">帮助中心</a></dd>
                <dd><a href="<%=basePath %>/MemberLoginServlet/logOut">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>
