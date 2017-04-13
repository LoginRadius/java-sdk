package com.loginradius.sdk.models.phone;

/**
 * Created by loginradius on 8/11/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PhoneForgotPasswordData {

    @SerializedName("AccountSid")
    @Expose
    private String accountSid;
    @SerializedName("Sid")
    @Expose
    private String sid;

    /**
     *
     * @return
     * The accountSid
     */
    public String getAccountSid() {
        return accountSid;
    }

    /**
     *
     * @param accountSid
     * The AccountSid
     */
    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     *
     * @return
     * The sid
     */
    public String getSid() {
        return sid;
    }

    /**
     *
     * @param sid
     * The Sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

}


