package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.raas.models.LoginRadiusPresenceResponse;
import com.loginradius.sdk.raas.models.RaaSCustomObjectResponse;
import com.loginradius.sdk.raas.models.RaaSCustomObjectStats;
import com.loginradius.sdk.raas.models.RaaSResponse;
import com.loginradius.sdk.social.core.LoginRadiusClient;

/**
 * This file contains the apis for custom object
 * @author LoginRadius
 *
 */


public class CustomObjectAPI extends RaaSAPI {

	
	/**
	 * 
	 * @param accountid
	 * @param objectId
	 * @param customObject
	 * @return
	 */
	public RaaSResponse objectCreateUpdate(String accountid, String objectId, String customObject){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectId);
		params.put("accountid", accountid);
		
		String jsonResponse = executePost("/raas/v1/user/customObject/upsert", params,customObject);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

		
	}
	
	/**
	 * 
	 * @param objectId
	 * @param accountIds
	 * @return
	 */
	
	public RaaSCustomObjectResponse[] getObjectByAccountIds(String objectId, String accountIds){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectId);
		params.put("accountids", accountIds);
		
		String jsonResponse = executeGet("/raas/v1/user/customObject", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectResponse[].class);
		
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
	
	
	/**
	 * 
	 * @param objectid
	 * @return
	 */
	@Deprecated
	public RaaSCustomObjectResponse[] getObjectByUniqueObjectid(String objectid){
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectid);
		
		String jsonResponse = executeGet("/raas/v1/user/customObject", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectResponse[].class);

	}
	
	
	

	/**
	 * 
	 * @param objectid
	 * @param query
	 * @param indexvalue
	 * @return
	 */
	public RaaSCustomObjectResponse[] getObjectByQuery(String objectid, String query, String indexvalue){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectid);
		params.put("q", query);
		params.put("cursor", indexvalue);
		String jsonResponse = executeGet("/raas/v1/user/customObject", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectResponse[].class);
		
			
	}

	
	/**
	 * 
	 * @param objectid
	 * @param indexvalue
	 * @return
	 */
	public RaaSCustomObjectResponse[] getObjectByObjectid(String objectid, String indexvalue){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectid);
		params.put("cursor", indexvalue);
		String jsonResponse = executeGet("/raas/v1/user/customObject", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectResponse[].class);
		
	}
	
	/**
	 * 
	 * @param objectid
	 * @param accountId
	 * @param isBlock
	 * @return
	 */
	public RaaSResponse deleteCustomObject(String objectid, String accountId, boolean isBlock){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectid);
		params.put("accountId", accountId);
		
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("isblock", isBlock ? "TRUE" : "FALSE");
		
		String jsonResponse = executePost("/raas/v1/user/customObject/status", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
		
		
	}
	
	/**
	 * 
	 * @param objectid
	 * @return
	 */
	public RaaSCustomObjectStats getCustomObjectStats(String objectid){
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectid);
		
		String jsonResponse = executeGet("/raas/v1/user/customObject/stats",params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSCustomObjectStats.class);
		
	}
	
	/**
	 * 
	 * @param objectid
	 * @param accountid
	 * @return
	 */
	public LoginRadiusPresenceResponse checkForCustomObject(String objectid, String accountid){
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("objectid", objectid);
		params.put("accountid", accountid);
		
		String jsonResponse = executeGet("/raas/v1/user/customObject/check", params);
		return LoginRadiusClient.formatResponse(jsonResponse, LoginRadiusPresenceResponse.class);
		
	}
	
	
	
	
	

	
}
