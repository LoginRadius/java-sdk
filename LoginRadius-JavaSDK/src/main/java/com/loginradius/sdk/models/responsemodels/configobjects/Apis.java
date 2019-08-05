
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

	/// <summary>
	/// PostForgotPasswordByEmail
	/// </summary>
	public Boolean getPostForgotPasswordByEmail() {
		return postForgotPasswordByEmail;
	}

	/// <summary>
	/// PostForgotPasswordByEmail
	/// </summary>
	public void setPostForgotPasswordByEmail(Boolean postForgotPasswordByEmail) {
		this.postForgotPasswordByEmail = postForgotPasswordByEmail;
	}

	/// <summary>
	/// PostForgotPasswordByPhone
	/// </summary>
	public Boolean getPostForgotPasswordByPhone() {
		return postForgotPasswordByPhone;
	}

	/// <summary>
	/// PostForgotPasswordByPhone
	/// </summary>
	public void setPostForgotPasswordByPhone(Boolean postForgotPasswordByPhone) {
		this.postForgotPasswordByPhone = postForgotPasswordByPhone;
	}

	/// <summary>
	/// PutChangePassword
	/// </summary>
	public Boolean getPutChangePassword() {
		return putChangePassword;
	}

	/// <summary>
	/// PutChangePassword
	/// </summary>
	public void setPutChangePassword(Boolean putChangePassword) {
		this.putChangePassword = putChangePassword;
	}

	/// <summary>
	/// PostLoginByEmailAndPassword
	/// </summary>
	public Boolean getPostLoginByEmailAndPassword() {
		return postLoginByEmailAndPassword;
	}

	/// <summary>
	/// PostLoginByEmailAndPassword
	/// </summary>
	public void setPostLoginByEmailAndPassword(Boolean postLoginByEmailAndPassword) {
		this.postLoginByEmailAndPassword = postLoginByEmailAndPassword;
	}

	/// <summary>
	/// PostLoginByUserNameAndPassword
	/// </summary>
	public Boolean getPostLoginByUserNameAndPassword() {
		return postLoginByUserNameAndPassword;
	}

	/// <summary>
	/// PostLoginByUserNameAndPassword
	/// </summary>
	public void setPostLoginByUserNameAndPassword(Boolean postLoginByUserNameAndPassword) {
		this.postLoginByUserNameAndPassword = postLoginByUserNameAndPassword;
	}

	/// <summary>
	/// PostLoginByPhoneAndPassword
	/// </summary>
	public Boolean getPostLoginByPhoneAndPassword() {
		return postLoginByPhoneAndPassword;
	}

	/// <summary>
	/// PostLoginByPhoneAndPassword
	/// </summary>
	public void setPostLoginByPhoneAndPassword(Boolean postLoginByPhoneAndPassword) {
		this.postLoginByPhoneAndPassword = postLoginByPhoneAndPassword;
	}

	/// <summary>
	/// PutUpdateProfile
	/// </summary>
	public Boolean getPutUpdateProfile() {
		return putUpdateProfile;
	}

	/// <summary>
	/// PutUpdateProfile
	/// </summary>
	public void setPutUpdateProfile(Boolean putUpdateProfile) {
		this.putUpdateProfile = putUpdateProfile;
	}

}
