
<%@page import="com.loginradius.sdk.models.servertime.ServerTimeResponse"%>
<%@page import="com.loginradius.sdk.resource.Sott"%>
<%@page import="com.loginradius.sdk.advanced.api.AdvancedGetAPI"%>
<%@page import="com.loginradius.sdk.models.resthooks.fields.FieldList"%>
<%@page import="com.loginradius.sdk.models.resthooks.querydata.QueryData"%>
<%@page import="com.loginradius.sdk.models.AdvancedIdentityUserList"%>
<%@page import="com.loginradius.sdk.advanced.api.AdvancedPostAPI"%>
<%@page import="com.loginradius.sdk.advanced.api.LRAdvancedAPI"%>
<%@page import="com.loginradius.sdk.models.mention.LoginRadiusMention"%>
<%@page import="com.loginradius.sdk.models.LoginRadiusPostResponse"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.loginradius.sdk.models.photo.LoginRadiusPhoto"%>
<%@page import="com.loginradius.sdk.models.page.LoginRadiusPage"%>
<%@page import="com.loginradius.sdk.models.post.LoginRadiusPost"%>
<%@page import="com.loginradius.sdk.models.album.LoginRadiusAlbum"%>
<%@page import="com.loginradius.sdk.models.status.LoginRadiusStatus"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationDeleteAPI"%>
<%@page import="com.loginradius.sdk.models.AccessToken"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusCallbackHelper"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationPostAPI"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationPutAPI"%>
<%@page import="com.loginradius.sdk.models.CheckAvailability"%>
<%@page import="com.loginradius.sdk.models.role.AddRolePermissions"%>
<%@page import="com.google.gson.JsonPrimitive"%>
<%@page import="com.loginradius.sdk.models.login.LoginData"%>
<%@page import="com.loginradius.sdk.authentication.api.AuthenticationGetAPI"%>
<%@page import="com.loginradius.sdk.authentication.api.LRAuthenticationAPI"%>
<%@page import="com.loginradius.sdk.models.role.AssignRoles"%>
<%@page import="com.loginradius.sdk.management.api.ManagementDeleteAPI"%>
<%@page import="com.loginradius.sdk.models.register.DeleteResponse"%>
<%@page import="com.loginradius.sdk.management.api.ManagementPutAPI"%>
<%@page import="com.loginradius.sdk.models.role.LoginRadiusRoleResponse"%>
<%@page import="com.loginradius.sdk.management.api.ManagementGetAPI"%>
<%@page import="com.loginradius.sdk.models.customobject.ReadCustomObject"%>
<%@page import="com.loginradius.sdk.models.customobject.CreateCustomObject"%>
<%@page import="com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile"%>
<%@page import="com.loginradius.sdk.models.register.RegistrationData"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusClient"%>
<%@page import="com.loginradius.sdk.resource.LoginRadiusException"%>
<%@page import="com.loginradius.sdk.models.register.RegisterResponse"%>
<%@page import="com.loginradius.sdk.management.api.ManagementPostAPI"%>
<%@page import="com.loginradius.sdk.management.api.LRManagementAPI"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
   <link rel="stylesheet" href="assets/css/lr_raas.css">
     <link rel="stylesheet" href="assets/css/tab.css">
     
      <link rel="stylesheet" type="text/css" href="assets/css/style.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<script src="https://auth.lrcontent.com/v2/js/LoginRadiusV2.js"></script>

<%
String apikey=application.getInitParameter("LoginRadiusApiKey");
String apisecret=application.getInitParameter("LoginRadiusSecret");

Sott getsott =new Sott();
String sott =getsott.main(apisecret,apikey,null);%>
<script>
function redirect(token) {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = "Profile.jsp";
     var _token = document.createElement("input");
    _token.type = "hidden";
    _token.name = "token";
    _token.value = token;
    form.appendChild(_token);
    document.body.appendChild(form);
    form.submit();
}
function registerInterface(){
	
	
	var commonOptions = {};
	commonOptions.apiKey = "<%=application.getInitParameter("LoginRadiusApiKey")%>";
	commonOptions.appName = "<%=application.getInitParameter("LoginRadiusSiteName")%>";
	commonOptions.hashTemplate = true;
	commonOptions.accessTokenResponse = true;
	commonOptions.phoneLogin = false;
	commonOptions.sott = "<%= sott %>"; 
	commonOptions.verificationUrl = "http://localhost:8080";
	commonOptions.callbackUrl="http://localhost:8080";
	
commonOptions.formValidationMessage=true;
	var LRObject= new LoginRadiusV2(commonOptions);
	
	var registration_options = {}
    registration_options.onSuccess = function(response) {
        //On Success
        console.log(response);
       
        alert(JSON.stringify(response));
        

    };
    registration_options.onError = function(errors) {
        //On Errors
        console.log(errors);
        for(var i=0;i<errors.length;i++){
   		 alert(errors[i].Description);
   		 
   	 }



    };
    registration_options.container = "registration-container";
    LRObject.util.ready(function() {
        LRObject.init("registration", registration_options);
    })
}
	

