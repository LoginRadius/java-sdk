
package com.loginradius.sdk.models.configuration;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecurityQuestions {

    @SerializedName("Questions")
    @Expose
    private List<Question> questions = null;
    @SerializedName("SecurityQuestionCount")
    @Expose
    private Object securityQuestionCount;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Object getSecurityQuestionCount() {
        return securityQuestionCount;
    }

    public void setSecurityQuestionCount(Object securityQuestionCount) {
        this.securityQuestionCount = securityQuestionCount;
    }

}
