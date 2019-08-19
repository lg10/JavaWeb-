package cn.xmkeshe.cm.servlet;

import cn.xmkeshe.cm.factory.ServiceFactory;
import cn.xmkeshe.cm.vo.Dept;
import cn.xmkeshe.utils.servlet.DispatcherServlet;
import cn.xmkeshe.utils.validate.ValidateUtils;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class DeptServlet extends DispatcherServlet {
    public void list(){
        try {
            super.request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        super.response.setCharacterEncoding("UTF-8");
        try {
            List<Dept> all = ServiceFactory.getIDeptServiceInstance().list();
            super.response.getWriter().print(JSONObject.toJSONString(all));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listSplitone() {
        // 编码过滤器
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
            Map<String, Object> map = ServiceFactory.getIDeptServiceInstance().listSplit(currentPage, lineSize);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", map.get("allDept"));
            map.put("count", map.get("allCount"));
            super.response.getWriter().print(JSONObject.toJSONString(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void add(){
        //接收参数
        String title = super.request.getParameter("title");
        String note = super.request.getParameter("note");
        //数据验证
        if (ValidateUtils.validateEmpty(title) && ValidateUtils.validateEmpty(note)){
            Dept dept = new Dept();
            dept.setTitle(title);
            dept.setNote(note);
            try {
                if (ServiceFactory.getIDeptServiceInstance().insert(dept)) {//数据增加成功
                    super.response.getWriter().print("success");
                } else {//数据增加失败
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
