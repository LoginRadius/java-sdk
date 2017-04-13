package com.loginradius.sdk.models.resthooks.querydata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {
	@SerializedName("Users")
	@Expose
	private Users users;

	/**
	* 
	* @return
	* The users
	*/
	public Users getUsers() {
	return users;
	}

	/**
	* 
	* @param users
	* The Users
	*/
	public void setUsers(Users users) {
	this.users = users;
	}
}
