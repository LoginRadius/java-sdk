package com.loginradius.sdk.social.core;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loginradius.sdk.social.api.LoginRadiusAPI;
import com.loginradius.sdk.social.models.AccessToken;

public class LoginRadiusClient {

	private AccessToken _token;

	public LoginRadiusClient(AccessToken token) {
		_token = token;
	}
	public LoginRadiusClient(String token) {
		_token = new AccessToken();
		_token.access_token=token;
		
	}
	
	
	
	public static <T> T formatResponse(String response, Class<T> cls) 
	{	
		GsonBuilder gsonbuilder= new com.google.gson.GsonBuilder();
		gsonbuilder.serializeNulls();
		
		Gson gson= gsonbuilder.create();
		
		return gson.fromJson(response, cls); 
				
		//return new Gson().fromJson(response, cls);		
		
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
	
	 /*
     * @Description: Method to convert Map to JSON String
     * @param: map Map<String, String> 
     * @return: json String
     */
    public static String convert(Map<String, String> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }
	
	
	
	
}
