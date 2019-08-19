package cn.xmkeshe.utils.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    //数据库连接信息
    private static final String DBDRIVER = ResourceBundle.getBundle("jdbc").getString("jdbc.driver");
    private static final String DBURL = ResourceBundle.getBundle("jdbc").getString("jdbc.url");
    private static final String DBUSER= ResourceBundle.getBundle("jdbc").getString("jdbc.user");
    private static final String DBPASSWORD = ResourceBundle.getBundle("jdbc").getString("jdbc.password");
    private Connection conn;
    //加载数据库信息
    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //连接数据库
    public Connection getConn(){
        return this.conn;
    }
    //判断数据库连接是否存在
    public void close(){
        if (this.conn != null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

