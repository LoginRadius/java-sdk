
package com.loginradius.sdk.models.cloudstorage.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupLog {

    @SerializedName("IP")
    @Expose
    private Object iP;
    @SerializedName("UserAgent")
    @Expose
    private String userAgent;
    @SerializedName("Host")
    @Expose
    private Object host;

    public Object getIP() {
        return iP;
    }

    public void setIP(Object iP) {
        this.iP = iP;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Object getHost() {
        return host;
    }

    public void setHost(Object host) {
        this.host = host;
    }

}
