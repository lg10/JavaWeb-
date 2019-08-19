function getContextPath() {
    var contextPath = document.location.pathname;
    var index = contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0, index + 1);
    delete index;
    return contextPath;
}

layui.use(['table','layer','jquery'],function () {
    var table = layui.table;
    index = layer.load(2);
    $ = layui.$;
    table.render({
        elem:'.layui-table',
        url:getContextPath()+'/pages/back/member/MemberServlet/listSplitByTitle',
        page:true,
        limit:10,
        cols:[[
            {field:'mid',title:'账号名',sort:true},
            {field:'name',title:'姓名',sort:true},
            {field:'phone',title:'电话',sort:true},
            {field:'lastdate',title:'上次登录时间',sort:true},
            {field:'right',tltle:'操作',toolbar:'#barOption'},

        ]],
        done:function () {
            layer.close(index);
        }
    }),
    table.on('tool(listSplit)',function (obj) {
        var data = obj.data;
        if (obj.event = "edit"){
            var mid = data.mid;
            $.ajax({
                type:'post',
                url:getContextPath()+'/pages/back/member/MemberServlet/updataPass',
                data:{"mid":mid},
                success: function (data) {
                    if (data == "success") {
                        layer.msg('重置成功,密码：54321', {
                            time: 2000, icon: 1, end: function () {
                                location.reload();
                            }
                        })
                    } else {
                        layer.msg('重置失败', {
                            time: 2000, icon: 2, end: function () {
                                location.reload();
                            }
                        })
                    }
                }
            })
        }
    })
    // table.on('tool(listSplit)',function (obj) {
    //     var data = obj.data;
    //     if (obj.event = "delete"){
    //         var status = data.status;
    //         $.ajax({
    //             type:'post',
    //             url:getContextPath()+'/pages/back/member/MemberServlet/status',
    //             data:{"mid":mid},
    //             success: function (data) {
    //                 if (data == "success") {
    //                     layer.msg('重置成功,密码：54321', {
    //                         time: 2000, icon: 1, end: function () {
    //                             location.reload();
    //                         }
    //                     })
    //                 } else {
    //                     layer.msg('重置失败', {
    //                         time: 2000, icon: 2, end: function () {
    //                             location.reload();
    //                         }
    //                     })
    //                 }
    //             }
    //         })
    //     }
    // })
})

