
<%@page import="com.loginradius.sdk.models.page.LoginRadiusPage"%>
<%@page import="com.loginradius.sdk.api.PageAPI"%>
<%@page import="com.loginradius.sdk.models.album.LoginRadiusAlbum"%>
<%@page import="com.loginradius.sdk.api.AlbumAPI"%>
<%@page import="com.loginradius.sdk.models.status.LoginRadiusStatuses"%>
<%@page import="com.loginradius.sdk.api.StatusAPI"%>
<%@page import="com.loginradius.sdk.models.like.LoginRadiusLike"%>
<%@page import="com.loginradius.sdk.api.LikeAPI"%>
<%@page import="com.loginradius.sdk.models.group.LoginRadiusGroup"%>
<%@page import="com.loginradius.sdk.api.GroupAPI"%>
<%@page import="com.loginradius.sdk.models.event.LoginRadiusEvent"%>
<%@page import="com.loginradius.sdk.api.EventAPI"%>
<%@page import="com.loginradius.sdk.models.company.LoginRadiusCompany"%>
<%@page import="com.loginradius.sdk.api.CompanyAPI"%>
<%@page import="com.loginradius.sdk.models.LoginRadiusContactCursorResponse"%>
<%@page import="com.loginradius.sdk.api.ContactAPI"%>
<%@page import="com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile"%>
<%@page import="com.loginradius.sdk.api.UserProfileAPI"%>
<%@page import="com.loginradius.sdk.core.LoginRadiusClient"%>
<%@page import="com.loginradius.sdk.models.AccessToken"%>
<%@page import="com.loginradius.sdk.core.LoginRadiusCallbackHelper"%>
<%@page import="java.util.List"%>

