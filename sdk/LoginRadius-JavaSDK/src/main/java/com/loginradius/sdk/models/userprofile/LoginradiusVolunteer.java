/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loginradius.sdk.models.userprofile;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Administrator
 */
public class LoginradiusVolunteer {

    @SerializedName("Id")
    public String id;
    @SerializedName("Role")
    public String role;
    @SerializedName("Organization")
    public String organization;
    @SerializedName("Cause")
    public String cause;
}
