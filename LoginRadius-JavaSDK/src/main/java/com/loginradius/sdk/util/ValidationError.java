package com.loginradius.sdk.util;

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

	public void setFieldName(final String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
