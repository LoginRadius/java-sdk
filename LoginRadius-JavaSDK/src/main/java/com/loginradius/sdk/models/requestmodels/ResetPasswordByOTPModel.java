/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for ResetPasswordByOTP API
	// </summary>
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



		// <summary>
		//	The Verification Code
		// </summary>
		public String getOtp() {
			return otp;
		}
		// <summary>
		//	The Verification Code
		// </summary>
		public void setOtp(String otp) {
			this.otp = otp;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public String getPassword() {
			return password;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public void setPassword(String password) {
			this.password = password;
		}
		// <summary>
		//	New Phone Number
		// </summary>
		public String getPhone() {
			return phone;
		}
		// <summary>
		//	New Phone Number
		// </summary>
		public void setPhone(String phone) {
			this.phone = phone;
		}
		// <summary>
		//	If you are sending an sms via the sendsms parameter, this parameter allows you to specify which reset password sms  template you would like to use.
		// </summary>
		public String getResetPasswordSmsTemplate() {
			return resetPasswordSmsTemplate;
		}
		// <summary>
		//	If you are sending an sms via the sendsms parameter, this parameter allows you to specify which reset password sms  template you would like to use.
		// </summary>
		public void setResetPasswordSmsTemplate(String resetPasswordSmsTemplate) {
			this.resetPasswordSmsTemplate = resetPasswordSmsTemplate;
		}
		// <summary>
		//	SMS template name
		// </summary>
		public String getSmsTemplate() {
			return smsTemplate;
		}
		// <summary>
		//	SMS template name
		// </summary>
		public void setSmsTemplate(String smsTemplate) {
			this.smsTemplate = smsTemplate;
		}
    }