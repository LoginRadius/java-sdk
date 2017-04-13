package com.loginradius.sdk.models.advancedsocial;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackableStatusFetching {
	@SerializedName("Shares")
	@Expose
	private Integer shares;
	@SerializedName("Likes")
	@Expose
	private Integer likes;
	@SerializedName("Comments")
	@Expose
	private Integer comments;

	/**
	* 
	* @return
	* The shares
	*/
	public Integer getShares() {
	return shares;
	}

	/**
	* 
	* @param shares
	* The Shares
	*/
	public void setShares(Integer shares) {
	this.shares = shares;
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
	* The comments
	*/
	public Integer getComments() {
	return comments;
	}

	/**
	* 
	* @param comments
	* The Comments
	*/
	public void setComments(Integer comments) {
	this.comments = comments;
	}
}
