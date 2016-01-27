package com.loginradius.sdk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.loginradius.sdk.social.core.LoginRadiusException;

public class ArgumentValidator {

	private static String allowedPathNames[] = { "userprofile", "contact", "company", "event", "group", "like",
			"status", "album", "checkin", "audio", "video", "photo", "post", "page", "following", "mention",
			"message" };

	private static List<String> pathNames = new ArrayList<String>();

	static {

		pathNames = Arrays.asList(allowedPathNames);

	}

	public static boolean pathValidator(String path) {

		String field = path;

		boolean match = false;

		if (field == null) {
			throw new LoginRadiusException("Invalid argument");

		} else {

			field = field.trim();
			if (!pathNames.contains(field)) {

				match = false;

			} else {
				match = true;
			}

		}

		return match;

	}

}
