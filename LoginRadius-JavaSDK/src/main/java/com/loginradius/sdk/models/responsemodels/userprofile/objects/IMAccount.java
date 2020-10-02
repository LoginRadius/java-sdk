/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete IMAccount data
	 */
	public class IMAccount {
	
		
		@SerializedName("AccountName")
        private String accountName;
		
		@SerializedName("AccountType")
        private String accountType;



		/**
		 * Name of account
		 */
		public String getAccountName() {
			return accountName;
		}
		/**
		 * Name of account
		 */
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		/**
		 * Type of account
		 */
		public String getAccountType() {
			return accountType;
		}
		/**
		 * Type of account
		 */
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
    }