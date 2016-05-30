package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusException;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestRequest;
import com.loginradius.sdk.util.RestResponse;
import com.loginradius.sdk.raas.models.RaaSClientConfig;
/**
 *LoginRadiusAPI base class
 * 
 * 
 */
public abstract class RaaSAPI {
	
	protected RestRequest restrequest = new RestRequest();
	protected LoginRadiusJsonDeserializer deserializer = new LoginRadiusJsonDeserializer();	
	
	protected String executeGet(String apiRelativepath,
			Map<String,String> params) {

		Map<String, String> reParams = new HashMap<String, String>();
		reParams.put("appkey", RaaSClientConfig.getConfiguration().getAppKey());
		reParams.put("appsecret", RaaSClientConfig.getConfiguration().getAppSecret());
		if(RaaSClientConfig.getConfiguration().getObjectID()!=null)
			reParams.put("objectid", RaaSClientConfig.getConfiguration().getObjectID());
		if(params!=null)
		reParams.putAll(params);
		RestResponse response = restrequest.get(apiRelativepath,reParams);
	
		String jsonresponse = response.getResponse();
		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {
			
			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}

	protected String executePost(String apiRelativepath,
			Map<String, String> getParams, Map<String, String> postParams) {

		Map<String, String> reParams = new HashMap<String, String>();
		reParams.put("appkey", RaaSClientConfig.getConfiguration().getAppKey());
		reParams.put("appsecret", RaaSClientConfig.getConfiguration().getAppSecret());
		if(RaaSClientConfig.getConfiguration().getObjectID()!=null)
			reParams.put("objectid", RaaSClientConfig.getConfiguration().getObjectID());
		if(getParams!=null)
		reParams.putAll(getParams);
		RestResponse response = restrequest.post(apiRelativepath,
				reParams, postParams);

		String jsonresponse = response.getResponse();
		
		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {
			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}
	
	protected String executePost(String apiRelativepath,
			Map<String, String> getParams, String postParams) {

		Map<String, String> reParams = new HashMap<String, String>();
		reParams.put("appkey", RaaSClientConfig.getConfiguration().getAppKey());
		reParams.put("appsecret", RaaSClientConfig.getConfiguration().getAppSecret());
		if(RaaSClientConfig.getConfiguration().getObjectID()!=null)
			reParams.put("objectid", RaaSClientConfig.getConfiguration().getObjectID());
		if(getParams!=null)
		reParams.putAll(getParams);
		RestResponse response = restrequest.post(apiRelativepath,
				reParams, postParams);

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {
			
			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}
	
	
}