function forgotpassword(){
	

	
	
		var commonOptions = {};
	commonOptions.apiKey = "<%=application.getInitParameter("LoginRadiusApiKey")%>";
	commonOptions.appName = "<%=application.getInitParameter("LoginRadiusSiteName")%>";
	commonOptions.hashTemplate = true;
	commonOptions.accessTokenResponse = true;
	commonOptions.phoneLogin = false;
	commonOptions.sott = "<%= sott %>"; 
	commonOptions.verificationUrl = "http://localhost:8080";
	commonOptions.callbackUrl="http://localhost:8080";
    commonOptions.formValidationMessage=true;
	var LRObject= new LoginRadiusV2(commonOptions);
	
	 var forgotpassword_options = {};
     forgotpassword_options.container = "forgotpassword-container";
     forgotpassword_options.onSuccess = function(response) {
         // On Success
    	  alert(JSON.stringify(response));
         console.log(response);

     };
     forgotpassword_options.onError = function(errors) {
         // On Errors
         console.log(errors);
         for(var i=0;i<errors.length;i++){
    		 alert(errors[i].Description);
    		 
    	 }
     }

     LRObject.util.ready(function() {
         LRObject.init("forgotPassword", forgotpassword_options);
     });

	

}


var commonOptions = {};
commonOptions.apiKey = "<%=application.getInitParameter("LoginRadiusApiKey")%>";
commonOptions.appName = "<%=application.getInitParameter("LoginRadiusSiteName")%>";
commonOptions.hashTemplate = true;
commonOptions.accessTokenResponse = true;
commonOptions.phoneLogin = false;
commonOptions.sott = "<%= sott %>"; 
commonOptions.verificationUrl = "http://localhost:8080";
commonOptions.callbackUrl="http://localhost:8080";
commonOptions.formValidationMessage=true;
var LRObject= new LoginRadiusV2(commonOptions);
var options = {};
var sl_options = {};
sl_options.onSuccess = function(response) {
	if(response.access_token!=null){
		 redirect(response.access_token);
	}else{
		redirect(response);
	}

   
    console.log(response);
};
options.onSuccess = function(response) {

   
	if(response.access_token!=null){
		 redirect(response.access_token);
	}else{
		redirect(response);
	}
    console.log(response);
};
options.onError = function(errors) {


	for(var i=0;i<errors.length;i++){
		 alert(errors[i].Description);
		 
	}

    console.log(errors);

};
sl_options.onError = function(errors) {
	for(var i=0;i<errors.length;i++){
		 alert(errors[i].Description);
		 
	}

    //On Errors
    console.log(errors);

};
options.container = "login-container";
sl_options.container = "sociallogin-container"
sl_options.templateName = "loginradiuscustom_tmpl";

LRObject.customInterface(".interfacecontainerdiv", sl_options);
LRObject.util.ready(function() {
  

    LRObject.init("login", options);
    LRObject.init('socialLogin', sl_options);
});

</script>

</head>
<body>
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
            </div>
            </nav>
 </div>
		
<div>
 <div id="sociallogin-container" class="interfacecontainerdiv" style="width: 22%;float: left;margin-left: 178px;margin-bottom: 20px;"></div>



<div style="text-align: left;"> 

<div>
   <div class="lineverticle"></div>
   <div class="wordwrapperline">
       <div class="wordline">or</div>
       <div style="float: right;margin: -60px 75px 0px 0px;">

<div class="container">
 
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Login</a></li>
    <li><a data-toggle="tab" href="#menu1">Register</a></li>
    <li><a data-toggle="tab" href="#menu2">Forgot Password ?</a></li>
   
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    
<div id="login-container" style="margin-top: 25px"></div>

    </div>
    <div id="menu1" class="tab-pane fade">
   <script type="text/javascript">registerInterface();</script>
   <div id="registration-container" style="margin-top: 25px"></div>
    
    </div>
    
    <div id="menu2" class="tab-pane fade">
    <script type="text/javascript">forgotpassword();</script>
  <div id="forgotpassword-container" style="margin-top: 25px"></div>
  </div>
   
  </div>
</div>
</div>

                <script type="text/html" id="loginradiuscustom_tmpl">
                    <a class="lr-sl-shaded-brick-button lr-flat-<#=Name.toLowerCase()#>" href="javascript:void(0)" onclick="return <#=ObjectName#>.util.openWindow('<#= Endpoint #>');"  title="<#= Name #>">
<span class="lr-sl-icon lr-sl-icon-<#=Name.toLowerCase()#>"></span></span>
Login With <#=Name#>

</a>
</script>

</body>
</html>
