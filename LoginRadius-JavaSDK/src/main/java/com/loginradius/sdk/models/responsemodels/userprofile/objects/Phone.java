/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Phone data
	// </summary>
	public class Phone {
	
		
		@SerializedName("PhoneNumber")
        private String phoneNumber;
		
		@SerializedName("PhoneType")
        private String phoneType;



		// <summary>
		//	Phone number
		// </summary>
		public String getPhoneNumber() {
			return phoneNumber;
		}
		// <summary>
		//	Phone number
		// </summary>
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		// <summary>
		//	Phone type
		// </summary>
		public String getPhoneType() {
			return phoneType;
		}
		// <summary>
		//	Phone type
		// </summary>
		public void setPhoneType(String phoneType) {
			this.phoneType = phoneType;
		}
    }