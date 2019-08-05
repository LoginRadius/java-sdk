
package com.loginradius.sdk.models.responsemodels.configobjects;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SocialSchema {

	@SerializedName("Providers")
	@Expose
	private List<Provider> providers = null;

	/// <summary>
	/// Social Providers
	/// </summary>
	public List<Provider> getProviders() {
		return providers;
	}

	/// <summary>
	/// Social Providers
	/// </summary>
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

}
