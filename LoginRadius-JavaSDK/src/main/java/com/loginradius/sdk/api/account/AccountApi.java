/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.account;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.AccountCreateModel;
import com.loginradius.sdk.models.requestmodels.AccountUserProfileUpdateModel;
import com.loginradius.sdk.models.requestmodels.MultiEmailToken;
import com.loginradius.sdk.models.requestmodels.MultiSmsOtp;
import com.loginradius.sdk.models.requestmodels.UpsertEmailModel;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;
import com.loginradius.sdk.models.responsemodels.ListReturn;
import com.loginradius.sdk.models.responsemodels.MultiToken;
import com.loginradius.sdk.models.responsemodels.UserPasswordHash;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.EmailVerificationTokenResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.ForgotPasswordResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PrivacyPolicyHistoryResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class AccountApi {
   private static Gson gson =new Gson();

   public AccountApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   // <summary>
   // This API is used to update the information of existing accounts in your Cloud Storage. See our Advanced API Usage section
   // <a href='/api/v2/user-registration/advanced-api-usage'>Here</a> for more capabilities.
   // </summary>
   // <param name="payload">Json data for update account</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="nullSupport">Boolean, pass true if you wish to update any user
   // profile field with a NULL value.
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.15

	public void UpdateAccountByUid(JsonObject payload, String uid,
		String fields, Boolean nullSupport, final AsyncHandler<Identity> handler) {

		if (payload == null) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("payload"));
		}

		if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
		}

		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
		queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

		if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
			queryParameters.put("fields", fields);
		}

		if (nullSupport != null && nullSupport) {
			queryParameters.put("nullSupport", String.valueOf(nullSupport));
		}

		String resourcePath = "identity/v2/manage/account/" + uid;

		LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(payload),
				new AsyncHandler<String>() {

					@Override
					public void onSuccess(String response) {
						TypeToken<Identity> typeToken = new TypeToken<Identity>() {
						};
						Identity successResponse = JsonDeserializer.deserializeJson(response, typeToken);
						handler.onSuccess(successResponse);
					}

					@Override
					public void onFailure(ErrorResponse errorResponse) {
						handler.onFailure(errorResponse);
					}
				});
	}
  
  
   
   // <summary>
   // This API is used to retrieve all of the accepted Policies by the user, associated with their UID.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Complete Policy History data</returns>
   // 15.1.1	    
		
		
   public void getPrivacyPolicyHistoryByUid(String uid, final AsyncHandler<PrivacyPolicyHistoryResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/privacypolicy/history";
            
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
   // This API is used to create an account in Cloud Storage. This API bypass the normal email verification process and manually creates the user. <br><br>In order to use this API, you need to format a JSON request body with all of the mandatory fields
   // </summary>
   // <param name="accountCreateModel">Model Class containing Definition of payload for Account Create API</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.1	    
		
		
   public void createAccount(AccountCreateModel accountCreateModel, String fields, final AsyncHandler<Identity> handler) {

      if (accountCreateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accountCreateModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(accountCreateModel), new AsyncHandler<String>() {
			
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
   // This API is used to retrieve all of the profile data, associated with the specified account by email in Cloud Storage.
   // </summary>
   // <param name="email">Email of the user</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.2	    
		
		
   public void getAccountProfileByEmail(String email, String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("email", email);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account";
            
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
   // This API is used to retrieve all of the profile data associated with the specified account by user name in Cloud Storage.
   // </summary>
   // <param name="userName">UserName of the user</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.3	    
		
		
   public void getAccountProfileByUserName(String userName, String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(userName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("userName"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("userName", userName);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account";
            
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
   // This API is used to retrieve all of the profile data, associated with the account by phone number in Cloud Storage.
   // </summary>
   // <param name="phone">The Registered Phone Number</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.4	    
		
		
   public void getAccountProfileByPhone(String phone, String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("phone", phone);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account";
            
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
   // This API is used to retrieve all of the profile data, associated with the account by uid in Cloud Storage.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.5	    
		
		
   public void getAccountProfileByUid(String uid, String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account/" + uid;
            
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
   // This API is used to update the information of existing accounts in your Cloud Storage. See our Advanced API Usage section <a href='https://www.loginradius.com/docs/api/v2/customer-identity-api/advanced-api-usage/'>Here</a> for more capabilities.
   // </summary>
   // <param name="accountUserProfileUpdateModel">Model Class containing Definition of payload for Account Update API</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.15	    
		
		
   public void updateAccountByUid(AccountUserProfileUpdateModel accountUserProfileUpdateModel, String uid,
      String fields, final AsyncHandler<Identity> handler) {

      if (accountUserProfileUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accountUserProfileUpdateModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account/" + uid;
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(accountUserProfileUpdateModel), new AsyncHandler<String>() {
			
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
   // This API is used to update the PhoneId by using the Uid's. Admin can update the PhoneId's for both the verified and unverified profiles. It will directly replace the PhoneId and bypass the OTP verification process.
   // </summary>
   // <param name="phone">Phone number</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.16	    
		
		
   public void updatePhoneIDByUid(String phone, String uid,
      String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/manage/account/" + uid + "/phoneid";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API use to retrive the hashed password of a specified account in Cloud Storage.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition for Complete PasswordHash data</returns>
   // 18.17	    
		
		
   public void getAccountPasswordHashByUid(String uid, final AsyncHandler<UserPasswordHash> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/password";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserPasswordHash> typeToken = new TypeToken<UserPasswordHash>() {};
          UserPasswordHash successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to set the password of an account in Cloud Storage.
   // </summary>
   // <param name="password">New password</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition for Complete PasswordHash data</returns>
   // 18.18	    
		
		
   public void setAccountPasswordByUid(String password, String uid, final AsyncHandler<UserPasswordHash> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(password)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("password"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("password", password);

      String resourcePath = "identity/v2/manage/account/" + uid + "/password";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserPasswordHash> typeToken = new TypeToken<UserPasswordHash>() {};
          UserPasswordHash successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API deletes the Users account and allows them to re-register for a new account.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.19	    
		
		
   public void deleteAccountByUid(String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid;
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // This API is used to invalidate the Email Verification status on an account.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 18.20	    
		
		
   public void invalidateAccountEmailVerification(String uid, String emailTemplate,
      String verificationUrl, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/manage/account/" + uid + "/invalidateemail";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // This API Returns a Forgot Password Token it can also be used to send a Forgot Password email to the customer. Note: If you have the UserName workflow enabled, you may replace the 'email' parameter with 'username' in the body.
   // </summary>
   // <param name="email">user's email</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="resetPasswordUrl">Url to which user should get re-directed to for resetting the password</param>
   // <param name="sendEmail">If set to true, the API will also send a Forgot Password email to the customer, bypassing any Bot Protection challenges that they are faced with.</param>
   // <returns>Response containing Definition of Complete Forgot Password data</returns>
   // 18.22	    
		
		
   public void getForgotPasswordToken(String email, String emailTemplate,
      String resetPasswordUrl, Boolean sendEmail, final AsyncHandler<ForgotPasswordResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(resetPasswordUrl)) {
        queryParameters.put("resetPasswordUrl", resetPasswordUrl);
      }

      if (sendEmail != null && sendEmail) {
        queryParameters.put("sendEmail", String.valueOf(sendEmail));
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);

      String resourcePath = "identity/v2/manage/account/forgot/token";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ForgotPasswordResponse> typeToken = new TypeToken<ForgotPasswordResponse>() {};
          ForgotPasswordResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API Returns an Email Verification token.
   // </summary>
   // <param name="email">user's email</param>
   // <returns>Response containing Definition of Complete Verification data</returns>
   // 18.23	    
		
		
   public void getEmailVerificationToken(String email, final AsyncHandler<EmailVerificationTokenResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);

      String resourcePath = "identity/v2/manage/account/verify/token";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EmailVerificationTokenResponse> typeToken = new TypeToken<EmailVerificationTokenResponse>() {};
          EmailVerificationTokenResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The API is used to get LoginRadius access token based on UID.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 18.24	    
		
		
   public void getAccessTokenByUid(String uid, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      String resourcePath = "identity/v2/manage/account/access_token";
            
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
   // This API Allows you to reset the phone no verification of an end user’s account.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 18.27	    
		
		
   public void resetPhoneIDVerificationByUid(String uid, String smsTemplate,
      Boolean isVoiceOtp, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      String resourcePath = "identity/v2/manage/account/" + uid + "/invalidatephone";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // This API is used to add/upsert another emails in account profile by different-different email types. If the email type is same then it will simply update the existing email, otherwise it will add a new email in Email array.
   // </summary>
   // <param name="upsertEmailModel">Model Class containing Definition of payload for UpsertEmail Property</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.29	    
		
		
   public void upsertEmail(UpsertEmailModel upsertEmailModel, String uid,
      String fields, final AsyncHandler<Identity> handler) {

      if (upsertEmailModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("upsertEmailModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account/" + uid + "/email";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(upsertEmailModel), new AsyncHandler<String>() {
			
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
   // Use this API to Remove emails from a user Account
   // </summary>
   // <param name="email">user's email</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 18.30	    
		
		
   public void removeEmail(String email, String uid,
      String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);

      String resourcePath = "identity/v2/manage/account/" + uid + "/email";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API is used to refresh an access token via it's associated refresh token.
   // </summary>
   // <param name="refreshToken">LoginRadius refresh token</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 18.31	    
		
		
   public void refreshAccessTokenByRefreshToken(String refreshToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(refreshToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("refreshToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("refresh_Token", refreshToken);

      String resourcePath = "identity/v2/manage/account/access_token/refresh";
            
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
   // The Revoke Refresh Access Token API is used to revoke a refresh token or the Provider Access Token, revoking an existing refresh token will invalidate the refresh token but the associated access token will work until the expiry.
   // </summary>
   // <param name="refreshToken">LoginRadius refresh token</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.32	    
		
		
   public void revokeRefreshToken(String refreshToken, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(refreshToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("refreshToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("refresh_Token", refreshToken);

      String resourcePath = "identity/v2/manage/account/access_token/refresh/revoke";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // The Revoke All Refresh Access Token API is used to revoke all refresh tokens for a specific user.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.33	    
		
		
   public void revokeAllRefreshToken(String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/access_token/refresh/revoke";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // This API generate Email tokens and Email OTPs for Email verification, Add email, Forgot password, Delete user, Passwordless login, Forgot pin, One-touch login and Auto login.
   // </summary>
   // <param name="multiEmailToken">Model Class containing Definition of payload for Multipurpose Email Token Generation API</param>
   // <param name="tokentype">The identifier type for the token that we need to generate</param>
   // <returns>Response containing Definition for Complete MultiToken</returns>
   // 18.34	    
		
		
   public void multipurposeEmailTokenGeneration(MultiEmailToken multiEmailToken, String tokentype, final AsyncHandler<MultiToken> handler) {

      if (multiEmailToken == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiEmailToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(tokentype)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("tokentype"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/emailtoken/" + tokentype;
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(multiEmailToken), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiToken> typeToken = new TypeToken<MultiToken>() {};
          MultiToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // Note: This is intended for specific workflows where an email may be associated to multiple UIDs. This API is used to retrieve all of the identities (UID and Profiles), associated with a specified email in Cloud Storage.
   // </summary>
   // <param name="email">Email of the user</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Complete user Identity data</returns>
   // 18.35	    
		
		
   public void getAccountIdentitiesByEmail(String email, String fields, final AsyncHandler<ListReturn<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("email", email);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/manage/account/identities";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListReturn<Identity>> typeToken = new TypeToken<ListReturn<Identity>>() {};
          ListReturn<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to delete all user profiles associated with an Email.
   // </summary>
   // <param name="email">Email of the user</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.36	    
		
		
   public void accountDeleteByEmail(String email, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("email", email);

      String resourcePath = "identity/v2/manage/account";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // This API is used to update a user's Uid. It will update all profiles, custom objects and consent management logs associated with the Uid.
   // </summary>
   // <param name="updateUidModel">Payload containing Update UID</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 18.41	    
		
		
   public void accountUpdateUid(UpdateUidModel updateUidModel, String uid, final AsyncHandler<PostResponse> handler) {

      if (updateUidModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("updateUidModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      String resourcePath = "identity/v2/manage/account/uid";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(updateUidModel), new AsyncHandler<String>() {
			
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
   // This API generates SMS OTP for Add phone, Phone Id verification, Forgot password, Forgot pin, One-touch login, smart login and Passwordless login.
   // </summary>
   // <param name="multiSmsOtp"></param>
   // <param name="smsotptype">The identifier type for the OTP that we need to generate</param>
   // <returns>Response containing Definition for Complete MultiToken</returns>
   // 18.44	    
		
		
   public void multipurposeSMSOTPGeneration(MultiSmsOtp multiSmsOtp, String smsotptype, final AsyncHandler<MultiToken> handler) {

      if (multiSmsOtp == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiSmsOtp"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(smsotptype)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("smsotptype"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/smsotp/" + smsotptype;
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(multiSmsOtp), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiToken> typeToken = new TypeToken<MultiToken>() {};
          MultiToken successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve a LoginRadius access token by passing in a valid custom JWT token.
   // </summary>
   // <param name="idToken">Custom JWT Token</param>
   // <param name="providername">JWT Provider Name</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 44.3	    
		
		
   public void accessTokenViaCustomJWTToken(String idToken, String providername, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(idToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("idToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(providername)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("providername"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("id_Token", idToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("providername", providername);

      String resourcePath = "api/v2/access_token/jwt";
            
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
}
