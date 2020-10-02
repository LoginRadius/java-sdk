
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiRequestSigningConfig {

	@SerializedName("IsEnabled")
	@Expose
	private Boolean isEnabled;
	@SerializedName("Mode")
	@Expose
	private String mode;

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
	 * ApiRequestSigningConfig's Mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ApiRequestSigningConfig's Mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

}
