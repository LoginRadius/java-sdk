package com.loginradius.sdk.models.userprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebProfiles {
	@SerializedName("Small")
	@Expose
	private String small;
	@SerializedName("Square")
	@Expose
	private String square;
	@SerializedName("Large")
	@Expose
	private String large;
	@SerializedName("Profile")
	@Expose
	private String profile;

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
