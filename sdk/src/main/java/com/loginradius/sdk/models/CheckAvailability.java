package com.loginradius.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckAvailability {

	@SerializedName("IsExist")
	@Expose
	private Boolean isExist;

	/**
	* 
	* @return
	* The isExist
	*/
	public Boolean getIsExist() {
	return isExist;
	}

	/**
	* 
	* @param isExist
	* The isExist
	*/
	public void setIsExist(Boolean isExist) {
	this.isExist = isExist;
	}

	}
