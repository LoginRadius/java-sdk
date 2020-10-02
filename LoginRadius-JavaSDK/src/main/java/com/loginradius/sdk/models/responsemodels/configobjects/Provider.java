
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

	/**
	 * Provider's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Provider's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Provider's EndPoint
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * Provider's EndPoint
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
