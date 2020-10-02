
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

	/**
	 * LoginLockedType
	 */
	public String getLoginLockedType() {
		return loginLockedType;
	}

	/**
	 * LoginLockedType
	 */
	public void setLoginLockedType(String loginLockedType) {
		this.loginLockedType = loginLockedType;
	}

	/**
	 * MaximumFailedLoginAttempts
	 */
	public Integer getMaximumFailedLoginAttempts() {
		return maximumFailedLoginAttempts;
	}

	/**
	 * MaximumFailedLoginAttempts
	 */
	public void setMaximumFailedLoginAttempts(Integer maximumFailedLoginAttempts) {
		this.maximumFailedLoginAttempts = maximumFailedLoginAttempts;
	}

	/**
	 * SuspendConfiguration
	 */
	public SuspendConfiguration getSuspendConfiguration() {
		return suspendConfiguration;
	}

	/**
	 * SuspendConfiguration
	 */
	public void setSuspendConfiguration(SuspendConfiguration suspendConfiguration) {
		this.suspendConfiguration = suspendConfiguration;
	}

}
