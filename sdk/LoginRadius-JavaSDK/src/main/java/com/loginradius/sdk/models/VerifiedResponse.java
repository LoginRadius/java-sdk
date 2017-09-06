package com.loginradius.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifiedResponse {
	@SerializedName("IsVerified")
	@Expose
	private Boolean isVerified;

	public Boolean getIsVerified() {
	return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
	this.isVerified = isVerified;
	}

}
