package cn.xmkeshe.utils.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * <li>此接口中定义常用方法</li>
 * @param <K>表示对象逐渐类型
 * @param <V>表示对象
 */
public interface IDAO<K, V> {
    /**
     * <li>实现数据增加功能</li>
     * @param vo 表示要执行的操作对象
     * @return 增加成功返回true，增加失败返回false
     * @throws SQLException
     */
    public boolean doCreate(V vo)throws SQLException;

    /**
     *
     * <li>实现对象数据更新操作方法</li>
     * @param vo 表示要执行的更新的对象数据
     * @return 更新成功返回true 更新失败返回false
     * @throws SQLException
     */
    public boolean doUpdate(V vo)throws SQLException;

    /**
     * <li>根据编号删除数据行中的记录</li>
     * @param id 变化四会要执行删除的数据编号
     * @return 删除成功返回true 删除失败返回flase
     * @throws SQLException
     */
    public boolean doRemove(K id)throws SQLException;

    /**
     * <li>实现批量删除功能</li>
     * @param ids 表示要执行删除的集合数据
     * @return 删除成功返回true 删除失败返回flase
     * @throws SQLException
     */
    public boolean doRemoveBtch(Set<K> ids)throws SQLException;

    /**
     * <li>查询全部数据行的记录</li>
     * @return 查询成功返回全部记录，查询失败返回null
     * @throws SQLException
     */
    public List<V> findAll()throws SQLException;

    /**
     * <li>根据编号查询数据行</li>
     * @param id 表示要执行查询的数据行
     * @return 查询成功返回该记录行，查询失败返回null
     * @throws SQLException
     */
    public V findById(K id)throws SQLException;

    /**
     * <li>实现分页显示</li>
     * @param currentPage 表示当前页
     * @param lineSize 表示每页记录数
     * @return 查询成功返回数据行，查询失败返回null
     * @throws SQLException
     */
    public List<V> findAllBySplit(Integer currentPage,Integer lineSize)throws SQLException;

    /**
     * <li>实现数据量统计操作</li>
     * @return 查询成功返回数据行记录，查询失败返回0
     * @throws SQLException
     */
    public Integer getAllCount()throws SQLException;

    /**
     * <li>实现模糊查询分页</li>
     * @param keyWord 要查询的关键字
     * @param currentPage 表示当前页
     * @param lineSize 表示每一页显示记录数
     * @return
     * @throws SQLException
     */
    public List<V> findAllBySplit(String keyWord,Integer currentPage,Integer lineSize)throws SQLException;

    /**
     * <li>实现数据量统计操作</li>String column,String keyWord
     * @return 查询成功返回数据行记录，查询失败返回0
     * @throws SQLException
     */
    public Integer getAllCount(String keyWords)throws SQLException;
}
