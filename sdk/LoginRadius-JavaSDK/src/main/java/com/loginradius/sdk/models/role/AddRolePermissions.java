package com.loginradius.sdk.models.role;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddRolePermissions {
	
	@SerializedName("Permissions")
	@Expose
	private AddPermission permissions;
	@SerializedName("Name")
	@Expose
	private String name;

	/**
	* 
	* @return
	* The permissions
	*/
	public AddPermission getPermissions() {
	return permissions;
	}

	/**
	* 
	* @param permissions
	* The Permissions
	*/
	public void setPermissions(AddPermission permissions) {
	this.permissions = permissions;
	}

	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
	return name;
	}

	/**
	* 
	* @param name
	* The Name
	*/
	public void setName(String name) {
	this.name = name;
	}

}
