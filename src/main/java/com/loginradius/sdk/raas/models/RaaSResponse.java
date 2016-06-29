package com.loginradius.sdk.raas.models;

import com.loginradius.sdk.social.models.LoginRadiusPostResponse;

public class RaaSResponse extends LoginRadiusPostResponse {

	private String description;
	private int errorCode;
	private boolean isProviderError;
	private String message;
	private boolean providerErrorResponse;

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
