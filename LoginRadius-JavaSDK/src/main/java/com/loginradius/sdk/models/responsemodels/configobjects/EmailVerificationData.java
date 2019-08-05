package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;

public class EmailVerificationData<T> extends AccessTokenBase {

	@SerializedName("Profile")
	private T profile;

	@SerializedName("Email")
	private String email;

	/// <summary>
	/// user's email
	/// </summary>
	public String getEmail() {
		return email;
	}

	/// <summary>
	/// user's email
	/// </summary>
	public void setEmail(String email) {
		this.email = email;
	}

	/// <summary>
	/// user's profile data
	/// </summary>
	public T getProfile() {
		return profile;
	}

	/// <summary>
	/// user's profile data
	/// </summary>
	public void setProfile(T profile) {
		this.profile = profile;
	}
}
