package com.loginradius.sdk.models.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSource {
	@SerializedName("TargetUrl")
	@Expose
	private String targetUrl;
	@SerializedName("Event")
	@Expose
	private String event;

	public String getTargetUrl() {
	return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
	this.targetUrl = targetUrl;
	}

	public String getEvent() {
	return event;
	}

	public void setEvent(String event) {
	this.event = event;
	}
}
