package com.loginradius.sdk.core;

import com.google.gson.Gson;
import com.loginradius.sdk.api.LoginRadiusAPI;
import com.loginradius.sdk.models.AccessToken;

public class LoginRadiusClient {

	AccessToken _token;
	String token1;

	public LoginRadiusClient(AccessToken token) {
		_token = token;
	}
	public LoginRadiusClient(String token) {
		_token = new AccessToken();
		_token.access_token=token;
		
	
	}
   
	public <T> T getResponse(LoginRadiusAPI api, Class<T> cls) 
	{
		if (api == null) {
			throw new IllegalArgumentException("api");
		} else {
			String jsonresponse = getStringResponse(api);
			
			return new Gson().fromJson(jsonresponse, cls);
		}
	}

	public String getStringResponse(LoginRadiusAPI api) 
	{
		return api.getResponse(_token.access_token);
	}
}
