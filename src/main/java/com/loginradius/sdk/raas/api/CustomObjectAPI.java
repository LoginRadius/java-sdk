package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.raas.models.RaaSCustomObjectResponse;
import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.social.models.LoginRadiusPostResponse;

/**
 * This file contains the apis for custom object
 * @author ashru_bh
 *
 */


public class CustomObjectAPI extends RaaSAPI {

	
	/*public LoginRadiusPostResponse objectCreateUpdate(String accountid, String objectId, String customObject){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectId);
		params.put("accountid", accountid);
		//customObject.to
		
		Map<String, String> postparams = new HashMap<String, String>();
		params.put("objectid", objectId);
		
		
		
		
	}*/
	
	/**
	 * 
	 * @param objectId
	 * @param accountIds
	 * @return
	 */
	
	public RaaSCustomObjectResponse getObjectByAccountIds(String objectId, String accountIds){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectId);
		params.put("accountids", accountIds);
		
		String jsonResponse = executeGet("/raas/v1/user/customObject", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectResponse.class);
		
	}
	
	
	
	/**
	 * 
	 * @param objectId
	 * @param accountId
	 * @return
	 */
	public RaaSCustomObjectResponse getObjectByAccountid(String objectId, String accountId){
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectId);
		params.put("accountid", accountId);
		
		String jsonResponse = executeGet("/raas/v1/user/customObject", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectResponse.class);

	}
	

	
}
