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
        url:getContextPath()+'/pages/back/logs/LogsServlet/listSplit',
        page:true,
        limit:10,
        cols:[[
            {field:'logid',title:'日志编号',sort:true},
            {field:'mid',title:'用户工号',templet:'<div>{{d.member ? d.member.mid : ""}}</div>'},
            {field:'logdate',title:'上次登录时间'},
            {field:'ip',title:'ip地址'},


        ]],
        done:function () {
            layer.close(index);
        },
        id:"testReload"
    });
        active={
        reload:function () {
            var demoReload = $("#demoReload");
            table.reload('testReload',{
                page:{
                    curr:1
                },where: {
                    kw :demoReload.val()
                }
            })
        }
    }
    $(".demoTable .layui-btn").on('click',function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this):'';
    })
});

