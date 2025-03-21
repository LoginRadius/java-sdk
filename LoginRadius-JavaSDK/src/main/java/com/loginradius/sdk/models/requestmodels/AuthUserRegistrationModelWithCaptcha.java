/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Auth User Registration by Recaptcha API
	// </summary>
	public class AuthUserRegistrationModelWithCaptcha extends AuthUserRegistrationModel {
	
		
		@SerializedName("g-recaptcha-response")
        private String g_recaptcha_response;
		
		@SerializedName("qq_captcha_randstr")
        private String qq_captcha_randstr;
		
		@SerializedName("qq_captcha_ticket")
        private String qq_captcha_ticket;
		
		@SerializedName("recaptcha_challenge_field")
        private String recaptcha_challenge_field;
		
		@SerializedName("recaptcha_response_field")
        private String recaptcha_response_field;



		// <summary>
		//	The acknowledgement received by Google in Google recaptcha authorisation process.
		// </summary>
		public String getG_Recaptcha_Response() {
			return g_recaptcha_response;
		}
		// <summary>
		//	The acknowledgement received by Google in Google recaptcha authorisation process.
		// </summary>
		public void setG_Recaptcha_Response(String g_recaptcha_response) {
			this.g_recaptcha_response = g_recaptcha_response;
		}
		// <summary>
		//	the value of the user's random string retrieved from the QQ captcha
		// </summary>
		public String getQq_Captcha_Randstr() {
			return qq_captcha_randstr;
		}
		// <summary>
		//	the value of the user's random string retrieved from the QQ captcha
		// </summary>
		public void setQq_Captcha_Randstr(String qq_captcha_randstr) {
			this.qq_captcha_randstr = qq_captcha_randstr;
		}
		// <summary>
		//	QQ Captcha ticket received from QQ in the QQ Captcha authorization process
		// </summary>
		public String getQq_Captcha_Ticket() {
			return qq_captcha_ticket;
		}
		// <summary>
		//	QQ Captcha ticket received from QQ in the QQ Captcha authorization process
		// </summary>
		public void setQq_Captcha_Ticket(String qq_captcha_ticket) {
			this.qq_captcha_ticket = qq_captcha_ticket;
		}
		// <summary>
		//	V1 recaptcha field (optional in case of V2 recaptcha)
		// </summary>
		public String getRecaptcha_challenge_field() {
			return recaptcha_challenge_field;
		}
		// <summary>
		//	V1 recaptcha field (optional in case of V2 recaptcha)
		// </summary>
		public void setRecaptcha_challenge_field(String recaptcha_challenge_field) {
			this.recaptcha_challenge_field = recaptcha_challenge_field;
		}
		// <summary>
		//	V1 recaptcha field (optional in case of V2 recaptcha)
		// </summary>
		public String getRecaptcha_response_field() {
			return recaptcha_response_field;
		}
		// <summary>
		//	V1 recaptcha field (optional in case of V2 recaptcha)
		// </summary>
		public void setRecaptcha_response_field(String recaptcha_response_field) {
			this.recaptcha_response_field = recaptcha_response_field;
		}
    }