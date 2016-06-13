package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.raas.models.RaaSUserDetails;
import com.loginradius.sdk.raas.models.RaaSHashPassword;
import com.loginradius.sdk.raas.models.RaaSResponse;

public class AccountAPI extends RaaSAPI {

	/**
	 * 
	 * @param accountid
	 * @param password
	 * @return
	 */
	public RaaSResponse setAccountPassword(String accountid, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountid);
		params.put("action", "set");
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("password", password);
		String jsonResponse = executePost("/raas/v1/account/password", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

	}

	/**
	 * 
	 * @param accountId
	 * @param oldusername
	 * @param newusername
	 * @return
	 */
	public RaaSResponse changeUserName(String accountId, String oldusername, String newusername) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountId", accountId);
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("oldusername", oldusername);
		postParams.put("newusername", newusername);
		String jsonResponse = executePost("/raas/v1/account/changeusername", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */

	public RaaSResponse checkUserName(String username) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		String jsonResponse = executeGet("/raas/v1/user/checkusername", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

	}

	/**
	 * 
	 * @param accountId
	 * @param oldusername
	 * @param newusername
	 * @return
	 */
	
	public RaaSResponse setUserName(String accountId, String oldusername, String newusername) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountId", accountId);
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("newusername", newusername);
		String jsonResponse = executePost("/raas/v1/account/setusername", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

		
	}

	
	/**
	 * This API changes the account password password
	 * 
	 * @param accountId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public RaaSResponse changeAccountPassword(String accountId, String oldPassword, String newPassword) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("oldpassword", oldPassword);
		postParams.put("newpassword", newPassword);
		String jsonResponse = executePost("/raas/v1/account/password", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

	}

	/**
	 * 
	 * @param accountId
	 *            accountID or RaasID of the user
	 * @param provider
	 *            social provider name
	 * @param providerId
	 *            social provider ID of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse linkAccount(String accountId, String provider, String providerId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("provider", provider);
		params.put("providerid", providerId);
		String jsonResponse = executePost("/raas/v1/account/link", null, params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	/**
	 * 
	 * @param accountId
	 *            accountID or RaasID of the user
	 * @param provider
	 *            social provider name
	 * @param providerId
	 *            social provider ID of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse unlinkAccount(String accountId, String provider, String providerId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("provider", provider);
		params.put("providerid", providerId);
		String jsonResponse = executePost("/raas/v1/account/unlink", null, params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}


    /**
     * This API is used to retrieve all of the profile data from each of the linked social provider accounts associated with the account. 
     * For ex: A user has linked facebook and google account then this api will retrieve both profile data.
     *
     * accountId, the identifier for each user account, it may have multiple IDs(identifier for each social platform) associated 
     * with it
     * return Array of user profile
     */
	public RaaSUserDetails[] getAllProfilesFromAccount(String accountId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		String jsonResponse = executeGet("/raas/v1/account", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails[].class);
	}

	/**
	 * 
	 * @param accountId
	 *            accountID or RaasID of the user
	 * @param isBlock
	 *            true or false whether the user should be blocked or not
	 * @return returns isPosted with value true
	 */

	/**
	 * 
	 * @param userID
	 *            ID generated from RaasProfile
	 * @return HashedPassword of the user
	 */
	public RaaSHashPassword getHashPassword(String accountId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		String jsonResponse = executeGet("/raas/v1/account/password", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSHashPassword.class);
	}

	/***
	 * 
	 * @param accountId
	 * @param isBlock
	 * @return
	 */
	public RaaSResponse setAccountStatus(String accountId, boolean isBlock) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("isblock", isBlock ? "true" : "false");
		String jsonResponse = executePost("/raas/v1/account/status", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	/**
	 * 
	 * @param accountId
	 *            accountID or RaasID of the user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse deleteAccount(String accountId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		String jsonResponse = executeGet("/raas/v1/account/delete", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	public RaaSResponse deleteAccountWithEmailConfirmation(String accountId, String deleteUserLink, String template) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountId);
		params.put("deleteUserLink", deleteUserLink);
		params.put("template", template);
		String jsonResponse = executeGet("/raas/v1/account/deleteuseremail", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

}
