package com.loginradius.sdk.models.resthooks.fields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgeRange {
	@SerializedName("Min")
	@Expose
	private Integer min;
	@SerializedName("Max")
	@Expose
	private Integer max;

	/**
	* 
	* @return
	* The min
	*/
	public Integer getMin() {
	return min;
	}

	/**
	* 
	* @param min
	* The Min
	*/
	public void setMin(Integer min) {
	this.min = min;
	}

	/**
	* 
	* @return
	* The max
	*/
	public Integer getMax() {
	return max;
	}

	/**
	* 
	* @param max
	* The Max
	*/
	public void setMax(Integer max) {
	this.max = max;
	}
}
