/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Certifications Property
	// </summary>
	public class Certifications {
	
		
		@SerializedName("Authority")
        private String authority;
		
		@SerializedName("EndDate")
        private String endDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Number")
        private String number;
		
		@SerializedName("StartDate")
        private String startDate;



		// <summary>
		//	Authority of certifications
		// </summary>
		public String getAuthority() {
			return authority;
		}
		// <summary>
		//	Authority of certifications
		// </summary>
		public void setAuthority(String authority) {
			this.authority = authority;
		}
		// <summary>
		//	Certification end date
		// </summary>
		public String getEndDate() {
			return endDate;
		}
		// <summary>
		//	Certification end date
		// </summary>
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		// <summary>
		//	Certification id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Certification id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Certification name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Certification name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Certification number
		// </summary>
		public String getNumber() {
			return number;
		}
		// <summary>
		//	Certification number
		// </summary>
		public void setNumber(String number) {
			this.number = number;
		}
		// <summary>
		//	Certification start date
		// </summary>
		public String getStartDate() {
			return startDate;
		}
		// <summary>
		//	Certification start date
		// </summary>
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
    }