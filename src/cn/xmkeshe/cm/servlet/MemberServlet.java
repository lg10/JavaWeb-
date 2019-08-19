package cn.xmkeshe.cm.servlet;
import cn.xmkeshe.cm.factory.*;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.md5.MD5Code;
import cn.xmkeshe.utils.servlet.DispatcherServlet;
import cn.xmkeshe.utils.validate.ValidateUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@SuppressWarnings("serial")
public class MemberServlet extends DispatcherServlet {
    public  void updatePassWord(){
        Member member = (Member) super.request.getSession().getAttribute("member");
        String mid = member.getMid(); //取得mid
        String password = super.request.getParameter("password");
        if (ValidateUtils.validateEmpty(mid)){
            //保存数据到对象中
            try {
                if (ServiceFactory.getIMemberServiceInstance().updataByPass(mid,new MD5Code().getMD5ofStr("{["+password+"]}"))) {
                    super.response.getWriter().print("success");
                } else {
                    super.response.getWriter().print("error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void listSplitByTitle(){
        Member member = (Member)super.request.getSession().getAttribute("member");
        String title = member.getTitle();
        try {
            super.request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        super.response.setCharacterEncoding("UTF-8");
        int currentPage = 1;
        int lineSize = 10;
        try {
            lineSize = Integer.parseInt(super.request.getParameter("limit"));
        } catch (Exception e) {}
        try {
            currentPage = Integer.parseInt(super.request.getParameter("page"));
        } catch (Exception e) {}
        try {
            Map<String, Object> map = ServiceFactory.getIMemberServiceInstance().listSplit(currentPage, lineSize,title);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", map.get("data"));
            map.put("count", map.get("count"));
            super.response.getWriter().print(JSONObject.toJSONString(map,SerializerFeature.WriteDateUseDateFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addByTitle(){
        String mid = super.request.getParameter("mid");
        String name = super.request.getParameter("name");
        String phone = super.request.getParameter("phone");
        Member member = (Member)super.request.getSession().getAttribute("member");
        String title = member.getTitle();
        //数据验证
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(name)
                &&ValidateUtils.validateEmpty(phone)){
            //保存数据到对象中
            Member vo = new Member();
            vo.setMid(mid);
            vo.setName(name);
            vo.setPassword(new MD5Code().getMD5ofStr("{[12345]}"));
            vo.setPhone(phone);
            vo.setFlag(2);//部门组员
            vo.setStatus(7);
            vo.setTitle(title);
            try {
                if (ServiceFactory.getIMemberServiceInstance().insert(vo)) {
                    super.response.getWriter().print("success");
                } else {
                    super.response.getWriter().print("error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void Status(){
        String mid = super.request.getParameter("mid");
        if (ValidateUtils.validateEmpty(mid)){
            //保存数据到对象中
            try {
                if (ServiceFactory.getIMemberServiceInstance().updateByStatus(mid,1)) {
                    super.response.getWriter().print("success");
                } else {
                    super.response.getWriter().print("error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void unlockStatus(){
        String mid = super.request.getParameter("mid");
        String status = super.request.getParameter("status");
        if (ValidateUtils.validateEmpty(mid)){
            //保存数据到对象中
            System.out.println(status);
                try {
                    if (ServiceFactory.getIMemberServiceInstance().updateByStatus(mid, Integer.parseInt(status))) {
                        super.response.getWriter().print("success");
                    } else {
                        super.response.getWriter().print("error");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void updataPass(){
        String mid = super.request.getParameter("mid");
        if (ValidateUtils.validateEmpty(mid)){
            //保存数据到对象中
            try {
                if (ServiceFactory.getIMemberServiceInstance().updataByPass(mid,new MD5Code().getMD5ofStr("{[54321]}"))) {
                    super.response.getWriter().print("success");
                } else {
                    super.response.getWriter().print("error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void listSplit(){
        try {
            super.request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        super.response.setCharacterEncoding("UTF-8");
        int currentPage = 1;
        int lineSize = 10;
        try {
            lineSize = Integer.parseInt(super.request.getParameter("limit"));
        } catch (Exception e) {}
        try {
            currentPage = Integer.parseInt(super.request.getParameter("page"));
        } catch (Exception e) {}
        try {
            Map<String, Object> map = ServiceFactory.getIMemberServiceInstance().listSplit(currentPage, lineSize);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", map.get("data"));
            map.put("count", map.get("count"));
            super.response.getWriter().print(JSONObject.toJSONString(map, SerializerFeature.WriteDateUseDateFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void add(){
        String mid = super.request.getParameter("mid");
        String name = super.request.getParameter("name");
        String phone = super.request.getParameter("phone");
        String title = super.request.getParameter("title");
        //数据验证
        if (ValidateUtils.validateEmpty(mid)&&ValidateUtils.validateEmpty(name)
                &&ValidateUtils.validateEmpty(phone)&&ValidateUtils.validateEmpty(title)){
            //保存数据到对象中
            Member vo = new Member();
            vo.setMid(mid);
            vo.setName(name);
            vo.setPassword(new MD5Code().getMD5ofStr("{[12345]}"));
            vo.setPhone(phone);
            vo.setFlag(1);
            vo.setStatus(7);
            vo.setTitle(title);
            try {
                if (ServiceFactory.getIMemberServiceInstance().insert(vo)) {
                    super.response.getWriter().print("success");
                } else {
                    super.response.getWriter().print("error");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                super.response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
