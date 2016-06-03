package com.loginradius.sdk.raas.models;

public class LoginRadiusPresenceResponse {

	private boolean isExist;
	private String description;
	private int errorCode;
	private boolean isProviderError;
	private String message;
	private boolean providerErrorResponse;
	public boolean isExist() {
		return isExist;
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
