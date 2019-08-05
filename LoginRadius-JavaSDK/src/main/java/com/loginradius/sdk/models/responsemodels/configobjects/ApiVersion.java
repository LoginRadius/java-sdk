
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiVersion {

	@SerializedName("v1")
	@Expose
	private Boolean v1;
	@SerializedName("v2")
	@Expose
	private Boolean v2;

	/// <summary>
	/// APIVersion V1
	/// </summary>
	public Boolean getV1() {
		return v1;
	}

	/// <summary>
	/// APIVersion V1
	/// </summary>
	public void setV1(Boolean v1) {
		this.v1 = v1;
	}

	/// <summary>
	/// APIVersion V2
	/// </summary>
	public Boolean getV2() {
		return v2;
	}

	/// <summary>
	/// APIVersion V2
	/// </summary>
	public void setV2(Boolean v2) {
		this.v2 = v2;
	}

}
