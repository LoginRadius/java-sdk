/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Reset Pin By Security Question and Phone API
	// </summary>
	public class ResetPINBySecurityQuestionAnswerAndPhoneModel extends ResetPINBySecurityQuestionAnswer {
	
		
		@SerializedName("Phone")
        private String phone;



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