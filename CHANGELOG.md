> **LoginRadius Java SDK Change Log** provides information regarding what has changed, more specifically what changes, improvements and bug fix has been made to the SDK. For more details please refer to the [LoginRadius API Documention(https://github.com/LoginRadius/java-sdk)

### Version 4.2.1
Released on **November 23,  2018**
##### Enhancements

  - LoginRadiusClient.java optimization
  - Update Exception object to include ValidationError model
  - Added Unit tests
  - Updated demo with new UI and features


### Version 4.2.0
Released on **October 11,  2018**
##### Enhancements

  - Added Custom Domain option
  - Added more fields to LoginRadiusUltimateUserProfile model
  - Auth Delete Account API (GET)
  - Access Token API (GET)
  - Status Posting API (GET)
  - Phone Login API (POST)
  - MFA Email Login API (POST)
  - MFA User Name Login API (POST)
  - MFA Phone Login API (POST)
  - Update MFA by Access Token (PUT)
  - Update MFA Setting (PUT)
  - Access Token via Vkontakte Token API (GET)
  - Access Token via Google JWT API (GET)
  - WebHook Subscribe API (POST)
  - WebHook Test API (GET)
  - WebHook Subscribed URLs API (GET)
  - WebHook Unsubscribe API (DEL)
  - Delete All Records by Datasource API (DEL)

##### Breaking Changes

  - Renamed LoginRadiusConstant variables with 2FA to MFA


### Version 4.1.0
Released on **September 20,  2018**

##### Enhancements

  - Added API Request Signing(Enabling this feature customer don’t need to pass apisecret in API request. They can pass a dynamically generated hash value instead of this. Also, this feature will make sure that the message has not tampered during transit when someone calls our APIs).
  - Add Request Access Token in Header(LoginRadius access token can be passed on to the request as in header for auth apis).
  - Option to Prevent Sending Email Verification(an option to prevent sending email verification in case of optional email verification flow).
  - Recaptcha for Auth APIs(By enabling this option customer can enforce client to pass reCaptcha in some auth APIs for authentication).
  - Access Token on Registration Event.
  - API Secret in Headers for all Account APIs.
  - Remove Phone ID by access token API
  - Added Get Email Verification token API
  - Added Get Forgot Password token API
  - Auth Verify Email by OTP API
  - Auth Reset Password by OTP API
  - Account Identities by Email API
  - One Touch Login by Email API
  - One Touch Login By Phone API
  - One Touch OTP Verification API
  - Smart Login by Email API
  - Smart Login by Username API
  - Smart Login Ping API
  - Smart Login Verify Token API
  - PasswordLess Login by Email API
  - PasswordLess Login By UserName API
  - PasswordLess Login Verification API
  - Phone Login Using One Time Passcode API
  - Phone Send One time Passcode API
  
##### Breaking Changes

- For developers migrating from v4.0.1, there will be some breaking changes in terms of SDK implementation. In this version, we have updated endpoints and renamed "Auto Login" to "Smart Login", "No Registration/Simplified Registration" to "One touch Login" and "Instant Link Login" to "PasswordLess Login". Also, changed the methods of the above APIs accordingly.
 - We define new Method by using it you can directly initilize your api key and secret key.you dont have to initilize in every method.
 - For more details, please have a look [here](https://docs.loginradius.com/api/v2/deployment/sdk-libraries/java-library)


  

### Version 4.0.1
Released on **December 28,  2017**

##### Enhancements

  - Updated endpoint of Configuration API. 

### Version 4.0.0
Released on **November 17,  2017**

##### Enhancements

  - Added new configuration api for better implementation. 
  - Added new reset password by security answer API.
  - Added new remove an email management API.
  - Added custom scopes and external permissions enhancement in social login.
  - Significantly improved code performance.

##### Bug Fixes

  - Fixed issue remove Unirest library for http request.
  - Fixed issue thread leak when calling RestRequest.


### Version 3.4.0
Released on **September 06,  2017**

##### Enhancements

  - Added new verified and unverified both email ids stored in different profile fields. 
  - Added new projection of fields in all APIs
  - Added new verify auto login email API.
  - Added new management API to generate SOTT.
  - Added new context role expiration in add/update role context API.
  - Added new risk based authentication in login API.
  - Significantly improved code performance.

### Version 3.3.0
Released on **July 20,  2017**

##### Enhancements

  - Added new Custom Registration Data APIs. 
  - Added new Get Security Questions By Access Token,Email,UserName and Phone APIs
  - Added new Simplified Registration APIs.
  - Significantly improved code performance.
 
##### Bug Fixes

  - Fixed Issue related to missing fields in Login API.
  
  
### Version 3.2.0
Released on **June 15,  2017**

##### Enhancements

  - Added new access token API based on UID (user impersonation) 
  - Added new Auto Login APIs
  - Added new backup code API in case of device lost and Google Authenticator enabled.
  - Significantly improved code performance.
 
##### Bug Fixes
  - Issue with NULL Support at Update Account APIs.


### Version 3.1.0
Released on **May 10,  2017**

##### Enhancements

  - Added new Two Factor Authentication [2FA] APIs.
  - Added new api to get basic server information for sott time validation.
  - Added new Context based Roles and Permissions Management APIs
  - Added new fields in APIs response Unverified email ids in UserProfile and Image in PhotoAPI.
  - Added new email prompt Auto login.
  - Significantly improved code performance.
  - Increased custom connection and socket timeout 15000(milliseconds).
  




### Version 3.0.0
Released on **April 13,  2017**


##### Enhancements

  - Updated with [api-v2](https://docs.loginradius.com/api/v2/getting-started/introduction)
  - Added new multiple APIs for better user experience.
  - EndUser add and remove multiple Emails.
  - Added update profile feature in SDK.
  - Significantly improved code performance.
  - Reduce number of library from SDK.
  - Added phonenuber and username login.
  - By default the connection timeout (the time it takes to connect to a server) is 10000, and the socket timeout (the time it takes to receive data) is 60000. 
  

### Version 2.5.3
Released on **January 12,  2017**

##### Enhancements
  - Significantly improved code performance.

##### Bug Fixes
  - Updated SDK to Fetch Custom Fields.
 
 

### Version 2.5.1
Released on **June 20,  2016**

##### Enhancements

  - Custom object APIs have been newly added
  - Wrapper methods for latest LoginRadius APIs have been added in Account API and User API
  - Significantly improved code performance.
 
##### API breaking changes

  - This is a revamp of the previous SDK. Most of the classes are re-written for providing ease of implementation and to cover all of the existing 
  - There are breaking changes in user-create/user-register and user-update apis

##### Bug Fixes

  - User create/update and User register can now be used to update custom fields
  - Issue with the method UserEmailAvailabilty is fixed and the method returns isExist=true
  - Issue with Token validate and invalidate methods is fixed and these methods return expected results.
 

