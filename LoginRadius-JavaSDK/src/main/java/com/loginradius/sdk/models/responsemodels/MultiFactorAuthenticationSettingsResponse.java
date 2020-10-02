/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Multi-Factor Authentication Settings data
	 */
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



		/**
		 * google authenticator verified or not
		 */
		public Boolean getIsGoogleAuthenticatorVerified() {
			return isGoogleAuthenticatorVerified;
		}
		/**
		 * google authenticator verified or not
		 */
		public void setIsGoogleAuthenticatorVerified(Boolean isGoogleAuthenticatorVerified) {
			this.isGoogleAuthenticatorVerified = isGoogleAuthenticatorVerified;
		}
		/**
		 * OTP authenticator verified or not
		 */
		public Boolean getIsOTPAuthenticatorVerified() {
			return isOTPAuthenticatorVerified;
		}
		/**
		 * OTP authenticator verified or not
		 */
		public void setIsOTPAuthenticatorVerified(Boolean isOTPAuthenticatorVerified) {
			this.isOTPAuthenticatorVerified = isOTPAuthenticatorVerified;
		}
		/**
		 * Manual entry code
		 */
		public String getManualEntryCode() {
			return manualEntryCode;
		}
		/**
		 * Manual entry code
		 */
		public void setManualEntryCode(String manualEntryCode) {
			this.manualEntryCode = manualEntryCode;
		}
		/**
		 * Otp phone number
		 */
		public String getOTPPhoneNo() {
			return oTPPhoneNo;
		}
		/**
		 * Otp phone number
		 */
		public void setOTPPhoneNo(String oTPPhoneNo) {
			this.oTPPhoneNo = oTPPhoneNo;
		}
		/**
		 * OTP status
		 */
		public SMSResponseData getOTPStatus() {
			return oTPStatus;
		}
		/**
		 * OTP status
		 */
		public void setOTPStatus(SMSResponseData oTPStatus) {
			this.oTPStatus = oTPStatus;
		}
		/**
		 * QR code
		 */
		public String getQRCode() {
			return qRCode;
		}
		/**
		 * QR code
		 */
		public void setQRCode(String qRCode) {
			this.qRCode = qRCode;
		}
    }