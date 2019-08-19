function getContextPath() {
    var contextPath = document.location.pathname;
    var index = contextPath.substr(1).indexOf("/");
    contextPath = contextPath.substr(0, index + 1);
    delete index;
    return contextPath;
}
layui.define(['element'],function(exports){
    var $ = layui.$;
    $('.input-field').on('change',function(){
        var $this = $(this),
            value = $.trim($this.val()),
            $parent = $this.parent();

        if(value !== '' && !$parent.hasClass('field-focus')){
            $parent.addClass('field-focus');
        }else{
            $parent.removeClass('field-focus');
        }
    })
    exports('login');
});
layui.use(['form','jquery','layer'],function(){
    var form  = layui.form,
        $ = layui.$,
        layer = layui.layer;
    form.on('submit(submitBtn)',function(obj){
        $.ajax({
            url:getContextPath()+'/MemberLoginServlet/login',
            type:'POST',
            data:$(".layui-form").serialize(), // 取得表单的所有数据内容
            success:function(data){
                // alert(data);
                if(data =="success"){
                    layer.msg('用户登录成功',{time:100,icon:1,end:function(){
                        location.href=getContextPath()+"/pages/back/index.jsp";
                        }})
                }else if (data == "lock") {
                    layer.msg('用户账号被锁定',{time:2000,icon:2})
                }else{
                    layer.msg('用户登录失败',{time:2000,icon:2})
                }
            }
        });
    });
})