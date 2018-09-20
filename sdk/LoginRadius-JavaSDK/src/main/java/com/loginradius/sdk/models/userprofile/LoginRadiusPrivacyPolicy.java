package com.loginradius.sdk.models.userprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRadiusPrivacyPolicy {
	@SerializedName("Version")
	@Expose
	private String version;
	@SerializedName("AcceptSource")
	@Expose
	private String acceptSource;
	@SerializedName("AcceptDateTime")
	@Expose
	private String acceptDateTime;

	public String getVersion() {
	return version;
	}

	public void setVersion(String version) {
	this.version = version;
	}

	public String getAcceptSource() {
	return acceptSource;
	}

	public void setAcceptSource(String acceptSource) {
	this.acceptSource = acceptSource;
	}

	public String getAcceptDateTime() {
	return acceptDateTime;
	}

	public void setAcceptDateTime(String acceptDateTime) {
	this.acceptDateTime = acceptDateTime;
	}

}
