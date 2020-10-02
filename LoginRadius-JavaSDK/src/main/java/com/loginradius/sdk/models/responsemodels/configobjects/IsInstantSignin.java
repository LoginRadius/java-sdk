
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

	/**
	 * user's email link
	 */
	public Boolean getEmailLink() {
		return emailLink;
	}

	/**
	 * user's email link
	 */
	public void setEmailLink(Boolean emailLink) {
		this.emailLink = emailLink;
	}

	/**
	 * user's sms/otp
	 */
	public Boolean getSmsOtp() {
		return smsOtp;
	}

	/**
	 * user's sms/otp
	 */
	public void setSmsOtp(Boolean smsOtp) {
		this.smsOtp = smsOtp;
	}

}
