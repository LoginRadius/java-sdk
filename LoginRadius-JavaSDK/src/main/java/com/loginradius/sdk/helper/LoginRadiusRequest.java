package com.loginradius.sdk.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;

public class LoginRadiusRequest {
	private LoginRadiusRequest() {
	}

	private static final String encoding = "UTF-8";
	private static final String keySecret = "apiSecret";
	private static final String keyToken = "access_token";

	private static String authorization = "";
	private static String apiSecret = "";
	private static String sott = "";

	static ErrorResponse errorResponse;
	private static Integer code = 0;

	public static void execute(String method, String resourcePath, Map<String, String> params, String payload,
			final AsyncHandler<String> asyncHandler) {
		String serviceUrl = LoginRadiusSDK.getDomain() + "/" + resourcePath;
		if (!LoginRadiusValidator.isNullOrWhiteSpace(LoginRadiusSDK.getApiRegion())) {
			params.put("region", LoginRadiusSDK.getApiRegion());
		}
		if (resourcePath.equals("ciam/appinfo")) {
			serviceUrl = LoginRadiusSDK.getConfigDomain() + "/" + resourcePath;
		}
		if (params.containsKey("sott")) {
			sott = params.get("sott");
			params.remove("sott");
		}
		if (params.containsKey(keySecret) && serviceUrl.contains("/identity/v2")) {
			apiSecret = params.get(keySecret);
			params.remove(keySecret);
		}
		if (params.containsKey(keyToken) && resourcePath.contains("identity/v2/auth")) {
			authorization = params.get(keyToken);
			params.remove(keyToken);
		}

		String task = LoginRadiusRequestRunner(method, LoginRadiusSDK.getRequestUrl(serviceUrl, params), payload);
		if (code == 200 && !task.contains("description") && !task.contains("Description")) {
			asyncHandler.onSuccess(task);
		} else {
			ErrorResponse errorResponse = exception(task);
			asyncHandler.onFailure(errorResponse);
		}
	}

	private static String LoginRadiusRequestRunner(String method, String url, String payload) {

		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod(method);
			con.setConnectTimeout(15000); // set timeout to 15 seconds
			con.setReadTimeout(15000);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", encoding);
			con.setRequestProperty("Accept-Encoding", "gzip");

			if (!sott.equals("")) {
				con.setRequestProperty("X-LoginRadius-Sott", sott);
			}
			if (!authorization.equals("")) {
				con.setRequestProperty("Authorization", "Bearer " + authorization);
				authorization = "";
			}
			if(LoginRadiusSDK.getOriginIp()!=null && LoginRadiusSDK.getOriginIp()!="") {
				con.setRequestProperty("X-Origin-IP", LoginRadiusSDK.getOriginIp());
				
			}
			if (!apiSecret.equals("") && LoginRadiusSDK.getRequestSigning()) {
				String time = getTime();
				con.setRequestProperty("X-Request-Expires", time);
				if (payload != null) {
					con.setRequestProperty("digest", "SHA-256=" + encode(apiSecret,
							time + ":" + URLEncoder.encode(url, encoding).toLowerCase() + ":" + payload));
				} else {
					con.setRequestProperty("digest", "SHA-256="
							+ encode(apiSecret, time + ":" + URLEncoder.encode(url, encoding).toLowerCase()));
				}
			} else if (!apiSecret.equals("") && !LoginRadiusSDK.getRequestSigning()) {
				con.setRequestProperty("X-LoginRadius-ApiSecret", apiSecret);
			}
			con.setDoOutput(true);
			if (!method.equals("GET")) {
				OutputStream os = con.getOutputStream();
				OutputStreamWriter body = new OutputStreamWriter(os, encoding);
				String p = payload != null ? payload : "{}";
				body.write(p);
				body.flush();
				body.close();
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				code = responseCode;
				return readStream(con.getInputStream(), con.getContentEncoding());
			} else if(responseCode == 429){
				code = 106;
				return "Too Many Request in a particular time frame";
			}else {
				code = responseCode;
				return readStream(con.getErrorStream(), con.getContentEncoding());
			}

		} catch (UnknownHostException e) {
			code = 101;
			return e.toString();
		} catch (IllegalArgumentException e) {
			code = 102;
			return e.toString();
		} catch (MalformedURLException e) {
			code = 103;
			return e.toString();
		} catch (SocketTimeoutException e) {
			code = 104;
			return e.toString();
		} catch (IOException e) {
			code = 105;
			return e.toString();
		}
	}

	private static String readStream(InputStream in, String en) {
		BufferedReader reader = null;
		StringBuilder response = new StringBuilder();
		try {
			if ("gzip".equals(en)) {
				reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(in)));
			} else {
				reader = new BufferedReader(new InputStreamReader(in));
			}
			String line = "";
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return response.toString();
	}

	public static String encode(String key, final String data) {
		String s = null;
		try {
			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(encoding), "HmacSHA256");
			sha256_HMAC.init(secret_key);
			s = Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes(encoding)));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return s;
	}

	private static String getTime() {
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s", Locale.US);
		dateFormat.setTimeZone(timeZone);
		calendar.add(Calendar.MINUTE, 60);
		return dateFormat.format(calendar.getTime());
	}

	private static ErrorResponse exception(String error) {
		ErrorResponse obj = new ErrorResponse();
		switch (code) {
		case 101:
			obj.setDescription(
					"Thrown to indicate that the IP address of a host could not be determined, Please Check your internet connection");
			obj.setErrorCode(101);
			obj.setMessage("UnknownHostException");
			break;
		case 102:
			obj.setDescription(error);
			obj.setErrorCode(102);
			obj.setMessage("IllegalArgumentException");
			break;
		case 103:
			obj.setDescription(error);
			obj.setErrorCode(103);
			obj.setMessage("MalformedURLException");
			break;
		case 104:
			obj.setDescription(error);
			obj.setErrorCode(104);
			obj.setMessage("SocketTimeoutException");
			break;
		case 105:
			obj.setDescription(error);
			obj.setErrorCode(105);
			obj.setMessage("IOException");
			break;
		case 106:
			obj.setDescription(error);
			obj.setErrorCode(106);
			obj.setMessage("TOO_MANY_REQUESTS");
			break;
		default:
			TypeToken<ErrorResponse> typeToken = new TypeToken<ErrorResponse>() {
			};
			obj = JsonDeserializer.deserializeJson(error, typeToken);
			break;
		}

		return obj;
	}
}
