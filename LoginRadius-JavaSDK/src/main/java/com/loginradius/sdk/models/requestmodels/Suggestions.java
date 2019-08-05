/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Suggestions Property
	// </summary>
	public class Suggestions {
	
		
		@SerializedName("CompaniestoFollow")
        private List<NameId> companiestoFollow;
		
		@SerializedName("IndustriestoFollow")
        private List<NameId> industriestoFollow;
		
		@SerializedName("NewssourcetoFollow")
        private List<NameId> newssourcetoFollow;
		
		@SerializedName("PeopletoFollow")
        private List<NameId> peopletoFollow;



		// <summary>
		//	Companies needs to follow
		// </summary>
		public List<NameId> getCompaniestoFollow() {
			return companiestoFollow;
		}
		// <summary>
		//	Companies needs to follow
		// </summary>
		public void setCompaniestoFollow(List<NameId> companiestoFollow) {
			this.companiestoFollow = companiestoFollow;
		}
		// <summary>
		//	Industries needs to follow
		// </summary>
		public List<NameId> getIndustriestoFollow() {
			return industriestoFollow;
		}
		// <summary>
		//	Industries needs to follow
		// </summary>
		public void setIndustriestoFollow(List<NameId> industriestoFollow) {
			this.industriestoFollow = industriestoFollow;
		}
		// <summary>
		//	News sources needs to follow
		// </summary>
		public List<NameId> getNewssourcetoFollow() {
			return newssourcetoFollow;
		}
		// <summary>
		//	News sources needs to follow
		// </summary>
		public void setNewssourcetoFollow(List<NameId> newssourcetoFollow) {
			this.newssourcetoFollow = newssourcetoFollow;
		}
		// <summary>
		//	People needs to follow
		// </summary>
		public List<NameId> getPeopletoFollow() {
			return peopletoFollow;
		}
		// <summary>
		//	People needs to follow
		// </summary>
		public void setPeopletoFollow(List<NameId> peopletoFollow) {
			this.peopletoFollow = peopletoFollow;
		}
    }