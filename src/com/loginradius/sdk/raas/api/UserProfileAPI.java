package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.raas.models.*;


public class UserProfileAPI extends  RaaSAPI{

	/**
	 * 
	 * @param userId ID generated from RaasProfile
	 * @return RaasUserProfile with all user data
	 */
	public RaaSUserDetails getUser(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userId);		
		String jsonResponse = executeGet("/raas/v1/user", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
	}
	/**
	 * 
	 * @param UserName UserName given by user
	 * @param Password Password given by user
	 * @return RaasUserProfile with all user data
	 */
	public RaaSUserDetails getUser(String UserName, String Password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", UserName);
		params.put("password", Password);
		String jsonResponse = executeGet("/raas/v1/user", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
	}
	
	/**
	 * 
	 * @param userId ID generated from RaasProfile
	 * @param userDetails Details given by user in the form
	 * @return returns isPosted with value true
	 */
	public <T> RaaSResponse editUser(String userId, T userDetails) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userId);		
		Map<String, String> postParams = new HashMap<String,String>();
		RaaSUserDetails userData = (RaaSUserDetails) userDetails;
		postParams.put("firstname", userData.getFirstName());
		if(userData.getLastName()!=null)
		postParams.put("lastname",userData.getLastName());
		if(userData.getGender()!=null)
		postParams.put("gender",userData.getGender());
		if(userData.getBirthDate()!=null)
		postParams.put("birthdate",userData.getBirthDate());
		String jsonResponse = executePost("/raas/v1/user",params, postParams);		
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	/**
	 * 
	 * @param userId ID generated from RaasProfile
	 * @param OldPassword oldpassword given by user
	 * @param NewPassword newpassword given by user
	 * @return returns isPosted with value true
	 */
	public RaaSResponse changePassword(String userId, String OldPassword, String NewPassword){
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userId);		
		Map<String, String> postParams = new HashMap<String,String>();
		postParams.put("oldpassword", OldPassword);		
		postParams.put("newpassword",NewPassword);		
		String jsonResponse = executePost("/raas/v1/user/password",params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	/**
	 * 
	 * @param userid ID generated from RaasProfile
	 * @param password password given by the admin
	 * @return returns isPosted with value true
	 */
	public RaaSResponse setPassword(String userid, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("action", "setpassword");
		params.put("userid",userid);
		Map<String, String> postParams = new HashMap<String,String>();
		postParams.put("password", password);	
		String jsonResponse = executePost("/raas/v1/user/password", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	/**
	 * 
	 * @param user Userdetails given by the user
	 * return RaasUserProfile with all user data
	 */
	public RaaSUserDetails createUser(RaaSUserDetails user){
		Map<String, String> params = new HashMap<String, String>();
		params.put("emailid", user.getEmailId());
		params.put("password",user.getPassword());
		if(user.getFirstName()!=null)
		params.put("firstname", user.getFirstName());
		if(user.getLastName()!=null)
		params.put("lastname",user.getLastName());
		if(user.getGender()!=null)
		params.put("gender", user.getGender());
		if(user.getBirthDate()!=null)
		params.put("birthdate",user.getBirthDate());
		String jsonResponse = executePost("/raas/v1/user", null, params);
	    return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
	}
	
	/**
	 * 
	 * @param userID ID generated from RaasProfile
	 * @return HashedPassword of the user
	 */
	public RaaSHashPassword getHashPassword(String userID){
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userID);
		String jsonResponse = executeGet("/raas/v1/user/password", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSHashPassword.class);
	}
	
	/**
	 * 
	 * @param userDetails UserData given by the user
	 * @return returns isPosted with value true
	 */
	public <T> RaaSResponse registerUser(T userDetails) {
		RaaSUserDetails userData = (RaaSUserDetails) userDetails;
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.clear();
		postParams.put("emailid", userData.getEmailId());
		postParams.put("password",userData.getPassword());
		if(userData.getFirstName()!=null)
		postParams.put("firstname",userData.getFirstName());
		if(userData.getLastName()!=null)
		postParams.put("lastname",userData.getLastName());
		if(userData.getGender()!=null)
		postParams.put("gender",userData.getGender());
		if(userData.getBirthDate()!=null)
		postParams.put("birthdate",userData.getBirthDate());
		String jsonResponse = executePost("/raas/v1/user/register", null,postParams);	
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
		
	}
	
}
