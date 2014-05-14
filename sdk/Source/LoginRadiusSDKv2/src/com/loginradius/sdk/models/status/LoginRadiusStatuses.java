package com.loginradius.sdk.models.status;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusStatuses {

    @SerializedName("ID")
    public String id;
    @SerializedName("Text")
    public String text;
    @SerializedName("DateTime")
    public String dateTime;
    @SerializedName("Likes")
    public int likes;
    @SerializedName("Place")
    public String place;
    @SerializedName("Source")
    public String source;
    @SerializedName("ImageUrl")
    public String imageUrl;
    @SerializedName("LinkUrl")
    public String linkUrl;
    @SerializedName("Name")
    public String name;
}
