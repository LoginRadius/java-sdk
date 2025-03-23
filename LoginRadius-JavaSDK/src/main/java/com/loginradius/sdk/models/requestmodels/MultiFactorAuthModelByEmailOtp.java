/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class MultiFactorAuthModelByEmailOtp {
	
		
		@SerializedName("EmailId")
        private String emailId;
		
		@SerializedName("Otp")
        private String otp;



		// <summary>
		//	
		// </summary>
		public String getEmailId() {
			return emailId;
		}
		// <summary>
		//	
		// </summary>
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		// <summary>
		//	
		// </summary>
		public String getOtp() {
			return otp;
		}
		// <summary>
		//	
		// </summary>
		public void setOtp(String otp) {
			this.otp = otp;
		}
    }