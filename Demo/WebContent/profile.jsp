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
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Profile</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="assets/css/lr-raas.css" />
<link rel="stylesheet" type="text/css" href="assets/css/customize.css" />
<link rel="stylesheet" type="text/css" href="assets/css/custom-social.css" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />



</head>
<body>



	<div class="main-nav">
		<div class="container"></div>
	</div>
	<!-- Start Things -->
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
							<a href="/JavaDemoNew">LoginRadius</a>
						</h1>

						<div class="site-description">User Registration HTML Demo</div>
					</div>
				</div>

				<!-- Fragment Caching -->
				<div class="secondary-menu" style="text-align: right;">

					<a
						href="/JavaDemoNew/getProfile?raasId=<%=request.getAttribute("userId")%>">Accounts
						Info</a>
					<%
						if (request.getAttribute("RaasID") == null) {
					%>
					<a
						href="setPassword.jsp?userid=<%=request.getAttribute("userId")%>">Set
						Password</a>
					<%
						} else {
					%>
					/ <a
						href="resetPassword.jsp?userid=<%=request.getAttribute("RaasID")%>">Reset
						Password</a>
					<%
						}
					%>
					/ <a href="/JavaDemoNew">Logout</a>
				</div>
			</div>
		</nav>



		<div class="lr-profile-frame lr-input-style">

			<div class="lr-profile-header">

				<span class="lr-image-frame"> <img
					src="<%=request.getAttribute("imageurl")%>"></img>
				</span>

				<div class="lr-heading">
					Hello, <span class="lr-user-name"><%=request.getAttribute("firstName")%>
						<%=request.getAttribute("lastName")%></span>
				</div>

				<div class="lr-profile-info">

					<div class="lr-email-info">
						<span class="lr-value lr-em"><%=request.getAttribute("emailID")%></span>
					</div>

					<div class="lr-uid-info">
						<span class="lr-label">UID: </span> <span class="lr-value"><%=request.getAttribute("userId")%></span>
					</div>
				</div>

				<!-- Add Menu tab items -->
				<div class="lr-menu-buttons">
					<span class="lr-buttons lr-tab-active" data-tab="lr-profile">Profile</span>
					<span class="lr-buttons" data-tab="lr-account-prov">Account Providers</span> 
					<span class="lr-buttons" id="lr-password-tab" data-tab="lr-set-pw">Set Password</span>
					<span class="lr-buttons" data-tab="lr-social-login">Social Login APIs</span>
					<span class="lr-logout" onclick='login_radius_log_out();'>Logout</span>
				</div>
				
				
		<div id="lr-pop-group" class="lr-show-layover" style="display: none; position: fixed;">
        <div id="lr-overlay" class="lr-show-layover"></div>
        <div id="lr-register-container" class="lr-popup-container lr-show">
            <div class="lr-popup-header">
                <span class="lr-popup-close-span"><a class="lr-popup-close-btn" onclick="hide()">×</a></span><div class="lr-header-logo">
                    <img src="" alt="Logo" class="lr-header-logo-img">
                    <p id="header-content"class="lr-header-caption"></p>
                </div>
            </div>
            <div id="lr-popup-body-container" class="popup">
            </div>
        </div>
    	</div>
        <!-- Working till this part -->
        <!-- Popup Div Ends Here -->

        <div id="lr-profile" class="lr-frame lr-input-style lr-align-left lr-tab-active">
        <div class="lr-submenu-buttons">
            <span id="lr-tab-basic" class="lr-buttons lr-tab-active" data-tab="lr-basic">Basic Profile</span>
            <span id="lr-tab-extened" class="lr-buttons" data-tab="lr-extened">Extended Profile</span>
           		<%
           			String provider =  request.getAttribute("provider").toString();
						if (provider != "RAAS") {
							if(provider=="facebook" || provider=="twitter" || provider=="linkedin"){
							
						
				%>
				
				 <span id="lr-tab-post" class="lr-buttons" data-tab="lr-post">Post Status</span>
				<% }%>
				
		
                <span id="lr-tab-contact" class="lr-buttons" data-tab="lr-contact">Contacts</span>
                <span id="lr-tab-likes" class="lr-buttons" data-tab="lr-likes">Likes</span>
                <span id="lr-tab-albums" class="lr-buttons" data-tab="lr-albums">Albums</span>
                <span id="lr-tab-checkins" class="lr-buttons" data-tab="lr-checkins">Checkins</span>
                <span id="lr-tab-audio" class="lr-buttons" data-tab="lr-audio">Audio</span>
                <span id="lr-tab-mentions" class="lr-buttons" data-tab="lr-mentions">Mentions</span>
                <span id="lr-tab-following" class="lr-buttons" data-tab="lr-following">Following</span>
                <span id="lr-tab-events" class="lr-buttons" data-tab="lr-events">Events</span>
                <span id="lr-tab-posts" class="lr-buttons" data-tab="lr-posts">Posts</span>
                <span id="lr-tab-companies" class="lr-buttons" data-tab="lr-companies">Companies</span>
                <span id="lr-tab-groups" class="lr-buttons" data-tab="lr-groups">Groups</span>
                <span id="lr-tab-status" class="lr-buttons" data-tab="lr-status">Status</span>
                <span id="lr-tab-videos" class="lr-buttons" data-tab="lr-videos">Videos</span>
                <%} %>
            
        </div>
        </div>
        
        
        
        <div id="lr-basic" class="lr-frame lr-subframe lr-tab-active">
            <form action="" method="post" id="updateForm">
                <label class="lr-input-frame lr-inline">
                    <span class="lr-input-label">FirstName</span>
                    <input type="text" placeholder="FirstName" name="FirstName" value=<%= request.getAttribute("firstName") %>>
                </label>
                <label class="lr-input-frame lr-inline">
                    <span class="lr-input-label">LastName</span>
                    <input type="text" placeholder="LastName" name="LastName" value=<%= request.getAttribute("lastName") %>>
                </label>
                <label class="lr-input-frame lr-inline">
                    <span class="lr-input-label">BirthDate</span>
                    <input type="text" placeholder="BirthDate" id="BirthDate" name="BirthDate" class="loginradius-raas-birthdate hasDatepicker" value=<%= request.getAttribute("dateofbirth") %>>
                </label>
              <!--   <label class="lr-input-frame lr-inline">
                    <span class="lr-input-label">Country</span>
                    <input type="text" placeholder="Country" name="Country" value="@if (Model.Country != null)
                                                                                   {@Model.Country.Name
                                                                                   } ">
                </label>
                
                <label class="lr-input-frame lr-inline">
                    <span class="lr-input-label">City</span>
                    <input type="text" placeholder="City" name="City" value="@Model.City">
                </label> -->
                <div class="lr-submit-frame lr-align-right">
                    <input name="update" type="submit" value="Save" id="Save">
                </div>
                <span id="msg" style="color: Black;"></span>
            </form>
            <script type="text/javascript">
                $('#Save').click(function() {
                    var form = $("#updateForm");
                    var url = form.attr("action");
                    var formData = form.serialize();

                    $.post(url, formData, function(data) {
                        $("#msg").html(data);

                    });
                })
            </script>
        </div>
    
   		 <div id="lr-extened" class="lr-frame lr-subframe lr-extened lr-align-left"></div>
        <div id="lr-contact" class="lr-frame lr-subframe lr-contact lr-align-left"></div>
        <div id="lr-likes" class="lr-frame lr-subframe lr-likes lr-align-left"></div>
        <div id="lr-albums" class="lr-frame lr-subframe lr-albums lr-align-left"></div>
        <div id="lr-checkins" class="lr-frame lr-subframe lr-checkins lr-align-left"></div>
        <div id="lr-audio" class="lr-frame lr-subframe lr-audio lr-align-left"></div>
        <div id="lr-mentions" class="lr-frame lr-subframe lr-mentions lr-align-left"></div>
        <div id="lr-following" class="lr-frame lr-subframe lr-following lr-align-left"></div>
        <div id="lr-events" class="lr-frame lr-subframe lr-events lr-align-left"></div>
        <div id="lr-posts" class="lr-frame lr-subframe lr-posts lr-align-left"></div>
        <div id="lr-companies" class="lr-frame lr-subframe lr-companies lr-align-left"></div>
        <div id="lr-groups" class="lr-frame lr-subframe lr-groups lr-align-left"></div>
        <div id="lr-status" class="lr-frame lr-subframe lr-status lr-align-left"></div>
        <div id="lr-videos" class="lr-frame lr-subframe lr-videos lr-align-left"></div>
    
        </div>

</div>
<div id="lr-account-prov" class="lr-frame lr-account-prov lr-align-left">
    <div class="lr-login-buttons-frame lr-space-fix">

        <div class="interfacecontainerdiv" id="interfacecontainerdiv"></div>
        <div class="lr-linked-data lr-linked-frame"></div>
        <div style="clear: both"></div>
        <div class="lr-unlinked-data lr-not-linked-frame"></div>
        <div style="clear: both"></div>
    </div>
</div>
    
    
<!-- Add Set Password Container -->
<div id="lr-set-pw" class="lr-frame lr-set-pw lr-align-left">
    <div id="setpasswordbox"></div>
</div>
<!-- Add Change Password Container -->
<div id="lr-change-pw" class="lr-frame lr-change-pw lr-align-left">
    <div id="changepasswordbox"></div>

</div>
</div>
    
    <script>
    
	 function getTable(profile) {
            var data = '<table>';
            for (var key in profile) {
                data += '<tr><th>' + key + '</th>';
                var value = (profile[key] != null) ? profile[key] : '';
                if (typeof value == "object") {
                    data += '<td>' + createHorizontalTable(value) + '</td>';
                } else {
                    data += '<td>' + value + '</td>';
                }
                data += '</tr>';
            }
            data += '</table>';
            return data;
        }

        function createHorizontalTable(profile, count, table) {
            var data = '';
            if (typeof count == "undefined") {
                count = 0;
            }
            if (count == '0') {
                data += '<table><tr>';
                for (var key in profile) {
                    var value = (profile[key] != null) ? profile[key] : '';
                    if ((key == '0' || key == '1' || key == '2' || key == '3' || key == '4' || key == '5' || key == '6' || key == '7') && (typeof value == "object")) {
                        data = '';
                        return createHorizontalTable(value);
                    }
                    data += '<td>' + key + '</td>';
                }
                data += '</tr>';
            }
            data += '<tr>';
            for (var key in profile) {
                var value = (profile[key] != null) ? profile[key] : '';
                if (typeof value == "object") {
                    data += '<td>' + createHorizontalTable(value) + '</td>';
                } else {
                    data += '<td>' + value + '</td>';
                }
            }
            if (table == "albums") {
                data += '<td> <span onclick="viewphoto(&quot;' + profile["ID"] + '&quot;);"><b>View</b></span> </td>';
            }
            if (table == "contact") {
                data += '<td> <span onclick="SendMessage(&quot;' + profile["ID"] + '&quot;,&quot;' + profile["Name"] + '&quot;,&quot;@Model.Provider&quot;);"><b>Send</b></span> </td>';
            }
            data += '</tr>';
            if (count == '0') {
                data += '</table>';
            }
            return data;
        }
   
	</script>

<script src="//hub.loginradius.com/include/js/LoginRadius.js"></script>

<script src="//cdn.loginradius.com/hub/prod/js/LoginRadiusRaaS.js"></script>

<script>
    $(document).ready(function() {
        $('.lr-menu-buttons .lr-buttons').click(function() {
            var dataTab = $(this).attr("data-tab");
            $('.lr-menu-buttons .lr-buttons').removeClass('lr-tab-active');
            $('.lr-frame').removeClass('lr-tab-active');

            if (dataTab === 'lr-profile') {
                $('.lr-submenu-buttons .lr-buttons').removeClass('lr-tab-active');
                $("#lr-basic, #lr-tab-basic").addClass('lr-tab-active');
                //$("#lr-profile, #lr-tab-basic").addClass('lr-tab-active');
            }
            $(this).addClass('lr-tab-active');
            $("#" + dataTab).addClass('lr-tab-active');
        });
        $('.lr-submenu-buttons .lr-buttons').click(function() {
            var dataTab = $(this).attr("data-tab");
            $('.lr-submenu-buttons .lr-buttons').removeClass('lr-tab-active');
            $('.lr-frame .lr-subframe').removeClass('lr-tab-active');

            $(this).addClass('lr-tab-active');
            $("#" + dataTab).addClass('lr-tab-active');
        });
        // this makes the first element with that class visible.. if you don't want this.. add that class manually
        //$('.lr-menu-buttons .lr-buttons:eq(0)').addClass('lr-tab-active');
        //$('.lr-profile-frame .lr-frame:eq(0)').addClass('lr-tab-active');
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        window.LoginRadiusRaaS.$hooks.setProcessHook(function() {
            //console.log("start process", '');
            $('#fade').show();
        }, function() {
            //console.log("end process", '');
            $('#fade').hide();
        });
        var raasoption = {};

        raasoption.apikey = "<%= application.getInitParameter("LoginRadiusApiKey") %>";
        raasoption.templatename = "loginradiuscustom_tmpl";
        raasoption.hashTemplate = true;
        raasoption.inFormvalidationMessage = true;
        window.LoginRadiusRaaS.CustomInterface(".interfacecontainerdiv", raasoption);
        window.LoginRadiusRaaS.init(raasoption, 'accountlinking', function(response) {
            if (response.isPosted) {
                window.location.href = window.location;
            } else {
                var handle = function(data) {
                    data = JSON.parse(data);
                    if (data.status === 'success') {
                        window.handleResponse(true, data.message);
                    } else if (data.status === 'error') {
                        window.handleResponse(true, data.message, true);
                    }
                    $('#fade').hide();
                };
                var form = document.createElement("form");
                form.method = "POST";
                form.action = "/Home/Welcome";
                var accounttoken = document.createElement("input");
                accounttoken.type = "hidden";
                accounttoken.name = "accounttoken";
                accounttoken.value = response;
                console.log(response);

                form.appendChild(accounttoken);
                document.body.appendChild(form);
                form.submit();
            }

        }, function(response) {
        }, "interfacecontainerdiv");

        window.LoginRadiusRaaS.passwordHandleForms("setpasswordbox", "changepasswordbox", function(israas) {
            if (israas) {
                $('#lr-password-tab').attr("data-tab", "lr-change-pw");
                $('#lr-password-tab').html("Change Password");
                $("#changepasswordbox").show();
            } else {
                $('#lr-password-tab').attr("data-tab", "lr-set-pw");
                $('#lr-password-tab').attr("Set Password");
                $("#setpasswordbox").show();
            }
        }, function() {
            document.forms['setpassword'].action = "/profile.jsp";
            document.forms['setpassword'].submit();
        }, function(errors) {
            //var messageHeader = document.getElementById('lr-setpasswordbox-popup-message');
            //messageHeader.innerHTML = errors[0].message;
            //messageHeader.style.color = "Red";
        }, function() {
            document.forms['changepassword'].action = '/profile.jsp';
            document.forms['changepassword'].submit();
        }, function(errors) {
            //var messageHeader = document.getElementById('lr-changepasswordbox-popup-message');
            //messageHeader.innerHTML = errors[0].message;
            //messageHeader.style.color = "Red";
        });
    });

