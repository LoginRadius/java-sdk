package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.raas.models.LoginRadiusEmailVerificationTokenResponse;
import com.loginradius.sdk.raas.models.LoginRadiusForgotPasswordResponse;
import com.loginradius.sdk.raas.models.LoginRadiusPresenceResponse;
import com.loginradius.sdk.raas.models.RaaSResponse;
import com.loginradius.sdk.raas.models.RaaSUserDetails;
import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.social.models.AccessToken;


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
	public RaaSUserDetails[] getUserbyEmail(String email){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("emailid", email);
		String jsonResponse = executeGet("/raas/v1/user", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails[].class);
		
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
	public RaaSResponse editUser(String userId, Map<String, String> userDetails ) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userId);		
		Map<String, String> postParams = new HashMap<String,String>();
		postParams.putAll(userDetails);
	
		String jsonResponse = executePost("/raas/v1/user",params, postParams);		
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}
	
	
	
	
	/**
	 * 
	 * @param accountid
	 * @param action
	 * @param emailid
	 * @param emailtype
	 * @return
	 */
	
	public RaaSResponse userEmailAddRemove(String accountid, String action, String emailid, String emailtype){
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("accountid", accountid);		
		params.put("action", action);		
		Map<String, String> postParams = new HashMap<String,String>();
		postParams.put("emailid", emailid);		
		postParams.put("emailtype", emailtype);	

		String jsonResponse = executePost("/raas/v1/account/email",params, postParams);		
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
		params.put("action", "set");
		params.put("userid",userid);
		Map<String, String> postParams = new HashMap<String,String>();
		postParams.put("password", password);	
		String jsonResponse = executePost("/raas/v1/user/password", params, postParams);
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	}

	/**
	 * 
	 * return RaasUserProfile with all user data
	 */
	public RaaSUserDetails createUser(Map<String, String> userDetails){
		Map<String, String> postParams = new HashMap<String, String>();
		
		if(userDetails!=null && !userDetails.isEmpty()){
			postParams.putAll(userDetails);
		String jsonResponse = executePost("/raas/v1/user", null, postParams);
	    return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
		}else{
			throw new NullPointerException("The provided data is not correct");
		}
			
	}
	
	
	/**
	 * 
	 * @param emailId
	 * @param password
	 * @param emailId
	 * @return
	 */
	
	public RaaSResponse createRegistrationProfile(String emailId, String password, String accountId){
		
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("accountid", accountId);
		postParams.put("emailid",emailId);
		postParams.put("password",password);
		String jsonResponse = executePost("/raas/v1/user", null, postParams);
	    return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
	    
	}

	
	
	
	
	/**
	 * 
	 * @param userDetails UserData given by the user
	 * @return returns isPosted with value true
	 */
	public  RaaSResponse registerUser( Map<String, String> userDetails) {
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.putAll(userDetails);
		String jsonResponse = executePost("/raas/v1/user/register", null,postParams);	
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
		
	}
	
	
	/**
	 * 
	 * @param userid
	 * @param deleteuserlink
	 * @param template
	 * @return
	 */
	
	public RaaSResponse deleteUserWithEmailConfirmation(String userid, String deleteuserlink, String template){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userid);
		params.put("deleteuserlink", deleteuserlink);
		params.put("template", template);
		String jsonResponse = executeGet("/raas/v1/user/deleteuseremail", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

		
	}
	
	
	
	
}
