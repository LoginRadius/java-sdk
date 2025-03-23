/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Job data
	// </summary>
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



		// <summary>
		//	Is active or not
		// </summary>
		public Boolean getActive() {
			return active;
		}
		// <summary>
		//	Is active or not
		// </summary>
		public void setActive(Boolean active) {
			this.active = active;
		}
		// <summary>
		//	Job company
		// </summary>
		public JobBookmarkCompany getCompany() {
			return company;
		}
		// <summary>
		//	Job company
		// </summary>
		public void setCompany(JobBookmarkCompany company) {
			this.company = company;
		}
		// <summary>
		//	Job description
		// </summary>
		public String getDescriptionSnippet() {
			return descriptionSnippet;
		}
		// <summary>
		//	Job description
		// </summary>
		public void setDescriptionSnippet(String descriptionSnippet) {
			this.descriptionSnippet = descriptionSnippet;
		}
		// <summary>
		//	Job id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Job id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Position of job
		// </summary>
		public JobBookmarkPosition getPosition() {
			return position;
		}
		// <summary>
		//	Position of job
		// </summary>
		public void setPosition(JobBookmarkPosition position) {
			this.position = position;
		}
		// <summary>
		//	Job posting timestamp
		// </summary>
		public String getPostingTimestamp() {
			return postingTimestamp;
		}
		// <summary>
		//	Job posting timestamp
		// </summary>
		public void setPostingTimestamp(String postingTimestamp) {
			this.postingTimestamp = postingTimestamp;
		}
    }