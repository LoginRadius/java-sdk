package com.loginradius.sdk.models.resthooks.querydata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {
	@SerializedName("Value")
	@Expose
	private Integer value;

	/**
	* 
	* @return
	* The value
	*/
	public Integer getValue() {
	return value;
	}

	/**
	* 
	* @param value
	* The Value
	*/
	public void setValue(Integer value) {
	this.value = value;
	}
}
