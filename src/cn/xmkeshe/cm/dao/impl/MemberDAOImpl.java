package cn.xmkeshe.cm.dao.impl;

import cn.xmkeshe.cm.dao.IMemberDAO;
import cn.xmkeshe.cm.vo.Logs;
import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MemberDAOImpl extends AbstractDAOImpl implements IMemberDAO {

    public MemberDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Member vo) throws SQLException {
        String sql = "INSERT INTO member(mid,name,password,phone,flag,status,title)VALUES(?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getName());
        super.pstmt.setString(3, vo.getPassword());
        super.pstmt.setString(4,vo.getPhone());
        super.pstmt.setInt(5, vo.getFlag());
        super.pstmt.setInt(6, vo.getStatus());
        super.pstmt.setString(7, vo.getTitle());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Member vo) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean doRemove(String id) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean doRemoveBtch(Set<String> ids) throws SQLException {
        return false;
    }


    @Override
    public List<Member> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Member findById(String id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Member> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        List<Member> all= new ArrayList<Member>();
        String sql = "SELECT mid,name,phone,lastdate,title,password FROM member WHERE flag!=0 LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, (currentPage -1) * lineSize); // 取得当期页面
        super.pstmt.setInt(2, lineSize); // 每页显示记录数
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Member member = new Member();
            member.setMid(rs.getString(1));
            member.setName(rs.getString(2));
            member.setPhone(rs.getString(3));
            member.setLastdate(rs.getTimestamp(4));
            member.setTitle(rs.getString(5));
            member.setPassword(rs.getString(6));
            all.add(member);
        }
        return all;
    }

    @Override
    public Integer getAllCount() throws SQLException {
        String sql = "SELECT COUNT(mid) FROM member WHERE flag!=0 ";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public List<Member> findAllBySplit(String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String keyWord) throws SQLException {
        return null;
    }


    @Override
    public Member findLogin(Member vo) throws SQLException {
        Member member = new Member();
        String sql = "SELECT mid,name,phone,flag,title,status FROM member  WHERE mid=? AND password=?  ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            member.setMid(rs.getString(1));
            member.setName(rs.getString(2));
            member.setPhone(rs.getString(3));
            member.setFlag(rs.getInt(4));
            member.setTitle(rs.getString(5));
            member.setStatus(rs.getInt(6));
        }
        return member;
    }

    @Override
    public boolean doUpdateByPass(String mid, String password) throws SQLException {
        String sql = "UPDATE member SET password=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, password);
        super.pstmt.setString(2, mid);
        return super.pstmt.executeUpdate() > 0;
    }


    @Override
    public List<Member> findAllBySplit(Integer currentPage, Integer lineSize, String title) throws SQLException {
        List<Member> all= new ArrayList<Member>();
        String sql = "SELECT mid,name,phone,ip,lastdate,title FROM member WHERE title=? AND flag=2 LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, title);
        super.pstmt.setInt(2, (currentPage -1) * lineSize); // 取得当期页面
        super.pstmt.setInt(3, lineSize); // 每页显示记录数
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()) {
            Member member = new Member();
            member.setMid(rs.getString(1));
            member.setName(rs.getString(2));
            member.setPhone(rs.getString(3));
            member.setLastdate(rs.getTimestamp(4));
            member.setTitle(rs.getString(5));
            member.setIp(rs.getString(6));
            all.add(member);
        }
        return all;
    }

    @Override
    public Integer getAllCountByTitle(String title) throws SQLException {
        String sql = "SELECT COUNT(mid) FROM member WHERE title=? AND flag=2";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, title);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doUpdateByStatus(String mid, Integer status) throws SQLException {
        String sql = "UPDATE member SET status=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, status);
        super.pstmt.setString(2, mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdateByunlockStatus(String mid, Integer status) throws SQLException {
        String sql = "UPDATE member SET status=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, status);
        super.pstmt.setString(2, mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdateByLastdate(String mid, Date lastdate) throws SQLException {
        String sql = "UPDATE member SET lastdate=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setTimestamp(1,new Timestamp(lastdate.getTime()));
        super.pstmt.setString(2,mid);
        return super.pstmt.executeUpdate() > 0;
    }

}

