package com.loginradius.sdk.models.rolecontext;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Datum {
	@SerializedName("Context")
	@Expose
	private String context;
	@SerializedName("Roles")
	@Expose
	private List<String> roles = null;
	@SerializedName("AdditionalPermissions")
	@Expose
	private Object additionalPermissions;

	public String getContext() {
	return context;
	}

	public void setContext(String context) {
	this.context = context;
	}

	public List<String> getRoles() {
	return roles;
	}

	public void setRoles(List<String> roles) {
	this.roles = roles;
	}

	public Object getAdditionalPermissions() {
	return additionalPermissions;
	}

	public void setAdditionalPermissions(Object additionalPermissions) {
	this.additionalPermissions = additionalPermissions;
	}
}
