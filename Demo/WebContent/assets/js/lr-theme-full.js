/// <reference path="lr-theme-full.js" />
var raasoption = {};
if (lrThemeSettings.raasoption.apikey != null)
{ raasoption.apikey = lrThemeSettings.raasoption.apikey; }
else { raasoption.apikey = raasoption.apikey; }
raasoption.appname = lrThemeSettings.raasoption.appname;
raasoption.emailVerificationUrl = lrThemeSettings.raasoption.emailVerificationUrl;
raasoption.forgotPasswordUrl = lrThemeSettings.raasoption.forgotPasswordUrl;
if(navigator.userAgent.match("CriOS")){
	raasoption.templatename = "loginradiuscustom_tmpl_IOS";
} else {
	raasoption.templatename = "loginradiuscustom_tmpl";
}
raasoption.hashTemplate = true;
raasoption.V2Recaptcha = true;
raasoption.V2RecaptchaSiteKey = '6LdQVwwTAAAAAIxz5rbzNdwoEHDL-1pypzwXxAa_';
if (lrThemeSettings.auto_login_after_verify_email) {
	raasoption.enableLoginOnEmailVerification = true;
}else {
	raasoption.enableLoginOnEmailVerification = false;
}

LoginRadiusRaaS.$hooks.setProcessHook(function() {
	lrThemeSettings.form_render_submit_hook.start();
}, function() {
	lrThemeSettings.form_render_submit_hook.end();
});

LoginRadiusRaaS.CustomInterface(".interfacecontainerdiv", raasoption);

function redirect(socialtoken) {
    if (socialtoken.isPosted) {
        alert("The email is not verified, please verify the link in your email");
        window.location.href = window.location;
    } else {
        var form = document.createElement("form");
        form.method = "POST";
        form.action = "/profile.jsp";
        var token = document.createElement("input");
        token.type = "hidden";
        token.name = "token";
        token.value = socialtoken;
        form.appendChild(token);
        document.body.appendChild(form);
        form.submit();
    }
}

function redirectToLogin(response) {
    var form = document.createElement("form");
    form.method = "POST";
    form.action = "/profile.jsp";
    var userDetails = document.createElement("input");
    userDetails.name = "Access_token";
    userDetails.value = response.access_token;
    form.appendChild(userDetails);
    document.body.appendChild(form);
    form.submit();
}

