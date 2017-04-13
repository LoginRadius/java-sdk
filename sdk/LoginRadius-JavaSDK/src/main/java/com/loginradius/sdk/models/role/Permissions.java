package com.loginradius.sdk.models.role;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Permissions {

	@SerializedName("Permissions")
	@Expose
	private List<String> permissions = new ArrayList<String>();

	/**
	* 
	* @return
	* The permissions
	*/
	public List<String> getPermissions() {
	return permissions;
	}

	/**
	* 
	* @param permissions
	* The Permissions
	*/
	public void setPermissions(List<String> permissions) {
	this.permissions = permissions;
	}

}
