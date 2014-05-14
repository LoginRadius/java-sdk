
<%@page import="java.net.URLEncoder"%>
<%@page import="com.loginradius.sdk.models.LoginRadiusPostResponse"%>
<%@page import="com.loginradius.sdk.core.LoginRadiusClient"%>
<%@page import="com.loginradius.sdk.api.StatusUpdateAPI"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status Update</title>
</head>
<body>
<%

  //Retrieving token stored in session for status post
  String token=(String)session.getAttribute("lrtoken");
  StatusUpdateAPI statusapi=new StatusUpdateAPI();
  
  //Setting status update parameters based on values provided by client in Callback form
  statusapi.setTitle(request.getParameter("title"));
  statusapi.setUrl(request.getParameter("url"));
  statusapi.setImageurl(request.getParameter("imageUrl"));
  statusapi.setStatus(request.getParameter("status"));
  statusapi.setCaption(request.getParameter("caption"));
  statusapi.setDescription(request.getParameter("description"));
  LoginRadiusClient client=new LoginRadiusClient(token);
  
  //Retrieving the response
  LoginRadiusPostResponse res = client.getResponse(statusapi,LoginRadiusPostResponse.class);
  //Showing alert box if status updated and redirecting to Welcome page
  if(res.isPosted)
  { %>
      <script>
       alert('Status Updated');
       window.location = 'Welcome.jsp';
      </script>
<% } %>
</body>
</html>