
package com.loginradius.sdk.models.responsemodels.configobjects;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecurityQuestions {

	@SerializedName("Questions")
	@Expose
	private List<Object> questions = null;
	@SerializedName("SecurityQuestionCount")
	@Expose
	private Integer securityQuestionCount;

	/**
	 * Question
	 */
	public List<Object> getQuestions() {
		return questions;
	}

	/**
	 * Question
	 */
	public void setQuestions(List<Object> questions) {
		this.questions = questions;
	}

	/**
	 * Number of Question
	 */
	public Integer getSecurityQuestionCount() {
		return securityQuestionCount;
	}

	/**
	 * Number of Question
	 */
	public void setSecurityQuestionCount(Integer securityQuestionCount) {
		this.securityQuestionCount = securityQuestionCount;
	}

}
