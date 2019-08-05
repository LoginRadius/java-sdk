/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	// <summary>
	//	Model Class containing Definition for Phone Property
	// </summary>
	public class Phone {
	
		
		@SerializedName("op")
        private OperationType op;
		
		@SerializedName("PhoneNumber")
        private String phoneNumber;
		
		@SerializedName("PhoneType")
        private String phoneType;



		// <summary>
		//	operation type
		// </summary>
		public OperationType getOp() {
			return op;
		}
		// <summary>
		//	operation type
		// </summary>
		public void setOp(OperationType op) {
			this.op = op;
		}
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