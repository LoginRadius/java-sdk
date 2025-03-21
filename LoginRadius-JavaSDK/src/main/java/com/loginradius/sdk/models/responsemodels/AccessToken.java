/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Profile data
	// </summary>
	public class AccessToken<T> extends AccessTokenBase {
	
		
		@SerializedName("Profile")
        private T profile;



		// <summary>
		//	Complete user profile data
		// </summary>
		public T getProfile() {
			return profile;
		}
		// <summary>
		//	Complete user profile data
		// </summary>
		public void setProfile(T profile) {
			this.profile = profile;
		}
    }