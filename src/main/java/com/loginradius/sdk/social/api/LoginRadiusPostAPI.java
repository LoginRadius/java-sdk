package com.loginradius.sdk.social.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class LoginRadiusPostAPI extends LoginRadiusAPI {

	
	private final String method;
	
	private  Map<String,String> map = new HashMap<String,String>();

	
	
	public LoginRadiusPostAPI(String method){
		
		this.method = method;
		
		
	}
	
	
	
	public LoginRadiusPostAPI(String method, Map<String,String> map){
		
		this.method = method;
		this.map = map;
		
	}
	
	
	
	
	
	@Override
	public String getResponse(String token) {
		// TODO Auto-generated method stub
		
		
		//write the validator
		
		if(!ArgumentValidator.pathValidator(this.method)){
			
			throw new LoginRadiusException("Invalid Argument used. Please refer documentation and use the correct argument");
			
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(this.map!=null && !this.map.isEmpty()){
			
			params.putAll(map);
		}
		
		params.put("access_token", token);
		 return executePost(path + method, params, null);
	}

}
