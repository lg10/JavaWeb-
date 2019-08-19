function getContextPath() {
    var contextPath = document.location.pathname;
    var index = contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0, index + 1);
    delete index;
    return contextPath;
}

layui.use(['table','layer'],function () {
    var table = layui.table;
    index = layer.load(1);
    table.render({
        elem:'.layui-table',
        url:getContextPath()+'/pages/back/dept/DeptServlet/listSplitone',
        page:true,
        limit:10,
        cols:[[
            {field:'did',title:'编号',sort:true},
            {field:'title',title:'部门名称',sort:true},
            {field:'note',title:'部门描述',sort:true},
        ]],
        done:function () {
            layer.close(index);
        }
    })
})