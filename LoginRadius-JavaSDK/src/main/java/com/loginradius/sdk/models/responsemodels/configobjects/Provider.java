
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provider {

	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Endpoint")
	@Expose
	private String endpoint;

	/// <summary>
	/// Provider's name
	/// </summary>
	public String getName() {
		return name;
	}

	/// <summary>
	/// Provider's name
	/// </summary>
	public void setName(String name) {
		this.name = name;
	}

	/// <summary>
	/// Provider's EndPoint
	/// </summary>
	public String getEndpoint() {
		return endpoint;
	}

	/// <summary>
	/// Provider's EndPoint
	/// </summary>
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
