/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	/**
	 * Model Class containing Definition for Phone Property
	 */
	public class Phone {
	
		
		@SerializedName("op")
        private OperationType op;
		
		@SerializedName("PhoneNumber")
        private String phoneNumber;
		
		@SerializedName("PhoneType")
        private String phoneType;



		/**
		 * operation type
		 */
		public OperationType getOp() {
			return op;
		}
		/**
		 * operation type
		 */
		public void setOp(OperationType op) {
			this.op = op;
		}
		/**
		 * Phone number
		 */
		public String getPhoneNumber() {
			return phoneNumber;
		}
		/**
		 * Phone number
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		/**
		 * Phone type
		 */
		public String getPhoneType() {
			return phoneType;
		}
		/**
		 * Phone type
		 */
		public void setPhoneType(String phoneType) {
			this.phoneType = phoneType;
		}
    }