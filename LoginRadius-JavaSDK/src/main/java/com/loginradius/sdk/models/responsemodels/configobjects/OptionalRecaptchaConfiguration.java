
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

	/**
	 * IsEnabled
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * IsEnabled
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * Apis
	 */
	public Apis getApis() {
		return apis;
	}

	/**
	 * Apis
	 */
	public void setApis(Apis apis) {
		this.apis = apis;
	}

}
