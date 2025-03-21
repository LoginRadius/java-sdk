/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.*;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.requestmodels.*;

	// <summary>
	//	Model Class containing Definition of payload for Webhook Subscribe API
	// </summary>
	public class WebHookSubscribeModel {
	
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("TargetUrl")
        private String targetUrl;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Headers")
        private Map<String,String> headers;
		
		@SerializedName("QueryParams")
        private Map<String,String> queryParams;
		
		@SerializedName("Authentication")
        private WebhookAuthenticationModel authentication;



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
		// <summary>
		//	Name of the customer
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of the customer
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Custom headers for the webhook
		// </summary>
		public Map<String,String> getHeaders() {
			return headers;
		}
		// <summary>
		//	Custom headers for the webhook
		// </summary>
		public void setHeaders(Map<String,String> headers) {
			this.headers = headers;
		}
		// <summary>
		//	Query parameters for the webhook
		// </summary>
		public Map<String,String> getQueryParams() {
			return queryParams;
		}
		// <summary>
		//	Query parameters for the webhook
		// </summary>
		public void setQueryParams(Map<String,String> queryParams) {
			this.queryParams = queryParams;
		}
		// <summary>
		//	Authentication details for the webhook
		// </summary>
		public WebhookAuthenticationModel getAuthentication() {
			return authentication;
		}
		// <summary>
		//	Authentication details for the webhook
		// </summary>
		public void setAuthentication(WebhookAuthenticationModel authentication) {
			this.authentication = authentication;
		}
    }