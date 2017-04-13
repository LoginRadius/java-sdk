package com.loginradius.sdk.models.userprofile;

/**
 * Created by loginradius on 9/27/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileImageUrls {

    @SerializedName("Profile")
    @Expose
    private String profile;

    /**
     * @return The profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile The Profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }
}
