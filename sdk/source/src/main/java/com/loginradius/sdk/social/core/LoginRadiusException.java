package com.loginradius.sdk.social.core;

import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;


public class LoginRadiusException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private LoginRadiusRestErrorResponse responseError;
	
	public LoginRadiusRestErrorResponse getErrorResponse(){
		return responseError;
	}
       
	public LoginRadiusException(String message){
		super(message);
	}
	public LoginRadiusException(LoginRadiusRestErrorResponse error) {
	     this.responseError = error;
	}

	public LoginRadiusException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	
}
