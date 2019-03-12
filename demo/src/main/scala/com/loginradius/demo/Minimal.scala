package com.loginradius.demo

import org.scalatra._
import scalate.ScalateSupport
import com.google.gson._
import scala.collection.JavaConverters._

import com.loginradius.sdk.authentication.api._
import com.loginradius.sdk.models.GetPasswordResponse
import com.loginradius.sdk.models.login.LoginData
import com.loginradius.sdk.models.register.RegisterResponse
import com.loginradius.sdk.models.two_factor.TwoFactorLogin
import com.loginradius.sdk.models.email.EmailVerificationResponse
import com.loginradius.sdk.resource.LoginRadiusException
import com.loginradius.sdk.resource.LoginRadiusClient
import com.loginradius.sdk.resource.Sott
import com.loginradius.sdk.util.LoginRadiusConstant

class Minimal(var client: LoginRadiusClient) extends ScalatraServlet with ScalateSupport {

	var gson: Gson = new Gson()

	get("/") {
		redirect("/loginscreen")
	}

	get("/loginscreen") {
		contentType="text/html"
		layoutTemplate("/WEB-INF/templates/views/loginscreen.ssp")
	}

	get("/minimal") {
		contentType="text/html"
		layoutTemplate("/WEB-INF/templates/views/index.ssp")
	}

	get("/emailverification") {
		contentType="text/html"
		layoutTemplate("/WEB-INF/templates/views/emailverification.ssp")
	}

	get("/resetpassword") {
		contentType="text/html"
		layoutTemplate("/WEB-INF/templates/views/resetpassword.ssp")
	}

	get("/login") {
		try {
			var map: java.util.Map[String,String] = Map("password" -> params("password"), "email" -> params("email")).asJava
			var api: LRAuthenticationAPI = new AuthenticationGetAPI(LoginRadiusConstant.EMAIL_LOGIN, map)
			var res: LoginData = client.getResponse(api, classOf[LoginData])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	post("/mfa") {
		try {
			var json: JsonObject = new JsonObject()
			json.add("email", new JsonPrimitive(params("email")))
			json.add("password", new JsonPrimitive(params("password")))
			var api: LRAuthenticationAPI = new AuthenticationPostAPI(LoginRadiusConstant.MFA_LOGIN, null, json)
			var res: TwoFactorLogin = client.getResponse(api, classOf[TwoFactorLogin])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/mfa/verify") {
		try {
			var map: java.util.Map[String,String] = Map("secondfactorauthenticationtoken" -> params("token")).asJava
			var json: JsonObject = new JsonObject()
			json.add("googleauthenticatorcode", new JsonPrimitive(params("code")))
			var api: LRAuthenticationAPI = new AuthenticationPutAPI(LoginRadiusConstant.MFA_VERIFY_BYGOOGLEAUTHENTICATOR, map, json)
			var res: TwoFactorLogin = client.getResponse(api, classOf[TwoFactorLogin])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	post("/register") {
		try {
			var map: java.util.Map[String,String] = Map("verificationurl" -> urls.emailVerificationUrl, "sott" -> getSott()).asJava
			var json: JsonObject = new JsonObject()
			var arr: JsonArray = new JsonArray()
			var arr_sets: JsonObject = new JsonObject()
			arr_sets.add("Type", new JsonPrimitive("Primary"))
			arr_sets.add("Value", new JsonPrimitive(params("email")))
			arr.add(arr_sets)
			json.add("Email", arr)
			json.add("Password", new JsonPrimitive(params("email")))
			var api: LRAuthenticationAPI = new AuthenticationPostAPI(LoginRadiusConstant.REGISTER, map, json)
			var res: RegisterResponse = client.getResponse(api, classOf[RegisterResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/email/verify") {
		try {
			var map: java.util.Map[String,String] = Map("verificationtoken" -> params("token")).asJava
			var api: LRAuthenticationAPI = new AuthenticationGetAPI(LoginRadiusConstant.VERIFY_EMAIL, map)
			var res: EmailVerificationResponse = client.getResponse(api, classOf[EmailVerificationResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/passwordless") {
		try {
			var map: java.util.Map[String,String] = Map("email" -> params("email"), "verificationurl" -> urls.emailVerificationUrl).asJava
			var api: LRAuthenticationAPI = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN, map)
			var res: EmailVerificationResponse = client.getResponse(api, classOf[EmailVerificationResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/passwordless/verify") {
		try {
			var map: java.util.Map[String,String] = Map("verificationtoken" -> params("token")).asJava
			var api: LRAuthenticationAPI = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN_VERIFICATION, map)
			var res: LoginData = client.getResponse(api, classOf[LoginData])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	post("/password/forgot") {
		try {
			var map: java.util.Map[String,String] = Map("resetpasswordurl" -> urls.resetPasswordUrl).asJava
			var json: JsonObject = new JsonObject()
			json.add("email", new JsonPrimitive(params("email")))
			var api: LRAuthenticationAPI = new AuthenticationPostAPI(LoginRadiusConstant.FORGOT_PASSWORD_BYEMAIL, map, json)
			var res: RegisterResponse = client.getResponse(api, classOf[RegisterResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/password/reset") {
		try {
			var json: JsonObject = new JsonObject()
			json.add("resettoken", new JsonPrimitive(params("token")))
			json.add("password", new JsonPrimitive(params("password")))
			var api: LRAuthenticationAPI = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD, null, json)
			var res: RegisterResponse = client.getResponse(api, classOf[RegisterResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	def getSott() : String = {
        try {
            return Sott.main(credentials.apiSecret, credentials.apiKey, null)
        } catch {
        	case e: Exception => return ""
        }
    }
}
