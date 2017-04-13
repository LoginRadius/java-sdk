package com.loginradius.sdk.models.role;


import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;





public class AssignRoles {

	@SerializedName("Roles")
	@Expose
	private List<String> roles = null;

	/**
	* 
	* @return
	* The roles
	*/
	public List<String> getRoles() {
	return roles;
	}

	/**
	* 
	* @param roles
	* The Roles
	*/
	public void setRoles(List<String> roles) {
	this.roles = roles;
	}
}
