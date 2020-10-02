/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Email;

	/**
	 * Response containing Definition of RoleContext Profile
	 */
	public class RoleContextResponseModel {
	
		
		@SerializedName("Email")
        private List<Email> email;
		
		@SerializedName("FullName")
        private String fullName;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("LastLoginDate")
        private String lastLoginDate;
		
		@SerializedName("RoleContext")
        private RoleContextResponse roleContext;
		
		@SerializedName("Uid")
        private String uid;



		/**
		 * user's email
		 */
		public List<Email> getEmail() {
			return email;
		}
		/**
		 * user's email
		 */
		public void setEmail(List<Email> email) {
			this.email = email;
		}
		/**
		 * Users complete name
		 */
		public String getFullName() {
			return fullName;
		}
		/**
		 * Users complete name
		 */
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public String getImageUrl() {
			return imageUrl;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		/**
		 * last login date
		 */
		public String getLastLoginDate() {
			return lastLoginDate;
		}
		/**
		 * last login date
		 */
		public void setLastLoginDate(String lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}
		/**
		 * Array of RoleContext object, see body tab for structure
		 */
		public RoleContextResponse getRoleContext() {
			return roleContext;
		}
		/**
		 * Array of RoleContext object, see body tab for structure
		 */
		public void setRoleContext(RoleContextResponse roleContext) {
			this.roleContext = roleContext;
		}
		/**
		 * UID, the unified identifier for each user account
		 */
		public String getUid() {
			return uid;
		}
		/**
		 * UID, the unified identifier for each user account
		 */
		public void setUid(String uid) {
			this.uid = uid;
		}
    }