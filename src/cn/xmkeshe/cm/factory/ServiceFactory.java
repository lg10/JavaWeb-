package cn.xmkeshe.cm.factory;


import cn.xmkeshe.cm.service.ICustomerService;
import cn.xmkeshe.cm.service.IDeptService;
import cn.xmkeshe.cm.service.ILogsService;
import cn.xmkeshe.cm.service.IMemberService;
import cn.xmkeshe.cm.service.Impl.CustomerServiceImpl;
import cn.xmkeshe.cm.service.Impl.DeptServiceImpl;
import cn.xmkeshe.cm.service.Impl.LogsServiceImpl;
import cn.xmkeshe.cm.service.Impl.MemberServiceImpl;

public class ServiceFactory {
    public  static IMemberService getIMemberServiceInstance(){
        return new MemberServiceImpl();
    }

    public  static IDeptService getIDeptServiceInstance(){
        return new DeptServiceImpl();
    }

    public  static ICustomerService getICustomerServiceInstance(){
        return new CustomerServiceImpl();
    }

    public  static ILogsService getILogsServiceInstance(){
        return new LogsServiceImpl();
    }
}
