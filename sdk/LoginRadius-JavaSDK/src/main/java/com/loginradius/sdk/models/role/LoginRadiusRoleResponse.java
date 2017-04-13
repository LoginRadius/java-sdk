package com.loginradius.sdk.models.role;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class LoginRadiusRoleResponse {
	@SerializedName("data")
	@Expose
	private List<LoginRadiusRole> data = new ArrayList<LoginRadiusRole>();
	@SerializedName("Count")
	@Expose
	private Integer count;

	/**
	* 
	* @return
	* The data
	*/
	public List<LoginRadiusRole> getData() {
	return data;
	}

	/**
	* 
	* @param data
	* The data
	*/
	public void setData(List<LoginRadiusRole> data) {
	this.data = data;
	}
	
	/**
	* 
	* @return
	* The count
	*/
	public Integer getCount() {
	return count;
	}

	/**
	* 
	* @param count
	* The Count
	*/
	public void setCount(Integer count) {
	this.count = count;
	}
}
