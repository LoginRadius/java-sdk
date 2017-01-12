package com.loginradius.sdk.social.core;

import java.util.Map;

public class LoginRadiusEndpoint {
	private static final String LOGINRADIUS_API_ROOT = "https://api.loginradius.com";

	public static String getRequestUrl(String relativeUrl) {

		if (relativeUrl.startsWith("/")) {
			return LOGINRADIUS_API_ROOT + relativeUrl;
		} else {
			return LOGINRADIUS_API_ROOT + "/" + relativeUrl;
		}
	}

	public static String getRequestUrl(String relativeUrl,
			Map<String, String> queryArgs) {

		String keyvalueString = createKeyValueString(queryArgs);

		String url = getRequestUrl(relativeUrl);

		if (url.contains("?")) {
			return url + "&" + keyvalueString;
		}

		return url + "?" + keyvalueString;
	}

	public static String createKeyValueString(Map<String, String> queryArgs) {

		if (queryArgs != null) {
			String[] sb = new String[queryArgs.size()];

			int i = 0;
			for (Map.Entry<String, String> entry : queryArgs.entrySet()) {
				sb[i] = entry.getKey() + "=" + entry.getValue();
				i++;
			}

			return combine(sb, "&");
		} else {
			return "";
		}
	}

	public static String combine(String[] s, String glue) {
		int k = s.length;
		if (k == 0)
			return null;
		StringBuilder out = new StringBuilder();
		out.append(s[0]);
		for (int x = 1; x < k; ++x)
			out.append(glue).append(s[x]);
		return out.toString();
	}
}
