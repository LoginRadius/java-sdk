/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.authentication;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.AuthUserRegistrationModel;
import com.loginradius.sdk.models.requestmodels.AuthUserRegistrationModelWithCaptcha;
import com.loginradius.sdk.models.requestmodels.EmailAuthenticationModel;
import com.loginradius.sdk.models.requestmodels.EmailVerificationByOtpModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordByEmailAndOtpModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordByResetTokenModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordBySecurityAnswerAndEmailModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordBySecurityAnswerAndPhoneModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordBySecurityAnswerAndUserNameModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordByUserNameModel;
import com.loginradius.sdk.models.requestmodels.UnlockProfileModel;
import com.loginradius.sdk.models.requestmodels.UserNameAuthenticationModel;
import com.loginradius.sdk.models.requestmodels.UserProfileUpdateModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;
import com.loginradius.sdk.models.responsemodels.SecurityQuestions;
import com.loginradius.sdk.models.responsemodels.configobjects.EmailVerificationData;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteRequestAcceptResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.ExistResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PrivacyPolicyHistoryResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.TokenInfoResponseModel;
import com.loginradius.sdk.models.responsemodels.otherobjects.UserProfilePostResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class AuthenticationApi {
   private static Gson gson =new Gson();

   public AuthenticationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   // <summary>
   // This API is used to update the user's profile by passing the access_token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius 
   // that is activated after successful authentication.</param>
   // <param name="payload">Json data for update profile</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that
   // the response only includes a specific set of fields</param>
   // <param name="nullSupport">Boolean, pass true if you wish to update any user
   // profile field with a NULL value.</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 5.4

	public void updateProfileByAccessToken(String accessToken, JsonObject payload,
			String emailTemplate, String fields, Boolean nullSupport, String smsTemplate, String verificationUrl,
			final AsyncHandler<UserProfilePostResponse<Identity>> handler) {

		if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
		}

		if (payload == null) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("payload"));
		}

		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("access_token", accessToken);
		queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

		if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
			queryParameters.put("emailTemplate", emailTemplate);
		}

		if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
			queryParameters.put("fields", fields);
		}

		if (nullSupport != null && nullSupport) {
			queryParameters.put("nullSupport", String.valueOf(nullSupport));
		}

		if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
			queryParameters.put("smsTemplate", smsTemplate);
		}

		if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
			queryParameters.put("verificationUrl", verificationUrl);
		}

		String resourcePath = "identity/v2/auth/account";

		LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(payload),
				new AsyncHandler<String>() {

					@Override
					public void onSuccess(String response) {
						TypeToken<UserProfilePostResponse<Identity>> typeToken = new TypeToken<UserProfilePostResponse<Identity>>() {
						};
						UserProfilePostResponse<Identity> successResponse = JsonDeserializer.deserializeJson(response,
								typeToken);
						handler.onSuccess(successResponse);
					}

					@Override
					public void onFailure(ErrorResponse errorResponse) {
						handler.onFailure(errorResponse);
					}
				});
	}
   
   
   // <summary>
   // This API is used to retrieve the list of questions that are configured on the respective LoginRadius site.
   // </summary>
   // <param name="email">Email of the user</param>
   // <returns>Response containing Definition for Complete SecurityQuestions data</returns>
   // 2.1	    
		
		
   public void getSecurityQuestionsByEmail(String email, final AsyncHandler<SecurityQuestions[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("email", email);

      String resourcePath = "identity/v2/auth/securityquestion/email";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SecurityQuestions[]> typeToken = new TypeToken<SecurityQuestions[]>() {};
          SecurityQuestions[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve the list of questions that are configured on the respective LoginRadius site.
   // </summary>
   // <param name="userName">UserName of the user</param>
   // <returns>Response containing Definition for Complete SecurityQuestions data</returns>
   // 2.2	    
		
		
   public void getSecurityQuestionsByUserName(String userName, final AsyncHandler<SecurityQuestions[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(userName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("userName"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("userName", userName);

      String resourcePath = "identity/v2/auth/securityquestion/username";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SecurityQuestions[]> typeToken = new TypeToken<SecurityQuestions[]>() {};
          SecurityQuestions[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve the list of questions that are configured on the respective LoginRadius site.
   // </summary>
   // <param name="phone">The Registered Phone Number</param>
   // <returns>Response containing Definition for Complete SecurityQuestions data</returns>
   // 2.3	    
		
		
   public void getSecurityQuestionsByPhone(String phone, final AsyncHandler<SecurityQuestions[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("phone", phone);

      String resourcePath = "identity/v2/auth/securityquestion/phone";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SecurityQuestions[]> typeToken = new TypeToken<SecurityQuestions[]>() {};
          SecurityQuestions[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve the list of questions that are configured on the respective LoginRadius site.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition for Complete SecurityQuestions data</returns>
   // 2.4	    
		
		
   public void getSecurityQuestionsByAccessToken(String accessToken, final AsyncHandler<SecurityQuestions[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/securityquestion/accesstoken";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SecurityQuestions[]> typeToken = new TypeToken<SecurityQuestions[]>() {};
          SecurityQuestions[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api validates access token, if valid then returns a response with its expiry otherwise error.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 4.1	    
		
		
   public void authValidateAccessToken(String accessToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/access_token/validate";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api call invalidates the active access token or expires an access token's validity.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="preventRefresh">Boolean value that when set as true, in addition of the access token being invalidated, it will no longer have the capability of being refreshed.</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 4.2	    
		
		
   public void authInValidateAccessToken(String accessToken, Boolean preventRefresh, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (preventRefresh != null && preventRefresh) {
        queryParameters.put("preventRefresh", String.valueOf(preventRefresh));
      }

      String resourcePath = "identity/v2/auth/access_token/invalidate";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api call provide the active access token Information
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition of Token Information</returns>
   // 4.3	    
		
		
   public void getAccessTokenInfo(String accessToken, final AsyncHandler<TokenInfoResponseModel> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/access_token";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<TokenInfoResponseModel> typeToken = new TypeToken<TokenInfoResponseModel>() {};
          TokenInfoResponseModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API retrieves a copy of the user data based on the access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 5.2	    
		
		
   public void getProfileByAccessToken(String accessToken, String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/account";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Identity> typeToken = new TypeToken<Identity>() {};
          Identity successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API sends a welcome email
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 5.3	    
		
		
   public void sendWelcomeEmail(String accessToken, String welcomeEmailTemplate, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/account/sendwelcomeemail";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to update the user's profile by passing the access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="userProfileUpdateModel">Model Class containing Definition of payload for User Profile update API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition of Complete Validation and UserProfile data</returns>
   // 5.4	    
		
		
   public void updateProfileByAccessToken(String accessToken, UserProfileUpdateModel userProfileUpdateModel,
      String emailTemplate, String fields, String smsTemplate, String verificationUrl, final AsyncHandler<UserProfilePostResponse<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (userProfileUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("userProfileUpdateModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/account";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(userProfileUpdateModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<Identity>> typeToken = new TypeToken<UserProfilePostResponse<Identity>>() {};
          UserProfilePostResponse<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API will send a confirmation email for account deletion to the customer's email when passed the customer's access token
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="deleteUrl">Url of the site</param>
   // <param name="emailTemplate">Email template name</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 5.5	    
		
		
   public void deleteAccountWithEmailConfirmation(String accessToken, String deleteUrl,
      String emailTemplate, final AsyncHandler<DeleteRequestAcceptResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(deleteUrl)) {
        queryParameters.put("deleteUrl", deleteUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      String resourcePath = "identity/v2/auth/account";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<DeleteRequestAcceptResponse> typeToken = new TypeToken<DeleteRequestAcceptResponse>() {};
          DeleteRequestAcceptResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to delete an account by passing it a delete token.
   // </summary>
   // <param name="deletetoken">Delete token received in the email</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 5.6	    
		
		
   public void deleteAccountByDeleteToken(String deletetoken, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(deletetoken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("deletetoken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("deletetoken", deletetoken);

      String resourcePath = "identity/v2/auth/account/delete";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to allow a customer with a valid access token to unlock their account provided that they successfully pass the prompted Bot Protection challenges. The Block or Suspend block types are not applicable for this API. For additional details see our Auth Security Configuration documentation.You are only required to pass the Post Parameters that correspond to the prompted challenges.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="unlockProfileModel">Payload containing Unlock Profile API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 5.15	    
		
		
   public void unlockAccountByToken(String accessToken, UnlockProfileModel unlockProfileModel, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (unlockProfileModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("unlockProfileModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/unlock";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(unlockProfileModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to check the email exists or not on your site.
   // </summary>
   // <param name="email">Email of the user</param>
   // <returns>Response containing Definition Complete ExistResponse data</returns>
   // 8.1	    
		
		
   public void checkEmailAvailability(String email, final AsyncHandler<ExistResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("email", email);

      String resourcePath = "identity/v2/auth/email";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ExistResponse> typeToken = new TypeToken<ExistResponse>() {};
          ExistResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to verify the email of user. Note: This API will only return the full profile if you have 'Enable auto login after email verification' set in your LoginRadius Admin Console's Email Workflow settings under 'Verification Email'.
   // </summary>
   // <param name="verificationToken">Verification token received in the email</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="url">Mention URL to log the main URL(Domain name) in Database.</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation, UserProfile data and Access Token</returns>
   // 8.2	    
		
		
   public void verifyEmail(String verificationToken, String fields,
      String url, String welcomeEmailTemplate, final AsyncHandler<UserProfilePostResponse<EmailVerificationData<Identity>>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(verificationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("verificationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("verificationToken", verificationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(url)) {
        queryParameters.put("url", url);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/email";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<EmailVerificationData<Identity>>> typeToken = new TypeToken<UserProfilePostResponse<EmailVerificationData<Identity>>>() {};
          UserProfilePostResponse<EmailVerificationData<Identity>> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to verify the email of user when the OTP Email verification flow is enabled, please note that you must contact LoginRadius to have this feature enabled.
   // </summary>
   // <param name="emailVerificationByOtpModel">Model Class containing Definition for EmailVerificationByOtpModel API</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="url">Mention URL to log the main URL(Domain name) in Database.</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation, UserProfile data and Access Token</returns>
   // 8.3	    
		
		
   public void verifyEmailByOTP(EmailVerificationByOtpModel emailVerificationByOtpModel, String fields,
      String url, String welcomeEmailTemplate, final AsyncHandler<UserProfilePostResponse<EmailVerificationData<Identity>>> handler) {

      if (emailVerificationByOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("emailVerificationByOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(url)) {
        queryParameters.put("url", url);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/email";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(emailVerificationByOtpModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<EmailVerificationData<Identity>>> typeToken = new TypeToken<UserProfilePostResponse<EmailVerificationData<Identity>>>() {};
          UserProfilePostResponse<EmailVerificationData<Identity>> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to add additional emails to a user's account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="email">user's email</param>
   // <param name="type">String to identify the type of parameter</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 8.5	    
		
		
   public void addEmail(String accessToken, String email,
      String type, String emailTemplate, String verificationUrl, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(type)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("type"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);
      bodyParameters.addProperty("type", type);

      String resourcePath = "identity/v2/auth/email";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to remove additional emails from a user's account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="email">user's email</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 8.6	    
		
		
   public void removeEmail(String accessToken, String email, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);

      String resourcePath = "identity/v2/auth/email";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<DeleteResponse> typeToken = new TypeToken<DeleteResponse>() {};
          DeleteResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API retrieves a copy of the user data based on the Email
   // </summary>
   // <param name="emailAuthenticationModel">Model Class containing Definition of payload for Email Authentication API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.2.1	    
		
		
   public void loginByEmail(EmailAuthenticationModel emailAuthenticationModel, String emailTemplate,
      String fields, String loginUrl, String verificationUrl, final AsyncHandler<AccessToken<Identity>> handler) {

      if (emailAuthenticationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("emailAuthenticationModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
        queryParameters.put("loginUrl", loginUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/login";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(emailAuthenticationModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessToken<Identity>> typeToken = new TypeToken<AccessToken<Identity>>() {};
          AccessToken<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API retrieves a copy of the user data based on the Username
   // </summary>
   // <param name="userNameAuthenticationModel">Model Class containing Definition of payload for Username Authentication API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.2.2	    
		
		
   public void loginByUserName(UserNameAuthenticationModel userNameAuthenticationModel, String emailTemplate,
      String fields, String loginUrl, String verificationUrl, final AsyncHandler<AccessToken<Identity>> handler) {

      if (userNameAuthenticationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("userNameAuthenticationModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
        queryParameters.put("loginUrl", loginUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/login";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(userNameAuthenticationModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessToken<Identity>> typeToken = new TypeToken<AccessToken<Identity>>() {};
          AccessToken<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to send the reset password url to a specified account. Note: If you have the UserName workflow enabled, you may replace the 'email' parameter with 'username'
   // </summary>
   // <param name="email">user's email</param>
   // <param name="resetPasswordUrl">Url to which user should get re-directed to for resetting the password</param>
   // <param name="emailTemplate">Email template name</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 10.1	    
		
		
   public void forgotPassword(String email, String resetPasswordUrl,
      String emailTemplate, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(resetPasswordUrl)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordUrl"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("resetPasswordUrl", resetPasswordUrl);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);

      String resourcePath = "identity/v2/auth/password";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to reset password for the specified account by security question
   // </summary>
   // <param name="resetPasswordBySecurityAnswerAndEmailModel">Model Class containing Definition of payload for ResetPasswordBySecurityAnswerAndEmail API</param>
   // <returns>Response containing Definition of Validation data and access token</returns>
   // 10.3.1	    
		
		
   public void resetPasswordBySecurityAnswerAndEmail(ResetPasswordBySecurityAnswerAndEmailModel resetPasswordBySecurityAnswerAndEmailModel, final AsyncHandler<UserProfilePostResponse<AccessTokenBase>> handler) {

      if (resetPasswordBySecurityAnswerAndEmailModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordBySecurityAnswerAndEmailModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/securityanswer";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordBySecurityAnswerAndEmailModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessTokenBase>> typeToken = new TypeToken<UserProfilePostResponse<AccessTokenBase>>() {};
          UserProfilePostResponse<AccessTokenBase> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to reset password for the specified account by security question
   // </summary>
   // <param name="resetPasswordBySecurityAnswerAndPhoneModel">Model Class containing Definition of payload for ResetPasswordBySecurityAnswerAndPhone API</param>
   // <returns>Response containing Definition of Validation data and access token</returns>
   // 10.3.2	    
		
		
   public void resetPasswordBySecurityAnswerAndPhone(ResetPasswordBySecurityAnswerAndPhoneModel resetPasswordBySecurityAnswerAndPhoneModel, final AsyncHandler<UserProfilePostResponse<AccessTokenBase>> handler) {

      if (resetPasswordBySecurityAnswerAndPhoneModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordBySecurityAnswerAndPhoneModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/securityanswer";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordBySecurityAnswerAndPhoneModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessTokenBase>> typeToken = new TypeToken<UserProfilePostResponse<AccessTokenBase>>() {};
          UserProfilePostResponse<AccessTokenBase> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to reset password for the specified account by security question
   // </summary>
   // <param name="resetPasswordBySecurityAnswerAndUserNameModel">Model Class containing Definition of payload for ResetPasswordBySecurityAnswerAndUserName API</param>
   // <returns>Response containing Definition of Validation data and access token</returns>
   // 10.3.3	    
		
		
   public void resetPasswordBySecurityAnswerAndUserName(ResetPasswordBySecurityAnswerAndUserNameModel resetPasswordBySecurityAnswerAndUserNameModel, final AsyncHandler<UserProfilePostResponse<AccessTokenBase>> handler) {

      if (resetPasswordBySecurityAnswerAndUserNameModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordBySecurityAnswerAndUserNameModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/securityanswer";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordBySecurityAnswerAndUserNameModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessTokenBase>> typeToken = new TypeToken<UserProfilePostResponse<AccessTokenBase>>() {};
          UserProfilePostResponse<AccessTokenBase> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to set a new password for the specified account.
   // </summary>
   // <param name="resetPasswordByResetTokenModel">Model Class containing Definition of payload for ResetToken API</param>
   // <returns>Response containing Definition of Validation data and access token</returns>
   // 10.7.1	    
		
		
   public void resetPasswordByResetToken(ResetPasswordByResetTokenModel resetPasswordByResetTokenModel, final AsyncHandler<UserProfilePostResponse<AccessTokenBase>> handler) {

      if (resetPasswordByResetTokenModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordByResetTokenModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/reset";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordByResetTokenModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessTokenBase>> typeToken = new TypeToken<UserProfilePostResponse<AccessTokenBase>>() {};
          UserProfilePostResponse<AccessTokenBase> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to set a new password for the specified account.
   // </summary>
   // <param name="resetPasswordByEmailAndOtpModel">Model Class containing Definition of payload for ResetPasswordByEmailAndOtp API</param>
   // <returns>Response containing Definition of Validation data and access token</returns>
   // 10.7.2	    
		
		
   public void resetPasswordByEmailOTP(ResetPasswordByEmailAndOtpModel resetPasswordByEmailAndOtpModel, final AsyncHandler<UserProfilePostResponse<AccessTokenBase>> handler) {

      if (resetPasswordByEmailAndOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordByEmailAndOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/reset";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordByEmailAndOtpModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessTokenBase>> typeToken = new TypeToken<UserProfilePostResponse<AccessTokenBase>>() {};
          UserProfilePostResponse<AccessTokenBase> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to set a new password for the specified account if you are using the username as the unique identifier in your workflow
   // </summary>
   // <param name="resetPasswordByUserNameModel">Model Class containing Definition of payload for ResetPasswordByUserName API</param>
   // <returns>Response containing Definition of Validation data and access token</returns>
   // 10.7.3	    
		
		
   public void resetPasswordByOTPAndUserName(ResetPasswordByUserNameModel resetPasswordByUserNameModel, final AsyncHandler<UserProfilePostResponse<AccessTokenBase>> handler) {

      if (resetPasswordByUserNameModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordByUserNameModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/reset";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordByUserNameModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessTokenBase>> typeToken = new TypeToken<UserProfilePostResponse<AccessTokenBase>>() {};
          UserProfilePostResponse<AccessTokenBase> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to change the accounts password based on the previous password
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="newPassword">New password</param>
   // <param name="oldPassword">User's current password</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 10.8	    
		
		
   public void changePassword(String accessToken, String newPassword,
      String oldPassword, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(newPassword)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("newPassword"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(oldPassword)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("oldPassword"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("newPassword", newPassword);
      bodyParameters.addProperty("oldPassword", oldPassword);

      String resourcePath = "identity/v2/auth/password/change";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to unlink up a social provider account with the specified account based on the access token and the social providers user access token. The unlinked account will automatically get removed from your database.
   // </summary>
   // <param name="accessToken">Access_Token</param>
   // <param name="provider">Name of the provider</param>
   // <param name="providerId">Unique ID of the linked account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 12.2	    
		
		
   public void unlinkSocialIdentities(String accessToken, String provider,
      String providerId, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(provider)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("provider"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(providerId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("providerId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("provider", provider);
      bodyParameters.addProperty("providerId", providerId);

      String resourcePath = "identity/v2/auth/socialidentity";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<DeleteResponse> typeToken = new TypeToken<DeleteResponse>() {};
          DeleteResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to link up a social provider account with an existing LoginRadius account on the basis of access token and the social providers user access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="candidateToken">Access token of the account to be linked</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 12.4	    
		
		
   public void linkSocialIdentities(String accessToken, String candidateToken, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(candidateToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("candidateToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("candidateToken", candidateToken);

      String resourcePath = "identity/v2/auth/socialidentity";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to link up a social provider account with an existing LoginRadius account on the basis of ping and the social providers user access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="clientGuid">Unique ID generated by client</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 12.5	    
		
		
   public void linkSocialIdentitiesByPing(String accessToken, String clientGuid, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(clientGuid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("clientGuid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("clientGuid", clientGuid);

      String resourcePath = "identity/v2/auth/socialidentity";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to set or change UserName by access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="username">Username of the user</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 13.1	    
		
		
   public void setOrChangeUserName(String accessToken, String username, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(username)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("username"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("username", username);

      String resourcePath = "identity/v2/auth/username";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to check the UserName exists or not on your site.
   // </summary>
   // <param name="username">UserName of the user</param>
   // <returns>Response containing Definition Complete ExistResponse data</returns>
   // 13.2	    
		
		
   public void checkUserNameAvailability(String username, final AsyncHandler<ExistResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(username)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("username"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("username", username);

      String resourcePath = "identity/v2/auth/username";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ExistResponse> typeToken = new TypeToken<ExistResponse>() {};
          ExistResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to update the privacy policy stored in the user's profile by providing the access token of the user accepting the privacy policy
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 15.1	    
		
		
   public void acceptPrivacyPolicy(String accessToken, String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/privacypolicy/accept";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Identity> typeToken = new TypeToken<Identity>() {};
          Identity successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API will return all the accepted privacy policies for the user by providing the access token of that user.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Complete Policy History data</returns>
   // 15.2	    
		
		
   public void getPrivacyPolicyHistoryByAccessToken(String accessToken, final AsyncHandler<PrivacyPolicyHistoryResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/privacypolicy/history";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PrivacyPolicyHistoryResponse> typeToken = new TypeToken<PrivacyPolicyHistoryResponse>() {};
          PrivacyPolicyHistoryResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API creates a user in the database as well as sends a verification email to the user.
   // </summary>
   // <param name="authUserRegistrationModel">Model Class containing Definition of payload for Auth User Registration API</param>
   // <param name="sott">LoginRadius Secured One Time Token</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <param name="verificationUrl">Email verification url</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation, UserProfile data and Access Token</returns>
   // 17.1.1	    
		
		
   public void userRegistrationByEmail(AuthUserRegistrationModel authUserRegistrationModel, String sott,
      String emailTemplate, String fields, String options, String verificationUrl, String welcomeEmailTemplate, final AsyncHandler<UserProfilePostResponse<AccessToken<Identity>>> handler) {

      if (authUserRegistrationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("authUserRegistrationModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(sott)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("sott"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("sott", sott);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/register";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(authUserRegistrationModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessToken<Identity>>> typeToken = new TypeToken<UserProfilePostResponse<AccessToken<Identity>>>() {};
          UserProfilePostResponse<AccessToken<Identity>> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API creates a user in the database as well as sends a verification email to the user.
   // </summary>
   // <param name="authUserRegistrationModelWithCaptcha">Model Class containing Definition of payload for Auth User Registration by Recaptcha API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation, UserProfile data and Access Token</returns>
   // 17.2	    
		
		
   public void userRegistrationByCaptcha(AuthUserRegistrationModelWithCaptcha authUserRegistrationModelWithCaptcha, String emailTemplate,
      String fields, String options, String smsTemplate, String verificationUrl, String welcomeEmailTemplate, final AsyncHandler<UserProfilePostResponse<AccessToken<Identity>>> handler) {

      if (authUserRegistrationModelWithCaptcha == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("authUserRegistrationModelWithCaptcha"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/register/captcha";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(authUserRegistrationModelWithCaptcha), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessToken<Identity>>> typeToken = new TypeToken<UserProfilePostResponse<AccessToken<Identity>>>() {};
          UserProfilePostResponse<AccessToken<Identity>> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API resends the verification email to the user.
   // </summary>
   // <param name="email">user's email</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 17.3	    
		
		
   public void authResendEmailVerification(String email, String emailTemplate,
      String verificationUrl, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);

      String resourcePath = "identity/v2/auth/register";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
