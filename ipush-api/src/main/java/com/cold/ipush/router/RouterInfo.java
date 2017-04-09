package com.cold.ipush.router;

/**
 * Created by faker on 2017/4/8.
 */
public class RouterInfo {

    private String ip;
    private String os;
    private String clientVer;

    public RouterInfo(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getClientVer() {
        return clientVer;
    }

    public void setClientVer(String clientVer) {
        this.clientVer = clientVer;
    }
}
