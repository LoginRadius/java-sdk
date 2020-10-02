
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwoFactorAuthentication {

	@SerializedName("IsEnabled")
	@Expose
	private Boolean isEnabled;
	@SerializedName("IsRequired")
	@Expose
	private Boolean isRequired;
	@SerializedName("IsGoogleAuthenticator")
	@Expose
	private Boolean isGoogleAuthenticator;

	/**
	 * Enable two factor authentication true or false
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * Enable two factor authentication true or false
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * IsRequired
	 */
	public Boolean getIsRequired() {
		return isRequired;
	}

	/**
	 * IsRequired
	 */
	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	/**
	 * Enable google authenticator true or false
	 */
	public Boolean getIsGoogleAuthenticator() {
		return isGoogleAuthenticator;
	}

	/**
	 * Enable google authenticator true or false
	 */
	public void setIsGoogleAuthenticator(Boolean isGoogleAuthenticator) {
		this.isGoogleAuthenticator = isGoogleAuthenticator;
	}

}
