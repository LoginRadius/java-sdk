package com.loginradius.sdk.raas.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.raas.models.LoginRadiusEmailVerificationTokenResponse;
import com.loginradius.sdk.raas.models.LoginRadiusForgotPasswordResponse;
import com.loginradius.sdk.raas.models.LoginRadiusPresenceResponse;
import com.loginradius.sdk.raas.models.RaaSClientConfig;
import com.loginradius.sdk.raas.models.RaaSResponse;
import com.loginradius.sdk.raas.models.RaaSUserDetails;
import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.social.core.LoginRadiusException;
import com.loginradius.sdk.social.models.AccessToken;
import com.loginradius.sdk.util.ArgumentValidator;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestResponse;


public class UserProfileAPI extends  RaaSAPI{

	
	
	/**
	 * 
	 * @param userId ID generated from RaasProfile
	 * @return RaasUserProfile with all user data
	 */
	public RaaSUserDetails getUserByUserId(String userId) {
		
		if(ArgumentValidator.isEmpty(userId)){
			throw new IllegalArgumentException("The input to the method is not correct");
		}
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

		if(ArgumentValidator.isEmpty(email)){
			throw new IllegalArgumentException("The input to the method is not correct");
		}
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

		if(ArgumentValidator.isEmpty(UserName) || ArgumentValidator.isEmpty(Password)){
			throw new IllegalArgumentException("The input to the method is not correct");
		}
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
		if(ArgumentValidator.isEmpty(emailId)){
			throw new IllegalArgumentException("The input to the method is not correct");
		}
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
		if(ArgumentValidator.isEmpty(emailId)){
			throw new IllegalArgumentException("The input to the method is not correct");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", emailId);
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
		if(ArgumentValidator.isEmpty(emailId) || (ArgumentValidator.isEmpty(link))){
			throw new IllegalArgumentException("The input to the method is not correct");
		}
		
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
		if(ArgumentValidator.isEmpty(access_token)){
			throw new IllegalArgumentException("Access token cannot be empty");
		}
		
		//The api end points are not correct
		Map<String, String> reParams = new HashMap<String, String>();
		reParams.put("access_token", access_token);
		reParams.put("key", RaaSClientConfig.getConfiguration().getAppKey());
		reParams.put("secret", RaaSClientConfig.getConfiguration().getAppSecret());
		
		RestResponse response = restrequest.get("/api/v2/access_token/Validate",reParams);
		String jsonresponse = response.getResponse();
		System.out.println("RaaSAPI.jsonresponse " + jsonresponse);
		
		if (response.getStatusCode() != 200){
			
			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	
		
		
		return LoginRadiusClient.formatResponse(jsonresponse, AccessToken.class);
		
	}
		
	/**
	 * This api invalidates the access token.Avalilable from api v2 onwards
	 * @param access_token
	 * @return
	 */
	public RaaSResponse invalidateAccessToken(String access_token){
		if(ArgumentValidator.isEmpty(access_token)){
			throw new IllegalArgumentException("Access token cannot be empty");
		}
		Map<String, String> reParams = new HashMap<String, String>();
		reParams.put("access_token", access_token);
		reParams.put("key", RaaSClientConfig.getConfiguration().getAppKey());
		reParams.put("secret", RaaSClientConfig.getConfiguration().getAppSecret());		
		RestResponse response = restrequest.get("/api/v2/access_token/invalidate", reParams); 
		
		String jsonresponse = response.getResponse();
		System.out.println("RaaSAPI.jsonresponse " + jsonresponse);
		
		if (response.getStatusCode() != 200){
			
			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	
		return LoginRadiusClient.formatResponse(jsonresponse, RaaSResponse.class);
		
	}
		
	
	
	
	/**
	 * 
	 * @param userId ID generated from RaasProfile
	 * @param userDetails Details given by user in the form
	 * @return returns isPosted with value true
	 */
	public RaaSResponse editUser(String userId, String userDetails ) {
		if(userDetails == null ||userDetails.isEmpty()){
			throw new IllegalArgumentException("User details cannot be empty");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userId);		
		String jsonResponse = executePost("/raas/v1/user",params, userDetails);		
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
		if(ArgumentValidator.isEmpty(accountid)|| ArgumentValidator.isEmpty(action) || ArgumentValidator.isEmpty(emailid) 
				|| ArgumentValidator.isEmpty(emailtype)){
			throw new IllegalArgumentException("The input is not correct.");
		}
		
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
	@Deprecated
	public RaaSResponse changePassword(String userId, String OldPassword, String NewPassword){
		
		if(ArgumentValidator.isEmpty(OldPassword) || ArgumentValidator.isEmpty(NewPassword) ){
			throw new IllegalArgumentException("You cannot provide empty passwords");
		}
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
	@Deprecated
	public RaaSResponse setPassword(String userid, String password) {
		if(ArgumentValidator.isEmpty(userid) || ArgumentValidator.isEmpty(password)){
			throw new IllegalArgumentException("Invalid input");
		}
		
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
	public RaaSUserDetails createUser(String userDetails){
		
		
		if(ArgumentValidator.isEmpty(userDetails)){
			throw new IllegalArgumentException("User Details cannot be empty");
		}
		
		String jsonResponse = executePost("/raas/v1/user", null, userDetails);
	    return LoginRadiusClient.formatResponse(jsonResponse, RaaSUserDetails.class);
		
			
	}
	
	

	/**
	 * 
	 * @param userDetails UserData given by the user
	 * @return returns isPosted with value true
	 */
	public  RaaSResponse registerUser(String userDetails) {
		
		if(ArgumentValidator.isEmpty(userDetails)){
			throw new IllegalArgumentException("User Details cannot be empty");
		}
	
		String jsonResponse = executePost("/raas/v1/user/register", null,userDetails);	
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);
		
	}
	
	
	/**
	 * 
	 * @param emailId
	 * @param password
	 * @param accountId
	 * @return
	 */
	public RaaSResponse createRegistrationProfile(String emailId, String password, String accountId){
		
		if(ArgumentValidator.isEmpty(emailId) || ArgumentValidator.isEmpty(password) || ArgumentValidator.isEmpty(accountId)){
			throw new IllegalArgumentException("Invalid input");
		}
		Map<String, String> postParams = new HashMap<String, String>();
		postParams.put("accountid", accountId);
		postParams.put("emailid",emailId);
		postParams.put("password",password);
		String jsonResponse = executePost("raas/v1/account/profile", null, postParams);
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
		if(ArgumentValidator.isEmpty(userid) || ArgumentValidator.isEmpty(deleteuserlink)){
			throw new IllegalArgumentException("Invalid input");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("userid", userid);
		params.put("deleteuserlink", deleteuserlink);
		params.put("template", template);
		String jsonResponse = executeGet("/raas/v1/user/deleteuseremail", params); 
		return LoginRadiusClient.formatResponse(jsonResponse, RaaSResponse.class);

		
	}
	
	
	
	
}
