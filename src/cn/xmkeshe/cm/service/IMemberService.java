package cn.xmkeshe.cm.service;

import cn.xmkeshe.cm.vo.Member;

import java.util.Map;

public interface IMemberService {
    /**
     * <li>实现用户登录检查的工作</li>
     * @param vo
     * @return
     * @throws Exception
     */
    public Map<String,Object> login(Member vo)throws Exception;
    public boolean insert(Member vo)throws Exception;
    public Map<String ,Object>listSplit(int currentPage,int lineSize)throws Exception;
    public boolean updataByPass(String mid,String password)throws Exception;//密码更新
    public boolean updateByStatus(String mid,Integer status)throws Exception;//账户锁定 status!=7 登录判断账户锁定

    public  Map<String, Object> listSplit(int currentPage, int lineSize, String title)throws Exception;


}
