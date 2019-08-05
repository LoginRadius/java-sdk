
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
	/// ApiRequestSigningConfig's Mode
	/// </summary>
	public String getMode() {
		return mode;
	}

	/// <summary>
	/// ApiRequestSigningConfig's Mode
	/// </summary>
	public void setMode(String mode) {
		this.mode = mode;
	}

}
