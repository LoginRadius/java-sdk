/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class SecurityQuestionOptionalModel {
	
		
		@SerializedName("Answer")
        private String answer;
		
		@SerializedName("QuestionId")
        private String questionId;



		// <summary>
		//	
		// </summary>
		public String getAnswer() {
			return answer;
		}
		// <summary>
		//	
		// </summary>
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		// <summary>
		//	
		// </summary>
		public String getQuestionId() {
			return questionId;
		}
		// <summary>
		//	
		// </summary>
		public void setQuestionId(String questionId) {
			this.questionId = questionId;
		}
    }