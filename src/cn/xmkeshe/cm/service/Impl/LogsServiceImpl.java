package cn.xmkeshe.cm.service.Impl;

import cn.xmkeshe.cm.factory.DAOFactory;
import cn.xmkeshe.cm.service.ILogsService;
import cn.xmkeshe.utils.dbc.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class LogsServiceImpl implements ILogsService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public Map<String, Object> listSplit(int currentPage, int lineSize, String mid) throws Exception {
        try {
            Map<java.lang.String, java.lang.Object> map = new HashMap<String, Object>();
            map.put("data",
                    DAOFactory.getILogsDAOInstance(this.dbc.getConn()).findAllBySplit(currentPage, lineSize,mid));
            map.put("count", DAOFactory.getILogsDAOInstance(this.dbc.getConn()).getAllCountByTitle(mid));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
