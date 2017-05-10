package com.loginradius.sdk.models.two_factor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.login.Profile;
public class TwoFactorLogin {

	@SerializedName("SecondFactorAuthentication")
	@Expose
	private SecondFactorAuthentication secondFactorAuthentication;
	@SerializedName("Profile")
	@Expose
	private Profile profile;
	@SerializedName("access_token")
	@Expose
	private String accessToken;
	@SerializedName("expires_in")
	@Expose
	private String expiresIn;

	public SecondFactorAuthentication getSecondFactorAuthentication() {
	return secondFactorAuthentication;
	}

	public void setSecondFactorAuthentication(SecondFactorAuthentication secondFactorAuthentication) {
	this.secondFactorAuthentication = secondFactorAuthentication;
	}

	 public Profile getProfile() {
	        return profile;
	 }

	public void setProfile(Profile profile) {
	        this.profile = profile;
	 }
	public String getAccessToken() {
	return accessToken;
	}

	public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
	}

	public String getExpiresIn() {
	return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
	this.expiresIn = expiresIn;
	}
}
