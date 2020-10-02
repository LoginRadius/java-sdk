/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete SecurityQuestions data
	 */
	public class SecurityQuestions {
	
		
		@SerializedName("Question")
        private String question;
		
		@SerializedName("QuestionId")
        private String questionId;



		/**
		 * Question
		 */
		public String getQuestion() {
			return question;
		}
		/**
		 * Question
		 */
		public void setQuestion(String question) {
			this.question = question;
		}
		/**
		 * Id of question
		 */
		public String getQuestionId() {
			return questionId;
		}
		/**
		 * Id of question
		 */
		public void setQuestionId(String questionId) {
			this.questionId = questionId;
		}
    }