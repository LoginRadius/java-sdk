package com.loginradius.sdk.raas.models;

import com.google.gson.annotations.SerializedName;

public class RaaSHashPassword {

	@SerializedName("hashpassword")
	public String HashPassword;

	public String getHashPassword() {
		return HashPassword;
	}

	public void setHashPassword(String hashPassword) {
		HashPassword = hashPassword;
	}
	
}
