package com.loginradius.sdk.models.webhook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebhookTestResponse {
	@SerializedName("IsAllowed")
	@Expose
	private Boolean isAllowed;

	public Boolean getIsAllowed() {
	return isAllowed;
	}

	public void setIsAllowed(Boolean isAllowed) {
	this.isAllowed = isAllowed;
	}
}
