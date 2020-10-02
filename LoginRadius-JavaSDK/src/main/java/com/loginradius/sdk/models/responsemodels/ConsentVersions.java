/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing consent version information
	 */
	public class ConsentVersions {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("IsCustom")
        private Boolean isCustom;
		
		@SerializedName("Version")
        private Integer version;



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
		/**
		 * privacy policy version
		 */
		public Integer getVersion() {
			return version;
		}
		/**
		 * privacy policy version
		 */
		public void setVersion(Integer version) {
			this.version = version;
		}
    }