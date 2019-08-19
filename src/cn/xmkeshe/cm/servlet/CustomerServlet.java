package cn.xmkeshe.cm.servlet;

import cn.xmkeshe.cm.factory.ServiceFactory;
import cn.xmkeshe.cm.vo.Customer;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.servlet.DispatcherServlet;
import cn.xmkeshe.utils.validate.ValidateUtils;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class CustomerServlet extends DispatcherServlet {
    public  void update(){
        String cmid = super.request.getParameter("cmid");
        String name = super.request.getParameter("name");
        String phone = super.request.getParameter("phone");
        String address = super.request.getParameter("address");
        String intention = super.request.getParameter("intention");
        String note = super.request.getParameter("note");
        String type= super.request.getParameter("type");
        System.out.println(cmid+","+name+","+phone+","+address+","+intention+","+note+","+type);
        if (ValidateUtils.validateEmpty(name)&&ValidateUtils.validateEmpty(phone)&&ValidateUtils.validateEmpty(cmid)&&
                ValidateUtils.validateEmpty(address)&&ValidateUtils.validateEmpty(intention)&&
                ValidateUtils.validateEmpty(note)&&ValidateUtils.validateEmpty(type)){
            Customer vo = new Customer();
            vo.setName(name);
            vo.setAddress(address);
            vo.setNote(note);
            vo.setPhone(phone);
            vo.setType(type);
            vo.setIntention(intention);
            vo.setCmid(Integer.parseInt(cmid));
            try{
                if (ServiceFactory.getICustomerServiceInstance().update(vo)){
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
    public  void listSplitByMid(){
        Member member = (Member)super.request.getSession().getAttribute("member");
        String mid = member.getMid();//取得登录成功的用户编号
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
            Map<String, Object> map = ServiceFactory.getICustomerServiceInstance().listSplit(currentPage, lineSize,mid);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", map.get("data"));
            map.put("count", map.get("count"));
            super.response.getWriter().print(JSONObject.toJSONString(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void add(){
        Member member = (Member) super.request.getSession().getAttribute("member"); //取得当前登录用户id信息
        //System.out.println(member.getMid()+88888);
        String name = super.request.getParameter("name");
        String phone = super.request.getParameter("phone");
        String address = super.request.getParameter("address");
        String intention = super.request.getParameter("intention");
        String note = super.request.getParameter("note");
        String type= super.request.getParameter("type");
        if (ValidateUtils.validateEmpty(name)&&ValidateUtils.validateEmpty(phone)&&
                ValidateUtils.validateEmpty(address)&&ValidateUtils.validateEmpty(intention)&&
                ValidateUtils.validateEmpty(note)&&ValidateUtils.validateEmpty(type)){
            Customer vo = new Customer();
            Member mem = new Member();
            mem.setMid(member.getMid());
            vo.setMember(mem);  //取得mid
            vo.setName(name);
            vo.setAddress(address);
            vo.setNote(note);
            vo.setPhone(phone);
            vo.setType(type);
            vo.setIntention(intention);
            try{
                if (ServiceFactory.getICustomerServiceInstance().insert(vo)){
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