var LrRaasTheme = {
	init: function(body) {
		this.createParent();
		this.appendOverlayDiv();
		this.createPopup("register");
		this.createPopup("login");
		this.createPopup("forgot");
		this.raasFormInject();
		this.appendFooter();
	},
	appendOverlayDiv: function() {
		var div = document.createElement("div");
		div.id = "lr-overlay";
		document.getElementById("lr-pop-group").appendChild(div);
	},
	createParent: function() {
		var group = document.createElement("div");
		group.id = "lr-pop-group";
		document.body.appendChild(group);
	},
	createPopup: function(action) {
		var div = document.createElement("div");
		var headerDiv;
	    var footerDiv;

		switch(action){
			case "register":
				div.id = "lr-register-container";
				div.className = "lr-popup-container";
				headerDiv = this.createHeader(window.lrThemeSettings.caption_message.register);

				break;

			case "login":
				div.id = "lr-login-container";
				div.className = "lr-popup-container";
				headerDiv = this.createHeader(window.lrThemeSettings.caption_message.login);
				
				break;

			case "forgot":
				div.id = "lr-fp-container";
				div.className = "lr-popup-container";
				headerDiv = this.createHeader(window.lrThemeSettings.caption_message.forgot_password);

				break;

			case "reset":
				div.id = "lr-rp-container";
				div.className = "lr-popup-container";
				headerDiv = this.createHeader(window.lrThemeSettings.caption_message.reset_password);

				break;

			case "social":
				div.id = "lr-social-container";
				div.className = "lr-popup-container";
				headerDiv = this.createHeader(window.lrThemeSettings.caption_message.fields_missing);

				break;

			default:
				break;
		}

		var bodyDiv = this.createBody(action);
		div.appendChild(headerDiv);
		div.appendChild(bodyDiv);

		document.getElementById("lr-pop-group").appendChild(div);
	},
	createHeader: function(message) {
		var div = document.createElement("div");
		div.className = "lr-popup-header";
		//the close btn
		var closeSpan = document.createElement("span");
		closeSpan.className = "lr-popup-close-span";
		closeSpan.innerHTML = '<a class="lr-popup-close-btn" onclick="LrRaasTheme.closeAllPopups()">&#215</a>';
		div.appendChild(closeSpan);
		//customizable logo section
		var logoDiv = document.createElement("div");
		logoDiv.className = "lr-header-logo";
		logoDiv.innerHTML = '<img src="'+window.lrThemeSettings.logo.logo_image_path+'" alt="Logo" class="lr-header-logo-img" />';
		logoDiv.innerHTML += '<p class="lr-header-caption">'+message+"</p>";
		div.appendChild(logoDiv);

		return div;
	},
	createBody: function(action){
		var div = document.createElement("div");
		div.id = "lr-popup-body-container";

		var messageHeader = document.createElement("div");
		messageHeader.id = "lr-"+action+"-popup-message";
		messageHeader.className = "lr-popup-message";

		div.appendChild(messageHeader);
	    var socialDiv;
	    var regDiv;
	    switch(action){
			case "register":
			    socialDiv = document.createElement("div");
			    socialDiv.className = "interfacecontainerdiv lr-sl-shaded-brick-frame lr-column";
			    regDiv = document.createElement("div");
			    regDiv.id = "register-div";
				regDiv.className = "lr-column";

				div.appendChild(socialDiv);
				div.appendChild(regDiv);

				break;
			case "login":
			    socialDiv = document.createElement("div");
			    socialDiv.className = "interfacecontainerdiv lr-sl-shaded-brick-frame lr-column";
			    regDiv = document.createElement("div");
			    regDiv.id = "login-div";
				regDiv.className = "lr-column";

				div.appendChild(socialDiv);
				div.appendChild(regDiv);

				break;

			case "forgot":
				var fpDiv = document.createElement("div");
				fpDiv.id = "forgotpassword-div";
				div.appendChild(fpDiv);

				break;

			case "reset":
				var rpDiv = document.createElement("div");
				rpDiv.id = "resetpassword-div";
				div.appendChild(rpDiv);

				break;

			case "social":
			    socialDiv = document.createElement("div");
			    socialDiv.id = "sociallogin-container";
				div.appendChild(socialDiv);
				break;

			default:
				break;
		}

		return div;
	},
	createFooter: function(action) {
		var div = document.createElement("div");
		div.id = "lr-popup-footer";
		div.className = "lr-popup-footer";
		switch(action){
			case "register":
				div.innerHTML = "<a class='lr-raas-theme-login'>Login</a>";
				break;
			case "login":
				div.innerHTML = "<a class='lr-raas-theme-fp'>Forgot Password</a> <a class='lr-raas-theme-register'>Register</a>";
				break;
			case "forgot":
				div.innerHTML = "<a class='lr-raas-theme-login'>Login</a>";
				break;
			default:
				break;
		}

		return div;
	},
	raasFormInject: function() {
		window.$SL.util.ready(function() {
		    window.LoginRadiusRaaS.init(raasoption, "registration", function (response) {

				var messageHeader = document.getElementById("lr-register-popup-message");
				messageHeader.innerHTML = window.lrThemeSettings.success_message.register;
				messageHeader.style.color = "Green";
				$('input[type="text"],input[type="password"], select').val('');
			}, function(errors) {
				var messageHeader = document.getElementById("lr-register-popup-message");
				messageHeader.innerHTML = errors[0].message;
				messageHeader.style.color = "Red";
			}, "register-div");

		    window.LoginRadiusRaaS.init(raasoption, "login", function (response) {
		        $('.se-pre-con').show();
		        if (response != null) {
		            redirectToLogin(response);
		        }
				var messageHeader = document.getElementById("lr-login-popup-message");
				messageHeader.innerHTML = window.lrThemeSettings.success_message.login;
				messageHeader.style.color = "Green";
				$('input[type="text"],input[type="password"], select').val('');
			}, function(errors) {
				var messageHeader = document.getElementById("lr-login-popup-message");
				messageHeader.innerHTML = errors[0].message;
				messageHeader.style.color = "Red";
			}, "login-div");

		    window.LoginRadiusRaaS.init(raasoption, "sociallogin", function (response) {
		        $('.se-pre-con').show();
		        if (response != null) {
		            redirect(response);
		        }

				var socialMessageHeader = document.getElementById("lr-social-popup-message");

				if(document.getElementById("loginradius-raas-social-registration-emailid")) {
					if(socialMessageHeader) {
					    socialMessageHeader.innerHTML = window.lrThemeSettings.success_message.register;
					    socialMessageHeader.style.color = "Green";
					}	
					
				} else {
					if(socialMessageHeader) {
					    socialMessageHeader.innerHTML = window.lrThemeSettings.success_message.social_login;
					    socialMessageHeader.style.color = "Green";
					}	
				
				}

			}, function (errors) {
				// console.log( errors );
			    var socialMessageHeader = document.getElementById("lr-register-popup-message");
			    socialMessageHeader.innerHTML = errors[0].message;
			    socialMessageHeader.style.color = "Red";
			    var socialMessageHeader = document.getElementById("lr-login-popup-message");
			    socialMessageHeader.innerHTML = errors[0].message;
			    socialMessageHeader.style.color = "Red";
			}, "sociallogin-container");

			window.LoginRadiusRaaS.$hooks.socialLogin.onFormRender = function() {
				LrRaasTheme.createPopup("social");
				LrRaasTheme.showPopup("lr-social-container");
			};

			window.LoginRadiusRaaS.init(raasoption, "forgotpassword", function(response) {
				var messageHeader = document.getElementById("lr-forgot-popup-message");
				messageHeader.innerHTML = window.lrThemeSettings.success_message.forgot_password;
				$('input[type="text"],input[type="password"], select').val('');
				messageHeader.style.color = "Green";
			}, function(errors) {
				var messageHeader = document.getElementById("lr-forgot-popup-message");
				messageHeader.innerHTML = errors[0].message;
				messageHeader.style.color = "Red";
			}, "forgotpassword-div");

			var params = LrRaasTheme.getUrlParameters();
			for ( var key in params ) {
		        if (params.hasOwnProperty(key)) {
		            if ("emailverification" === params[key]) {
		                window.LoginRadiusRaaS.init(raasoption, "emailverification", function(response) {
		                    console.log(response);
		                    var messageHeader;
		                    if (raasoption.enableLoginOnEmailVerification) {
		                        if (response.access_token != null && response.access_token !== "") {
		                            LrRaasTheme.showPopup("lr-login-container");
		                            messageHeader = document.getElementById("lr-login-popup-message");
		                            messageHeader.innerHTML = window.lrThemeSettings.success_message.login;
		                            window.lrThemeSettings.success_function.login();
		                        } else {
		                            LrRaasTheme.showPopup("lr-login-container");
		                            messageHeader = document.getElementById("lr-login-popup-message");
		                            messageHeader.innerHTML = window.lrThemeSettings.success_message.email_verified;
		                            messageHeader.style.color = "Green";
		                        }
		                    } else {
		                        LrRaasTheme.showPopup("lr-login-container");
		                        messageHeader = document.getElementById("lr-login-popup-message");
		                        messageHeader.innerHTML = window.lrThemeSettings.success_message.email_verified;
		                        messageHeader.style.color = "Green";
		                    }
		                }, function(errors) {

		                    LrRaasTheme.showPopup("lr-login-container");
		                    var messageHeader = document.getElementById("lr-login-popup-message");
		                    messageHeader.innerHTML = errors[0].message;
		                    messageHeader.style.color = "Red";
		                });
		            } else if ("reset" === params[key]) {
		                LrRaasTheme.createPopup("reset");
		                window.LoginRadiusRaaS.init(raasoption, "resetpassword", function(response) {
		                   
		                    $('input[type="password"], select').val('');
		                    LrRaasTheme.showPopup("lr-login-container");
		                    var messageHeader = document.getElementById("lr-login-popup-message");
		                    messageHeader.innerHTML = window.lrThemeSettings.success_message.reset_password;
		                    messageHeader.style.color = "Green";
		                }, function(errors) {
		                    var messageHeader = document.getElementById("lr-reset-popup-message");
		                    messageHeader.innerHTML = errors[0].message;
		                    messageHeader.style.color = "Red";
		                }, "resetpassword-div");
		                LrRaasTheme.showPopup("lr-rp-container");
		            } else {
		                return true;
		            }
		        }
		    }

		});
	},
	appendFooter: function() {
		var regForm = document.getElementsByName("loginradius-raas-registration");
		var loginForm = document.getElementsByName("loginradius-raas-login");			
		var forgotForm = document.getElementsByName("loginradius-raas-forgotpassword");

		var loginFormInterval = setInterval( function () {
			if ( document.readyState !== "complete" ) return;
			clearInterval( loginFormInterval );       
			//var registrationFooterDiv = LrRaasTheme.createFooter("register");
			//regForm[0].appendChild(registrationFooterDiv);

			var loginFooterDiv = LrRaasTheme.createFooter("login");
			loginForm[0].appendChild(loginFooterDiv);

			var forgotFooterDiv = LrRaasTheme.createFooter("forgot");
			forgotForm[0].appendChild(forgotFooterDiv);

			LrRaasTheme.addClassListener();
		}, 100 );
	},
	showPopup: function(popupId) {
		this.closeAllPopups();
		this.clearAllMessages();
		this.showOverlay();

		var pop = document.getElementById(popupId);
		pop.className = pop.className + " lr-show";
	},
	hideOverlay: function() {
		document.getElementById("lr-overlay").className = "";
		document.getElementById("lr-pop-group").className = "";
	},
	showOverlay: function() {
		document.getElementById("lr-overlay").className = "lr-show-layover";
		document.getElementById("lr-pop-group").className = "lr-show-layover";
	},
	resetAllPopups: function() {
		var formList = ["loginradius-raas-registration","loginradius-raas-login","loginradius-raas-forgotpassword"];
		for(var i = 0; i < formList.length; i ++ ) {
			var form = document.getElementsByName(formList[i]);
			form[0].reset();
		}
	},
	closeAllPopups: function() {
		if (window.lrThemeSettings.reset_form_after_close_popup ) {
		    var resetAllPopups = this.resetAllPopups;
		};
		this.hideOverlay();
		var popups = document.getElementsByClassName("lr-popup-container");
		for(var i=0; i < popups.length; i++){
			popups[i].className = "lr-popup-container";
		}
		$('input[type="text"],input[type="password"], select').val('');
	},
	clearAllMessages: function() {
		var messageHeaders = document.getElementsByClassName("lr-popup-message");
		for( var i = 0; i < messageHeaders.length; i++ )
		{
			messageHeaders[i].innerHTML = "";
		}
	},
	addClassListener: function() {
		document.getElementById("lr-overlay").addEventListener("click", function(){
			LrRaasTheme.closeAllPopups();
		});

		var closeBtnClass = document.getElementsByClassName("lr-popup-close-btn");
	    var i;
	    for( i = 0; i < closeBtnClass.length; i ++) {
			closeBtnClass[i].addEventListener("click", function(event){
				LrRaasTheme.closeAllPopups();
				return false;
			});
		}			

		var lrSignupClass = document.getElementsByClassName("lr-raas-theme-register");
		for( i = 0; i < lrSignupClass.length; i ++) {
			lrSignupClass[i].addEventListener("click", function(event){
				LrRaasTheme.showPopup("lr-register-container");
				return false;
			});
		}

		var lrLoginClass = document.getElementsByClassName("lr-raas-theme-login");
		for( i = 0; i < lrLoginClass.length; i ++) {
			lrLoginClass[i].addEventListener("click", function(event){
				LrRaasTheme.showPopup("lr-login-container");
				return false;
			});
		}

		var fpClass = document.getElementsByClassName("lr-raas-theme-fp");
		for( i = 0; i < fpClass.length; i ++) {
			fpClass[i].addEventListener("click", function(event){
				LrRaasTheme.showPopup("lr-fp-container");
				return false;
			});
		}
	},
	getUrlParameters: function() {
		var prmstr = window.location.search.substr(1);
		return prmstr != null && prmstr !== "" ? this.transformToAssocArray(prmstr) : {};
	},
	transformToAssocArray: function(prmstr) {
		var params = {};
		var prmArray = prmstr.split("&");
		for ( var i = 0; i < prmArray.length; i ++ ) {
			var tmpArray = prmArray[i].split("=");
			params[tmpArray[0]] = tmpArray[1];
		}

		return params;
	}
}
LrRaasTheme.init();
