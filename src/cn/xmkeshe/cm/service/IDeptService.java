package cn.xmkeshe.cm.service;

import cn.xmkeshe.cm.vo.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptService {
    /**
     * <li>增加数据</li>
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean insert(Dept vo)throws Exception;

    /**
     * <li>实现数据分页操作</li>
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
    public Map<String,Object> listSplit(int currentPage,int lineSize)throws Exception;
    /**
     * <li>取得表中的全部数据
     * @return
     * @throws Exception
     */
    public List<Dept> list()throws Exception;
}
