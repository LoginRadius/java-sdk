
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

	/// <summary>
	/// Enable two factor authentication true or false
	/// </summary>
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/// <summary>
	/// Enable two factor authentication true or false
	/// </summary>
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/// <summary>
	/// IsRequired
	/// </summary>
	public Boolean getIsRequired() {
		return isRequired;
	}

	/// <summary>
	/// IsRequired
	/// </summary>
	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	/// <summary>
	/// Enable google authenticator true or false
	/// </summary>
	public Boolean getIsGoogleAuthenticator() {
		return isGoogleAuthenticator;
	}

	/// <summary>
	/// Enable google authenticator true or false
	/// </summary>
	public void setIsGoogleAuthenticator(Boolean isGoogleAuthenticator) {
		this.isGoogleAuthenticator = isGoogleAuthenticator;
	}

}
