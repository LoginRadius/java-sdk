/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.*;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for ReCaptchaBodyModel Property
	// </summary>
	public class CaptchaModel {
	
		
		@SerializedName("g-recaptcha-response")
        private String g_recaptcha_response;
		
		@SerializedName("h-captcha-response")
        private String h_captcha_response;
		
		@SerializedName("qq_captcha_randstr")
        private String qq_captcha_randstr;
		
		@SerializedName("qq_captcha_ticket")
        private String qq_captcha_ticket;



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
		//	The acknowledgement received by Google in Google recaptcha authorisation process.
		// </summary>
		public String getH_captcha_response() {
			return h_captcha_response;
		}
		// <summary>
		//	The acknowledgement received by Google in Google recaptcha authorisation process.
		// </summary>
		public void setH_captcha_response(String h-captcha-response) {
			this.h_captcha_response = h_captcha_response;
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
    }