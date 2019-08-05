/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Sott data
	// </summary>
	public class SottResponseData {
	
		
		@SerializedName("ExpiryTime")
        private String expiryTime;
		
		@SerializedName("Sott")
        private String sott;



		// <summary>
		//	Sott expiry time
		// </summary>
		public String getExpiryTime() {
			return expiryTime;
		}
		// <summary>
		//	Sott expiry time
		// </summary>
		public void setExpiryTime(String expiryTime) {
			this.expiryTime = expiryTime;
		}
		// <summary>
		//	SOTT is a secure one time token
		// </summary>
		public String getSott() {
			return sott;
		}
		// <summary>
		//	SOTT is a secure one time token
		// </summary>
		public void setSott(String sott) {
			this.sott = sott;
		}
    }