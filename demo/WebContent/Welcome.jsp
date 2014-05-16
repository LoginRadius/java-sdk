<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginRadiusDemo</title>
</head>
<body>

<h4>Welcome to LoginRadius demo.Please select a provider to continue :</h4>

 <div id="interfacecontainerdiv" class="interfacecontainerdiv"></div>
 
  <script src="https://hub.loginradius.com/include/js/LoginRadius.js"></script>
  <script type="text/javascript">      
    var options={};      
    options.login=true;         
    LoginRadius_SocialLogin.util.ready(function () { 
    	$ui = LoginRadius_SocialLogin.lr_login_settings;
    	$ui.interfacesize = "";
    	$ui.apikey = "API_KEY_HERE";
    	$ui.callback=""; 
    	$ui.lrinterfacecontainer ="interfacecontainerdiv"; 
    	LoginRadius_SocialLogin.init(options);  }); 
   </script>

 
</body>
</html>