</script>
<script type="text/javascript">
   /*  function viewphoto(id) {
        document.getElementById("header-content").innerHTML = 'Album Photos';
        document.getElementById('lr-pop-group').style.display = "block";
        $('.popup').append('<img id="img_load" src="../../assets/images/waiting.gif" />');

        $.ajax({
            url: '@Url.Action("PhotoData", "Home")',
            type: "POST",
            data: "AlbumID=" + id,
            success: function(data) {
                for (var key in data) {
                    if (data.hasOwnProperty(key)) {
                        $('.popup').append('<div class="popupimg"> <img src="' + data[key].ImageUrl + '" width="300" height="200">  <div class="desc"><b>Description:</b>' + data[key].Description + '<br/><b>Name:</b>' + data[key].Name + '</div></div>');
                    }
                }
                document.getElementById('img_load').style.display = "none";
            }
        });
        return false;
    } */

    function SendMessage(id, name, provider) {
        if (provider == "linkedIn" || provider == "twitter") {
            document.getElementById("header-content").innerHTML = 'Send A Direct Message to ' + name;
            document.getElementById('lr-pop-group').style.display = "block";
            document.getElementById("lr-popup-body-container").innerHTML = '<div id="lr-message" class="lr-frame lr-subframe"> <form name="directmessage" id="directMessageForm" onsubmit="return validateMessageForm()"><input type="text" placeholder="To" name="To" value="' + id + '" hidden=""> <label class="lr-input-frame lr-inline"> <span class="lr-input-label">Subject</span><input type="text" placeholder="Subject" name="Subject"> </label> <label class="lr-input-frame lr-inline"> <span class="lr-input-label">Message</span> <input type="text" placeholder="Message" name="Message"> </label> <span id="responseMessage" style="color: black"></span><div class="lr-submit-frame lr-align-right"><input type="submit" value="Send" id="postMessage"><div id="divMsg" style="display:none;"> <img src="/assets/images/ajax-loader.gif" alt="Please wait.." /></div></div></form></div>';
            document.getElementById('lr-message').style.display = "block";
            return false;
        } else {
            alert("This endpoint/feature is not supported by the current provider");
           }
        return false;
    }
    function hide() {
        document.getElementById('lr-pop-group').style.display = "none";
        $('.popup').html("");
    }

