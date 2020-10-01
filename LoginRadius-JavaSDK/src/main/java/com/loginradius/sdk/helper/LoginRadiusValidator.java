package com.loginradius.sdk.helper;

public class LoginRadiusValidator {
	private LoginRadiusValidator() {
	}

	public static boolean isNullOrWhiteSpace(String str) {
		if (str != null) {
			str = str.trim();
		}
		return str == null || str.isEmpty();
	}

	public static String getValidationMessage(final String s) {
		return "The " + s + " is a Required Parameter So its can not be null or empty";
	}
}
