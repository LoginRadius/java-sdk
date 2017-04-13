package com.loginradius.sdk.models.advancedsocial;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shortenurl {
	@SerializedName("UrlKey")
	@Expose
	private Integer urlKey;
	@SerializedName("UrlBase36Key")
	@Expose
	private String urlBase36Key;
	@SerializedName("ShortUrl")
	@Expose
	private String shortUrl;

	/**
	* 
	* @return
	* The urlKey
	*/
	public Integer getUrlKey() {
	return urlKey;
	}

	/**
	* 
	* @param urlKey
	* The UrlKey
	*/
	public void setUrlKey(Integer urlKey) {
	this.urlKey = urlKey;
	}

	/**
	* 
	* @return
	* The urlBase36Key
	*/
	public String getUrlBase36Key() {
	return urlBase36Key;
	}

	/**
	* 
	* @param urlBase36Key
	* The UrlBase36Key
	*/
	public void setUrlBase36Key(String urlBase36Key) {
	this.urlBase36Key = urlBase36Key;
	}

	/**
	* 
	* @return
	* The shortUrl
	*/
	public String getShortUrl() {
	return shortUrl;
	}

	/**
	* 
	* @param shortUrl
	* The ShortUrl
	*/
	public void setShortUrl(String shortUrl) {
	this.shortUrl = shortUrl;
	}

}
