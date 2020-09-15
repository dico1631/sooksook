package com.lyj84.registeration;

/**
 * Created by lyj84 on 2018-04-29.
 */

public class Notice {

    String notice;
    String name;
    String date;

    public Notice(String notice, String name, String date) {
        this.notice = notice;
        this.name = name;
        this.date = date;
    }
    public String getNotice() {
        return notice;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }


    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
