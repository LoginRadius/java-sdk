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
public class ProviderAccessCredential {

    @SerializedName("AccessToken")
    public String accessToken;
    @SerializedName("TokenSecret")
    public String tokenSecret;
}
