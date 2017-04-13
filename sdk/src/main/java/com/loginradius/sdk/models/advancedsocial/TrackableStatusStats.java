package com.loginradius.sdk.models.advancedsocial;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackableStatusStats {
	@SerializedName("Id")
	@Expose
	private String id;
	@SerializedName("Url")
	@Expose
	private Object url;

	/**
	* 
	* @return
	* The id
	*/
	public String getId() {
	return id;
	}

	/**
	* 
	* @param id
	* The Id
	*/
	public void setId(String id) {
	this.id = id;
	}

	/**
	* 
	* @return
	* The url
	*/
	public Object getUrl() {
	return url;
	}

	/**
	* 
	* @param url
	* The Url
	*/
	public void setUrl(Object url) {
	this.url = url;
	}
}
