/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Suggestions data
	 */
	public class Suggestions {
	
		
		@SerializedName("CompaniestoFollow")
        private List<NameId> companiestoFollow;
		
		@SerializedName("IndustriestoFollow")
        private List<NameId> industriestoFollow;
		
		@SerializedName("NewssourcetoFollow")
        private List<NameId> newssourcetoFollow;
		
		@SerializedName("PeopletoFollow")
        private List<NameId> peopletoFollow;



		/**
		 * Companies needs to follow
		 */
		public List<NameId> getCompaniestoFollow() {
			return companiestoFollow;
		}
		/**
		 * Companies needs to follow
		 */
		public void setCompaniestoFollow(List<NameId> companiestoFollow) {
			this.companiestoFollow = companiestoFollow;
		}
		/**
		 * Industries needs to follow
		 */
		public List<NameId> getIndustriestoFollow() {
			return industriestoFollow;
		}
		/**
		 * Industries needs to follow
		 */
		public void setIndustriestoFollow(List<NameId> industriestoFollow) {
			this.industriestoFollow = industriestoFollow;
		}
		/**
		 * News sources needs to follow
		 */
		public List<NameId> getNewssourcetoFollow() {
			return newssourcetoFollow;
		}
		/**
		 * News sources needs to follow
		 */
		public void setNewssourcetoFollow(List<NameId> newssourcetoFollow) {
			this.newssourcetoFollow = newssourcetoFollow;
		}
		/**
		 * People needs to follow
		 */
		public List<NameId> getPeopletoFollow() {
			return peopletoFollow;
		}
		/**
		 * People needs to follow
		 */
		public void setPeopletoFollow(List<NameId> peopletoFollow) {
			this.peopletoFollow = peopletoFollow;
		}
    }