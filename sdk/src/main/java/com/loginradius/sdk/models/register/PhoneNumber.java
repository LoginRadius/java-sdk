
package com.loginradius.sdk.models.register;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneNumber {

    @SerializedName("PhoneType")
    @Expose
    private String phoneType;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;

    /**
     * 
     * @return
     *     The phoneType
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * 
     * @param phoneType
     *     The PhoneType
     */
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * 
     * @return
     *     The phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber
     *     The PhoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
