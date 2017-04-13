package com.loginradius.sdk.models.phone;

/**
 * Created by loginradius on 8/11/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PhoneForgotPasswordResponse {

    @SerializedName("IsPosted")
    @Expose
    private Boolean isPosted;
    @SerializedName("data")
    @Expose
    private PhoneForgotPasswordData data;

    /**
     *
     * @return
     * The isPosted
     */
    public Boolean getIsPosted() {
        return isPosted;
    }

    /**
     *
     * @param isPosted
     * The isPosted
     */
    public void setIsPosted(Boolean isPosted) {
        this.isPosted = isPosted;
    }

    /**
     *
     * @return
     * The data
     */
    public PhoneForgotPasswordData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(PhoneForgotPasswordData data) {
        this.data = data;
    }

}