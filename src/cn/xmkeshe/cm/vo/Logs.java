package cn.xmkeshe.cm.vo;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {
    private Integer logid;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public Date getLogdate() {
        return logdate;
    }

    public void setLogdate(Date logdata) {
        this.logdate = logdata;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    private Date logdate;
    private  String ip;
    private  Member member;//mid
}
