/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class MultiSmsOtp {
	
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Phone")
        private String phone;
		
		@SerializedName("Uid")
        private String uid;



		// <summary>
		//	
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	
		// </summary>
		public String getPhone() {
			return phone;
		}
		// <summary>
		//	
		// </summary>
		public void setPhone(String phone) {
			this.phone = phone;
		}
		// <summary>
		//	
		// </summary>
		public String getUid() {
			return uid;
		}
		// <summary>
		//	
		// </summary>
		public void setUid(String uid) {
			this.uid = uid;
		}
    }