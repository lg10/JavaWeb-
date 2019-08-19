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
            url: getContextPath() + '/pages/back/member/MemberServlet/add',
            type: 'POST',
            data: $('.layui-form').serialize(),//获取表单数据
            success: function (data) {
                if (data == "success") {
                    layer.msg('数据增加成功', {
                        time: 2000, icon: 1, end: function () {
                            location.reload();
                        }
                    })
                } else {
                    layer.msg('数据增加失败', {
                        time: 2000, icon: 2, end: function () {
                            location.reload();
                        }
                    })
                }
            }

        })
    })
})


// layui.use(['form','jquery','layer'],function (){
//     var form = layui.form,
//         $ = layui.$,
//         layer = layui.layer;
//     form.on('submit(submitBtn)',function (obj) {
//         $.ajax({
//             url:getContextPath()+'/pages/back/dept/DeptServlet/add',
//             type:'POST',
//             data:$('.layui-form').serialize(),//获取表单数据
//             success:function (data) {
//                 if ("data == success"){
//                     layer.msg('数据增加成功',{time:2000,icon:1,end:function () {
//                             location.href="../../pages/back/dept/dept_insert.jsp";
//                         }})
//                 }else{
//                     layer.msg('数据增加失败',{time:2000,icon:2,end:function () {
//                             location.href="../../pages/back/dept/dept_insert.jsp";
//                         }})
//                 }
//             }
//
//         })
//     })
// })