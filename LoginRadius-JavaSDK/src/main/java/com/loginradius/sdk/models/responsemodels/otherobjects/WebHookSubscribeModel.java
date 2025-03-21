/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.*;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete WebHook data
	// </summary>
	public class WebHookSubscribeModel {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("TargetUrl")
        private String targetUrl;
		
		@SerializedName("Event")
        private String event;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("LastModifiedDate")
        private String lastModifiedDate;
		
		@SerializedName("SecretName")
        private String secretName;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("IsIntegrationWebhook")
        private Boolean isIntegrationWebhook;
		
		@SerializedName("Headers")
        private Map<String,String> headers;
		
		@SerializedName("QueryParams")
        private Map<String,String> queryParams;
		
		@SerializedName("Authentication")
        private JsonObject authentication;



		// <summary>
		//	ID of the User
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public void setId(String id) {
			this.id = id;
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
		//	Date of Creation of Profile
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Date of Creation of Profile
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	LastModifiedDate value that need to be inserted
		// </summary>
		public String getLastModifiedDate() {
			return lastModifiedDate;
		}
		// <summary>
		//	LastModifiedDate value that need to be inserted
		// </summary>
		public void setLastModifiedDate(String lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
		}
		// <summary>
		//	The event associated with the consent form
		// </summary>
		public String getSecretName() {
			return secretName;
		}
		// <summary>
		//	The event associated with the consent form
		// </summary>
		public void setSecretName(String secretName) {
			this.secretName = secretName;
		}
		// <summary>
		//	Webhook Name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Webhook Name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	The event associated with the consent form
		// </summary>
		public Boolean getIsIntegrationWebhook() {
			return isIntegrationWebhook;
		}
		// <summary>
		//	The event associated with the consent form
		// </summary>
		public void setIsIntegrationWebhook(Boolean isIntegrationWebhook) {
			this.isIntegrationWebhook = isIntegrationWebhook;
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
		public JsonObject getAuthentication() {
			return authentication;
		}
		// <summary>
		//	Authentication details for the webhook
		// </summary>
		public void setAuthentication(JsonObject authentication) {
			this.authentication = authentication;
		}
    }