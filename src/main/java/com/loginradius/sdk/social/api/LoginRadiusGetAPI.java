package com.loginradius.sdk.social.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class LoginRadiusGetAPI extends LoginRadiusAPI {

	
	
	private String method = "";
	
	private Map<String,String> map = new HashMap<String,String>();

	
	
	public LoginRadiusGetAPI(String method){
		
		this.method = method;
		
	}
	
	
	
	public LoginRadiusGetAPI(String method, Map<String,String> map){
		
		this.method = method;
		this.map = map;
		
	}
	
	
	
	public String getResponse(String token){
		
		//ARgument validator should go here.
		
		if(!ArgumentValidator.pathValidator(this.method)){
			
			
			throw new LoginRadiusException("Invalid Argument used. Please refer documentation and use the correct argument");
			
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(this.map!=null && !this.map.isEmpty()){
			
			params.putAll(map);
		}
		
		params.put("access_token", token);

		return executeGet(path + method, params);
		
	}
	
	
	
	
	
}
