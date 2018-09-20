package com.loginradius.sdk.models.register;


/**
 * Created by loginradius on 7/30/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.login.LoginData;


public class RegisterResponse {

    @SerializedName("IsPosted")
    @Expose
    private Boolean isPosted;

    @SerializedName("Data")
	public LoginData data;
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
    
    
    public LoginData getData() {
        return data;
    }

    /**
     *
     * @param profile
     * The Profile
     */
    public void setData(LoginData data) {
        this.data = data;
    }


}

