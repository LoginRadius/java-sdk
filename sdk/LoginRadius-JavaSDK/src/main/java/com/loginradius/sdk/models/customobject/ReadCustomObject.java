package com.loginradius.sdk.models.customobject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadCustomObject {
	@SerializedName("data")
	@Expose
	private List<CreateCustomObject> data = new ArrayList<CreateCustomObject>();
	@SerializedName("Count")
	@Expose
	private Integer count;

	/**
	* 
	* @return
	* The data
	*/
	public List<CreateCustomObject> getData() {
	return data;
	}

	/**
	* 
	* @param data
	* The data
	*/
	public void setData(List<CreateCustomObject> data) {
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
