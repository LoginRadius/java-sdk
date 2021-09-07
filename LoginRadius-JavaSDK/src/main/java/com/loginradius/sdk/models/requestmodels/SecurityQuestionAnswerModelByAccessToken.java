/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class SecurityQuestionAnswerModelByAccessToken {
	
		
		@SerializedName("ReplaceSecurityQuestionAnswer")
        private Boolean replaceSecurityQuestionAnswer;
		
		@SerializedName("SecurityQuestionAnswer")
        private List<SecurityQuestionOptionalModel> securityQuestionAnswer;



		// <summary>
		//	
		// </summary>
		public Boolean getReplaceSecurityQuestionAnswer() {
			return replaceSecurityQuestionAnswer;
		}
		// <summary>
		//	
		// </summary>
		public void setReplaceSecurityQuestionAnswer(Boolean replaceSecurityQuestionAnswer) {
			this.replaceSecurityQuestionAnswer = replaceSecurityQuestionAnswer;
		}
		// <summary>
		//	
		// </summary>
		public List<SecurityQuestionOptionalModel> getSecurityQuestionAnswer() {
			return securityQuestionAnswer;
		}
		// <summary>
		//	
		// </summary>
		public void setSecurityQuestionAnswer(List<SecurityQuestionOptionalModel> securityQuestionAnswer) {
			this.securityQuestionAnswer = securityQuestionAnswer;
		}
    }