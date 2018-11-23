package com.loginradius.sdk.util;

import java.util.List;

import com.loginradius.sdk.models.ExtraInfo;
import com.loginradius.sdk.models.ValidationError;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
   
 */

public class LoginRadiusRestErrorResponse {

	private String description;

	private String message;

	private Boolean isProviderError;

	private Object providerErrorResponse;

	private Integer errorCode;

	private String Description;

	private String Message;

	private Boolean IsProviderError;

	private Object ProviderErrorResponse;

	private Integer ErrorCode;
	
	private List<ExtraInfo> ExtraInfo = null;

	private List<ValidationError> Errors = null;

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description == null ? Description : description;
	}

	/**
	 * 
	 * @param description
	 *            The Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The message
	 */
	public String getMessage() {
		return message == null ? Message : message;
	}

	/**
	 * 
	 * @param message
	 *            The Message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return The isProviderError
	 */
	public Boolean getIsProviderError() {
		return isProviderError == null ? IsProviderError : isProviderError;
	}

	/**
	 * 
	 * @param isProviderError
	 *            The IsProviderError
	 */
	public void setIsProviderError(Boolean isProviderError) {
		this.isProviderError = isProviderError;
	}

	/**
	 * 
	 * @return The providerErrorResponse
	 */
	public Object getProviderErrorResponse() {
		return providerErrorResponse == null ? ProviderErrorResponse : providerErrorResponse;
	}

	/**
	 * 
	 * @param providerErrorResponse
	 *            The ProviderErrorResponse
	 */
	public void setProviderErrorResponse(Object providerErrorResponse) {
		this.providerErrorResponse = providerErrorResponse;
	}

	/**
	 * 
	 * @return The errorCode
	 */
	public Integer getErrorCode() {
		return errorCode == null ? ErrorCode : errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 *            The ErrorCode
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * 
	 * @return The ExtraInfo
	 */
	public List<ExtraInfo> getExtraInfo() {
		return ExtraInfo;
	}

	/**
	 * 
	 * @param ExtraInfo
	 *            The ExtraInfo
	 */
	public void setExtraInfo(List<ExtraInfo> ExtraInfo) {
		this.ExtraInfo = ExtraInfo;
	}

	/**
	 * 
	 * @return The Errors
	 */
	public List<ValidationError> getErrors() {
		return Errors;
	}

	/**
	 * 
	 * @param Errors
	 *            The Errors
	 */
	public void setErrors(List<ValidationError> Errors) {
		this.Errors = Errors;
	}
}
