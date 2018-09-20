<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Email</title>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body>

<script src="https://auth.lrcontent.com/v2/js/LoginRadiusV2.js"></script>
<script type="text/javascript">
var commonOptions = {};
commonOptions.apiKey = "<%=application.getInitParameter("LoginRadiusApiKey")%>";
commonOptions.appName = "<%=application.getInitParameter("LoginRadiusSiteName")%>";
commonOptions.hashTemplate = true;
commonOptions.accessTokenResponse = true;
commonOptions.phoneLogin = false;
commonOptions.verificationUrl = "<put your verificationUrl>";
commonOptions.formValidationMessage=true;
var LRObject= new LoginRadiusV2(commonOptions);
var addemail_options = {};
addemail_options.container = "addemail-container";
addemail_options.onSuccess = function(response) {
    // On Success
   alert(JSON.stringify(response));
    console.log(response);
};
addemail_options.onError = function(errors) {
    // On Error
	for(var i=0;i<errors.length;i++){
		 alert(errors[i].Description);
		 
	}
};
LRObject.util.ready(function() {
    LRObject.init("addEmail", addemail_options);
});
</script>
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

              <!-- Fragment Caching -->
            
            <div class="secondary-menu" style="text-align: right;">
<a style="margin-top: 22px;" class="button-page" onclick="history.back()"><img class="img-back" src="assets/images/back.png" /><span id="tst" style="display: inline-block">Back</span></a>
 <a style="margin-top: 22px;" class="button-page" href="/LoginRadiusJavaDemo">Logout</a>
</div>
             
            </div>
            </nav>
        </div>
<div id="addemail-container" style="text-align: center;"></div>
		
</body>
</html>