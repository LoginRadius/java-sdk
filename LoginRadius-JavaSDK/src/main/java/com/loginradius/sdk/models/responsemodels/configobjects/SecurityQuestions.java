
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

	/// <summary>
	/// Question
	/// </summary>
	public List<Object> getQuestions() {
		return questions;
	}

	/// <summary>
	/// Question
	/// </summary>
	public void setQuestions(List<Object> questions) {
		this.questions = questions;
	}

	/// <summary>
	/// Number of Question
	/// </summary>
	public Integer getSecurityQuestionCount() {
		return securityQuestionCount;
	}

	/// <summary>
	/// Number of Question
	/// </summary>
	public void setSecurityQuestionCount(Integer securityQuestionCount) {
		this.securityQuestionCount = securityQuestionCount;
	}

}
