package com.loginradius.sdk.social.models.contact;

import com.google.gson.annotations.*;

public class LoginRadiusContact {

	@SerializedName("Name")
    public String name;
    @SerializedName("EmailID")
    public String emailId;
    @SerializedName("PhoneNumber")
    public String phoneNumber;
    @SerializedName("ID")
    public String id;
    @SerializedName("ProfileUrl")
    public String profileUrl;
    @SerializedName("ImageUrl")
    public String imageUrl;
    @SerializedName("Status")
    public String status;
    @SerializedName("Industry")
    public String industry;
    @SerializedName("Country")
    public String country;
    @SerializedName("Gender")
    public String gender;
    @SerializedName("DateOfBirth")
    public String DateOfBirth;
}
