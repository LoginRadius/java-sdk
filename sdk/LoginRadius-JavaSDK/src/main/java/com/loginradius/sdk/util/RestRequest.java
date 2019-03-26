package com.loginradius.sdk.util;

/* 
 * 
 * Created by LoginRadius Development Team on 16/11/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
   
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
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
import com.loginradius.sdk.resource.Endpoint;

public class RestRequest {
	private String authorization = "";
	private String apiSecret = "";
	private String sott = "";
	String emptyPayload = new String("{\"\":\"\"}");

	/**
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @param params
	 *            request input paramaters for API
	 * @return get response from LoginRadius with service URL
	 */
	public RestResponse get(String serviceUrl, Map<String, String> params) {

		if (params.containsKey("access_token") && serviceUrl.contains("/auth")) {
			authorization = params.get("access_token");
			params.remove("access_token");
		}
		if (params.containsKey("apisecret") && serviceUrl.contains("/identity/v2")) {
			apiSecret = params.get("apisecret");
			params.remove("apisecret");
		}

		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, params);

		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(15000); // set timeout to 15 seconds
			con.setReadTimeout(150000);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Accept-Encoding", "gzip");
			if (authorization != "") {
				con.setRequestProperty("Authorization", "Bearer " + authorization);
			}
			if (apiSecret != "" && LoginRadiusSDK.getRequestSigning()) {
				String time = getTime();
				con.setRequestProperty("X-Request-Expires", time);
				con.setRequestProperty("digest",
						"SHA-256=" + encode(apiSecret, time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase()));
			} else if (apiSecret != "" && !LoginRadiusSDK.getRequestSigning()) {
				con.setRequestProperty("X-LoginRadius-ApiSecret", apiSecret);
			}
			con.setDoOutput(true);
            
			BufferedReader br;
			if ("gzip".equals(con.getContentEncoding())) {
				 br = new BufferedReader(new InputStreamReader(
						con.getResponseCode() / 100 == 2 ? new GZIPInputStream(con.getInputStream()) : con.getErrorStream()));
				
		      }
		      else {
		    	 br = new BufferedReader(new InputStreamReader(
							con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
					
		      }
			String output;
			while ((output = br.readLine()) != null) {
				response.setResponse(output);
				response.setStatusCode(con.getResponseCode());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * post to handle post request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @param getParams
	 *            Request parameters for GET method
	 * @param payload
	 *            request payload
	 * @return post response from LoginRadius with GET/POST parameters
	 * 
	 */
	public RestResponse post(String serviceUrl, Map<String, String> getParams, String payload) {

		if (getParams.containsKey("sott")) {
			sott = getParams.get("sott");
			getParams.remove("sott");
		}
		if (getParams.containsKey("access_token") && serviceUrl.contains("/auth")) {
			authorization = getParams.get("access_token");
			getParams.remove("access_token");

		}
		if (getParams.containsKey("apisecret") && serviceUrl.contains("/identity/v2")) {
			apiSecret = getParams.get("apisecret");
			getParams.remove("apisecret");
		}

		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("POST");
			con.setConnectTimeout(15000); // set timeout to 15 seconds
			con.setReadTimeout(150000);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Accept-Encoding", "gzip");
			if (sott != "") {
				con.setRequestProperty("X-LoginRadius-Sott", sott);
			}
			if (authorization != "") {
				con.setRequestProperty("Authorization", "Bearer " + authorization);
			}
			if (apiSecret != "" && LoginRadiusSDK.getRequestSigning()) {
				String time = getTime();
				con.setRequestProperty("X-Request-Expires", time);
				if (payload != null && !payload.equals(emptyPayload)) {
					con.setRequestProperty("digest", "SHA-256=" + encode(apiSecret,
							time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase() + ":" + payload));
				} else {
					con.setRequestProperty("digest",
							"SHA-256=" + encode(apiSecret, time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase()));
				}
			} else if (apiSecret != "" && !LoginRadiusSDK.getRequestSigning()) {
				con.setRequestProperty("X-LoginRadius-ApiSecret", apiSecret);
			}

			con.setDoOutput(true);

			OutputStream os = con.getOutputStream();
			OutputStreamWriter body = new OutputStreamWriter(os, "UTF-8");
			body.write(payload);
			body.flush();
			body.close();

			BufferedReader br;
			if ("gzip".equals(con.getContentEncoding())) {
				 br = new BufferedReader(new InputStreamReader(
						con.getResponseCode() / 100 == 2 ? new GZIPInputStream(con.getInputStream()) : con.getErrorStream()));
				
		      }
		      else {
		    	 br = new BufferedReader(new InputStreamReader(
							con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
					
		      }
			String output;
			while ((output = br.readLine()) != null) {
				response.setResponse(output);
				response.setStatusCode(con.getResponseCode());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * Put to handle put request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @param getParams
	 *            Request parameters for GET method
	 * @param payload
	 *            request payload
	 * 
	 * @return put response from LoginRadius with service URL
	 * 
	 */

	public RestResponse put(String serviceUrl, Map<String, String> getParams, String payload) {

		if (getParams.containsKey("access_token") && serviceUrl.contains("/auth")) {
			authorization = getParams.get("access_token");
			getParams.remove("access_token");
		}
		if (getParams.containsKey("apisecret") && serviceUrl.contains("/identity/v2")) {
			apiSecret = getParams.get("apisecret");
			getParams.remove("apisecret");
		}

		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("PUT");
			con.setConnectTimeout(15000); // set timeout to 15 seconds
			con.setReadTimeout(150000);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Accept-Encoding", "gzip");	
			con.setDoOutput(true);
			if (authorization != "") {
				con.setRequestProperty("Authorization", "Bearer " + authorization);
			}
			if (apiSecret != "" && LoginRadiusSDK.getRequestSigning()) {
				String time = getTime();
				con.setRequestProperty("X-Request-Expires", time);
				if (payload != null && !payload.equals(emptyPayload)) {
					con.setRequestProperty("digest", "SHA-256=" + encode(apiSecret,
							time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase() + ":" + payload));
				} else {
					con.setRequestProperty("digest",
							"SHA-256=" + encode(apiSecret, time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase()));
				}
			} else if (apiSecret != "" && !LoginRadiusSDK.getRequestSigning()) {
				con.setRequestProperty("X-LoginRadius-ApiSecret", apiSecret);
			}
			OutputStream os = con.getOutputStream();
			OutputStreamWriter body = new OutputStreamWriter(os, "UTF-8");
			body.write(payload);
			body.flush();
			body.close();

			BufferedReader br;
			if ("gzip".equals(con.getContentEncoding())) {
				 br = new BufferedReader(new InputStreamReader(
						con.getResponseCode() / 100 == 2 ? new GZIPInputStream(con.getInputStream()) : con.getErrorStream()));
				
		      }
		      else {
		    	 br = new BufferedReader(new InputStreamReader(
							con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
					
		      }
			String output;
			while ((output = br.readLine()) != null) {
				response.setResponse(output);
				response.setStatusCode(con.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * Delete to handle delete request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @param getParams
	 *            Request parameters for GET method
	 * @param payload
	 *            request payload
	 * 
	 * @return delete response from LoginRadius with service URL
	 * 
	 */

	public RestResponse delete(String serviceUrl, Map<String, String> getParams, String payload) {

		if (getParams.containsKey("access_token") && serviceUrl.contains("/auth")) {
			authorization = getParams.get("access_token");
			getParams.remove("access_token");
		}
		if (getParams.containsKey("apisecret") && serviceUrl.contains("/identity/v2")) {
			apiSecret = getParams.get("apisecret");
			getParams.remove("apisecret");
		}

		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("DELETE");
			con.setConnectTimeout(15000); // set timeout to 15 seconds
			con.setReadTimeout(150000);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "utf-8");
			con.setRequestProperty("Accept-Encoding", "gzip");		
			con.setDoOutput(true);
			if (authorization != "") {
				con.setRequestProperty("Authorization", "Bearer " + authorization);
			}
			if (apiSecret != "" && LoginRadiusSDK.getRequestSigning()) {
				String time = getTime();
				con.setRequestProperty("X-Request-Expires", time);
				if (payload != null && !payload.equals(emptyPayload)) {
					con.setRequestProperty("digest", "SHA-256=" + encode(apiSecret,
							time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase() + ":" + payload));
				} else {

					con.setRequestProperty("digest",
							"SHA-256=" + encode(apiSecret, time + ":" + URLEncoder.encode(url, "UTF-8").toLowerCase()));
				}
			} else if (apiSecret != "" && !LoginRadiusSDK.getRequestSigning()) {
				con.setRequestProperty("X-LoginRadius-ApiSecret", apiSecret);
			}
			OutputStream os = con.getOutputStream();
			OutputStreamWriter body = new OutputStreamWriter(os, "UTF-8");
			body.write(payload);
			body.flush();
			body.close();
            
			BufferedReader br;
			if ("gzip".equals(con.getContentEncoding())) {
				 br = new BufferedReader(new InputStreamReader(
						con.getResponseCode() / 100 == 2 ? new GZIPInputStream(con.getInputStream()) : con.getErrorStream()));
				
		      }
		      else {
		    	 br = new BufferedReader(new InputStreamReader(
							con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
					
		      }
			String output;
			while ((output = br.readLine()) != null) {
				response.setResponse(output);
				response.setStatusCode(con.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	
	public String encode(String key, String data) {
		try {

			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
			sha256_HMAC.init(secret_key);
			return new String(Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes("UTF-8"))));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String getTime() {

		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s", Locale.US);
		dateFormat.setTimeZone(timeZone);
		calendar.add(Calendar.MINUTE, 60);
		return dateFormat.format(calendar.getTime());
	}

}
