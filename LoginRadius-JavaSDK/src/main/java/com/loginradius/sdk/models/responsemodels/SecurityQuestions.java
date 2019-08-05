/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete SecurityQuestions data
	// </summary>
	public class SecurityQuestions {
	
		
		@SerializedName("Question")
        private String question;
		
		@SerializedName("QuestionId")
        private String questionId;



		// <summary>
		//	Question
		// </summary>
		public String getQuestion() {
			return question;
		}
		// <summary>
		//	Question
		// </summary>
		public void setQuestion(String question) {
			this.question = question;
		}
		// <summary>
		//	Id of question
		// </summary>
		public String getQuestionId() {
			return questionId;
		}
		// <summary>
		//	Id of question
		// </summary>
		public void setQuestionId(String questionId) {
			this.questionId = questionId;
		}
    }