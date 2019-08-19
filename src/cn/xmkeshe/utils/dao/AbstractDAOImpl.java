package cn.xmkeshe.utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * <li>实现接口方法都可以在此编写</li>
 */
public class AbstractDAOImpl {
    public Connection conn;
    public PreparedStatement pstmt;
    public AbstractDAOImpl(Connection conn){
        this.conn=conn;
    }
}
