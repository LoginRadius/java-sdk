package com.loginradius.sdk.models.resthooks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscribedURLs {
	@SerializedName("target_url")
	@Expose
	private String targetUrl;
	@SerializedName("event")
	@Expose
	private String event;

	/**
	* 
	* @return
	* The targetUrl
	*/
	public String getTargetUrl() {
	return targetUrl;
	}

	/**
	* 
	* @param targetUrl
	* The target_url
	*/
	public void setTargetUrl(String targetUrl) {
	this.targetUrl = targetUrl;
	}

	/**
	* 
	* @return
	* The event
	*/
	public String getEvent() {
	return event;
	}

	/**
	* 
	* @param event
	* The event
	*/
	public void setEvent(String event) {
	this.event = event;
	}

}
