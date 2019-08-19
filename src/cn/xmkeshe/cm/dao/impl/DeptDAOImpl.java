package cn.xmkeshe.cm.dao.impl;

import cn.xmkeshe.cm.dao.IDeptDAO;
import cn.xmkeshe.cm.vo.Dept;
import cn.xmkeshe.utils.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DeptDAOImpl extends AbstractDAOImpl implements IDeptDAO {
    public DeptDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Dept vo) throws SQLException {
        String sql = "INSERT INTO dept(title,note)VALUES(?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Dept vo) throws SQLException {
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
    public List<Dept> findAll() throws SQLException {
        List<Dept> all = new ArrayList<Dept>();
        String sql = "SELECT did,title,note FROM dept";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Dept dept = new Dept();
            dept.setDid(rs.getInt(1));
            dept.setTitle(rs.getString(2));
            dept.setNote(rs.getString(3));
            all.add(dept);
        }
        return all;
    }

    @Override
    public Dept findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Dept> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        List<Dept> all= new ArrayList<Dept>();
        String sql = "SELECT did,title,note FROM dept LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, (currentPage -1) * lineSize); // 取得当期页面
        super.pstmt.setInt(2, lineSize); // 每页显示记录数
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Dept dept = new Dept();
            dept.setDid(rs.getInt(1));
            dept.setTitle(rs.getString(2));
            dept.setNote(rs.getString(3));
            all.add(dept);
        }
        return all;
    }

    @Override
    public Integer getAllCount() throws SQLException {
        String sql = "SELECT COUNT(did) FROM dept";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return  rs.getInt(1);
        }
        return 0;
    }

    @Override
    public List<Dept> findAllBySplit(String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String keyWords) throws SQLException {
        return null;
    }
}
