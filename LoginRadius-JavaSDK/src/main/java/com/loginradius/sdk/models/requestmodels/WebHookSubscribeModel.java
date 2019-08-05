/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Webhook Subscribe API
	// </summary>
	public class WebHookSubscribeModel {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("TargetUrl")
        private String targetUrl;



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
		//	URL where trigger will send data when it invoke
		// </summary>
		public String getTargetUrl() {
			return targetUrl;
		}
		// <summary>
		//	URL where trigger will send data when it invoke
		// </summary>
		public void setTargetUrl(String targetUrl) {
			this.targetUrl = targetUrl;
		}
    }