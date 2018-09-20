package com.loginradius.sdk.models.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailOtpResponse {
	@SerializedName("IsPosted")
	@Expose
	private Boolean isPosted;
	@SerializedName("Data")
	@Expose
	private EmailOtpData data;

	public Boolean getIsPosted() {
	return isPosted;
	}

	public void setIsPosted(Boolean isPosted) {
	this.isPosted = isPosted;
	}

	public EmailOtpData getData() {
	return data;
	}

	public void setData(EmailOtpData data) {
	this.data = data;
	}
}
