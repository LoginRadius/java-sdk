package com.loginradius.sdk.models.userprofile;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusPhoneNumber {

    @SerializedName("PhoneType")
    public String phoneType;
    @SerializedName("PhoneNumber")
    public String phoneNumber;
}
