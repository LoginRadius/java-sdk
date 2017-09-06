package com.loginradius.sdk.models;

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

	public void setDescription(String description) {
	this.description = description;
	}

	public Integer getErrorCode() {
	return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
	this.errorCode = errorCode;
	}

	public String getMessage() {
	return message;
	}

	public void setMessage(String message) {
	this.message = message;
	}
}
