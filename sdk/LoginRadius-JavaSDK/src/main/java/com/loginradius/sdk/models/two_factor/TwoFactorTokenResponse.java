package com.loginradius.sdk.models.two_factor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class TwoFactorTokenResponse {
	@SerializedName("QRCode")
	@Expose
	private Object qRCode;
	@SerializedName("ManualEntryCode")
	@Expose
	private Object manualEntryCode;
	@SerializedName("IsGoogleAuthenticatorVerified")
	@Expose
	private Boolean isGoogleAuthenticatorVerified;
	@SerializedName("IsOTPAuthenticatorVerified")
	@Expose
	private Boolean isOTPAuthenticatorVerified;
	@SerializedName("OTPPhoneNo")
	@Expose
	private Object oTPPhoneNo;
	@SerializedName("OTPStatus")
	@Expose
	private Object oTPStatus;

	public Object getQRCode() {
	return qRCode;
	}

	public void setQRCode(Object qRCode) {
	this.qRCode = qRCode;
	}

	public Object getManualEntryCode() {
	return manualEntryCode;
	}

	public void setManualEntryCode(Object manualEntryCode) {
	this.manualEntryCode = manualEntryCode;
	}

	public Boolean getIsGoogleAuthenticatorVerified() {
	return isGoogleAuthenticatorVerified;
	}

	public void setIsGoogleAuthenticatorVerified(Boolean isGoogleAuthenticatorVerified) {
	this.isGoogleAuthenticatorVerified = isGoogleAuthenticatorVerified;
	}

	public Boolean getIsOTPAuthenticatorVerified() {
	return isOTPAuthenticatorVerified;
	}

	public void setIsOTPAuthenticatorVerified(Boolean isOTPAuthenticatorVerified) {
	this.isOTPAuthenticatorVerified = isOTPAuthenticatorVerified;
	}

	public Object getOTPPhoneNo() {
	return oTPPhoneNo;
	}

	public void setOTPPhoneNo(Object oTPPhoneNo) {
	this.oTPPhoneNo = oTPPhoneNo;
	}

	public Object getOTPStatus() {
	return oTPStatus;
	}

	public void setOTPStatus(Object oTPStatus) {
	this.oTPStatus = oTPStatus;
	}
}
