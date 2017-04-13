package com.loginradius.sdk.models.group;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusGroup {

    @SerializedName("ID")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Email")
    public String email;
    @SerializedName("Description")
    public String description;
    @SerializedName("Type")
    public String type;
    @SerializedName("Country")
    public String country;
    @SerializedName("Logo")
    public String logo;
    @SerializedName("Image")
    public String image;
    @SerializedName("MemberCount")
    public String memberCount;
    
}
