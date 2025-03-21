/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class SecurityQuestionAnswerUpdateModel {
	
		
		@SerializedName("SecurityQuestionAnswer")
        private List<SecurityQuestionModel> securityQuestionAnswer;



		// <summary>
		//	
		// </summary>
		public List<SecurityQuestionModel> getSecurityQuestionAnswer() {
			return securityQuestionAnswer;
		}
		// <summary>
		//	
		// </summary>
		public void setSecurityQuestionAnswer(List<SecurityQuestionModel> securityQuestionAnswer) {
			this.securityQuestionAnswer = securityQuestionAnswer;
		}
    }