</script>

<!-- <script type="text/javascript">
    function validateForm() {
        var x = document.forms["poststatus"]["Status"].value;
        if (x == null || x == "") {
            $("#message").html("Status must be filled out");
            document.getElementById('message').style.color = 'Red';
            
        } else {
            $.ajax({
                url: '@Url.Action("PostStatus", "Home")',
                type: "POST",
                data: $("#StatusForm").serialize(),
                success: function(data) {
                    if (data == "True") {
                        $("#message").html("Status has been posted !");
                        document.getElementById('message').style.color = 'Green';
                    } else {
                        $("#message").html(data);
                        document.getElementById('message').style.color = 'Red';
                    }
                    $('input[type="text"], select').val('');
                }
            });
        }
        return false;
    }
    function validateMessageForm() {
        var x = document.forms["directmessage"]["Subject"].value;
        var y = document.forms["directmessage"]["Message"].value;
        if (x == "" || y == "" || x == null || y == null) {
            $("#responseMessage").html("Fields must be filled out");
            document.getElementById("responseMessage").style.color = "Red";
            return false;
        } else {
            $('#postMessage').attr('disabled', 'disabled');
            $('#divMsg').show();
            $.ajax({
                url: '@Url.Action("DirectMessage", "Home")',
                type: "POST",
                data: $("#directMessageForm").serialize(),
                success: function (data) {
                    if (data == "True") {
                        $("#responseMessage").html("Message Sent !");
                        document.getElementById('responseMessage').style.color = 'Green';
                    } else {
                        $("#responseMessage").html(data);
                        document.getElementById('responseMessage').style.color = 'Red';
                    }
                    $('#postMessage').removeAttr('disabled');
                    $('#divMsg').hide();
                    $('input[type="text"], select').val('');
                }
            });
        }
        return false;
    }
 -->
</script>

    <script>
        function unLinkAccount(name, providerId) {
            var form = document.createElement("form");
            form.method = "POST";
            form.action = "/Home/Welcome";
            var accountunlinkname = document.createElement("input");
            var accountunlinkid = document.createElement("input");
            accountunlinkname.name = "accountunlinkname";
            accountunlinkid.name = "accountunlinkid";
            accountunlinkid.value = providerId;
            accountunlinkname.value = name;
            form.appendChild(accountunlinkid);
            form.appendChild(accountunlinkname);
            document.body.appendChild(form);
            form.submit();
        }
    </script>
	
	
	
	
	
	

</body>
</html>