/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Multi-Factor Authentication Settings data
	// </summary>
	public class MultiFactorAuthenticationSettingsResponse {
	
		
		@SerializedName("IsGoogleAuthenticatorVerified")
        private Boolean isGoogleAuthenticatorVerified;
		
		@SerializedName("IsOTPAuthenticatorVerified")
        private Boolean isOTPAuthenticatorVerified;
		
		@SerializedName("ManualEntryCode")
        private String manualEntryCode;
		
		@SerializedName("OTPPhoneNo")
        private String oTPPhoneNo;
		
		@SerializedName("OTPStatus")
        private SMSResponseData oTPStatus;
		
		@SerializedName("QRCode")
        private String qRCode;



		// <summary>
		//	google authenticator verified or not
		// </summary>
		public Boolean getIsGoogleAuthenticatorVerified() {
			return isGoogleAuthenticatorVerified;
		}
		// <summary>
		//	google authenticator verified or not
		// </summary>
		public void setIsGoogleAuthenticatorVerified(Boolean isGoogleAuthenticatorVerified) {
			this.isGoogleAuthenticatorVerified = isGoogleAuthenticatorVerified;
		}
		// <summary>
		//	OTP authenticator verified or not
		// </summary>
		public Boolean getIsOTPAuthenticatorVerified() {
			return isOTPAuthenticatorVerified;
		}
		// <summary>
		//	OTP authenticator verified or not
		// </summary>
		public void setIsOTPAuthenticatorVerified(Boolean isOTPAuthenticatorVerified) {
			this.isOTPAuthenticatorVerified = isOTPAuthenticatorVerified;
		}
		// <summary>
		//	Manual entry code
		// </summary>
		public String getManualEntryCode() {
			return manualEntryCode;
		}
		// <summary>
		//	Manual entry code
		// </summary>
		public void setManualEntryCode(String manualEntryCode) {
			this.manualEntryCode = manualEntryCode;
		}
		// <summary>
		//	Otp phone number
		// </summary>
		public String getOTPPhoneNo() {
			return oTPPhoneNo;
		}
		// <summary>
		//	Otp phone number
		// </summary>
		public void setOTPPhoneNo(String oTPPhoneNo) {
			this.oTPPhoneNo = oTPPhoneNo;
		}
		// <summary>
		//	OTP status
		// </summary>
		public SMSResponseData getOTPStatus() {
			return oTPStatus;
		}
		// <summary>
		//	OTP status
		// </summary>
		public void setOTPStatus(SMSResponseData oTPStatus) {
			this.oTPStatus = oTPStatus;
		}
		// <summary>
		//	QR code
		// </summary>
		public String getQRCode() {
			return qRCode;
		}
		// <summary>
		//	QR code
		// </summary>
		public void setQRCode(String qRCode) {
			this.qRCode = qRCode;
		}
    }