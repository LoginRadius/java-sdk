<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
commonOptions.formValidationMessage=true;
var LRObject= new LoginRadiusV2(commonOptions);

var updatephone_options = {};
updatephone_options.container = "updatephone-container";
updatephone_options.onSuccess = function(response) {
    // On Success
   alert("You have successfully updated your Phone");
    console.log(response);
};
updatephone_options.onError = function(errors) {
    // On Error
	for(var i=0;i<errors.length;i++){
		 alert(errors[i].Description);
		 
	}
    console.log(errors);
};

LRObject.util.ready(function() {

    LRObject.init("updatePhone", updatephone_options);


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
              <a style="display:inline-block;" href="/LoginRadiusJavaDemo">Logout</a>
              </div>
            </div>
            </nav>




          </div>
	
		<div id="updatephone-container" style="text-align: center;"></div>
		
		
</body>
</html>