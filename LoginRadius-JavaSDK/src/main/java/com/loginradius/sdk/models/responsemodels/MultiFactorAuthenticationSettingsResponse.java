/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Multi-Factor Authentication Settings data
	// </summary>
	public class MultiFactorAuthenticationSettingsResponse {
	
		
		@SerializedName("Email")
        private List<String> email;
		
		@SerializedName("EmailOTPStatus")
        private EmailOtpStatus emailOTPStatus;
		
		@SerializedName("IsEmailOtpAuthenticatorVerified")
        private Boolean isEmailOtpAuthenticatorVerified;
		
		@SerializedName("IsGoogleAuthenticatorVerified")
        private Boolean isGoogleAuthenticatorVerified;
		
		@SerializedName("IsOTPAuthenticatorVerified")
        private Boolean isOTPAuthenticatorVerified;
		
		@SerializedName("IsSecurityQuestionAuthenticatorVerified")
        private Boolean isSecurityQuestionAuthenticatorVerified;
		
		@SerializedName("ManualEntryCode")
        private String manualEntryCode;
		
		@SerializedName("OTPPhoneNo")
        private String oTPPhoneNo;
		
		@SerializedName("OTPStatus")
        private SmsResponseData oTPStatus;
		
		@SerializedName("QRCode")
        private String qRCode;
		
		@SerializedName("SecurityQuestions")
        private List<SecurityQuestions> securityQuestions;



		// <summary>
		//	
		// </summary>
		public List<String> getEmail() {
			return email;
		}
		// <summary>
		//	
		// </summary>
		public void setEmail(List<String> email) {
			this.email = email;
		}
		// <summary>
		//	
		// </summary>
		public EmailOtpStatus getEmailOTPStatus() {
			return emailOTPStatus;
		}
		// <summary>
		//	
		// </summary>
		public void setEmailOTPStatus(EmailOtpStatus emailOTPStatus) {
			this.emailOTPStatus = emailOTPStatus;
		}
		// <summary>
		//	
		// </summary>
		public Boolean getIsEmailOtpAuthenticatorVerified() {
			return isEmailOtpAuthenticatorVerified;
		}
		// <summary>
		//	
		// </summary>
		public void setIsEmailOtpAuthenticatorVerified(Boolean isEmailOtpAuthenticatorVerified) {
			this.isEmailOtpAuthenticatorVerified = isEmailOtpAuthenticatorVerified;
		}
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
		//	
		// </summary>
		public Boolean getIsSecurityQuestionAuthenticatorVerified() {
			return isSecurityQuestionAuthenticatorVerified;
		}
		// <summary>
		//	
		// </summary>
		public void setIsSecurityQuestionAuthenticatorVerified(Boolean isSecurityQuestionAuthenticatorVerified) {
			this.isSecurityQuestionAuthenticatorVerified = isSecurityQuestionAuthenticatorVerified;
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
		public SmsResponseData getOTPStatus() {
			return oTPStatus;
		}
		// <summary>
		//	OTP status
		// </summary>
		public void setOTPStatus(SmsResponseData oTPStatus) {
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
		// <summary>
		//	Response containing Definition for Complete SecurityQuestions data
		// </summary>
		public List<SecurityQuestions> getSecurityQuestions() {
			return securityQuestions;
		}
		// <summary>
		//	Response containing Definition for Complete SecurityQuestions data
		// </summary>
		public void setSecurityQuestions(List<SecurityQuestions> securityQuestions) {
			this.securityQuestions = securityQuestions;
		}
    }