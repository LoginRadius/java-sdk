package com.loginradius.sdk.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.loginradius.sdk.models.userprofile.UserProfileList;

public class AdvancedIdentityUserList {

	
	@SerializedName("UserProfile")
	@Expose
	private List<UserProfileList> userProfile = new ArrayList<UserProfileList>();
	@SerializedName("TotalUsers")
	@Expose
	private Integer totalUsers;

	/**
	* 
	* @return
	* The userProfile
	*/
	public List<UserProfileList> getUserProfile() {
	return userProfile;
	}

	/**
	* 
	* @param userProfile
	* The UserProfile
	*/
	public void setUserProfile(List<UserProfileList> userProfile) {
	this.userProfile = userProfile;
	}

	/**
	* 
	* @return
	* The totalUsers
	*/
	public Integer getTotalUsers() {
	return totalUsers;
	}

	/**
	* 
	* @param totalUsers
	* The TotalUsers
	*/
	public void setTotalUsers(Integer totalUsers) {
	this.totalUsers = totalUsers;
	}
}
