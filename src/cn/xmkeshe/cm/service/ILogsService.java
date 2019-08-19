package cn.xmkeshe.cm.service;

import java.util.Map;

public interface ILogsService {
    public Map<String, Object> listSplit(int currentPage, int lineSize, String mid)throws Exception;
}
