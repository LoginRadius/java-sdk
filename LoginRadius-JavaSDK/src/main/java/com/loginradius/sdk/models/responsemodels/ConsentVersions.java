/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing consent version information
	// </summary>
	public class ConsentVersions {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("IsCustom")
        private Boolean isCustom;
		
		@SerializedName("Version")
        private Integer version;



		// <summary>
		//	Allowed events: Login, Register, UpdateProfile, ResetPassword, ChangePassword, emailVerification, AddEmail, RemoveEmail, BlockAccount, DeleteAccount, SetUsername, AssignRoles, UnassignRoles, SetPassword, LinkAccount, UnlinkAccount, UpdatePhoneId, VerifyPhoneNumber, CreateCustomObject, UpdateCustomobject, DeleteCustomObject
		// </summary>
		public String getEvent() {
			return event;
		}
		// <summary>
		//	Allowed events: Login, Register, UpdateProfile, ResetPassword, ChangePassword, emailVerification, AddEmail, RemoveEmail, BlockAccount, DeleteAccount, SetUsername, AssignRoles, UnassignRoles, SetPassword, LinkAccount, UnlinkAccount, UpdatePhoneId, VerifyPhoneNumber, CreateCustomObject, UpdateCustomobject, DeleteCustomObject
		// </summary>
		public void setEvent(String event) {
			this.event = event;
		}
		// <summary>
		//	true/false
		// </summary>
		public Boolean getIsCustom() {
			return isCustom;
		}
		// <summary>
		//	true/false
		// </summary>
		public void setIsCustom(Boolean isCustom) {
			this.isCustom = isCustom;
		}
		// <summary>
		//	privacy policy version
		// </summary>
		public Integer getVersion() {
			return version;
		}
		// <summary>
		//	privacy policy version
		// </summary>
		public void setVersion(Integer version) {
			this.version = version;
		}
    }