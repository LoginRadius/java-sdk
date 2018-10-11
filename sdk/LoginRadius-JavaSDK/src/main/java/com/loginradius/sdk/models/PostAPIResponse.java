package com.loginradius.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostAPIResponse {
	@SerializedName("IsPosted")
	@Expose
	private Boolean isPosted;

	public Boolean getIsPosted() {
	return isPosted;
	}

	public void setIsPosted(Boolean isPosted) {
	this.isPosted = isPosted;
	}
}
