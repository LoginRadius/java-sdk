package com.loginradius.sdk.models.phone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneSendOtpResponse {
	@SerializedName("IsPosted")
	@Expose
	private Boolean isPosted;
	@SerializedName("Data")
	@Expose
	private PhoneForgotPasswordData data;

	public Boolean getIsPosted() {
	return isPosted;
	}

	public void setIsPosted(Boolean isPosted) {
	this.isPosted = isPosted;
	}

	public PhoneForgotPasswordData getData() {
	return data;
	}

	public void setData(PhoneForgotPasswordData data) {
	this.data = data;
	}
}
