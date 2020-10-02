package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;

public class EmailVerificationData<T> extends AccessTokenBase {

	@SerializedName("Profile")
	private T profile;

	@SerializedName("Email")
	private String email;

	/**
	 * user's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * user's profile data
	 */
	public T getProfile() {
		return profile;
	}

	/**
	 * user's profile data
	 */
	public void setProfile(T profile) {
		this.profile = profile;
	}
}
