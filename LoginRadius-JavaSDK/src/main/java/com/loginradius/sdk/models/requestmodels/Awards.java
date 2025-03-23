/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Awards Property
	// </summary>
	public class Awards {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Issuer")
        private String issuer;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Id of the Awards
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of the Awards
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Award issuer details
		// </summary>
		public String getIssuer() {
			return issuer;
		}
		// <summary>
		//	Award issuer details
		// </summary>
		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}
		// <summary>
		//	Award name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Award name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }