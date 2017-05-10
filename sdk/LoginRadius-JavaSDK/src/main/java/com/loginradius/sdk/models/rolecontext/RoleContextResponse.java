package com.loginradius.sdk.models.rolecontext;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RoleContextResponse {
	@SerializedName("Data")
	@Expose
	private List<Datum> data = null;

	public List<Datum> getData() {
	return data;
	}

	public void setData(List<Datum> data) {
	this.data = data;
	}
}
