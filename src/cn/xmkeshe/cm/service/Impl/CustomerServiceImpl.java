package cn.xmkeshe.cm.service.Impl;

import cn.xmkeshe.cm.factory.DAOFactory;
import cn.xmkeshe.cm.service.ICustomerService;
import cn.xmkeshe.cm.vo.Customer;
import cn.xmkeshe.utils.dbc.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Customer vo) throws Exception {
        try {
            return DAOFactory.getICustomerDAOInstance(this.dbc.getConn()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize, String mid) throws Exception {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data",
                    DAOFactory.getICustomerDAOInstance(this.dbc.getConn()).findAllBySplit(currentPage, lineSize,mid));
            map.put("count", DAOFactory.getICustomerDAOInstance(this.dbc.getConn()).getAllCountByMid(mid));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Customer vo) throws Exception {
        try {
            return DAOFactory.getICustomerDAOInstance(this.dbc.getConn()).doUpdate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
