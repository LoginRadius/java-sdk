/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Family data
	 */
	public class Family {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Relationship")
        private String relationship;



		/**
		 * Family id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Family id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Family name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Family name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Family relationship
		 */
		public String getRelationship() {
			return relationship;
		}
		/**
		 * Family relationship
		 */
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
    }