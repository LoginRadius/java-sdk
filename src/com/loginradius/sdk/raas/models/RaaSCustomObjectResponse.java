package com.loginradius.sdk.raas.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class RaaSCustomObjectResponse {

	@SerializedName("id")
	public String Id;
	@SerializedName("isactive")
	public boolean isActive;
	@SerializedName("datecreated")
	public Date DateCreated;
	@SerializedName("datemodified")
	public Date DateModified;
	@SerializedName("isdeleted")
	public boolean isDeleted;
	@SerializedName("uid")
	public String Uid;
	@SerializedName("customobject")
	public Object customObject;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}
	public Date getDateModified() {
		return DateModified;
	}
	public void setDateModified(Date dateModified) {
		DateModified = dateModified;
	}
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public Object getCustomObject() {
		return customObject;
	}
	public void setCustomObject(Object customObject) {
		this.customObject = customObject;
	}
	
}
