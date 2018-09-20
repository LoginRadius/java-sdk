
package com.loginradius.sdk.models.cloudstorage.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileImageUrls {

    @SerializedName("Profile")
    @Expose
    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

}
