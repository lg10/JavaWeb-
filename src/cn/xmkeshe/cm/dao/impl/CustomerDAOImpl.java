package cn.xmkeshe.cm.dao.impl;

import cn.xmkeshe.cm.dao.ICustomerDAO;
import cn.xmkeshe.cm.vo.Customer;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomerDAOImpl extends AbstractDAOImpl implements ICustomerDAO {

    public CustomerDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Customer vo) throws SQLException {
        String sql = "INSERT INTO customer(mid,name,phone,address,intention,type,note) VALUES(?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getMember().getMid());
        super.pstmt.setString(2,vo.getName());
        super.pstmt.setString(3,vo.getPhone());
        super.pstmt.setString(4,vo.getAddress());
        super.pstmt.setString(5,vo.getIntention());
        super.pstmt.setString(6,vo.getType());
        super.pstmt.setString(7,vo.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Customer vo) throws SQLException {
        String sql = "UPDATE customer SET name=?,phone=?,address=?,intention=?,type=?,note=? WHERE cmid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getName());
        super.pstmt.setString(2,vo.getPhone());
        super.pstmt.setString(3,vo.getAddress());
        super.pstmt.setString(4,vo.getIntention());
        super.pstmt.setString(5,vo.getType());
        super.pstmt.setString(6,vo.getNote());
        super.pstmt.setInt(7,vo.getCmid());
        return super.pstmt.executeUpdate() > 0;
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
    public List<Customer> findAll() throws SQLException {
        return null;
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findAllBySplit(String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String keyWords) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findAllBySplit(Integer currentPage, Integer lineSize, String mid) throws SQLException {
        List<Customer> all= new ArrayList<Customer>();
        String sql = "SELECT cmid,name,phone,address,intention,type,note FROM customer WHERE mid=? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        super.pstmt.setInt(2, (currentPage -1) * lineSize); // 取得当期页面
        super.pstmt.setInt(3, lineSize); // 每页显示记录数
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Customer vo = new Customer();
            vo.setCmid(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setPhone(rs.getString(3));
            vo.setAddress(rs.getString(4));
            vo.setIntention(rs.getString(5));
            vo.setNote(rs.getString(6));
            vo.setType(rs.getString(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCountByMid(String mid) throws SQLException {
        String sql = "SELECT COUNT(cmid) FROM customer WHERE mid=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
