/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete WebHook data
	 */
	public class WebHookSubscribeModel {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("TargetUrl")
        private String targetUrl;



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
		 * URL where trigger will send data when it invoke
		 */
		public String getTargetUrl() {
			return targetUrl;
		}
		/**
		 * URL where trigger will send data when it invoke
		 */
		public void setTargetUrl(String targetUrl) {
			this.targetUrl = targetUrl;
		}
    }