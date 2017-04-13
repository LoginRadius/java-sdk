package com.loginradius.sdk.models.role;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RolePermissions {
	@SerializedName("EditUser")
	@Expose
	private Boolean editUser;
	@SerializedName("DeleteUser")
	@Expose
	private Boolean deleteUser;

	/**
	* 
	* @return
	* The editUser
	*/
	public Boolean getEditUser() {
	return editUser;
	}

	/**
	* 
	* @param editUser
	* The EditUser
	*/
	public void setEditUser(Boolean editUser) {
	this.editUser = editUser;
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
