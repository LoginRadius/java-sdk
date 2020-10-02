
package com.loginradius.sdk.models.responsemodels.configobjects;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SocialSchema {

	@SerializedName("Providers")
	@Expose
	private List<Provider> providers = null;

	/**
	 * Social Providers
	 */
	public List<Provider> getProviders() {
		return providers;
	}

	/**
	 * Social Providers
	 */
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

}
