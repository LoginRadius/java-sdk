package com.loginradius.sdk.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraInfo {
	@SerializedName("Description")
	@Expose
	private String description;
	@SerializedName("ErrorCode")
	@Expose
	private Integer errorCode;
	@SerializedName("Message")
	@Expose
	private String message;

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
