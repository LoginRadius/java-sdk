<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="//hub.loginradius.com/include/js/LoginRadius.js"></script>
<script src="//cdn.loginradius.com/hub/prod/js/LoginRadiusRaaS.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/lr-raas.css">
<link rel="stylesheet" type="text/css" href="assets/css/customize.css">
<link rel="stylesheet" type="text/css" href="assets/css/custom-social.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css">


<script type="text/html" id="loginradiuscustom_tmpl">
        <# if(isLinked) { #>
            <li style="padding-bottom:0%">
                &nbsp;&nbsp;&nbsp;&nbsp; <#= Name #> is Linked
                <a style="cursor: pointer;" class="c<#= Name.toLowerCase() #> lrsociallogin" onclick='return unLinkAccount(\"<#= Name.toLowerCase() #>\",\"<#= providerId #>\")'> Unlink now</a>
            </li>
            <# } else {#>

                <li style="padding-bottom:0%">
                    &nbsp;&nbsp;&nbsp;&nbsp; <#= Name #> is Linked
                    <a style="cursor: pointer;" class="c<#= Name.toLowerCase() #> lrsociallogin" onclick="return $SL.util.openWindow('<#= Endpoint #>&callback=@Request.Url.ToString()');"> Link now</a>
                </li>

                <# } #>
</script>
<script type="text/javascript">
$SL.util.ready(function () {
    var raasoption = {};
    raasoption.apikey = "<%= application.getInitParameter("LoginRadiusApiKey") %>";
    raasoption.templatename = "loginradiuscustom_tmpl";
    raasoption.hashTemplate = true;
    LoginRadiusRaaS.CustomInterface(".interfacecontainerdiv", raasoption);
    raasoption.inFormvalidationMessage = true;    
	raasoption.V2Recaptcha = true;    
	initializeRaasForms(raasoption);
});

function initializeRaasForms(raasoption) {
	LoginRadiusRaaS.init(raasoption, 'sociallogin', function (response) {
		LoginRadiusSDK.getUserprofile(function (data) {
			console.log(data);
            window.location.href="<%= application.getInitParameter("BaseDomain") %>getProfile?userid="+data.ID;
        });		
	    }, function (errors) {
	    console.log(errors);    
		alert("some error occurred please try again");
	    }, "social-login-container");
	
	LoginRadiusRaaS.init(raasoption, 'accountlinking', function(response) {
		if (response.isPosted) {
			window.location.href=window.location;
		} else {
			var send_data = 'value=accountLink&mtoken='+response;
			var handle = function (data){

				var data = JSON.parse(data);
				if(data.status == 'success'){
					handleResponse(true, data.message);
				}
				else if(data.status == 'error'){
					handleResponse(true, data.message, true);
				}
				
			}
			var array = {};
			array['value'] = 'accountLink';
			array['mtoken'] = response;
			get_form_for_hidden_value(array);
			//handle_ajax_functionality(send_data, handle);
		}

	}, function(response) {
	}, "interfacecontainerdiv");
}
</script>

<script type="text/javascript">
function unLinkAccount(name,id) {
    handleResponse(true, "");
    if (confirm('Are you sure you want to unlink!')) {
        var array = {};
        array['value'] = 'accountUnLink';
        array['provider'] = name;
        array['providerId'] = id;
        get_form_for_hidden_value(array);
    }    
}

function get_form_for_hidden_value(array){
    var form = document.createElement('form');
    var key;
    form.action = "<%= application.getInitParameter("BaseDomain") %>";
    form.method = 'POST';
    for (key in array) {
        var hiddenToken = document.createElement('input');
        hiddenToken.type = 'hidden';
        hiddenToken.value = array[key];
        hiddenToken.name = key;
        form.appendChild(hiddenToken);
    }
    document.body.appendChild(form);
    form.submit();
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Account Providers</title>
</head>
<body>
<body>
	<div class="main-nav">
    <div class="container">

    </div>
</div>
<!-- Start Things -->
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
                    <a href="/JavaDemo">LoginRadius</a>
                </h1>

                <div class="site-description">User Registration HTML Demo</div>
            </div>
        </div>

        <!-- Fragment Caching -->
        <div class="secondary-menu" style="text-align: right;">
                   


<a style="margin-top: 2%;" href="/JavaDemo">Logout</a>


        </div>
    </div>
</nav>
<div class="lr-frame lr-input-style">

		<h1>Account linked with : </h1>
		<div style="text-align: left !important;   margin-left: 20%;  margin-top: 10px;">
		<div id="interfacecontainerdiv" class="interfacecontainerdiv"></div>
		
		</div>
	</div>
</div>
</body>
</html>