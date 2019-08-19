package cn.xmkeshe.cm.service.Impl;

import cn.xmkeshe.cm.factory.DAOFactory;
import cn.xmkeshe.cm.service.IDeptService;
import cn.xmkeshe.cm.vo.Dept;

import cn.xmkeshe.utils.dbc.DatabaseConnection;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptServiceImpl implements IDeptService {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Dept vo) throws Exception {
        try {
            return DAOFactory.getIDeptDAOInstance(this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("allDept",
                    DAOFactory.getIDeptDAOInstance(this.dbc.getConn()).findAllBySplit(currentPage, lineSize));
            map.put("allCount", DAOFactory.getIDeptDAOInstance(this.dbc.getConn()).getAllCount());
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Dept> list() throws Exception {
        try {
            return DAOFactory.getIDeptDAOInstance(this.dbc.getConn()).findAll();
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

}
