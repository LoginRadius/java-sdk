<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script src="//hub.loginradius.com/include/js/LoginRadius.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
$SL.util.ready(function () {
    var raasoption = {};
    raasoption.apikey = "<%= application.getInitParameter("LoginRadiusApiKey") %>";   
    raasoption.inFormvalidationMessage = true;
    raasoption.emailVerificationUrl = 'emailverify.jsp';    
	raasoption.V2Recaptcha = false;
});	
</script>
<title>Registration Page</title>
</head>
<body>
<div id="registration-container">
<div class="error"><% if(request.getParameter("error")!=null) 
	out.println(request.getParameter("error")); %></div>
<form id="registration-form" method="post" action="getRegister">
<label for="loginradius-raas-registration-firstname">First name</label>
<input type="text" name="firstname" ><br>
<label for="loginradius-raas-registration-lastname">Last name</label>
<input type="text" name="lastname"><br>
<label for="loginradius-raas-registration-emailid">Email Id</label>
<input type="text" name="emailid" ><br>
<label for="loginradius-raas-registration-emailid">Gender</label>
<input type="text" name="gender" ><br>
<label for="loginradius-raas-registration-emailid">BirthDate</label>
<input type="text" name="birthdate" ><br>

<label for="loginradius-raas-registration-password">Password</label>
<input type="password" name="password"><br>
<label for="loginradius-raas-registration-confirmpassword">Confirm Password</label>
<input type="password" name="confirmpassword"><br>
<input type="submit" value="Register">
</form>
</div>
</body>
</html>