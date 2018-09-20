package com.loginradius.sdk.models.role;

import com.google.gson.annotations.*;

public class LoginRadiusRole {

	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Permissions")
	@Expose
	private Object  permissions;

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

	/**
	* 
	* @return
	* The permissions
	*/
	public Object  getPermissions() {
	return permissions;
	}

	/**
	* 
	* @param permissions
	* The Permissions
	*/
	public void setPermissions(Object  permissions) {
	this.permissions = permissions;
	}
   
}
