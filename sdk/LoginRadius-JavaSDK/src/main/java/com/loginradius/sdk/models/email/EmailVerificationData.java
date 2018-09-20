package com.loginradius.sdk.models.email;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.login.Profile;

public class EmailVerificationData {
	@SerializedName("Email")
	@Expose
	private String email;
	
	@SerializedName("Profile")
	@Expose
	private Profile profile;

	public String getEmail() {
	return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}
	
	
	public Profile getProfile() {
	return profile;
	}

	public void setProfile(Profile profile) {
	this.profile = profile;
	}
}
