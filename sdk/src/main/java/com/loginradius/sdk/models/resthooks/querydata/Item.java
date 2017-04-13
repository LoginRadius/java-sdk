package com.loginradius.sdk.models.resthooks.querydata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
	@SerializedName("Key")
	@Expose
	private String key;
	@SerializedName("KeyAsString")
	@Expose
	private Object keyAsString;
	@SerializedName("Count")
	@Expose
	private Integer count;
	@SerializedName("Child")
	@Expose
	private Child child;

	/**
	* 
	* @return
	* The key
	*/
	public String getKey() {
	return key;
	}

	/**
	* 
	* @param key
	* The Key
	*/
	public void setKey(String key) {
	this.key = key;
	}

	/**
	* 
	* @return
	* The keyAsString
	*/
	public Object getKeyAsString() {
	return keyAsString;
	}

	/**
	* 
	* @param keyAsString
	* The KeyAsString
	*/
	public void setKeyAsString(Object keyAsString) {
	this.keyAsString = keyAsString;
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

	/**
	* 
	* @return
	* The child
	*/
	public Child getChild() {
	return child;
	}

	/**
	* 
	* @param child
	* The Child
	*/
	public void setChild(Child child) {
	this.child = child;
	}
}
