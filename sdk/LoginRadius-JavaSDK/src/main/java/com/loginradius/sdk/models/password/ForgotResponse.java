package com.loginradius.sdk.models.password;

/**
 * Created by loginradius on 7/31/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotResponse {

    @SerializedName("isPosted")
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

