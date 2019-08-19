package cn.xmkeshe.cm.service.Impl;

import cn.xmkeshe.cm.factory.ServiceFactory;
import cn.xmkeshe.cm.vo.Logs;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.dbc.DatabaseConnection;
import cn.xmkeshe.cm.factory.DAOFactory;
import cn.xmkeshe.cm.service.IMemberService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MemberServiceImpl implements IMemberService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public Map<String,Object> login(Member vo) throws Exception {
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            Member member = DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findLogin(vo);
            if (member.getMid() != null){  //登陆成功
                Date date = new Date();  //设置当前日期
                if (DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doUpdateByLastdate(member.getMid(),date)){
                    Logs logs = new Logs();
                    member.setMid(member.getMid());
                    logs.setMember(member);
                    logs.setIp(vo.getIp());
                    logs.setLogdate(date);
                    if (DAOFactory.getILogsDAOInstance(this.dbc.getConn()).doCreate(logs)){
                        map.put("member",member);
                    }else{
                        map.put("member",null);
                    }
                }else {
                    map.put("member",null);
                }
            }
            map.put("member",member);
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean insert(Member vo) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }


    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("data",
                    DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findAllBySplit(currentPage,lineSize));
            map.put("count",DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).getAllCount());
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updataByPass(String mid, String password) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doUpdateByPass(mid, password);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateByStatus(String mid, Integer status) throws Exception {
        try {
            return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doUpdateByStatus(mid, status);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize, String title) throws Exception {
        try {
            Map<java.lang.String, java.lang.Object> map = new HashMap<java.lang.String, java.lang.Object>();
            map.put("data",
                    DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findAllBySplit(currentPage, lineSize,title));
            map.put("count", DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).getAllCountByTitle(title));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

}
