package com.loginradius.sdk.models.register;

/**
 * Created by loginradius on 7/30/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("IsPosted")
    @Expose
    private Boolean isPosted;

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

}

