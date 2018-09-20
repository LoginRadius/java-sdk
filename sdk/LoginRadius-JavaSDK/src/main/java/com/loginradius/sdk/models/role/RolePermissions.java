package com.loginradius.sdk.models.role;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RolePermissions {
	@SerializedName("CreateUser")
	@Expose
	private Boolean createUser;
	@SerializedName("DeleteUser")
	@Expose
	private Boolean deleteUser;

	/**
	* 
	* @return
	* The createUser
	*/
	public Boolean getCreateUser() {
	return createUser;
	}

	/**
	* 
	* @param createUser
	* The CreateUser
	*/
	public void setCreateUser(Boolean createUser) {
	this.createUser = createUser;
	}

	/**
	* 
	* @return
	* The deleteUser
	*/
	public Boolean getDeleteUser() {
	return deleteUser;
	}

	/**
	* 
	* @param deleteUser
	* The DeleteUser
	*/
	public void setDeleteUser(Boolean deleteUser) {
	this.deleteUser = deleteUser;
	}
}
