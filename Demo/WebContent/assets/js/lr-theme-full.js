var raasoption = {};
raasoption.apikey = lrThemeSettings.raasoption.apikey;
raasoption.appname = lrThemeSettings.raasoption.appname;
raasoption.emailVerificationUrl = lrThemeSettings.raasoption.emailVerificationUrl;
raasoption.forgotPasswordUrl = lrThemeSettings.raasoption.forgotPasswordUrl;


if(navigator.userAgent.match('CriOS')){
	raasoption.templatename = "loginradiuscustom_tmpl_IOS";
} else {
	raasoption.templatename = "loginradiuscustom_tmpl";
}
raasoption.hashTemplate = true;
raasoption.V2Recaptcha = true;

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


var LrRaasTheme = {
	init: function(body) {
		this.createParent();
		this.appendOverlayDiv();
		this.createPopup('register');
		this.createPopup('login');
		this.createPopup('forgot');
		this.raasFormInject();
		this.appendFooter();
	},
	appendOverlayDiv: function() {
		var div = document.createElement('div');
		div.id = 'lr-overlay';
		document.getElementById('lr-pop-group').appendChild(div);
	},
	createParent: function() {
		var group = document.createElement('div');
		group.id = 'lr-pop-group';
		document.body.appendChild(group);
	},
	createPopup: function(action) {
		var div = document.createElement('div');
		var header_div;
		var body_div;
		var footer_div;

		switch(action){
			case 'register':
				div.id = 'lr-register-container';
				div.className = 'lr-popup-container';
				header_div = this.createHeader(lrThemeSettings.caption_message.register);

				break;

			case 'login':
				div.id = 'lr-login-container';
				div.className = 'lr-popup-container';
				header_div = this.createHeader(lrThemeSettings.caption_message.login);
				
				break;

			case 'forgot':
				div.id = 'lr-fp-container';
				div.className = 'lr-popup-container';
				header_div = this.createHeader(lrThemeSettings.caption_message.forgot_password);

				break;

			case 'reset':
				div.id = 'lr-rp-container';
				div.className = 'lr-popup-container';
				header_div = this.createHeader(lrThemeSettings.caption_message.reset_password);

				break;

			case 'social':
				div.id = 'lr-social-container';
				div.className = 'lr-popup-container';
				header_div = this.createHeader(lrThemeSettings.caption_message.fields_missing);

				break;

			default:
				break;
		}

		body_div = this.createBody(action);
		div.appendChild(header_div);
		div.appendChild(body_div);

		document.getElementById('lr-pop-group').appendChild(div);
	},
	createHeader: function(message) {
		var div = document.createElement('div');
		div.className = 'lr-popup-header';
		//the close btn
		var closeSpan = document.createElement('span');
		closeSpan.className = 'lr-popup-close-span';
		closeSpan.innerHTML = '<a class="lr-popup-close-btn" onclick="LrRaasTheme.closeAllPopups()">&#215</a>';
		div.appendChild(closeSpan);
		//customizable logo section
		var logo_div = document.createElement('div');
		logo_div.className = 'lr-header-logo';
		logo_div.innerHTML = '<img src="'+lrThemeSettings.logo.logo_image_path+'" alt="Logo" class="lr-header-logo-img" />';
		logo_div.innerHTML += '<p class="lr-header-caption">'+message+'</p>';
		div.appendChild(logo_div);

		return div;
	},
	createBody: function(action){
		var div = document.createElement('div');
		div.id = 'lr-popup-body-container';

		var message_header = document.createElement('div');
		message_header.id = 'lr-'+action+'-popup-message';
		message_header.className = 'lr-popup-message';

		div.appendChild(message_header);

		switch(action){
			case 'register':
				var social_div = document.createElement('div');
				social_div.className = 'interfacecontainerdiv lr-sl-shaded-brick-frame lr-column';
				var reg_div = document.createElement('div');
				reg_div.id = 'register-div';
				reg_div.className = 'lr-column';

				div.appendChild(social_div);
				div.appendChild(reg_div);

				break;
			case 'login':
				var social_div = document.createElement('div');
				social_div.className = 'interfacecontainerdiv lr-sl-shaded-brick-frame lr-column';
				var reg_div = document.createElement('div');
				reg_div.id = 'login-div';
				reg_div.className = 'lr-column';

				div.appendChild(social_div);
				div.appendChild(reg_div);

				break;

			case 'forgot':
				var fp_div = document.createElement('div');
				fp_div.id = 'forgotpassword-div';
				div.appendChild(fp_div);

				break;

			case 'reset':
				var rp_div = document.createElement('div');
				rp_div.id = 'resetpassword-div';
				div.appendChild(rp_div);

				break;

			case 'social':
				var social_div = document.createElement('div');
				social_div.id = 'sociallogin-container';
				div.appendChild(social_div);
				break;

			default:
				break;
		}

		return div;
	},
	createFooter: function(action) {
		var div = document.createElement('div');
		div.id = 'lr-popup-footer';
		div.className = 'lr-popup-footer';
		switch(action){
			case 'register':
				div.innerHTML = "<a class='lr-raas-theme-login'>Login</a>";
				break;
			case 'login':
				div.innerHTML = "<a class='lr-raas-theme-fp'>Forgot Password</a> <a class='lr-raas-theme-register'>Register</a>";
				break;
			case 'forgot':
				div.innerHTML = "<a class='lr-raas-theme-login'>Login</a>";
				break;
			default:
				break;
		}

		return div;
	},
	raasFormInject: function() {
		$SL.util.ready(function() {
			LoginRadiusRaaS.init(raasoption, 'registration', function(response) {
				// console.log( response );
				var message_header = document.getElementById('lr-register-popup-message');
				message_header.innerHTML = lrThemeSettings.success_message.register;
				lrThemeSettings.success_function.register();
			}, function(errors) {
				var message_header = document.getElementById('lr-register-popup-message');
				message_header.innerHTML = errors[0].message;
			}, "register-div");

			LoginRadiusRaaS.init(raasoption, 'login', function(response) {
				var message_header = document.getElementById('lr-login-popup-message');
				message_header.innerHTML = lrThemeSettings.success_message.login;
				lrThemeSettings.success_function.login();
			}, function(errors) {
				var message_header = document.getElementById('lr-login-popup-message');
				message_header.innerHTML = errors[0].message;
			}, "login-div");

			LoginRadiusRaaS.init(raasoption, 'sociallogin', function (response) {

				var social_message_header = document.getElementById('lr-social-popup-message');

				if(document.getElementById('loginradius-raas-social-registration-emailid')) {
					if(social_message_header) {
						social_message_header.innerHTML = lrThemeSettings.success_message.register;
					}	
					lrThemeSettings.success_function.social_login(response);
				} else {
					if(social_message_header) {
						social_message_header.innerHTML = lrThemeSettings.success_message.social_login;
					}	
					lrThemeSettings.success_function.social_login(response);
				}

			}, function (errors) {

				var social_message_header = document.getElementById('lr-social-popup-message');
				if(social_message_header) {
					social_message_header.innerHTML = errors[0].message;
				} else {
					var popup_message = document.getElementsByClassName('lr-popup-message');
					for(var i = 0; i < popup_message.length; i++) {
						popup_message[i].innerHTML = errors[0].message;
					}
				}
				

			}, "sociallogin-container");

			LoginRadiusRaaS.$hooks.socialLogin.onFormRender = function() {
				LrRaasTheme.createPopup('social');
				LrRaasTheme.showPopup('lr-social-container');
			};

			LoginRadiusRaaS.init(raasoption, 'forgotpassword', function(response) {
				var message_header = document.getElementById('lr-forgot-popup-message');
				message_header.innerHTML = lrThemeSettings.success_message.forgot_password;
				lrThemeSettings.success_function.forgot_password();
			}, function(errors) {
				var message_header = document.getElementById('lr-forgot-popup-message');
				message_header.innerHTML = errors[0].message;
			}, "forgotpassword-div");

			var params = LrRaasTheme.getUrlParameters();
			for ( var key in params ) {
				if( 'emailverification' == params[key] ) {
					LoginRadiusRaaS.init(raasoption, 'emailverification', function(response){
						if(raasoption.enableLoginOnEmailVerification) {
							if (response.access_token != null && response.access_token != "") {
								LrRaasTheme.showPopup('lr-login-container');
								var message_header = document.getElementById('lr-login-popup-message');
								message_header.innerHTML = lrThemeSettings.success_message.login;
								lrThemeSettings.success_function.login();
							} else {
								LrRaasTheme.showPopup('lr-login-container');
								var message_header = document.getElementById('lr-login-popup-message');
								message_header.innerHTML = lrThemeSettings.success_message.email_verified;
							}
						} else {
							LrRaasTheme.showPopup('lr-login-container');
							var message_header = document.getElementById('lr-login-popup-message');
							message_header.innerHTML = lrThemeSettings.success_message.email_verified;
						}
					}, function(errors){	

						LrRaasTheme.showPopup('lr-login-container');
						var message_header = document.getElementById('lr-login-popup-message');
						message_header.innerHTML = errors[0].message;
					});
				} else if( 'reset' == params[key] ){
					LrRaasTheme.createPopup('reset');
					LoginRadiusRaaS.init(raasoption, 'resetpassword', function(response) {
						var message_header = document.getElementById('lr-reset-popup-message');
						message_header.innerHTML = lrThemeSettings.success_message.reset_password;
						lrThemeSettings.success_function.reset_password();
					}, function(errors) {
						var message_header = document.getElementById('lr-reset-popup-message');
						message_header.innerHTML = errors[0].message;
					}, "resetpassword-div");

					LrRaasTheme.showPopup('lr-rp-container');
				} else{
					return true;
				}
			}
			

		});
	},
	appendFooter: function() {
		var reg_form = document.getElementsByName('loginradius-raas-registration');
		var login_form = document.getElementsByName('loginradius-raas-login');			
		var forgot_form = document.getElementsByName('loginradius-raas-forgotpassword');

		var login_form_interval = setInterval(function () {
			if (document.readyState !== 'complete' ) {
				return;
			}

			if(reg_form.length==0) {
				reg_form = document.getElementsByName('loginradius-raas-registration');	
				return;
			}
			clearInterval(login_form_interval);       
			var registration_footer_div = LrRaasTheme.createFooter('register');
			reg_form[0].appendChild(registration_footer_div);

			var login_footer_div = LrRaasTheme.createFooter('login');
			login_form[0].appendChild(login_footer_div);

			var forgot_footer_div = LrRaasTheme.createFooter('forgot');
			forgot_form[0].appendChild(forgot_footer_div);

			LrRaasTheme.addClassListener();
		}, 100 );
	},
	showPopup: function(popup_id) {
		this.closeAllPopups();
		this.clearAllMessages();
		this.showOverlay();

		var pop = document.getElementById(popup_id);
		pop.className = pop.className + " lr-show";
	},
	hideOverlay: function() {
		document.getElementById('lr-overlay').className = '';
		document.getElementById('lr-pop-group').className = '';
	},
	showOverlay: function() {
		document.getElementById('lr-overlay').className = 'lr-show-layover';
		document.getElementById('lr-pop-group').className = 'lr-show-layover';
	},
	resetAllPopups: function() {
		var form_list = ['loginradius-raas-registration','loginradius-raas-login','loginradius-raas-forgotpassword'];
		for(var i = 0; i < form_list.length; i ++ ) {
			var form = document.getElementsByName(form_list[i]);
			form[0].reset();
		}
	},
	closeAllPopups: function() {
		if (lrThemeSettings.reset_form_after_close_popup ) {
			this.resetAllPopups;
		};
		this.hideOverlay();
		var popups = document.getElementsByClassName("lr-popup-container");
		for(var i=0; i < popups.length; i++){
			popups[i].className = "lr-popup-container";
		}
	},
	clearAllMessages: function() {
		var message_headers = document.getElementsByClassName('lr-popup-message');
		for( var i = 0; i < message_headers.length; i++ )
		{
			message_headers[i].innerHTML = "";
		}
	},
	addClassListener: function() {
		document.getElementById('lr-overlay').addEventListener("click", function(){
			LrRaasTheme.closeAllPopups();
		});

		var closeBtnClass = document.getElementsByClassName("lr-popup-close-btn");
		for( var i = 0; i < closeBtnClass.length; i ++) {
			closeBtnClass[i].addEventListener("click", function(event){
				LrRaasTheme.closeAllPopups();
				return false;
			});
		}			

		var lrSignupClass = document.getElementsByClassName("lr-raas-theme-register");
		for( var i = 0; i < lrSignupClass.length; i ++) {
			lrSignupClass[i].addEventListener("click", function(event){
				LrRaasTheme.showPopup('lr-register-container');
				return false;
			});
		}

		var lrLoginClass = document.getElementsByClassName("lr-raas-theme-login");
		for( var i = 0; i < lrLoginClass.length; i ++) {
			lrLoginClass[i].addEventListener("click", function(event){
				LrRaasTheme.showPopup('lr-login-container');
				return false;
			});
		}

		var fpClass = document.getElementsByClassName("lr-raas-theme-fp");
		for( var i = 0; i < fpClass.length; i ++) {
			fpClass[i].addEventListener("click", function(event){
				LrRaasTheme.showPopup('lr-fp-container');
				return false;
			});
		}
	},
	getUrlParameters: function() {
		var prmstr = window.location.search.substr(1);
		return prmstr != null && prmstr != "" ? this.transformToAssocArray(prmstr) : {};
	},
	transformToAssocArray: function(prmstr) {
		var params = {};
		var prm_array = prmstr.split("&");
		for ( var i = 0; i < prm_array.length; i ++ ) {
			var tmp_array = prm_array[i].split("=");
			params[tmp_array[0]] = tmp_array[1];
		}

		return params;
	}
}

LrRaasTheme.init();
