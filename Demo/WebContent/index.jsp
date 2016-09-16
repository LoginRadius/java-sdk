<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    
    <title>LoginRadius | User Registration Demo</title>

<script src="//hub.loginradius.com/include/js/LoginRadius.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/lr-raas.css">
<link rel="stylesheet" type="text/css" href="assets/css/customize.css">
<link rel="stylesheet" type="text/css" href="assets/css/custom-social.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">

<!-- Customizing -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>

</head>
<body>
	<div class="main-nav">
    <div class="container">

    </div>
</div>
<!-- Start Things -->
<div class="main">
    <div class="messagediv" style="display:none">
        <ul>
            <li class="top-tootip" style="width:96%">
                <p id="messageinfo"></p>
                <span> </span>
            </li>
            <div class="clear"></div>
        </ul>
    </div>
    
   
    <nav class="main-nav sticky-nav">
    <div class="container cf">
        <div class="logo no-text">
            <div class="logo-box">
                <h1 class="logo">
                    <a href="/JavaDemoNew">LoginRadius</a>
                </h1>

                <div class="site-description">User Registration Java Demo</div>
            </div>
        </div>

        <!-- Fragment Caching -->
        <div class="secondary-menu">
            <ul id="menu-top-menu" class="menu">
                <li id="menu-item-92" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-92"><a
                        class="lr-raas-button lr-raas-theme-login">Login</a></li>
                
                <li id="menu-item-93" class="menu-item menu-item-type-custom menu-item-object-custom menu-item-93"><a
                        class="lr-raas-button lr-raas-theme-register">Register</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="lr-frame lr-input-style">
    <h2>A Complete User Authentication Solution </h2>
	<h3>1. Managed Registration Service</h3>
        Our Managed Registration Service is a full user authentication solution for your web and mobile applications.
        The managed solution eliminates all the associated hassles with maintaining registration forms, and saves your
        engineering team significant time and resources.

        <h3>2. Fully Customizable</h3>
        LoginRadius’ Registration Service allows you to fully customize the registration form and login screen to match
        the look and feel of your website.

        <h3>3. Email Verification & Forgotten Service</h3>
        Email Verification of new sign-ups and forgotten username/password retrieval are simple fixes with LoginRadius’
        Managed Registration.

        <h3>4. Custom Emails</h3>
        You can easily set custom email templates and content for email verification and forgotten usernames and
        password service. LoginRadius’ system also has the capability to connect to your existing email service
        provider.

        <h3>5. User Data Management</h3>
        Data storage is provided to help you manage your users and their data. You keep full ownership of the data and
        have full access at all times. LoginRadius also delivers a copy of the data to your local database.

        <h3>6 Works with Social Login</h3>
        Our Registration Service comes with Social Login and Social Account Linking. Your existing users can choose to
        migrate to Social Login if they would prefer, or log-in through Traditional Registration. Both systems work
        together seamlessly.

        <h3>Works with all Major Technologies</h3>
        The LoginRadius Platform works with all popular web technologies; WordPress, Drupal, Joomla, PHP, .NET,
        Javascript, Android, iOS and many more. You can see the complete list here.
</div>
</div>
</body>



<script>

		var lrThemeSettings = {
			raasoption: {
				apikey : "<%= application.getInitParameter("LoginRadiusApiKey") %>",
				appname : "<%= application.getInitParameter("LoginRadiusSiteName") %>",
				forgotPasswordUrl : window.location.href,
				emailVerificationUrl : window.location.href
			},
			logo: {
				logo_image_path: "", /* Your logo image path, must be 28px * 28px */
				logo_alt_text: "" /* Alternative text for Image */
			},
			caption_message: {
				register: "Register",
				login: "Login",
				forgot_password: "Forgot Password",
				reset_password: "Reset Passord",
				fields_missing: "One Step Left"
			},
			success_message: {
				register: "Succeed, a verification email has been sent to your email address",
				login: "Login succeed",
				social_login: "Social login succeed", /* Or maybe go check your emails to verify for Twitter */
				email_verified: "Email verified successfully, you can login now",
				forgot_password: "A reset link has been sent to your email address, click to reset your email",
				reset_password: "Your password has been reset"
			},
			  success_function: {
					register: function(){
						alert('register succeed!');
					},
					login: function(response) {
						
						console.log(" response " + JSON.stringify(response));
						
						redirect(response.access_token);
						
						
					},
					social_login: function(response) {
				
						 
						console.log('response ' + response);
	
								redirect(response);
								//console.log('data' + data.access_token);
								//alert("token " + response.access_token);
								//alert("data" + JSON.stringify(response));
	       					     
	       					
					},
					forgot_password: function() {

					},
					reset_password: function() {
	    			if(response)
	    			 window.location.href ="index.jsp?success="+response;    
					}
				},

			form_render_submit_hook: {
				start: function(){
					// console.log( 'start' );
				},
				end: function(){
					
				}
			},
			reset_form_after_close_popup: false,
			auto_login_after_verify_email: true
		}
		
		
		
		function redirect(token) {
			console.log('redirecting .... ');
			   var form = document.createElement("form");
			   form.method = "POST";
			   form.action = "/JavaDemoNew/getProfile";
			   var _token = document.createElement("input");
			   _token.type = "hidden";
			   _token.name = "token";
			   _token.value = token;
			   form.appendChild(_token);
			   document.body.appendChild(form);
			   form.submit();
			}
		
		
		
		
		
	</script>
	
	<script src="//hub.loginradius.com/include/js/LoginRadius.js"></script>
	<script src="//cdn.loginradius.com/hub/prod/js/LoginRadiusRaaS.js"></script>
	<script src="LoginRadiusSDK.js" type="text/javascript"></script>  
	<script type="text/javascript" src="assets/js/lr-theme-full.js"></script>

		<script type="text/html" id="loginradiuscustom_tmpl">
		    <span class="lr-provider-label lr-sl-shaded-brick-button lr-flat-<#=Name.toLowerCase()#>"
		    onclick="return $SL.util.openWindow('<#= Endpoint #>&is_access_token=true&callback=<#= window.location #>');"
		          title="Sign up with <#= Name #>" alt="Sign in with <#=Name#>" >
		          <span class="lr-sl-icon lr-sl-icon-<#=Name.toLowerCase()#>"></span>
		          Sign up with <#=Name#>
		    </span>
		</script>

		<script type="text/html" id="loginradiuscustom_tmpl_IOS">
		    <span class="lr-provider-label lr-sl-shaded-brick-button lr-flat-<#=Name.toLowerCase()#>"
		    onclick="window.location.href='<#= Endpoint #>&is_access_token=true&callback=<#= window.location #>&callbacktype=hash';"
		          title="Sign up with <#= Name #> IOS" alt="Sign in with <#=Name#> IOS" >
		          <span class="lr-sl-icon lr-sl-icon-<#=Name.toLowerCase()#>"></span>
		          Sign up with <#=Name#> IOS
		    </span>
		</script>
		
<script type="text/javascript">
if(window.location.hash && window.location.hash.indexOf("lr-token")>-1){
	window.location.hash = window.location.hash.replace("lr-token","lr-access-token");
}

$('body').on('focus', "#loginradius-raas-registration-birthdate", function () {
    $(this).datepicker({ dateFormat: "mm-dd-yy", changeMonth: true, changeYear: true, yearRange: '1970:2015' });
});
$('body').on('focus', "#loginradius-raas-social-registration-birthdate", function () {
    $(this).datepicker({ dateFormat: "mm-dd-yy", changeMonth: true, changeYear: true, yearRange: '1970:2015' });
});      
</script>




