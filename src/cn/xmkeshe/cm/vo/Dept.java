package cn.xmkeshe.cm.vo;

import java.io.Serializable;

public class Dept implements Serializable {
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private  Integer did;
    private String title, note;
}
