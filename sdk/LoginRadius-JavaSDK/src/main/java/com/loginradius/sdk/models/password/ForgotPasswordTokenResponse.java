package com.loginradius.sdk.models.password;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordTokenResponse {
	@SerializedName("ForgotToken")
	@Expose
	private String forgotToken;
	@SerializedName("IdentityProviders")
	@Expose
	private List<String> identityProviders = null;

	public String getForgotToken() {
	return forgotToken;
	}

	public void setForgotToken(String forgotToken) {
	this.forgotToken = forgotToken;
	}

	public List<String> getIdentityProviders() {
	return identityProviders;
	}

	public void setIdentityProviders(List<String> identityProviders) {
	this.identityProviders = identityProviders;
	}
}
