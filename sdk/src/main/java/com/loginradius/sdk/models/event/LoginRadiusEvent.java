package com.loginradius.sdk.models.event;

import com.google.gson.annotations.*;

public class LoginRadiusEvent {

    @SerializedName("ID")
    public String id;
    @SerializedName("OwnerId")
    public String ownerId;
    @SerializedName("OwnerName")
    public String ownerName;
    @SerializedName("Name")
    public String name;
    @SerializedName("Description")
    public String description;
    @SerializedName("RsvpStatus")
    public String rsvpStatus;
    @SerializedName("Location")
    public String location;
    @SerializedName("StartTime")
    public String startTime;
    @SerializedName("UpdatedDate")
    public String updatedDate;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("Privacy")
    public String privacy;
   
  
}
