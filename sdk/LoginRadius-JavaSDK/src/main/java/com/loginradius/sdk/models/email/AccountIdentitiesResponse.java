package com.loginradius.sdk.models.email;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile;

public class AccountIdentitiesResponse {
	@SerializedName("Data")
	@Expose
	private List<LoginRadiusUltimateUserProfile> data = null;

	public List<LoginRadiusUltimateUserProfile> getData() {
	return data;
	}

	public void setData(List<LoginRadiusUltimateUserProfile> data) {
	this.data = data;
	}
}
