package com.loginradius.sdk.models.sott;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SottResponse {
	@SerializedName("Sott")
	@Expose
	private String sott;
	@SerializedName("ExpiryTime")
	@Expose
	private String expiryTime;

	public String getSott() {
	return sott;
	}

	public void setSott(String sott) {
	this.sott = sott;
	}

	public String getExpiryTime() {
	return expiryTime;
	}

	public void setExpiryTime(String expiryTime) {
	this.expiryTime = expiryTime;
	}
}
