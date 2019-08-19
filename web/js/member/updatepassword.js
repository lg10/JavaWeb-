function getContextPath() {
    var contextPath = document.location.pathname;
    var index = contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0, index + 1);
    delete index;
    return contextPath;
}

layui.use(['form','jquery','layer'],function (){
    var form = layui.form,
        $ = layui.$,
        layer = layui.layer;
    form.on('submit(submitBtn)',function (obj) {
        $.ajax({
            url: getContextPath() + '/pages/back/member/MemberServlet/updatePassWord',
            type: 'POST',
            data: $('.layui-form').serialize(),//获取表单数据
            success: function (data) {
                if (data == "success") {
                    layer.msg('密码修改成功,请重新登录', {
                        time: 2000, icon: 1, end: function () {
                            window.parent.location.href=getContextPath()+'/MemberLoginServlet/logOut';
                        }
                    })
                } else {
                    layer.msg('密码修改失败', {
                        time: 2000, icon: 2, end: function () {
                            location.reload();
                        }
                    })
                }
            }

        })
    })
})