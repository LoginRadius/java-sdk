package com.loginradius.sdk.models.customregistrationdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
	@SerializedName("Code")
	@Expose
	private String code;
	@SerializedName("Id")
	@Expose
	private String id;
	@SerializedName("DateCreated")
	@Expose
	private String dateCreated;
	@SerializedName("DateModified")
	@Expose
	private String dateModified;
	@SerializedName("IsActive")
	@Expose
	private Boolean isActive;
	@SerializedName("Type")
	@Expose
	private String type;
	@SerializedName("Key")
	@Expose
	private String key;
	@SerializedName("Value")
	@Expose
	private String value;
	@SerializedName("ParentId")
	@Expose
	private String parentId;
	@SerializedName("ParentType")
	@Expose
	private String parentType;

	public String getCode() {
	return code;
	}

	public void setCode(String code) {
	this.code = code;
	}

	public String getId() {
	return id;
	}

	public void setId(String id) {
	this.id = id;
	}

	public String getDateCreated() {
	return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
	this.dateCreated = dateCreated;
	}

	public String getDateModified() {
	return dateModified;
	}

	public void setDateModified(String dateModified) {
	this.dateModified = dateModified;
	}

	public Boolean getIsActive() {
	return isActive;
	}

	public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
	}

	public String getType() {
	return type;
	}

	public void setType(String type) {
	this.type = type;
	}

	public String getKey() {
	return key;
	}

	public void setKey(String key) {
	this.key = key;
	}

	public String getValue() {
	return value;
	}

	public void setValue(String value) {
	this.value = value;
	}

	public String getParentId() {
	return parentId;
	}

	public void setParentId(String parentId) {
	this.parentId = parentId;
	}

	public String getParentType() {
	return parentType;
	}

	public void setParentType(String parentType) {
	this.parentType = parentType;
	}
}
