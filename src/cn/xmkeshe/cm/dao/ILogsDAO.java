package cn.xmkeshe.cm.dao;

import cn.xmkeshe.cm.vo.Logs;
import cn.xmkeshe.utils.dao.IDAO;

import java.sql.SQLException;
import java.util.List;

public interface ILogsDAO extends IDAO<Integer, Logs> {
    /**
     * <li>实现数据分页显示
     * @param currentPage 表示当期页
     * @param lineSize 表示每页记录数
     * @return 查询成功返回数据行，查询失败返回null
     * @throws SQLException
     */
    public List<Logs> findAllBySplit(Integer currentPage, Integer lineSize, String mid)throws SQLException;
    /**
     * <li>实现数据量统计操作
     * @return 查询成功返回数据行记录，查询失败返回0
     * @throws SQLException
     */
    public Integer getAllCountByTitle(String mid)throws SQLException;
}
