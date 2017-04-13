package com.loginradius.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPasswordResponse {

	
	@SerializedName("PasswordHash")
	@Expose
	private String passwordHash;

	/**
	* 
	* @return
	* The passwordHash
	*/
	public String getPasswordHash() {
	return passwordHash;
	}

	/**
	* 
	* @param passwordHash
	* The PasswordHash
	*/
	public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
	}

}
