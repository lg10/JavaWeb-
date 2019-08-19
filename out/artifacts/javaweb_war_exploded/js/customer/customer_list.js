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
        url:getContextPath()+'/pages/back/customer/CustomerServlet/listSplitByMid',
        page:true,
        limit:10,
        cols:[[
            {field:'name',title:'姓名',sort:true},
            {field:'phone',title:'电话',sort:true},
            {field:'address',title:'地址',sort:true},
            {field:'intention',title:'态度',sort:true},
            {field:'note',title:'进度',sort:true},
            {field:'type',title:'备注',sort:true},
            {field:'right',title:'操作',toolbar:'#barOption'},

        ]],
        done:function () {
            layer.close(index);
        }
    }),
    table.on('tool(listSplit)',function (obj) {
        var data = obj.data;
        if (obj.event === "edit"){
            layer.open({
                type:2,
                area:['600px','80%'],
                title:'客户信息更新',
                content:getContextPath()+'/pages/back/customer/customer_update.jsp',
                success:function (layero,index){
                    var body = layer.getChildFrame('body',index);
                    var iframWin = window[layero.find('iframe')[0]['name']];
                    body.find('.name').val(data.name);
                    body.find('.phone').val(data.phone);
                    body.find('.address').val(data.address);
                    body.find('option[value='+data.intention+']').attr('selected',true);
                    body.find('option[value='+data.note+']').attr('selected',true);
                    body.find('.note').val(data.type);
                    body.find('.cmid').val(data.cmid);

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

