/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete profile data
	 */
	public class Identity extends UserProfile {
	
		
		@SerializedName("Identities")
        private List<SocialUserProfile> identities;



		/**
		 * User Identities list
		 */
		public List<SocialUserProfile> getIdentities() {
			return identities;
		}
		/**
		 * User Identities list
		 */
		public void setIdentities(List<SocialUserProfile> identities) {
			this.identities = identities;
		}
    }