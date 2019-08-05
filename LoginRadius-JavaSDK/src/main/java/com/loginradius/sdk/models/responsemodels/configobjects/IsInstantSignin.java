
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsInstantSignin {

	@SerializedName("EmailLink")
	@Expose
	private Boolean emailLink;
	@SerializedName("SmsOtp")
	@Expose
	private Boolean smsOtp;

	/// <summary>
	/// user's email link
	/// </summary>
	public Boolean getEmailLink() {
		return emailLink;
	}

	/// <summary>
	/// user's email link
	/// </summary>
	public void setEmailLink(Boolean emailLink) {
		this.emailLink = emailLink;
	}

	/// <summary>
	/// user's sms/otp
	/// </summary>
	public Boolean getSmsOtp() {
		return smsOtp;
	}

	/// <summary>
	/// user's sms/otp
	/// </summary>
	public void setSmsOtp(Boolean smsOtp) {
		this.smsOtp = smsOtp;
	}

}
