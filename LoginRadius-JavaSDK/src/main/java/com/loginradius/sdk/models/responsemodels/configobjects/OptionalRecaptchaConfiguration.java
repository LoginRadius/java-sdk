
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionalRecaptchaConfiguration {

	@SerializedName("IsEnabled")
	@Expose
	private Boolean isEnabled;
	@SerializedName("Apis")
	@Expose
	private Apis apis;

	/// <summary>
	/// IsEnabled
	/// </summary>
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/// <summary>
	/// IsEnabled
	/// </summary>
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/// <summary>
	/// Apis
	/// </summary>
	public Apis getApis() {
		return apis;
	}

	/// <summary>
	/// Apis
	/// </summary>
	public void setApis(Apis apis) {
		this.apis = apis;
	}

}
