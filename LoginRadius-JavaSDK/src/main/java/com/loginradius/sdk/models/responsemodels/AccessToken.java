/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Profile data
	 */
	public class AccessToken<T> extends AccessTokenBase {
	
		
		@SerializedName("Profile")
        private T profile;



		/**
		 * Complete user profile data
		 */
		public T getProfile() {
			return profile;
		}
		/**
		 * Complete user profile data
		 */
		public void setProfile(T profile) {
			this.profile = profile;
		}
    }