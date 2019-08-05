/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete profile data
	// </summary>
	public class Identity extends UserProfile {
	
		
		@SerializedName("Identities")
        private List<SocialUserProfile> identities;



		// <summary>
		//	User Identities list
		// </summary>
		public List<SocialUserProfile> getIdentities() {
			return identities;
		}
		// <summary>
		//	User Identities list
		// </summary>
		public void setIdentities(List<SocialUserProfile> identities) {
			this.identities = identities;
		}
    }