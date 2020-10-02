/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete SMS data
	 */
	public class SMSResponseData {
	
		
		@SerializedName("AccountSid")
        private String accountSid;
		
		@SerializedName("Sid")
        private String sid;



		/**
		 * Account Sid
		 */
		public String getAccountSid() {
			return accountSid;
		}
		/**
		 * Account Sid
		 */
		public void setAccountSid(String accountSid) {
			this.accountSid = accountSid;
		}
		/**
		 * Sid
		 */
		public String getSid() {
			return sid;
		}
		/**
		 * Sid
		 */
		public void setSid(String sid) {
			this.sid = sid;
		}
    }