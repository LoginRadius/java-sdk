package com.loginradius.sdk.models.email;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile;

public class EmailVerificationData {
	@SerializedName("Email")
	@Expose
	private String email;
	
	@SerializedName("Profile")
	@Expose
	private LoginRadiusUltimateUserProfile profile;

	public String getEmail() {
	return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}
	
	
	public LoginRadiusUltimateUserProfile getProfile() {
	return profile;
	}

	public void setProfile(LoginRadiusUltimateUserProfile profile) {
	this.profile = profile;
	}
}
