<%--
  Created by IntelliJ IDEA.
  User: zahui
  Date: 2019-07-28
  Time: 下午 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div class="layui-side custom-admin">
    <div class="layui-side-scroll">

        <div class="custom-logo">
            <img src="<%=basePath %>layui/images/logo.png" alt=""/>
            <h1>信息工程学院</h1>
        </div>
        <ul id="Nav" class="layui-nav layui-nav-tree">


        <!-- 管理员权限-->
            <c:if test="${member.flag == 0}">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe609;</i>
                        <em>部门管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/dept/dept_insert.jsp">增加部门</a></dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/dept/dept_list.jsp">部门列表</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon layui-icon-username"></i>
                        <em>账号管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/member/member_insert.jsp">增加账号</a></dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/member/member_list.jsp">账号列表</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon layui-icon-username"></i>
                        <em>日志管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/logs/logs_list.jsp">日志列表</a></dd>
                    </dl>
                </li>
            </c:if>
            <c:if test="${member.flag == 1}">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>组员管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/member-mgr/member_insert.jsp">增加组员</a></dd>
                        <dd>
                            <a href="<%=basePath %>pages/back/member-mgr/member_list.jsp">组员列表</a>
                        </dd>
                    </dl>
                </li>
            </c:if>
            <c:if test="${member.flag == 2}">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="layui-icon">&#xe857;</i>
                        <em>客户信息管理</em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath %>pages/back/customer/customer_insert.jsp">增加客户</a></dd>
                        <dd>
                            <a href="<%=basePath %>pages/back/customer/customer_list.jsp">客户列表</a>
                        </dd>
                    </dl>
                </li>
            </c:if>







            <li class="layui-nav-item">
                <a href="javascript:;">
                    <i class="layui-icon">&#xe612;</i>
                    <em>密码管理</em>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="<%=basePath %>pages/back/member/member_updatepassword.jsp">修改登录密码</a></dd>
                </dl>
            </li>
        </ul>

    </div>
</div>
