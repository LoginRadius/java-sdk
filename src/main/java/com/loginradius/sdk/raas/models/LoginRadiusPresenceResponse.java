package com.loginradius.sdk.raas.models;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusPresenceResponse {
	@SerializedName("isExist")
	private boolean isExists;
	private String description;
	private int errorCode;
	private boolean isProviderError;
	private String message;
	private boolean providerErrorResponse;
	public boolean isExists() {
		return isExists;
	}
	public String getDescription() {
		return description;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public boolean isProviderError() {
		return isProviderError;
	}
	public String getMessage() {
		return message;
	}
	public boolean isProviderErrorResponse() {
		return providerErrorResponse;
	}

	
}
