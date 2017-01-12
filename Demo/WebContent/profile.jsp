
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.loginradius.sdk.social.models.page.LoginRadiusPage"%>
<%@page import="com.loginradius.sdk.social.models.mention.LoginRadiusMention"%>
<%@page import="com.loginradius.sdk.social.models.post.LoginRadiusPost"%>
<%@page import="com.loginradius.sdk.social.models.following.LoginRadiusFollowing"%>
<%@page import="com.loginradius.sdk.social.models.album.LoginRadiusAlbum"%>
<%@page import="com.loginradius.sdk.social.models.status.LoginRadiusStatus"%>
<%@page import="com.loginradius.sdk.social.models.like.LoginRadiusLike"%>
<%@page import="com.loginradius.sdk.social.models.photo.LoginRadiusPhoto"%>
<%@page import="com.loginradius.sdk.social.models.group.LoginRadiusGroup"%>
<%@page import="com.loginradius.sdk.social.models.event.LoginRadiusEvent"%>
<%@page import="com.loginradius.sdk.social.models.company.LoginRadiusCompany"%>
<%@page import="com.loginradius.sdk.social.models.LoginRadiusContactCursorResponse"%>
<%@page import="com.loginradius.sdk.social.models.userprofile.LoginRadiusUltimateUserProfile"%>
<%@page import="com.loginradius.sdk.social.api.LoginRadiusAPI"%>
<%@page import="com.loginradius.sdk.social.api.LoginRadiusGetAPI"%>
<%@page import="com.loginradius.sdk.social.core.LoginRadiusClient"%>
<%@page import="com.loginradius.sdk.social.models.AccessToken"%>
<%@page import="com.loginradius.sdk.social.core.LoginRadiusCallbackHelper"%>
<%@page import="com.loginradius.sdk.social.core.LoginRadiusException"%>
<%@page import="java.util.List"%>

<%@page import="java.util.Iterator"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Profile</title>
<link rel="stylesheet" type="text/css" href="assets/css/lr-raas.css">
<link rel="stylesheet" type="text/css" href="assets/css/customize.css">
<link rel="stylesheet" type="text/css" href="assets/css/custom-social.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">

<%



LoginRadiusUltimateUserProfile profile = (LoginRadiusUltimateUserProfile)request.getAttribute("userProfile");
System.out.println("profile -- " + profile);

//LoginRadiusMention[] mentions = (LoginRadiusMention[])request.getAttribute("mentions");
LoginRadiusContactCursorResponse contacts = (LoginRadiusContactCursorResponse)request.getAttribute("contactCursor");

LoginRadiusCompany[] companies = (LoginRadiusCompany[])request.getAttribute("companies");
LoginRadiusEvent[] events =  (LoginRadiusEvent[])request.getAttribute("events");
LoginRadiusGroup[] groups = (LoginRadiusGroup[])request.getAttribute("groups");
LoginRadiusLike[] likes = (LoginRadiusLike[])request.getAttribute("likes");


%>


