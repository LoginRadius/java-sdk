package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.raas.models.RaaSUserDetails;
import com.loginradius.sdk.raas.models.RaaSHashPassword;
import com.loginradius.sdk.raas.models.RaaSResponse;



public class AccountAPI extends  RaaSAPI{

	/**
	 * 
	 * @param accountId accountID or RaasID of the user
	 * @param provider social provider name
	 * @param providerId social provider ID of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse linkAccount(String accountId, String provider, String providerId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("provider", provider);
		params.put("providerid", providerId);
		String jsonResponse = executePost("/raas/v1/account/link", null, params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	/**
	 * 
	 * @param accountId accountID or RaasID of the user
	 * @param provider social provider name
	 * @param providerId social provider ID of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse unlinkAccount(String accountId, String provider, String providerId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("provider", provider);
		params.put("providerid", providerId);
		String jsonResponse = executePost("/raas/v1/account/unlink", null, params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	/**
	 * 
	 * @param accountId accountID or RaasID of the user
	 * @param emailId Email ID of the user for which raas profile need to be created
	 * @param password password of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse createRaaSProfile(String accountId,String emailId,String password){
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("emailid", emailId);
		params.put("password", password);
		String jsonResponse = executePost("/raas/v1/account/profile", null, params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	/**
	 * 
	 * @param accountId accountID or RaasID of the user
	 * @return array of RaasUserProfile with all user data
	 */
	public RaaSUserDetails[] getAccount(String accountId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		String jsonResponse = executeGet("/raas/v1/account", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails[].class);
	}
	
	/**
	 * 
	 * @param accountId accountID or RaasID of the user
	 * @param isBlock true or false whether the user should be blocked or not
	 * @return returns isPosted with value true
	 */
	
	/**
	 * 
	 * @param userID ID generated from RaasProfile
	 * @return HashedPassword of the user
	 */
	public RaaSHashPassword getHashPassword(String accountId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		String jsonResponse = executeGet("/raas/v1/account/password", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSHashPassword.class);
	}
	
	
	
	
	public RaaSResponse setAccountStatus(String accountId, boolean isBlock){
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", accountId);
		Map<String, String> postParams = new HashMap<String,String>();
		postParams.put("isblock", isBlock?"true":"false");				
		String jsonResponse = executePost("/raas/v1/user/status", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	/**
	 * 
	 * @param accountId accountID or RaasID of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse deleteAccount(String accountId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", accountId);
		String jsonResponse = executeGet("/raas/v1/user/delete", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	
}