<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{color:#444;}

 </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Callback Page</title>
</head>
<body>

<center><h2>User Profile Data</h2></center>
	<%
	    //LoginRadius helper class initialized with LoginRadius API secret
		LoginRadiusCallbackHelper callbackhelper = new LoginRadiusCallbackHelper("API_SECRET_HERE");
        
	    //Request for access token
	    AccessToken token = callbackhelper.GetLoginRadiusToken(request);
		if(token !=null)
		{
			//Storing the token in session,to retreive it in Status.jsp page
			session.setAttribute("lrtoken",token.access_token);
			LoginRadiusClient client = new LoginRadiusClient(token);
			UserProfileAPI userprofileapi = new UserProfileAPI();
			//Ma
			LoginRadiusUltimateUserProfile userprofile = client.getResponse(userprofileapi,LoginRadiusUltimateUserProfile.class);
	 %>
		<table align="center" style=" width:50%; border:1px solid #ccc; box-shadow: 0px 0px 11px 0px #ccc;">
		
		
		        <tr>
		        <td>
		       <table>
		       
		       
		        <tr>
		        
		          <td style="padding: 10px;border: none;width: 25%;"><img src="<%=userprofile.ImageUrl%>" alt="Avatar" style="width:140px;height:140px;"></td>
		          
		          <td style="border:none;vertical-align: top;padding-top: 7px;">
		             <table border="0" width="100%">
		              <tr><td><%out.println(userprofile.ID);%></td></tr>
		              <tr><td><%out.println(userprofile.FullName);%></td></tr> 
		              <tr><td><%out.println(userprofile.Gender);%></td></tr>
		              <tr><td><%out.println(userprofile.BirthDate);%></td></tr>
		             </table>
		          </td>
		          </tr>
		          </table>
		          </td>
		          </tr>
		
		   <tr>
		   <td style=" width:100%; padding:2%;">
		   <table style=" width:100%; border:1px solid #ccc;padding: 10px;">
		   
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">First Name : </td>
               <td style="padding-bottom: 2%;"><% out.println(userprofile.FirstName);%></td></tr>
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Middle Name : </td>
               <td style="padding-bottom: 2%;"><% out.println(userprofile.MiddleName);%></td></tr>
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Last Name :</td>
               <td style="padding-bottom: 2%;"><% out.println(userprofile.LastName);%></td></tr>
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Local Country : </td>
              <td style="padding-bottom: 2%;"> <% out.println(userprofile.LocalCountry);  %> </tr>
                <tr>
                 <td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Email:</td>
                  <td style="padding-bottom: 2%;">
                   <table width="100%">
                   <%
                     for (int i = 0; i < userprofile.Email.size(); i++) 
                     {
                     %>
                     <tr>
                       <%out.println(userprofile.Email.get(i).Value); %>
                     </tr>
                     <%} %>
                   </table>
                 </td>
                 </tr>
                 
                 
                <tr>
                  <%
                   ContactAPI contacts=new ContactAPI();
                   LoginRadiusContactCursorResponse res=client.getResponse(contacts,LoginRadiusContactCursorResponse.class);
                   if(res!=null)
                   {
                	   for(int i=0;i<res.Data.size();i++)
                		   out.println("Contact Name : " + res.Data.get(i).name+"<br/>");
                   }
                   
                   CompanyAPI company=new CompanyAPI();
                   LoginRadiusCompany[] com=client.getResponse(company,LoginRadiusCompany[].class);
                   if(com.length>0)
                   {
                	   for(int i=0;i<com.length;i++)
                		   out.println("Company Name : "+com[i].name+"<br/>");
                   }
                   
                   EventAPI event =new EventAPI();
                   LoginRadiusEvent[] eve=client.getResponse(event,LoginRadiusEvent[].class);
                   if(eve.length>0)
                   {
                	   for(int i=0;i<eve.length;i++)
                		   out.println("Event Name : "+eve[i].name+"<br/>");
                   }
                   
                   GroupAPI group=new GroupAPI();
                   LoginRadiusGroup[] gr=client.getResponse(group,LoginRadiusGroup[].class);
                   if(gr.length>0)
                   {
                	   for(int i=0;i<gr.length;i++)
                		   out.println("Group Name : "+gr[i].name+"<br/>");
                   }
                   
                   /*LikeAPI like=new LikeAPI();
                   LoginRadiusLike[] lk=client.getResponse(like,LoginRadiusLike[].class);
                   if(lk.length>0)
                   {
                	   for(int i=0;i<lk.length;i++)
                		   out.println("Like Description : "+lk[i].Description+"<br/>");
                   }*/
                   
                   StatusAPI status=new StatusAPI();
                   LoginRadiusStatuses[] st=client.getResponse(status,LoginRadiusStatuses[].class);
                   if(st.length>0)
                   {
                	   for(int i=0;i<5;i++)
                		   out.println("Status Text : "+st[i].text+"<br/>");
                   }
                   
                   AlbumAPI album=new AlbumAPI();
                   LoginRadiusAlbum[] alb=client.getResponse(album,LoginRadiusAlbum[].class);
                   if(alb.length>0)
                   {
                	   for(int i=0;i<alb.length;i++)
                		   out.println("Album ID : "+alb[i].ID+"<br/>");
                   }
                   
                   /*PageAPI pages=new PageAPI();
                   LoginRadiusPage[] pg=client.getResponse(pages,LoginRadiusPage[].class);
                   if(pg.length>0)
                   {
                	   for(int i=0;i<pg.length;i++)
                		   out.println("Page Name : "+pg[i].Name+"<br/>");
                   }*/
                   
                   
                  %>
                </tr>
                 
                 </table>
                 </td>
                 </tr>

                  <tr>
                   <td style="font-size: 20px;padding: 11px;">Post Message :</td>
                  </tr> 
                   
                 <tr>  
                  <td style=" width:100%; padding:2%;">
                   <form action="Status.jsp">
                  <table style=" width:100%; padding: 10px;padding-top: 0px;">
                   
                   <tr>
                  <td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Title:</td>
                    <td style="padding-bottom: 2%;"><input type="text" name="title"  style="border: 1px solid #ccc;height: 23px;width: 300px;" /></td>
                   </tr>
                   <tr>
                  <td style="width: 25%;padding-bottom: 2%;font-weight: bold;"> Url:</td>
                   <td style="padding-bottom: 2%;"> <input type="text" name="url"  style="border: 1px solid #ccc;height: 23px;width: 300px;" /></td>
                   </tr>
                   <tr>
                   <td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Image URL:</td>
                    <td style="padding-bottom: 2%;"><input type="text" name="imageUrl"  style="border: 1px solid #ccc;height: 23px;width: 300px;" /></td>
                   </tr>
                   <tr>
                   <td style="width: 25%;padding-bottom: 2%;font-weight: bold;"> Status:</td>
                    <td style="padding-bottom: 2%;"><input type="text" name="status"  style="border: 1px solid #ccc;height: 23px;width: 300px;" /></td>
                   </tr>
                   <tr>
                   <td style="width: 25%;padding-bottom: 2%;font-weight: bold;"> Caption:</td>
                   <td style="padding-bottom: 2%;"> <input type="text" name="caption"  style="border: 1px solid #ccc;height: 23px;width: 300px;" /></td>
                  </tr>
                  <tr>
                  <td style="width: 25%;padding-bottom: 2%;font-weight: bold;"> Description:</td>
                   <td style="padding-bottom: 2%;"><input type="text" name="description"  style="border: 1px solid #ccc;height: 23px;width: 300px;" /></td>
                   </tr>
                  <tr>
                  <td></td>
                  <td> <input type="submit" name="OK" value="Post"/></td></tr>
                 
                   </table>
                     <%} %>
                   </form>
                 
                   </td>
                   </tr>
                   
           
        </table> 
        
  
</body>
</html>