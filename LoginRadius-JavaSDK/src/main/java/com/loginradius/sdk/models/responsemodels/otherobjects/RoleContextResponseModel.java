/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Email;

	// <summary>
	//	Response containing Definition of RoleContext Profile
	// </summary>
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



		// <summary>
		//	user's email
		// </summary>
		public List<Email> getEmail() {
			return email;
		}
		// <summary>
		//	user's email
		// </summary>
		public void setEmail(List<Email> email) {
			this.email = email;
		}
		// <summary>
		//	Users complete name
		// </summary>
		public String getFullName() {
			return fullName;
		}
		// <summary>
		//	Users complete name
		// </summary>
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public String getImageUrl() {
			return imageUrl;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		// <summary>
		//	last login date
		// </summary>
		public String getLastLoginDate() {
			return lastLoginDate;
		}
		// <summary>
		//	last login date
		// </summary>
		public void setLastLoginDate(String lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}
		// <summary>
		//	Array of RoleContext object, see body tab for structure
		// </summary>
		public RoleContextResponse getRoleContext() {
			return roleContext;
		}
		// <summary>
		//	Array of RoleContext object, see body tab for structure
		// </summary>
		public void setRoleContext(RoleContextResponse roleContext) {
			this.roleContext = roleContext;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public String getUid() {
			return uid;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public void setUid(String uid) {
			this.uid = uid;
		}
    }