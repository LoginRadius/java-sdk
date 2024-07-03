/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete SMS data
	// </summary>
	public class SmsResponseData {
	
		
		@SerializedName("AccountSid")
        private String accountSid;
		
		@SerializedName("Sid")
        private String sid;



		// <summary>
		//	Account Sid
		// </summary>
		public String getAccountSid() {
			return accountSid;
		}
		// <summary>
		//	Account Sid
		// </summary>
		public void setAccountSid(String accountSid) {
			this.accountSid = accountSid;
		}
		// <summary>
		//	Sid
		// </summary>
		public String getSid() {
			return sid;
		}
		// <summary>
		//	Sid
		// </summary>
		public void setSid(String sid) {
			this.sid = sid;
		}
    }
