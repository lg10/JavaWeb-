package cn.xmkeshe.cm.dao;

import cn.xmkeshe.cm.vo.Member;
import cn.xmkeshe.utils.dao.IDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IMemberDAO extends IDAO<String, Member> {
    /**
     * <li> 实现用户登录的方法
     * @param vo 表示要操作的数据
     * @return 登录成功返回对象中的数据，失败返回null
     * @throws SQLException
     */
    public Member findLogin(Member vo)throws SQLException;
    /**
     *     <li>更新密码
     * @param mid
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByPass(String mid,String password)throws SQLException;
    /**
     * <li>实现数据分页显示
     * @param currentPage 表示当期页
     * @param lineSize 表示每页记录数
     * @return 查询成功返回数据行，查询失败返回null
     * @throws SQLException
     */
    public List<Member> findAllBySplit(Integer currentPage, Integer lineSize, String title)throws SQLException;
    /**
     * <li>实现数据量统计操作
     * @return 查询成功返回数据行记录，查询失败返回0
     * @throws SQLException
     */
    public Integer getAllCountByTitle(String title)throws SQLException;
    /**
     *     <li>账户注销
     * @param mid
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByStatus(String mid,Integer status)throws SQLException;

    /**
     *     <li>账户解锁
     * @param mid
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByunlockStatus(String mid,Integer status)throws SQLException;

    public boolean doUpdateByLastdate(String mid, Date lastdate)throws SQLException;

}
