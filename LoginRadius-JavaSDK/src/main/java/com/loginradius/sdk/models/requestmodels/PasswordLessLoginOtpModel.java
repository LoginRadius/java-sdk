/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for PasswordLessLoginOtpModel API
	// </summary>
	public class PasswordLessLoginOtpModel extends LockoutModel {
	
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("Phone")
        private String phone;



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
    }