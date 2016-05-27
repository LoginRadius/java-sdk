package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.social.models.AccessToken;
import com.loginradius.sdk.social.models.LoginRadiusPostResponse;
import com.loginradius.sdk.raas.models.*;


public class UserProfileAPI extends  RaaSAPI{

	/**
	 * 
	 * @param userId ID generated from RaasProfile
	 * @return RaasUserProfile with all user data
	 */
	public RaaSUserDetails getUserByUserId(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userId);		
		String jsonResponse = executeGet("/raas/v1/user", params);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
	}
	
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public RaaSUserDetails getUserbyEmail(String email){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", email);
		String jsonResponse = executeGet("/raas/v1/user", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
		
	}
	
	
	/**
	 * 
	 * @param UserName UserName given by user
	 * @param Password Password given by user
	 * @return RaasUserProfile with all user data
	 */
	public RaaSUserDetails getUserAfterAuthentication(String UserName, String Password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", UserName);
		params.put("password", Password);
		String jsonResponse = executeGet("/raas/v1/user", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
	}
	
	
	/**
	 * checks whether an emaild is available for selection or not
	 * @param emailId
	 * @return
	 */
	public LoginRadiusPresenceResponse checkEmailAvailability(String emailId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("emailid", emailId);
		String jsonResponse = executeGet("/raas/v1/user/checkemail", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, LoginRadiusPresenceResponse.class);
		
	}
	
	
	/**
	 * 
	 * @param emailId
	 * @return
	 */
	
	public LoginRadiusForgotPasswordResponse getForgotPassWordToken(String emailId) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("emailid", emailId);
		String jsonResponse = executeGet("/raas/v1/account/password/forgot", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, LoginRadiusForgotPasswordResponse.class);
		
	}

	
	/**
	 * 
	 * @param emailId
	 * @param link
	 * @param template
	 * @return
	 */
	
	public LoginRadiusEmailVerificationTokenResponse getUserEmailVerificationResend(String emailId, 
			String link, String template){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("emailid", emailId);
		params.put("link", link);
		params.put("template", template);
		String jsonResponse = executeGet("/raas/v1/account/verificationemail", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, LoginRadiusEmailVerificationTokenResponse.class);

		
	}
	
	/**
	 * Validates the access token. Avalilable from api v2 onwards
	 * @param access_token
	 * @return
	 */
	public AccessToken validateAccessToken(String access_token){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", access_token);
		String jsonResponse = executeGet("/api/v2/access_token/Validate", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, AccessToken.class);
		
	}
		
	/**
	 * This api invalidates the access token.Avalilable from api v2 onwards
	 * @param access_token
	 * @return
	 */
	public AccessToken invalidateAccessToken(String access_token){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", access_token);
		String jsonResponse = executeGet("/api/v2/access_token/invalidate", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, AccessToken.class);
		
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
	
	
	public RaaSResponse deleteUserWithEmailConfirmation(String userid, String deleteuserlink, String template){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userid);
		params.put("deleteuserlink", deleteuserlink);
		params.put("template", template);
		String jsonResponse = executeGet("/raas/v1/user/deleteuseremail", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

		
	}
	
	
	
	
}
