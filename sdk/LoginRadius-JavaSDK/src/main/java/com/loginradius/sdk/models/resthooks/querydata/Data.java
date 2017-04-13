package com.loginradius.sdk.models.resthooks.querydata;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
	@SerializedName("Items")
	@Expose
	private List<Item> items = new ArrayList<Item>();

	/**
	* 
	* @return
	* The items
	*/
	public List<Item> getItems() {
	return items;
	}

	/**
	* 
	* @param items
	* The Items
	*/
	public void setItems(List<Item> items) {
	this.items = items;
	}
}
