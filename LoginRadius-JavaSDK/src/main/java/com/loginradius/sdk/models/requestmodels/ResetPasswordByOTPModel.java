/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for ResetPasswordByOTP API
	 */
	public class ResetPasswordByOTPModel extends LockoutModel {
	
		
		@SerializedName("otp")
        private String otp;
		
		@SerializedName("password")
        private String password;
		
		@SerializedName("Phone")
        private String phone;
		
		@SerializedName("ResetPasswordSmsTemplate")
        private String resetPasswordSmsTemplate;
		
		@SerializedName("smsTemplate")
        private String smsTemplate;



		/**
		 * The Verification Code
		 */
		public String getOtp() {
			return otp;
		}
		/**
		 * The Verification Code
		 */
		public void setOtp(String otp) {
			this.otp = otp;
		}
		/**
		 * Password for the email
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * Password for the email
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * New Phone Number
		 */
		public String getPhone() {
			return phone;
		}
		/**
		 * New Phone Number
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}
		/**
		 * If you are sending an sms via the sendsms parameter, this parameter allows you to specify which reset password sms  template you would like to use.
		 */
		public String getResetPasswordSmsTemplate() {
			return resetPasswordSmsTemplate;
		}
		/**
		 * If you are sending an sms via the sendsms parameter, this parameter allows you to specify which reset password sms  template you would like to use.
		 */
		public void setResetPasswordSmsTemplate(String resetPasswordSmsTemplate) {
			this.resetPasswordSmsTemplate = resetPasswordSmsTemplate;
		}
		/**
		 * SMS template name
		 */
		public String getSmsTemplate() {
			return smsTemplate;
		}
		/**
		 * SMS template name
		 */
		public void setSmsTemplate(String smsTemplate) {
			this.smsTemplate = smsTemplate;
		}
    }