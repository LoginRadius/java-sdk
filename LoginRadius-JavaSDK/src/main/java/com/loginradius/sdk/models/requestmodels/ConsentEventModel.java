/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model class containing list of consent
	 */
	public class ConsentEventModel {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("IsCustom")
        private Boolean isCustom;



		/**
		 * Allowed events: Login, Register, UpdateProfile, ResetPassword, ChangePassword, emailVerification, AddEmail, RemoveEmail, BlockAccount, DeleteAccount, SetUsername, AssignRoles, UnassignRoles, SetPassword, LinkAccount, UnlinkAccount, UpdatePhoneId, VerifyPhoneNumber, CreateCustomObject, UpdateCustomobject, DeleteCustomObject
		 */
		public String getEvent() {
			return event;
		}
		/**
		 * Allowed events: Login, Register, UpdateProfile, ResetPassword, ChangePassword, emailVerification, AddEmail, RemoveEmail, BlockAccount, DeleteAccount, SetUsername, AssignRoles, UnassignRoles, SetPassword, LinkAccount, UnlinkAccount, UpdatePhoneId, VerifyPhoneNumber, CreateCustomObject, UpdateCustomobject, DeleteCustomObject
		 */
		public void setEvent(String event) {
			this.event = event;
		}
		/**
		 * true/false
		 */
		public Boolean getIsCustom() {
			return isCustom;
		}
		/**
		 * true/false
		 */
		public void setIsCustom(Boolean isCustom) {
			this.isCustom = isCustom;
		}
    }