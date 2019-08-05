
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginLockedConfiguration {

	@SerializedName("LoginLockedType")
	@Expose
	private String loginLockedType;
	@SerializedName("MaximumFailedLoginAttempts")
	@Expose
	private Integer maximumFailedLoginAttempts;
	@SerializedName("SuspendConfiguration")
	@Expose
	private SuspendConfiguration suspendConfiguration;

	/// <summary>
	/// LoginLockedType
	/// </summary>
	public String getLoginLockedType() {
		return loginLockedType;
	}

	/// <summary>
	/// LoginLockedType
	/// </summary>
	public void setLoginLockedType(String loginLockedType) {
		this.loginLockedType = loginLockedType;
	}

	/// <summary>
	/// MaximumFailedLoginAttempts
	/// </summary>
	public Integer getMaximumFailedLoginAttempts() {
		return maximumFailedLoginAttempts;
	}

	/// <summary>
	/// MaximumFailedLoginAttempts
	/// </summary>
	public void setMaximumFailedLoginAttempts(Integer maximumFailedLoginAttempts) {
		this.maximumFailedLoginAttempts = maximumFailedLoginAttempts;
	}

	/// <summary>
	/// SuspendConfiguration
	/// </summary>
	public SuspendConfiguration getSuspendConfiguration() {
		return suspendConfiguration;
	}

	/// <summary>
	/// SuspendConfiguration
	/// </summary>
	public void setSuspendConfiguration(SuspendConfiguration suspendConfiguration) {
		this.suspendConfiguration = suspendConfiguration;
	}

}
