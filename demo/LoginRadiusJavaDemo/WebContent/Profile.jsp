

<%@page import="com.loginradius.sdk.models.role.LoginRadiusRoleResponse"%>
<%@page import="com.loginradius.sdk.models.login.EmailOtpResponse"%>
<%@page import="com.loginradius.sdk.models.role.AddRolePermissions"%>
<%@page import="com.google.gson.JsonPrimitive"%>
<%@page import="com.loginradius.sdk.models.phone.PhoneSendOtpResponse"%>
<%@page import="com.loginradius.sdk.models.phone.PhoneForgotPasswordResponse"%>
<%@page import="com.loginradius.sdk.models.company.LoginRadiusCompany"%>
<%@page import="com.loginradius.sdk.models.configuration.ConfigurationResponse"%>
<%@page import="com.loginradius.sdk.models.two_factor.BackUpCodesResponse"%>
<%@page import="com.loginradius.sdk.models.cloudstorage.insights.InsightsResponse"%>
<%@page import="com.loginradius.sdk.models.cloudstorage.customobject.GetCustoObjectsResponse"%>
<%@page import="com.loginradius.sdk.models.cloudstorage.identity.GetUserIdentityResponse"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationDeleteAPI"%>
<%@page import="com.loginradius.sdk.models.EmailDeleteRequest"%>
<%@page import="com.loginradius.sdk.resource.Sott"%>
<%@page import="com.loginradius.sdk.util.LoginRadiusConstant"%>
<%@page import="com.loginradius.sdk.models.login.LoginData"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationPostAPI"%>
<%@page import="com.loginradius.sdk.models.customregistrationdata.UpdateRegistrationDataResponse"%>
<%@page import="com.loginradius.sdk.management.api.ManagementPutAPI"%>
<%@page import="com.loginradius.sdk.management.api.ManagementGetAPI"%>
<%@page import="com.loginradius.sdk.models.register.DeleteResponse"%>
<%@page import="com.loginradius.sdk.management.api.ManagementDeleteAPI"%>
<%@page import="com.loginradius.sdk.models.customregistrationdata.GetRegistrationDataResponse"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.loginradius.sdk.management.api.ManagementPostAPI"%>
<%@page import="com.loginradius.sdk.management.api.LRManagementAPI"%>
<%@page import="com.loginradius.sdk.models.customobject.CreateCustomObject"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationPutAPI"%>
<%@page import="com.loginradius.sdk.models.register.RegisterResponse"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusClient"%>
<%@page import="com.loginradius.sdk.models.AccessToken"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusCallbackHelper"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusException"%>
<%@page import="com.loginradius.sdk.authentication.api.LRAuthenticationAPI"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationGetAPI"%>
<%@page import="com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>

