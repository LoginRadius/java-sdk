package com.loginradius.sdk.raas.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRadiusEmailVerificationTokenResponse {

	@SerializedName("Guid")
	@Expose
	private String guid;

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

	/**
	 * 
	 * @return The guid
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * 
	 * @param guid
	 *            The Guid
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
}
