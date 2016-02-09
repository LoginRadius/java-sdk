<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Change your password</title>
<script src="//hub.loginradius.com/include/js/LoginRadius.js"></script>
<script src="//cdn.loginradius.com/hub/prod/js/LoginRadiusRaaS.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/lr-raas.css">
<link rel="stylesheet" type="text/css" href="assets/css/customize.css">
<link rel="stylesheet" type="text/css" href="assets/css/custom-social.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">

<script type="text/javascript">
$SL.util.ready(function() {
    var raasoption = {};
    raasoption.apikey = "<%= application.getInitParameter("LoginRadiusApiKey") %>";
    LoginRadiusRaaS.init(raasoption, 'resetpassword', function(response) {
    	if(response)
    	 window.location.href ="index.jsp?success="+response;    	
    }, function(errors) {
       
    }, "resetpassword-container");
});
</script>

</head>
<body>
<div class="error"><% if(request.getParameter("error")!=null){
	      out.println(request.getParameter("error").toString());
}
	%></div>
<div style="  padding-left: 40%;
  padding-top: 5%;">
<form method="post" action="/JavaDemo/getProfile">
<label for="loginradius-raas-registration-password">Password</label>
<input type="password" name="password"><br>
<label for="loginradius-raas-registration-confirmpassword">Confirm Password</label>
<input type="password" name="confirmpassword"><br>
<input type="submit" value="Save">
<input type="hidden" name="userid" value=<%= request.getParameter("userid") %>>
</form>
</div>
</body>
</html>