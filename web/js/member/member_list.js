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
        url:getContextPath()+'/pages/back/member/MemberServlet/listSplit',
        page:true,
        limit:10,
        cols:[[
            {field:'title',title:'部门',width: '8%',sort:true},
            {field:'mid',title:'账号名',width: '10%',sort:true},
            {field:'name',title:'姓名',width: '10%',sort:true},
            {field:'phone',title:'电话',width: '13%',sort:true},
            {field:'lastdate',title:'上次登录时间',width: '18%',sort:true},
            {field:'ip',title:'ip',width: '16%',sort:true},
            {field:'right',title:'重置密码',toolbar:'#barOption'},
            // {field:'right',title:' ',width: '20%',toolbar:'#updateOption'},

        ]],
        done:function () {
            layer.close(index);
        }
    }),
    table.on('tool(listSplit)',function (obj) {
        var data = obj.data;
        if (obj.event === "edit"){
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
        }else if (obj.event === "update"){
            var mid = data.mid;
            $.ajax({
                type:'post',
                url:getContextPath()+'/pages/back/member/MemberServlet/unlockStatus',
                data:{"mid":mid,"status":1},
                success: function (data) {
                    if (data == "success") {
                        layer.msg('锁定成功', {
                            time: 2000, icon: 1, end: function () {
                                location.reload();
                            }
                        })
                    } else {
                        layer.msg('锁定失败', {
                            time: 2000, icon: 2, end: function () {
                                location.reload();
                            }
                        })
                    }
                }
            })
        }else   if (obj.event === "unlock"){
            var mid = data.mid;
            $.ajax({
                type:'post',
                url:getContextPath()+'/pages/back/member/MemberServlet/unlockStatus',
                data:{"mid":mid,"status":7},
                success: function (data) {
                    if (data == "success") {
                        layer.msg('解锁成功', {
                            time: 2000, icon: 1, end: function () {
                                location.reload();
                            }
                        })
                    } else {
                        layer.msg('解锁失败', {
                            time: 2000, icon: 2, end: function () {
                                location.reload();
                            }
                        })
                    }
                }
            })
        }
    });
    // if (status == "7"){
    //     document.getElementById( "lock" ).class = "layui-btn layui-btn-xs layui-btn-danger";
    //     document.getElementById( "lock" ).value="锁定账户";
    // }else{
    //     document.getElementById( "lock" ).class = "layui-btn layui-btn-xs layui-btn-primary";
    //     document.getElementById( "lock" ).value="解锁账户";
    //     document.getElementById( "lock" ).lay-event="update";
    // }
})

