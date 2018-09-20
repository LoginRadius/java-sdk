package com.loginradius.sdk.models.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailOtpData {

	    @SerializedName("Profile")
	    @Expose
	    private Profile profile;
	    @SerializedName("access_token")
	    @Expose
	    private String accessToken;
	    @SerializedName("expires_in")
	    @Expose
	    private String expiresIn;
	    @SerializedName("Email")
	    @Expose
	    private String email;

	   

	    /**
	     *
	     * @return
	     * The profile
	     */
	    public Profile getProfile() {
	        return profile;
	    }

	    /**
	     *
	     * @param profile
	     * The Profile
	     */
	    public void setProfile(Profile profile) {
	        this.profile = profile;
	    }

	    /**
	     *
	     * @return
	     * The accessToken
	     */
	    public String getAccessToken() {
	        return accessToken;
	    }

	    /**
	     *
	     * @param accessToken
	     * The access_token
	     */
	    public void setAccessToken(String accessToken) {
	        this.accessToken = accessToken;
	    }

	    /**
	     *
	     * @return
	     * The expiresIn
	     */
	    public String getExpiresIn() {
	        return expiresIn;
	    }

	    /**
	     *
	     * @param expiresIn
	     * The expires_in
	     */
	    public void setExpiresIn(String expiresIn) {
	        this.expiresIn = expiresIn;
	    }
	    
	    
	    public String getEmail() {
		    return email;
	    }

	    public void setEmail(String email) {
		    this.email = email;
		}
	    
}
