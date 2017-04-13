package com.loginradius.sdk.models.login;

/**
 * Created by loginradius on 7/30/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Email {

    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Value")
    @Expose
    private String value;

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The Value
     */
    public void setValue(String value) {
        this.value = value;
    }

}