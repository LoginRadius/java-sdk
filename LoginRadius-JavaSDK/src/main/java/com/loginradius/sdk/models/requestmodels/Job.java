/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Job Property
	 */
	public class Job {
	
		
		@SerializedName("Active")
        private Boolean active;
		
		@SerializedName("Company")
        private JobBookmarkCompany company;
		
		@SerializedName("DescriptionSnippet")
        private String descriptionSnippet;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Position")
        private JobBookmarkPosition position;
		
		@SerializedName("PostingTimestamp")
        private String postingTimestamp;



		/**
		 * Is active or not
		 */
		public Boolean getActive() {
			return active;
		}
		/**
		 * Is active or not
		 */
		public void setActive(Boolean active) {
			this.active = active;
		}
		/**
		 * Job company
		 */
		public JobBookmarkCompany getCompany() {
			return company;
		}
		/**
		 * Job company
		 */
		public void setCompany(JobBookmarkCompany company) {
			this.company = company;
		}
		/**
		 * Job description
		 */
		public String getDescriptionSnippet() {
			return descriptionSnippet;
		}
		/**
		 * Job description
		 */
		public void setDescriptionSnippet(String descriptionSnippet) {
			this.descriptionSnippet = descriptionSnippet;
		}
		/**
		 * Job id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Job id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Position of job
		 */
		public JobBookmarkPosition getPosition() {
			return position;
		}
		/**
		 * Position of job
		 */
		public void setPosition(JobBookmarkPosition position) {
			this.position = position;
		}
		/**
		 * Job posting timestamp
		 */
		public String getPostingTimestamp() {
			return postingTimestamp;
		}
		/**
		 * Job posting timestamp
		 */
		public void setPostingTimestamp(String postingTimestamp) {
			this.postingTimestamp = postingTimestamp;
		}
    }