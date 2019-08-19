package cn.xmkeshe.cm.dao.impl;

import cn.xmkeshe.cm.dao.ILogsDAO;
import cn.xmkeshe.cm.vo.Logs;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.dao.AbstractDAOImpl;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LogsDAOImpl extends AbstractDAOImpl implements ILogsDAO {
    public LogsDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Logs vo) throws SQLException {
        String sql = "INSERT INTO logs(mid,logdate,ip)VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getMember().getMid());
        super.pstmt.setTimestamp(2,new Timestamp(vo.getLogdate().getTime()));
        super.pstmt.setString(3,vo.getIp());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Logs vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Integer id) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemoveBtch(Set<Integer> ids) throws SQLException {
        return false;
    }

    @Override
    public List<Logs> findAll() throws SQLException {
        return null;
    }

    @Override
    public Logs findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Logs> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount() throws SQLException {
        return null;
    }

    @Override
    public List<Logs> findAllBySplit(String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String keyWords) throws SQLException {
        return null;
    }

    @Override
    public List<Logs> findAllBySplit(Integer currentPage, Integer lineSize, String mid) throws SQLException {
        List<Logs> all= new ArrayList<Logs>();
        String sql = "SELECT logid,mid,logdate,ip  FROM logs WHERE mid LIKE ?  LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%"+mid+"%");
        super.pstmt.setInt(2, (currentPage -1) * lineSize); // 取得当期页面
        super.pstmt.setInt(3, lineSize); // 每页显示记录数
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Logs logs = new Logs();
            logs.setLogid(rs.getInt(1));
            Member member = new Member();
            member.setMid(rs.getString(2));
            logs.setMember(member);
            logs.setLogdate(rs.getTimestamp(3));
            logs.setIp(rs.getString(4));
            all.add(logs);
        }
        return all;
    }

    @Override
    public Integer getAllCountByTitle(String mid) throws SQLException {
        String sql = "SELECT COUNT(logid) FROM logs WHERE mid LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%"+mid+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