<%@page import="java.util.Iterator"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Profile</title>


      <link rel="stylesheet" type="text/css" href="assets/css/style.css">

        <%
      
        LoginRadiusCallbackHelper callbackhelper = new LoginRadiusCallbackHelper();
        AccessToken token = callbackhelper.GetLoginRadiusToken(request);
        LoginRadiusClient client = new LoginRadiusClient();
        client.setToken(token);
        Gson gson =new Gson();
        if(token !=null)
        {  
        session.setAttribute("lrtoken",token.getAccessToken());
        
        

        try{ 	
        	LRAuthenticationAPI userprofileapi = new AuthenticationGetAPI(LoginRadiusConstant.READACCOUNT_BYTOKEN,null);
        	LoginRadiusUltimateUserProfile profile = client.getResponse(userprofileapi,LoginRadiusUltimateUserProfile.class);
        	
        	
       

        %>

<body>
        <!-- Start Things -->
        <table align="center"
          style="width: 50%; border: 1px solid #ccc; box-shadow: 0px 0px 11px 0px #ccc;margin: 0 auto;">
          <tr>
            <td>
              <table>


                <tr>

                  <td style="padding: 10px; border: none; width: 25%;"><img
                    src="<%=profile.getImageUrl()%>" alt="Avatar"
                    style="width: 140px; height: 140px;"></td>

                  <td
                    style="border: none; vertical-align: top; padding-top: 7px;">
                    <table border="0" width="100%">
                      <tr>
                      <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">Uid :</td>
                        <td>
                          <%
                            out.println(profile.getUid());
                          %>
                        </td>
                      </tr>
                      <tr>
                      <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">FullName :</td>
                        <td>
                          <%
                            out.println(profile.FullName);
                          %>
                        </td>
                      </tr>
                      <tr>
                      <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">Gender :</td>
                        <td>
                          <%
                            out.println(profile.Gender);
                          %>
                        </td>
                      </tr>
                      <tr>
                      <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">BirthDate :</td>
                        <td>
                          <%
                        	 out.println(profile.BirthDate);
                          
                          %>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
            </td>
          </tr>


          <tr>

            <td style="width: 100%; padding: 2%;">
              <table
                style="width: 100%; border: 1px solid #ccc; padding: 10px;">

                <tr>
                  <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">First
                    Name :</td>
                  <td style="padding-bottom: 2%;">
                    <%
                      out.println(profile.FirstName);
                    %>
                  </td>
                </tr>
                <tr>
                  <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">Middle
                    Name :</td>
                  <td style="padding-bottom: 2%;">
                    <%
                      out.println(profile.MiddleName);
                    %>
                  </td>
                </tr>
                <tr>
                  <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">Last
                    Name :</td>
                  <td style="padding-bottom: 2%;">
                    <%
                      out.println(profile.LastName);
                    %>
                  </td>
                </tr>
                <tr>
                  <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">Local
                    Country :</td>
                  <td style="padding-bottom: 2%;">
                    <%
                      out.println(profile.LocalCountry);
                    %>
                  
                </tr>
                <tr>
                  <td style="width: 25%; padding-bottom: 2%; font-weight: bold;">Email:</td>
                  <td style="padding-bottom: 2%;">
                    <table width="100%">
                      <%
                        for (int i = 0; i < profile.Email.size(); i++) {
                      %>
                      <tr>
                        <%
                          out.println(profile.Email.get(i).Value);
                        
                        %>
                      </tr>
                      <%
                        }
                      
        }catch(LoginRadiusException e){out.println(e.getErrorResponse().getDescription());}
        }
                      %>
                    </table>
                  </td>
                </tr>


            

              </table>
          </tr>


          <div class="main">
            <div class="messagediv" style="display: none">
              <ul>
                <li class="top-tootip" style="width: 96%">
                  <p id="messageinfo"></p> <span> </span>
                </li>
                <div class="clear"></div>
              </ul>
            </div>
            <nav class="main-nav sticky-nav">
            <div class="container cf">
              <div class="logo no-text">
                <div class="logo-box">
                  <h1 class="logo">
                    <a href="/LoginRadiusJavaDemo">LoginRadius</a>
                  </h1>

                  <div class="site-description">Java Demo</div>
                </div>
              </div>

              <!-- Fragment Caching -->
              <div class="secondary-menu" style="text-align: right;">


                 <a class="button-page" href="/LoginRadiusJavaDemo/Linking.jsp">
                 Account Linking</a>
                <a class="button-page" href="/LoginRadiusJavaDemo/ChangePassword.jsp">
                 Change Password</a>
                  <a class="button-page" href="/LoginRadiusJavaDemo/AddEmail.jsp">
                 AddEmail</a>
                <a class="button-page" href="/LoginRadiusJavaDemo/RemoveEmail.jsp">
                 RemoveEmail</a>
                   <a class="button-page" href="/LoginRadiusJavaDemo/ChangeUsername.jsp">
                 ChangeUsername</a>
                <a class="button-page" href="/LoginRadiusJavaDemo/UpdateProfile.jsp">
                 Update Profile</a>
                <a class="button-page" href="/LoginRadiusJavaDemo/UpdatePhone.jsp">
                 Update Phone</a>
                
              <a class="button-page"  href="/LoginRadiusJavaDemo">Logout</a>
              </div>
            </div>
            </nav>




          </div>
         
        </table>
        </body>
</html>