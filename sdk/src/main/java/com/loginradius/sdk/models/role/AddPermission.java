package com.loginradius.sdk.models.role;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddPermission {

	@SerializedName("UpdateUser1")
	@Expose
	private Boolean updateUser1;
	@SerializedName("DeleteUser1")
	@Expose
	private Boolean deleteUser1;
	@SerializedName("DeleteUser")
	@Expose
	private Boolean deleteUser;
	@SerializedName("EditUser")
	@Expose
	private Boolean editUser;

	/**
	* 
	* @return
	* The updateUser1
	*/
	public Boolean getUpdateUser1() {
	return updateUser1;
	}

	/**
	* 
	* @param updateUser1
	* The UpdateUser1
	*/
	public void setUpdateUser1(Boolean updateUser1) {
	this.updateUser1 = updateUser1;
	}

	/**
	* 
	* @return
	* The deleteUser1
	*/
	public Boolean getDeleteUser1() {
	return deleteUser1;
	}

	/**
	* 
	* @param deleteUser1
	* The DeleteUser1
	*/
	public void setDeleteUser1(Boolean deleteUser1) {
	this.deleteUser1 = deleteUser1;
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
}
