package com.loginradius.sdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailDeleteRequest {

	
	@SerializedName("IsDeleteRequestAccepted")
	@Expose
	private Boolean isDeleteRequestAccepted;

	/**
	* 
	* @return
	* The isDeleteRequestAccepted
	*/
	public Boolean getIsDeleteRequestAccepted() {
	return isDeleteRequestAccepted;
	}

	/**
	* 
	* @param isDeleteRequestAccepted
	* The isDeleteRequestAccepted
	*/
	public void setIsDeleteRequestAccepted(Boolean isDeleteRequestAccepted) {
	this.isDeleteRequestAccepted = isDeleteRequestAccepted;
	}
}
