package com.loginradius.sdk.models.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRadiusPost {

	@SerializedName("ID")
	@Expose
	private String iD;
	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Title")
	@Expose
	private String title;
	@SerializedName("StartTime")
	@Expose
	private String startTime;
	@SerializedName("UpdateTime")
	@Expose
	private String updateTime;
	@SerializedName("Message")
	@Expose
	private Object message;
	@SerializedName("Place")
	@Expose
	private String place;
	@SerializedName("Picture")
	@Expose
	private Object picture;
	@SerializedName("Likes")
	@Expose
	private Integer likes;
	@SerializedName("Share")
	@Expose
	private Integer share;
	@SerializedName("Type")
	@Expose
	private String type;

	/**
	* 
	* @return
	* The iD
	*/
	public String getID() {
	return iD;
	}

	/**
	* 
	* @param iD
	* The ID
	*/
	public void setID(String iD) {
	this.iD = iD;
	}

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
	* The title
	*/
	public String getTitle() {
	return title;
	}

	/**
	* 
	* @param title
	* The Title
	*/
	public void setTitle(String title) {
	this.title = title;
	}

	/**
	* 
	* @return
	* The startTime
	*/
	public String getStartTime() {
	return startTime;
	}

	/**
	* 
	* @param startTime
	* The StartTime
	*/
	public void setStartTime(String startTime) {
	this.startTime = startTime;
	}

	/**
	* 
	* @return
	* The updateTime
	*/
	public String getUpdateTime() {
	return updateTime;
	}

	/**
	* 
	* @param updateTime
	* The UpdateTime
	*/
	public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
	}

	/**
	* 
	* @return
	* The message
	*/
	public Object getMessage() {
	return message;
	}

	/**
	* 
	* @param message
	* The Message
	*/
	public void setMessage(Object message) {
	this.message = message;
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
	* The picture
	*/
	public Object getPicture() {
	return picture;
	}

	/**
	* 
	* @param picture
	* The Picture
	*/
	public void setPicture(Object picture) {
	this.picture = picture;
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
	* The share
	*/
	public Integer getShare() {
	return share;
	}

	/**
	* 
	* @param share
	* The Share
	*/
	public void setShare(Integer share) {
	this.share = share;
	}

	/**
	* 
	* @return
	* The type
	*/
	public String getType() {
	return type;
	}

	/**
	* 
	* @param type
	* The Type
	*/
	public void setType(String type) {
	this.type = type;
	}

}
