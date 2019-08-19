package cn.xmkeshe.cm.servlet;

import cn.xmkeshe.cm.factory.ServiceFactory;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.md5.MD5Code;
import cn.xmkeshe.utils.servlet.DispatcherServlet;
import cn.xmkeshe.utils.validate.ValidateUtils;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

@SuppressWarnings("serial")
public class MemberLoginServlet extends DispatcherServlet {
    public  void logOut(){
        super.request.getSession().invalidate(); //让session失效
        try {
            super.request.getRequestDispatcher("/login.jsp").forward(super.request,super.response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login() {
        // 接收表单参数
        String mid = super.request.getParameter("mid");
        String password = super.request.getParameter("password");
        // 数据验证
        if (ValidateUtils.validateEmpty(mid) && ValidateUtils.validateEmpty(password)) {  //判断true
            // 将数据保存在对象之中
            Member vo = new Member();
            vo.setMid(mid);
            vo.setPassword(new MD5Code().getMD5ofStr("{[" + password + "]}")); // 加盐处理
            vo.setIp(super.request.getRemoteAddr());//取得IP地址
            System.out.println(vo.getPassword()+"***");
            try {
                Map<String, Object> map = ServiceFactory.getIMemberServiceInstance().login(vo);
                Member member = (Member) map.get("member");

                if (member.getMid() != null) {
                    System.out.println(member.getStatus()+"______");
                    if (member.getStatus() == 7) {
                        super.request.getSession().setAttribute("member",  map.get("member")); //保存对象数据
                        super.response.getWriter().print("success");
                    } else {
                        super.response.getWriter().print("lock");
                    }
                } else {
                    super.response.getWriter().print("error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
