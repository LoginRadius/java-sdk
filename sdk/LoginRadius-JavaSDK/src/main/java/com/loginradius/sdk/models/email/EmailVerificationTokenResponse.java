package com.loginradius.sdk.models.email;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailVerificationTokenResponse {

	@SerializedName("VerificationToken")
	@Expose
	private String verificationToken;

	public String getVerificationToken() {
	return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
	this.verificationToken = verificationToken;
	}
}
