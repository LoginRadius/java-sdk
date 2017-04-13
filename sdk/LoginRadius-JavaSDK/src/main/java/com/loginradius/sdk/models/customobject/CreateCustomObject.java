package com.loginradius.sdk.models.customobject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateCustomObject {
	@SerializedName("Id")
	@Expose
	private String id;
	@SerializedName("IsActive")
	@Expose
	private Boolean isActive;
	@SerializedName("DateCreated")
	@Expose
	private String dateCreated;
	@SerializedName("DateModified")
	@Expose
	private String dateModified;
	@SerializedName("IsDeleted")
	@Expose
	private Boolean isDeleted;
	@SerializedName("Uid")
	@Expose
	private String uid;
	@SerializedName("CustomObject")
	@Expose
	private Object customObject;
	
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
	* The isActive
	*/
	public Boolean getIsActive() {
	return isActive;
	}

	/**
	* 
	* @param isActive
	* The IsActive
	*/
	public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
	}

	/**
	* 
	* @return
	* The dateCreated
	*/
	public String getDateCreated() {
	return dateCreated;
	}

	/**
	* 
	* @param dateCreated
	* The DateCreated
	*/
	public void setDateCreated(String dateCreated) {
	this.dateCreated = dateCreated;
	}

	/**
	* 
	* @return
	* The dateModified
	*/
	public String getDateModified() {
	return dateModified;
	}

	/**
	* 
	* @param dateModified
	* The DateModified
	*/
	public void setDateModified(String dateModified) {
	this.dateModified = dateModified;
	}

	/**
	* 
	* @return
	* The isDeleted
	*/
	public Boolean getIsDeleted() {
	return isDeleted;
	}

	/**
	* 
	* @param isDeleted
	* The IsDeleted
	*/
	public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
	}

	/**
	* 
	* @return
	* The uid
	*/
	public String getUid() {
	return uid;
	}

	/**
	* 
	* @param uid
	* The Uid
	*/
	public void setUid(String uid) {
	this.uid = uid;
	}

	/**
	* 
	* @return
	* The customObject
	*/
	public Object getCustomObject() {
	return customObject;
	}

	/**
	* 
	* @param customObject
	* The CustomObject
	*/
	public void setCustomObject(Object customObject) {
	this.customObject = customObject;
	}

}
