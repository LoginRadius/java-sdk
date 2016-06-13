package com.loginradius.sdk.raas.models;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class RaaSCustomObjectResponse {

	
	@SerializedName("Id")
	private String Id;
	@SerializedName("isActive")
	private boolean isActive;
	@SerializedName("DateCreated")
	private String DateCreated;
	@SerializedName("DateModified")
	private String DateModified;
	@SerializedName("isDeleted")
	private boolean isDeleted;
	@SerializedName("Uid")
	private String Uid;
	@SerializedName("CustomObject")
	private JsonObject CustomObject;
	public String getId() {
		return this.Id;
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
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getDateModified() {
		return DateModified;
	}
	public void setDateModified(String dateModified) {
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
	public JsonObject getCustomObject() {
		return CustomObject;
	}
	public void setCustomObject(JsonObject customObject) {
		this.CustomObject = customObject;
	}
	
}
