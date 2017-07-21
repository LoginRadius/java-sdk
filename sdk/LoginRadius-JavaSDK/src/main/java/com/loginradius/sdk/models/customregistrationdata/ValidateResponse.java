package com.loginradius.sdk.models.customregistrationdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidateResponse {
	@SerializedName("IsValid")
	@Expose
	private Boolean isValid;

	public Boolean getIsValid() {
	return isValid;
	}

	public void setIsValid(Boolean isValid) {
	this.isValid = isValid;
	}
}
