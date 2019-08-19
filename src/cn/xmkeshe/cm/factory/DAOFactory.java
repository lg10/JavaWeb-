package cn.xmkeshe.cm.factory;

import cn.xmkeshe.cm.dao.ICustomerDAO;
import cn.xmkeshe.cm.dao.IDeptDAO;
import cn.xmkeshe.cm.dao.ILogsDAO;
import cn.xmkeshe.cm.dao.IMemberDAO;
import cn.xmkeshe.cm.dao.impl.CustomerDAOImpl;
import cn.xmkeshe.cm.dao.impl.DeptDAOImpl;
import cn.xmkeshe.cm.dao.impl.LogsDAOImpl;
import cn.xmkeshe.cm.dao.impl.MemberDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public  static IMemberDAO getIMemberDAOInstance(Connection conn){
        return new MemberDAOImpl(conn);
    }

    public  static IDeptDAO getIDeptDAOInstance(Connection conn){
        return new DeptDAOImpl(conn);
    }

    public  static ICustomerDAO getICustomerDAOInstance(Connection conn){
        return new CustomerDAOImpl(conn);
    }

    public  static ILogsDAO getILogsDAOInstance(Connection conn){
        return new LogsDAOImpl(conn);
    }
}
