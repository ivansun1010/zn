package com.iat.zn.show.domain;

/**
 * Created by cnbjpuhui-384 on 2016/4/4.
 */
public class WinInfo implements Comparable<WinInfo> {
    private String winName;
    private String userName;
    private int watchNum;
    private String watchUrl;
    private String picUrl;

    public String getWinName() {
        return winName;
    }

    public void setWinName(String winName) {
        this.winName = winName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(int watchNum) {
        this.watchNum = watchNum;
    }

    public String getWatchUrl() {
        return watchUrl;
    }

    public void setWatchUrl(String watchUrl) {
        this.watchUrl = watchUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public int compareTo(WinInfo o) {
        return o.getWatchNum() - this.watchNum;
    }
}
