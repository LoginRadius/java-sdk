/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete IMAccount data
	// </summary>
	public class IMAccount {
	
		
		@SerializedName("AccountName")
        private String accountName;
		
		@SerializedName("AccountType")
        private String accountType;



		// <summary>
		//	Name of account
		// </summary>
		public String getAccountName() {
			return accountName;
		}
		// <summary>
		//	Name of account
		// </summary>
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		// <summary>
		//	Type of account
		// </summary>
		public String getAccountType() {
			return accountType;
		}
		// <summary>
		//	Type of account
		// </summary>
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
    }