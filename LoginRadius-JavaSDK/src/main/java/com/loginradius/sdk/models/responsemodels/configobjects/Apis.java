
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Apis {

	@SerializedName("PostForgotPasswordByEmail")
	@Expose
	private Boolean postForgotPasswordByEmail;
	@SerializedName("PostForgotPasswordByPhone")
	@Expose
	private Boolean postForgotPasswordByPhone;
	@SerializedName("PutChangePassword")
	@Expose
	private Boolean putChangePassword;
	@SerializedName("PostLoginByEmailAndPassword")
	@Expose
	private Boolean postLoginByEmailAndPassword;
	@SerializedName("PostLoginByUserNameAndPassword")
	@Expose
	private Boolean postLoginByUserNameAndPassword;
	@SerializedName("PostLoginByPhoneAndPassword")
	@Expose
	private Boolean postLoginByPhoneAndPassword;
	@SerializedName("PutUpdateProfile")
	@Expose
	private Boolean putUpdateProfile;

	/**
	 * PostForgotPasswordByEmail
	 */
	public Boolean getPostForgotPasswordByEmail() {
		return postForgotPasswordByEmail;
	}

	/**
	 * PostForgotPasswordByEmail
	 */
	public void setPostForgotPasswordByEmail(Boolean postForgotPasswordByEmail) {
		this.postForgotPasswordByEmail = postForgotPasswordByEmail;
	}

	/**
	 * PostForgotPasswordByPhone
	 */
	public Boolean getPostForgotPasswordByPhone() {
		return postForgotPasswordByPhone;
	}

	/**
	 * PostForgotPasswordByPhone
	 */
	public void setPostForgotPasswordByPhone(Boolean postForgotPasswordByPhone) {
		this.postForgotPasswordByPhone = postForgotPasswordByPhone;
	}

	/**
	 * PutChangePassword
	 */
	public Boolean getPutChangePassword() {
		return putChangePassword;
	}

	/**
	 * PutChangePassword
	 */
	public void setPutChangePassword(Boolean putChangePassword) {
		this.putChangePassword = putChangePassword;
	}

	/**
	 * PostLoginByEmailAndPassword
	 */
	public Boolean getPostLoginByEmailAndPassword() {
		return postLoginByEmailAndPassword;
	}

	/**
	 * PostLoginByEmailAndPassword
	 */
	public void setPostLoginByEmailAndPassword(Boolean postLoginByEmailAndPassword) {
		this.postLoginByEmailAndPassword = postLoginByEmailAndPassword;
	}

	/**
	 * PostLoginByUserNameAndPassword
	 */
	public Boolean getPostLoginByUserNameAndPassword() {
		return postLoginByUserNameAndPassword;
	}

	/**
	 * PostLoginByUserNameAndPassword
	 */
	public void setPostLoginByUserNameAndPassword(Boolean postLoginByUserNameAndPassword) {
		this.postLoginByUserNameAndPassword = postLoginByUserNameAndPassword;
	}

	/**
	 * PostLoginByPhoneAndPassword
	 */
	public Boolean getPostLoginByPhoneAndPassword() {
		return postLoginByPhoneAndPassword;
	}

	/**
	 * PostLoginByPhoneAndPassword
	 */
	public void setPostLoginByPhoneAndPassword(Boolean postLoginByPhoneAndPassword) {
		this.postLoginByPhoneAndPassword = postLoginByPhoneAndPassword;
	}

	/**
	 * PutUpdateProfile
	 */
	public Boolean getPutUpdateProfile() {
		return putUpdateProfile;
	}

	/**
	 * PutUpdateProfile
	 */
	public void setPutUpdateProfile(Boolean putUpdateProfile) {
		this.putUpdateProfile = putUpdateProfile;
	}

}
