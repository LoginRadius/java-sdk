/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model class containing list of consent
	// </summary>
	public class ConsentEventModel {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("IsCustom")
        private Boolean isCustom;



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
    }