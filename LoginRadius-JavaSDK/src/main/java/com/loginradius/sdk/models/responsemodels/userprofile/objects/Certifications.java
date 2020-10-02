/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Certifications data
	 */
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



		/**
		 * Authority of certifications
		 */
		public String getAuthority() {
			return authority;
		}
		/**
		 * Authority of certifications
		 */
		public void setAuthority(String authority) {
			this.authority = authority;
		}
		/**
		 * Certification end date
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * Certification end date
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		/**
		 * Certification id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Certification id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Certification name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Certification name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Certification number
		 */
		public String getNumber() {
			return number;
		}
		/**
		 * Certification number
		 */
		public void setNumber(String number) {
			this.number = number;
		}
		/**
		 * Certification start date
		 */
		public String getStartDate() {
			return startDate;
		}
		/**
		 * Certification start date
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
    }