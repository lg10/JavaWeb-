package cn.xmkeshe.cm.service;

import cn.xmkeshe.cm.vo.Customer;

import java.util.Map;

public interface ICustomerService{
    public boolean insert(Customer vo)throws Exception;
    public Map<String, Object> listSplit(int currentPage, int lineSize, String mid)throws Exception;
    public boolean update(Customer vo)throws Exception;
}
