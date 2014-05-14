package com.loginradius.sdk.core;

public class LoginRadiusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginRadiusException(String message) {
		super(message);
	}

	public LoginRadiusException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