<!-- Start Things -->
	<table align="center" style=" width:50%; border:1px solid #ccc; box-shadow: 0px 0px 11px 0px #ccc;">	
	  <tr>
		        <td>
		       <table>
		       
		       
		        <tr>
		        
		          <td style="padding: 10px;border: none;width: 25%;"><img src="<%=profile.ImageUrl%>" alt="Avatar" style="width:140px;height:140px;"></td>
		          
		          <td style="border:none;vertical-align: top;padding-top: 7px;">
		             <table border="0" width="100%">
		              <tr><td><%out.println(profile.ID);%></td></tr>
		              <tr><td><%out.println(profile.FullName);%></td></tr> 
		              <tr><td><%out.println(profile.Gender);%></td></tr>
		              <tr><td><%out.println(profile.BirthDate);%></td></tr>
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
               <td style="padding-bottom: 2%;"><% out.println(profile.FirstName);%></td></tr>
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Middle Name : </td>
               <td style="padding-bottom: 2%;"><% out.println(profile.MiddleName);%></td></tr>
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Last Name :</td>
               <td style="padding-bottom: 2%;"><% out.println(profile.LastName);%></td></tr>
               <tr><td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Local Country : </td>
              <td style="padding-bottom: 2%;"> <% out.println(profile.LocalCountry);  %> </tr>
                <tr>
                 <td style="width: 25%;padding-bottom: 2%;font-weight: bold;">Email:</td>
                  <td style="padding-bottom: 2%;">
                   <table width="100%">
                   <%
                     for (int i = 0; i < profile.Email.size(); i++) 
                     {
                     %>
                     <tr>
                       <%out.println(profile.Email.get(i).Value); %>
                     </tr>
                     <%} %>
                   </table>
                 </td>
                 </tr>
                 
                 
                <tr>
                  <%
                  
                  
                 
                   if(contacts!=null)
                   {
                	   System.out.println("contacts.Data.size()" + contacts.Data.size());
                	   for(int i=0;i<contacts.Data.size();i++)
                		   out.println("Contact Name : " + contacts.Data.get(i).name+"<br/>");
                   }
                   
                  
                   if(companies!=null && companies.length>0)
                   {
                	   for(int i=0;i<companies.length;i++)
                		   out.println("Company Name : "+companies[i].name+"<br/>");
                   }
                 
                 
                   if(events!=null && events.length>0)
                   {
                	   for(int i=0;i<events.length;i++)
                		   out.println("Event Name : "+events[i].name+"<br/>");
                   }
                   
                  
                   if(groups!=null&& groups.length>0)
                   {
                	   for(int i=0;i<groups.length;i++)
                		   out.println("Group Name : "+groups[i].name+"<br/>");
                   } 
                   
                  
                   if(likes!=null && likes.length>0)
                   {
                	   for(int i=0;i<likes.length;i++)
                		   out.println("Like Description : "+likes[i].Description+"<br/>");
                   }
                   /* 
                    LoginRadiusAPI status=new LoginRadiusGetAPI("status");
                   LoginRadiusStatus[] st=client.getResponse(status,LoginRadiusStatus[].class);
                   if(st.length>0)
                   {
                	   for(int i=0;i<5;i++)
                		   out.println("Status Text : "+st[i].text+"<br/>");
                   }
                   
                   
                   
                   LoginRadiusAPI posts=new LoginRadiusGetAPI("post");
                   
                   LoginRadiusPost[] userPosts = client.getResponse(posts,LoginRadiusPost[].class);
                   
                   if(userPosts.length>0)
                   {
                	   for(int k=0;k<userPosts.length;k++){
                		  
                		  
                		   
                		   out.println(" Likes : "+userPosts[k].likes+"<br/>");
                		   out.println(" Message: "+userPosts[k].message+"<br/>");
                		   out.println("post name : "+userPosts[k].name+"<br/>");
                	   }
                   }
                   //System.out.println("userfollowing.length -- " + userfollowing.length); 
                   
                   
                   LoginRadiusAPI album=new LoginRadiusGetAPI("album");
                   LoginRadiusAlbum[] alb=client.getResponse(album,LoginRadiusAlbum[].class);
                   
                 
                   //LoginRadiusPhoto photo
                   
                   Map<String, String> params = new HashMap<String,String>();
                  
                   
                   if(alb.length>0)
                   {
                	   for(int i=0;i<alb.length;i++){
                		out.println("Album ID : "+alb[i].ID+"<br/>");
                	   params.put("albumid", alb[i].ID);
                	   LoginRadiusAPI photos =new LoginRadiusGetAPI("photo", params);
                	   
                	   LoginRadiusPhoto[] userphotos=client.getResponse(photos,LoginRadiusPhoto[].class);
                	   
                	   if(userphotos.length>0)
                       {
                    	   for(int k=0;k<userphotos.length;k++){
                    		  
                    		  
                    		   
                    		   out.println(" id : "+userphotos[k].ID+"<br/>");
                    		   out.println(" link : "+userphotos[k].Link+"<br/>");
                    		   out.println("Owner name : "+userphotos[k].OwnerName+"<br/>");
                    	   }
                       }
                	   
                	   params.clear();
                	   
                	   
                	   }
                	 	   
                   }
                   
                   
                 
                   
                   LoginRadiusAPI video=new LoginRadiusGetAPI("video");
                   LoginRadiusLike[] videos=client.getResponse(video,LoginRadiusLike[].class);
                   System.out.println("videos.length -- " + videos.length);                   
                   if(videos.length>0)
                   {
                	   for(int i=0;i<videos.length;i++)
                		   out.println("Video Description : "+videos[i].Description+"<br/>");
                   }
                  
                   
                   LoginRadiusAPI audio=new LoginRadiusGetAPI("audio");
                   
                   LoginRadiusLike[] audios=client.getResponse(video,LoginRadiusLike[].class);
                   
                   System.out.println("audios.length -- " + audios.length); 
                   if(audios.length>0)
                   {
                	   for(int i=0;i<audios.length;i++)
                		   out.println("Audio Description : "+audios[i].Description+"<br/>");
                   } 
                  
                  
                   
                    */
                 
                   
                  %>
                </tr>
                 
                 </table>
		           
		           
		           
		           
		           
		           
		            </tr>
		          

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

                <div class="site-description">User Registration HTML Demo</div>
            </div>
        </div>

        <!-- Fragment Caching -->
        <div class="secondary-menu" style="text-align: right;" >
            


<%if(request.getAttribute("RaasID")==null) {%>
<a href="setPassword.jsp?userid=<%=request.getAttribute("userId")%>">Set Password</a>
<% }else { %> /
<a href="resetPassword.jsp?userid=<%=request.getAttribute("RaasID")%>">Reset Password</a>
<%} %> /
<a href="/JavaDemoNew">Logout</a>
        </div>
    </div>
</nav>






		      
		





</div>
</div>
</div>
</table> 
</body>
</html>