/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Awards data
	 */
	public class Awards {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Issuer")
        private String issuer;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Id of the Awards
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of the Awards
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Award issuer details
		 */
		public String getIssuer() {
			return issuer;
		}
		/**
		 * Award issuer details
		 */
		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}
		/**
		 * Award name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Award name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }