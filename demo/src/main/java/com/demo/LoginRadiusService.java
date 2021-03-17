package com.demo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loginradius.sdk.api.account.AccountApi;
import com.loginradius.sdk.api.account.RoleApi;
import com.loginradius.sdk.api.advanced.CustomObjectApi;
import com.loginradius.sdk.api.advanced.MultiFactorAuthenticationApi;
import com.loginradius.sdk.api.authentication.AuthenticationApi;
import com.loginradius.sdk.api.authentication.PasswordLessLoginApi;
import com.loginradius.sdk.models.enums.CustomObjectUpdateOperationType;
import com.loginradius.sdk.models.requestmodels.AccountUserProfileUpdateModel;
import com.loginradius.sdk.models.requestmodels.AuthUserRegistrationModel;
import com.loginradius.sdk.models.requestmodels.EmailAuthenticationModel;
import com.loginradius.sdk.models.requestmodels.EmailModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordByResetTokenModel;
import com.loginradius.sdk.models.requestmodels.RolesModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;
import com.loginradius.sdk.models.responsemodels.ListData;
import com.loginradius.sdk.models.responsemodels.MultiFactorAuthenticationResponse;
import com.loginradius.sdk.models.responsemodels.UserCustomObjectData;
import com.loginradius.sdk.models.responsemodels.UserPasswordHash;
import com.loginradius.sdk.models.responsemodels.configobjects.EmailVerificationData;
import com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel;
import com.loginradius.sdk.models.responsemodels.otherobjects.UserProfilePostResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;
import com.loginradius.sdk.util.Sott;

/**
 * Created by LoginRadius Development Team on 09/23/2018
 */
@Service
public class LoginRadiusService {

	@Value("${app.apikey}")
	private String apikey;
	@Value("${app.apisecret}")
	private String apisecret;
	@Value("${server.port}")
	private String server_port;
	Gson gson = new Gson();
	private LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();

	private String emailverification = "";
	private String resetpassword = "";
	private String resp = "";

	@PostConstruct
	public void init() {
		init.setApiKey(apikey);
		init.setApiSecret(apisecret);

		emailverification = "http://localhost:" + server_port + "/emailverification";
		resetpassword = "http://localhost:" + server_port + "/resetpassword";
	}

	public String login(HttpServletRequest request) {

		AuthenticationApi auth = new AuthenticationApi();
		EmailAuthenticationModel payload = new EmailAuthenticationModel();
		payload.setEmail(request.getParameter("email"));
		payload.setPassword(request.getParameter("password"));

		auth.loginByEmail(payload, null, null, null, null, new AsyncHandler<AccessToken<Identity>>() {

			@Override
			public void onSuccess(AccessToken<Identity> profile) {
				// TODO Auto-generated method stub
				resp = gson.toJson(profile);
			}

			@Override
			public void onFailure(ErrorResponse error) {
				// TODO Auto-generated method stub
				resp = error.getDescription();
			}

		});

		return resp;

	}

	public String register(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		AuthUserRegistrationModel userprofileModel = new AuthUserRegistrationModel();
		EmailModel email = new EmailModel();
		email.setType("Primary");
		email.setValue(request.getParameter("email"));
		userprofileModel.setEmail(new ArrayList<EmailModel>(Arrays.asList(email)));
		userprofileModel.setPassword(request.getParameter("password"));

		auth.userRegistrationByEmail(userprofileModel, getSott(), null, null, null, emailverification, null,
				new AsyncHandler<UserProfilePostResponse<AccessToken<Identity>>>() {

					@Override
					public void onSuccess(UserProfilePostResponse<AccessToken<Identity>> profile) {
						// TODO Auto-generated method stub
						resp = profile.getIsPosted().toString();

					}

					@Override
					public void onFailure(ErrorResponse error) {
						// TODO Auto-generated method stub
						resp = error.getDescription();
					}

				});
		return resp;
	}

	public String mfaLogin(HttpServletRequest request) {
		MultiFactorAuthenticationApi mfa = new MultiFactorAuthenticationApi();
		mfa.mfaLoginByEmail(request.getParameter("email"), request.getParameter("password"), null, null, null, null,
				null, null, new AsyncHandler<MultiFactorAuthenticationResponse<Identity>>() {

					@Override
					public void onSuccess(MultiFactorAuthenticationResponse<Identity> arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}

					@Override
					public void onFailure(ErrorResponse error) {
						// TODO Auto-generated method stub
						resp = error.getDescription();
					}

				});
		return resp;
	}

	public String mfaVerify(HttpServletRequest request) {
		MultiFactorAuthenticationApi mfa = new MultiFactorAuthenticationApi();
		mfa.mfaValidateGoogleAuthCode(request.getParameter("code"), request.getParameter("token"), null, null,
				new AsyncHandler<AccessToken<Identity>>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(AccessToken<Identity> arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});

		return resp;

	}

	public String emailVerify(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		auth.verifyEmail(request.getParameter("token"), null, null, null,
				new AsyncHandler<UserProfilePostResponse<EmailVerificationData<Identity>>>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(UserProfilePostResponse<EmailVerificationData<Identity>> arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});

		return resp;

	}

	public String passwordlessLogin(HttpServletRequest request) {
		PasswordLessLoginApi passwordlessLogin = new PasswordLessLoginApi();
		passwordlessLogin.passwordlessLoginByEmail(request.getParameter("email"), null, emailverification,
				new AsyncHandler<PostResponse>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(PostResponse arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});
		return resp;
	}

	public String passwordlessVerify(HttpServletRequest request) {
		PasswordLessLoginApi passwordlessLogin = new PasswordLessLoginApi();
		passwordlessLogin.passwordlessLoginVerification(request.getParameter("token"), null, null,
				new AsyncHandler<AccessToken<Identity>>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(AccessToken<Identity> arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});
		return resp;
	}

	public String forgotPassword(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		auth.forgotPassword(request.getParameter("email"), resetpassword, null, new AsyncHandler<PostResponse>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(PostResponse arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;
	}

	public String resetPassword(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		ResetPasswordByResetTokenModel payload = new ResetPasswordByResetTokenModel();
		payload.setResetToken(request.getParameter("token"));
		payload.setPassword(request.getParameter("password"));
		auth.resetPasswordByResetToken(payload, new AsyncHandler<UserProfilePostResponse<AccessTokenBase>>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(UserProfilePostResponse<AccessTokenBase> arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;
	}

	public String getUserProfile(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		auth.getProfileByAccessToken(request.getParameter("token"), null, new AsyncHandler<Identity>() {
			@Override
			public void onSuccess(Identity arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}

			@Override
			public void onFailure(ErrorResponse error) {
				// TODO Auto-generated method stub
				resp = error.getDescription();
			}

		});
		return resp;
	}

	public String changePassword(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		auth.changePassword(request.getParameter("token"), request.getParameter("newpassword"),
				request.getParameter("oldpassword"), new AsyncHandler<PostResponse>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(PostResponse arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});
		return resp;
	}

	public String setPassword(HttpServletRequest request) {
		AccountApi api = new AccountApi();
		api.setAccountPasswordByUid(request.getParameter("password"), request.getParameter("uid"),
				new AsyncHandler<UserPasswordHash>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(UserPasswordHash arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}

				});
		return resp;
	}

	public String accountUpdate(HttpServletRequest request) {
		AccountApi api = new AccountApi();
		AccountUserProfileUpdateModel userProfileUpdateModel = new AccountUserProfileUpdateModel();
		userProfileUpdateModel.setFirstName(request.getParameter("firstname"));
		userProfileUpdateModel.setLastName(request.getParameter("lastname"));
		userProfileUpdateModel.setAbout(request.getParameter("about"));
		api.updateAccountByUid(userProfileUpdateModel, request.getParameter("uid"), null, new AsyncHandler<Identity>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(Identity arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;
	}

	public String createCustomObject(HttpServletRequest request) {
		CustomObjectApi obj = new CustomObjectApi();
		JsonObject json = getRequestBody(request);
		obj.createCustomObjectByUid(request.getParameter("objectname"), json, request.getParameter("uid"),
				new AsyncHandler<UserCustomObjectData>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(UserCustomObjectData arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});
		return resp;
	}

	public String updateCustomObject(HttpServletRequest request) {
		CustomObjectApi obj = new CustomObjectApi();
		JsonObject json = getRequestBody(request);
		CustomObjectUpdateOperationType updateType = CustomObjectUpdateOperationType.PartialReplace;
		obj.updateCustomObjectByUid(request.getParameter("objectname"), request.getParameter("objectrecordid"), json,
				request.getParameter("uid"), updateType, new AsyncHandler<UserCustomObjectData>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(UserCustomObjectData arg0) {
						// TODO Auto-generated method stub

					}

				});

		return resp;
	}

	public String deleteCustomObject(HttpServletRequest request) {
		CustomObjectApi obj = new CustomObjectApi();
		obj.deleteCustomObjectByRecordID(request.getParameter("objectname"), request.getParameter("objectrecordid"),
				request.getParameter("uid"), new AsyncHandler<DeleteResponse>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(DeleteResponse arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});
		return resp;
	}

	public String getCustomObject(HttpServletRequest request) {
		CustomObjectApi obj = new CustomObjectApi();
		obj.getCustomObjectByUid(request.getParameter("objectname"), request.getParameter("uid"),
				new AsyncHandler<ListData<UserCustomObjectData>>() {

					@Override
					public void onFailure(ErrorResponse arg0) {
						// TODO Auto-generated method stub
						resp = arg0.getDescription();
					}

					@Override
					public void onSuccess(ListData<UserCustomObjectData> arg0) {
						// TODO Auto-generated method stub
						resp = gson.toJson(arg0);
					}
				});
		return resp;
	}

	public String mfaReset(HttpServletRequest request) {
		MultiFactorAuthenticationApi api = new MultiFactorAuthenticationApi();
		api.mfaResetGoogleAuthenticatorByUid(true, request.getParameter("uid"), new AsyncHandler<DeleteResponse>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(DeleteResponse arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});

		return resp;

	}

	public String getAllRoles(HttpServletRequest request) {
		RoleApi api = new RoleApi();
		api.getRolesList(new AsyncHandler<ListData<RoleModel>>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(ListData<RoleModel> arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;
	}

	public String getUserRoles(HttpServletRequest request) {
		RoleApi api = new RoleApi();
		api.getRolesByUid(request.getParameter("uid"), new AsyncHandler<AccountRolesModel>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(AccountRolesModel arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;
	}

	public String createRole(HttpServletRequest request) {

		RoleApi api = new RoleApi();
		RolesModel payload = new RolesModel();
		Map<String, Boolean> permissions = new HashMap<String, Boolean>();
		com.loginradius.sdk.models.requestmodels.RoleModel model = new com.loginradius.sdk.models.requestmodels.RoleModel();
		model.setName(request.getParameter("role"));
		permissions.put("permission_name1", true);
		permissions.put("permission_name2", true);
		model.setPermissions(permissions);
		payload.setRoles(new ArrayList<com.loginradius.sdk.models.requestmodels.RoleModel>(Arrays.asList(model)));
		api.createRoles(payload, new AsyncHandler<ListData<RoleModel>>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(ListData<RoleModel> arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});

		return resp;
	}

	public String deleteRole(HttpServletRequest request) {
		RoleApi api = new RoleApi();
		api.deleteRole(request.getParameter("role"), new AsyncHandler<DeleteResponse>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(DeleteResponse arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});

		return resp;

	}

	public String assignRole(HttpServletRequest request) {
		RoleApi api = new RoleApi();
		com.loginradius.sdk.models.requestmodels.AccountRolesModel payload = new com.loginradius.sdk.models.requestmodels.AccountRolesModel();
		// Roles
		List<String> roles = new ArrayList<String>();
		roles.add(request.getParameter("role"));

		payload.setRoles(roles);
		api.assignRolesByUid(payload, request.getParameter("uid"), new AsyncHandler<AccountRolesModel>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(AccountRolesModel arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;

	}

	public String logout(HttpServletRequest request) {
		AuthenticationApi auth = new AuthenticationApi();
		auth.authInValidateAccessToken(request.getParameter("token"), null, new AsyncHandler<PostResponse>() {

			@Override
			public void onFailure(ErrorResponse arg0) {
				// TODO Auto-generated method stub
				resp = arg0.getDescription();
			}

			@Override
			public void onSuccess(PostResponse arg0) {
				// TODO Auto-generated method stub
				resp = gson.toJson(arg0);
			}
		});
		return resp;
	}

	private JsonObject getRequestBody(HttpServletRequest request) {
		String line;
		StringBuffer buffer = new StringBuffer();
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			return new JsonParser().parse(data).getAsJsonObject();
		} catch (Exception e) {
			return null;
		}
	}

	private String getSott() {
		try {
			return Sott.getSott(null);
		} catch (Exception e) {
			return "";
		}
	}
}
