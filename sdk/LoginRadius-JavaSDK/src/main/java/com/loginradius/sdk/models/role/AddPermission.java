package com.loginradius.sdk.models.role;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddPermission {

	@SerializedName("UpdateUser")
	@Expose
	private Boolean updateUser;
	@SerializedName("DeleteUser")
	@Expose
	private Boolean deleteUser;
	@SerializedName("EditUsers")
	@Expose
	private Boolean editUsers;
	@SerializedName("DeleteUserss")
	@Expose
	private Boolean deleteUserss;

	public Boolean getUpdateUser() {
	return updateUser;
	}

	public void setUpdateUser(Boolean updateUser) {
	this.updateUser = updateUser;
	}

	public Boolean getDeleteUser() {
	return deleteUser;
	}

	public void setDeleteUser(Boolean deleteUser) {
	this.deleteUser = deleteUser;
	}

	public Boolean getEditUsers() {
	return editUsers;
	}

	public void setEditUsers(Boolean editUsers) {
	this.editUsers = editUsers;
	}

	public Boolean getDeleteUserss() {
	return deleteUserss;
	}

	public void setDeleteUserss(Boolean deleteUserss) {
	this.deleteUserss = deleteUserss;
	}
}
