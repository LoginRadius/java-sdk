/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Security Question and Phone API
	 */
	public class ResetPINBySecurityQuestionAnswerAndPhoneModel extends ResetPINBySecurityQuestionAnswer {
	
		
		@SerializedName("Phone")
        private String phone;



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
    }