package com.loginradius.sdk.models.mention;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRadiusMention {
	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Text")
	@Expose
	private String text;
	@SerializedName("ImageUrl")
	@Expose
	private Object imageUrl;
	@SerializedName("DateTime")
	@Expose
	private String dateTime;
	@SerializedName("Source")
	@Expose
	private String source;
	@SerializedName("Place")
	@Expose
	private String place;
	@SerializedName("Likes")
	@Expose
	private Integer likes;
	@SerializedName("LinkUrl")
	@Expose
	private Object linkUrl;
	@SerializedName("Id")
	@Expose
	private String id;

	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
	return name;
	}

	/**
	* 
	* @param name
	* The Name
	*/
	public void setName(String name) {
	this.name = name;
	}

	/**
	* 
	* @return
	* The text
	*/
	public String getText() {
	return text;
	}

	/**
	* 
	* @param text
	* The Text
	*/
	public void setText(String text) {
	this.text = text;
	}

	/**
	* 
	* @return
	* The imageUrl
	*/
	public Object getImageUrl() {
	return imageUrl;
	}

	/**
	* 
	* @param imageUrl
	* The ImageUrl
	*/
	public void setImageUrl(Object imageUrl) {
	this.imageUrl = imageUrl;
	}

	/**
	* 
	* @return
	* The dateTime
	*/
	public String getDateTime() {
	return dateTime;
	}

	/**
	* 
	* @param dateTime
	* The DateTime
	*/
	public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
	}

	/**
	* 
	* @return
	* The source
	*/
	public String getSource() {
	return source;
	}

	/**
	* 
	* @param source
	* The Source
	*/
	public void setSource(String source) {
	this.source = source;
	}

	/**
	* 
	* @return
	* The place
	*/
	public String getPlace() {
	return place;
	}

	/**
	* 
	* @param place
	* The Place
	*/
	public void setPlace(String place) {
	this.place = place;
	}

	/**
	* 
	* @return
	* The likes
	*/
	public Integer getLikes() {
	return likes;
	}

	/**
	* 
	* @param likes
	* The Likes
	*/
	public void setLikes(Integer likes) {
	this.likes = likes;
	}

	/**
	* 
	* @return
	* The linkUrl
	*/
	public Object getLinkUrl() {
	return linkUrl;
	}

	/**
	* 
	* @param linkUrl
	* The LinkUrl
	*/
	public void setLinkUrl(Object linkUrl) {
	this.linkUrl = linkUrl;
	}

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
}
