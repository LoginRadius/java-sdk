package com.loginradius.sdk.models.customregistrationdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateRegistrationDataResponse {
	@SerializedName("IsPosted")
	@Expose
	private Boolean isPosted;
	@SerializedName("Data")
	@Expose
	private Data data;

	public Boolean getIsPosted() {
	return isPosted;
	}

	public void setIsPosted(Boolean isPosted) {
	this.isPosted = isPosted;
	}

	public Data getData() {
	return data;
	}

	public void setData(Data data) {
	this.data = data;
	}

}
