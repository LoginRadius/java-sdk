package com.loginradius.sdk.models.phone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by loginradius on 8/26/2016.
 */
public class PhoneResponse {

    @SerializedName("isPosted")
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
