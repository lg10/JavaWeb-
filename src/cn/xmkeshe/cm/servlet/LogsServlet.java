package cn.xmkeshe.cm.servlet;

import cn.xmkeshe.cm.factory.ServiceFactory;
import cn.xmkeshe.utils.servlet.DispatcherServlet;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class LogsServlet extends DispatcherServlet {
    public void listSplit(){
        try {
            super.request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        super.response.setCharacterEncoding("UTF-8");
        int currentPage = 1;
        int lineSize = 10;
        String KeyWord = "";
        KeyWord = super.request.getParameter("kw");
        if(KeyWord == null){
            KeyWord = "";
        }
        try {
            lineSize = Integer.parseInt(super.request.getParameter("limit"));
        } catch (Exception e) {}
        try {
            currentPage = Integer.parseInt(super.request.getParameter("page"));
        } catch (Exception e) {}
        try {
            Map<String, Object> map = ServiceFactory.getILogsServiceInstance().listSplit(currentPage, lineSize,KeyWord);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", map.get("data"));
            map.put("count", map.get("count"));
            super.response.getWriter().print(JSONObject.toJSONString(map, SerializerFeature.WriteDateUseDateFormat));//时间转换为可识别，json中的方法SerializerFeature.WriteDateUseDateFormat
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
