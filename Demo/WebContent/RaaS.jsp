<%@page import="com.loginradius.sdk.social.core.LoginRadiusException"%>
<%@page import="com.loginradius.sdk.social.models.LoginRadiusPostResponse"%>
<%@page import="com.loginradius.sdk.raas.models.RaaSClientConfig"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.loginradius.sdk.raas.api.AccountAPI"%>
<%@page import="com.loginradius.sdk.raas.models.RaaSHashPassword"%>
<%@page import="com.loginradius.sdk.raas.models.RaaSResponse"%>
<%@page import="com.loginradius.sdk.raas.models.RaaSConfiguration"%>
<%@page import="com.loginradius.sdk.raas.models.RaaSUserDetails"%>
<%@page import="com.loginradius.sdk.raas.api.UserProfileAPI"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
RaaSConfiguration configSettings = new RaaSConfiguration("YOUR-API-KEY","YOUR-API-SECRET");


new RaaSClientConfig(configSettings);
Gson gson = new Gson();
UserProfileAPI userAPI= new UserProfileAPI();
/*RaaSUserDetails newUser= new RaaSUserDetails();
newUser.FirstName="FirstName";
newUser.LastName= "LastName";
newUser.emailId="abc11@email.com";
newUser.password="Password";
newUser.BirthDate="12-15-2011";
newUser.Gender="m";
RaaSUserDetails user= userAPI.createUser(newUser);
out.println(user.FirstName);*/
RaaSUserDetails newUser= new RaaSUserDetails();
newUser.FirstName="FirstName1";
newUser.LastName= "LastName112";
newUser.emailId="abbcee8f1524y3@gmail.com";
newUser.password="Password223";
newUser.BirthDate="10-10-1989";
newUser.Gender="f";




try{
//RaaSResponse resp  = userAPI.registerUser(newUser);

AccountAPI accountAPI= new AccountAPI();
RaaSHashPassword hashedPassword = accountAPI.getHashPassword("cffe5d857e444b6b98a26b4a895d2ce7");

out.println("hashedPassword.getHashPassword() -- " + hashedPassword.getHashPassword());

//out.println(gson.toJson(resp));
}catch(LoginRadiusException e){
	out.println(e.getErrorResponse().message);
	out.println(e.getErrorResponse().description);
	out.println(e.getErrorResponse().errorCode);
}catch(Exception e){
	out.println(e.getMessage());
	//out.println(e.getErrorResponse().description);
	//out.println(e.getErrorResponse().errorCode);
}
//out.println(gson.toJson(resp));

/* try{
RaaSUserDetails updatedUser= new RaaSUserDetails();
updatedUser.FirstName="FirstName111";
updatedUser.LastName= "LastName111";
updatedUser.BirthDate="10-10-2011";
updatedUser.Gender="f";
RaaSResponse resp = userAPI.editUser("a115a3f46e9d4b82830e5676837a1ddc",updatedUser);
}catch(LoginRadiusException exp){
	out.println(exp.getMessage());
	
}catch(Exception exp){
	out.println(exp.getMessage());
	
} */

//out.println(gson.toJson(resp));

/*LoginRadiusPostResponse postResponse = userAPI.changePassword("a115a3f46e9d4b82830e5676837a1ddc","Password","NewPassword");
out.println(gson.toJson(postResponse));
RaaSUserDetails user= userAPI.getUser("abc11@email.com","NewPassword");
out.println(gson.toJson(user));*/

%>
</body>
</html>