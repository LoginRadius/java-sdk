package com.loginradius.sdk.models.onetouch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.phone.PhoneForgotPasswordData;

public class AccountSidResponse {
	@SerializedName("Data")
	@Expose
	private PhoneForgotPasswordData data;

	public PhoneForgotPasswordData getData() {
	return data;
	}

	public void setData(PhoneForgotPasswordData data) {
	this.data = data;
	}
}
