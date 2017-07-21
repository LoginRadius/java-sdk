package com.loginradius.sdk.models.customregistrationdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSecurityQuestionsResponse {

@SerializedName("QuestionId")
@Expose
private String questionId;
@SerializedName("Question")
@Expose
private String question;

public String getQuestionId() {
return questionId;
}

public void setQuestionId(String questionId) {
this.questionId = questionId;
}

public String getQuestion() {
return question;
}

public void setQuestion(String question) {
this.question = question;
}
}
