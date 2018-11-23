package com.loginradius.sdk.resource;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loginradius.sdk.advanced.api.LRAdvancedAPI;
import com.loginradius.sdk.authentication.api.LRAuthenticationAPI;

import com.loginradius.sdk.management.api.LRManagementAPI;
import com.loginradius.sdk.models.AccessToken;

import java.util.Map;


public class LoginRadiusClient {
	private static Map<String, EndpointContent> authenticationLookup;
	private static Map<String, EndpointContent> managementLookup;
	private static Map<String, EndpointContent> advancedLookup;
	private static Gson gson;
	private AccessToken _token;

	public LoginRadiusClient(AccessToken token) {
		gson = new Gson();
		_token = token;
		authenticationLookup = Endpoint.authenticationAPILookUp();
		managementLookup = Endpoint.managementAPILookUp();
		advancedLookup = Endpoint.advancedAPILookUp();
	}

	public LoginRadiusClient(String token) {
		gson = new Gson();
		_token = new AccessToken();
		_token.setAccessToken(token);
		authenticationLookup = Endpoint.authenticationAPILookUp();
		managementLookup = Endpoint.managementAPILookUp();
		advancedLookup = Endpoint.advancedAPILookUp();
	}

	public LoginRadiusClient() {
		gson = new Gson();
		_token = new AccessToken();
		_token.setAccessToken("");
		authenticationLookup = Endpoint.authenticationAPILookUp();
		managementLookup = Endpoint.managementAPILookUp();
		advancedLookup = Endpoint.advancedAPILookUp();
	}

	public void setToken(String token) {
		_token = new AccessToken();
		_token.setAccessToken(token);
	}

	public void setToken(AccessToken token) {
		_token = token;
	}

	public static <T> T formatResponse(String response, Class<T> cls) {
		GsonBuilder gsonbuilder = new com.google.gson.GsonBuilder();
		gsonbuilder.serializeNulls();

		Gson gson = gsonbuilder.create();

		return gson.fromJson(response, cls);
	}

	public <T> T getResponse(LRAuthenticationAPI api, Class<T> cls) {
		if (api == null) {
			throw new IllegalArgumentException("api");
		} else {
			String jsonresponse = getStringResponse(api);

			return gson.fromJson(jsonresponse, cls);
		}
	}

	public String getStringResponse(LRAuthenticationAPI api) {
		return api.getResponse(_token.getAccessToken());
	}

	public <T> T getResponse(LRManagementAPI api, Class<T> cls) {
		if (api == null) {
			throw new IllegalArgumentException("api");
		} else {
			String jsonresponse = getStringResponse(api);

			return gson.fromJson(jsonresponse, cls);
		}
	}

	public String getStringResponse(LRManagementAPI api) {
		return api.getResponse(_token.getAccessToken());
	}

	public <T> T getResponse(LRAdvancedAPI api, Class<T> cls) {
		if (api == null) {
			throw new IllegalArgumentException("api");
		} else {
			String jsonresponse = getStringResponse(api);

			return gson.fromJson(jsonresponse, cls);
		}
	}

	public String getStringResponse(LRAdvancedAPI api) {
		return api.getResponse(_token.getAccessToken());
	}
	
	public static Map<String, EndpointContent> getAuthenticationAPILookup() {
		return LoginRadiusClient.authenticationLookup;
	}

	public static Map<String, EndpointContent> getManagementAPILookup() {
		return LoginRadiusClient.managementLookup;
	}

	public static Map<String, EndpointContent> getAdvancedAPILookup() {
		return LoginRadiusClient.advancedLookup;
	}
}