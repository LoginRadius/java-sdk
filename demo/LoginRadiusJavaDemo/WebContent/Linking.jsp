<%@page import="com.loginradius.sdk.authentication.api.AuthenticationDeleteAPI"%>
<%@page import="com.loginradius.sdk.models.register.DeleteResponse"%>
<%@page import="com.loginradius.sdk.models.socialinterface.Provider"%>
<%@page import="java.util.List"%>
<%@page import="com.loginradius.sdk.models.socialinterface.SocialInterface"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationGetAPI"%>
<%@page import="com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusException"%>
<%@page import="com.loginradius.sdk.models.register.RegisterResponse"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationPutAPI"%>
<%@page import="com.loginradius.sdk.authentication.api.LRAuthenticationAPI"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusClient"%>
<%@page import="com.loginradius.sdk.models.AccessToken"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusCallbackHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   
 <link rel="stylesheet" type="text/css" href="assets/css/style.css">
  <link rel="stylesheet" type="text/css" href="assets/css/lr_raas.css">
</head>
<script src="https://auth.lrcontent.com/v2/LoginRadiusV2.js"></script>
<script type="text/javascript">


var commonOptions = {};
commonOptions.apiKey = "<%=application.getInitParameter("LoginRadiusApiKey")%>";
commonOptions.appName = "<%=application.getInitParameter("LoginRadiusSiteName")%>";
commonOptions.hashTemplate = true;
commonOptions.accessTokenResponse = true;
commonOptions.phoneLogin = false;
commonOptions.verificationUrl = "<put your verificationUrl>";
commonOptions.callbackUrl="http://localhost:8080";
commonOptions.formValidationMessage=true;
var LRObject= new LoginRadiusV2(commonOptions);


var la_options = {};
la_options.container = "interfacecontainerdiv_link";
la_options.templateName = "loginradiuscustom_tmpl_link"
la_options.onSuccess = function(response) {
    // On Success

   alert("you have successfully link this provider");
    console.log(response);
};
la_options.onError = function(errors) {
    // On Errors
	for(var i=0;i<errors.length;i++){
		 alert(errors[i].Description);
		 
	}
    console.log(errors);
}

LRObject.util.ready(function() {
    LRObject.init("linkAccount", la_options);
    LRObject.init("unLinkAccount", la_options);
});

</script>








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
<div class="secondary-menu" style="text-align: right;">
 <a style="display:inline-block;" href="/LoginRadiusJavaDemo">Logout</a>
</div>
           
            </div>
            </nav>




          </div>
          
   

  <div id="interfacecontainerdiv_link"  style="margin-left: 350px;
    margin-right: 350px; margin-bottom: 20px" class="interfacecontainerdiv_link"></div>
                <script type="text/html" id="loginradiuscustom_tmpl_link">
                    <# if(isLinked) { #>
                        <div class="lr-linked">
                            <a class="lr-sl-shaded-brick-button lr-flat-<#=Name.toLowerCase()#>" href="javascript:void(0)" onclick='return  <#=ObjectName#>.util.unLinkAccount(\"<#= Name.toLowerCase() #>\",\"<#= providerId #>\")' title="<#= Name #>" alt="Connected">
<span class="lr-sl-icon lr-sl-icon-<#=Name.toLowerCase()#>"></span></span>
<#=Name#> is connected | Unlink <#=Name#> 
</a>

                        </div>
                        <# } else {#>
                            <div class="lr-unlinked">

                                <a class="lr-sl-shaded-brick-button lr-flat-<#=Name.toLowerCase()#>" href="javascript:void(0)" onclick="return  <#=ObjectName#>.util.openWindow('<#= Endpoint #>');" title="<#= Name #>">
<span class="lr-sl-icon lr-sl-icon-<#=Name.toLowerCase()#>"></span></span>
Link With <#=Name#>

</a>

                            </div>
                            <# } #>
                </script>


</body>
</html>