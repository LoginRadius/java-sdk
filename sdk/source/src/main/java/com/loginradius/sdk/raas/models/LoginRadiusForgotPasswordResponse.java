package com.loginradius.sdk.raas.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRadiusForgotPasswordResponse {
	
	@SerializedName("Guid")
	@Expose
	private String guid;
	@SerializedName("Providers")
	@Expose
	private List<String> providers = new ArrayList<String>();
	private String description;
	private int errorCode;
	private boolean isProviderError;
	private String message;
	private boolean providerErrorResponse;
	public String getDescription() {
		return description;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public boolean isProviderError() {
		return isProviderError;
	}


	public String getMessage() {
		return message;
	}


	public boolean isProviderErrorResponse() {
		return providerErrorResponse;
	}


	/**
	* 
	* @return
	* The guid
	*/
	public String getGuid() {
	return guid;
	}

	
	/**
	* 
	* @return
	* The providers
	*/
	public List<String> getProviders() {
	return providers;
	}


}
