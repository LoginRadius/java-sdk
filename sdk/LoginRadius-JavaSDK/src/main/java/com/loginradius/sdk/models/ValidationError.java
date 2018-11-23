package com.loginradius.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidationError {
	@SerializedName("FieldName")
	@Expose
	private String fieldName;
	@SerializedName("ErrorMessage")
	@Expose
	private String errorMessage;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}