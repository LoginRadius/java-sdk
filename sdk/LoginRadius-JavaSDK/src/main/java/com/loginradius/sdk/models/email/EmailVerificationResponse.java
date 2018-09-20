package com.loginradius.sdk.models.email;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailVerificationResponse {
	@SerializedName("IsPosted")
	@Expose
	private Boolean isPosted;
	@SerializedName("Data")
	@Expose
	private EmailVerificationData data;

	public Boolean getIsPosted() {
	return isPosted;
	}

	public void setIsPosted(Boolean isPosted) {
	this.isPosted = isPosted;
	}

	public EmailVerificationData getData() {
	return data;
	}

	public void setData(EmailVerificationData data) {
	this.data = data;
	}

}
