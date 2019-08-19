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
    <script type="text/javascript" src="<%=basePath %>js/customer/customer_insert.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/customer/add.js"></script>
    <title>客户信息管理系统</title>
</head>
<body style="padding-top: 80px;">
    <div class="layui-carousel">
        <div class="layui-col-md2">&nbsp;</div>
        <div class="layui-col-md8">
            <form method="post" class="layui-form">

                <div class="layui-form-item">
                    <label class="layui-form-label">姓  名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" lay-verify="required" class="layui-input" placeholder="请输入姓名">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">电  话</label>
                    <div class="layui-input-block">
                        <input type="text" name="phone" lay-verify="required" class="layui-input" placeholder="请输入电话">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">地  址</label>
                    <div class="layui-input-block">
                        <input type="text" name="address" lay-verify="required" class="layui-input" placeholder="请输入地址">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">客户意向</label>
                    <div class="layui-input-block">
                        <select class="layui-input" id="intention" name="intention">
                            <option value="无意向">无意向</option>
                            <option value="有意向">有意向</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">用户跟进</label>
                    <div class="layui-input-block">
                        <select class="layui-input" id="type" name="type">
                            <option value="线上联系">线上联系</option>
                            <option value="上门访问">上门访问</option>
                            <option value="签约中">签约中</option>
                            <option value="签约成功">签约成功</option>
                            <option value="签约失败待跟进">签约失败待跟进</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <textarea  class="layui-input" style="height:200px;" type="text" name="note" lay-verify="required"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="button" lay-submit lay-filter="submitBtn" value="增加" class="layui-btn  layui-col-md-offset8">
                        <button type="reset"  class="layui-btn layui-btn-danger">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
    layui.use('form',function(){
        var  form = layui.form;
    })
</script>
</html>
