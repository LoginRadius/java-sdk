package com.loginradius.sdk.util;

public class LoginRadiusRestErrorResponse{
	private String description;
	private int errorCode;
	private String message;
	private boolean isProviderError;
	private String providerErrorResponse;
	public String getDescription() {
		return description;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		return message;
	}
	public boolean isProviderError() {
		return isProviderError;
	}
	public String getProviderErrorResponse() {
		return providerErrorResponse;
	}
}
