package com.loginradius.sdk.resource;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;

public class LoginRadiusException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private LoginRadiusRestErrorResponse responseError;

	public LoginRadiusRestErrorResponse getErrorResponse() {
		return responseError;

	}

	public LoginRadiusException(String message) {
		super(message);
	}

	public LoginRadiusException(LoginRadiusRestErrorResponse error) {
		this.responseError = error;
	}

	public LoginRadiusException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
