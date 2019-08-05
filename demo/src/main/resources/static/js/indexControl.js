$(function() {
    login_traditional();
    login_mfa();
    login_passwordless();
    login_social();
    register();
    forgotpassword();
});

function login_traditional() {
    $("#btn-minimal-login").click(function() {
        $.ajax({
            type: "GET",
            url: "/login",
            dataType: "json",
            data: $.param({
                email: $("#minimal-login-email").val(),
                password: $("#minimal-login-password").val()
            }),
            success: function(res) {
                console.log("Login success::", res);
                getProfile(res.access_token, res.Profile.Uid);
            },
            error: function(xhr, status, error) {
                console.log("Login err::", xhr.responseText);
                $("#minimal-login-message").text(xhr.responseText);
                $("#minimal-login-message").attr("class", "error-message");
            }
        });
    });
}

function login_mfa() {
    $("#btn-minimal-mfalogin-next").click(function() {
        $.ajax({
            type: "POST",
            url: "/mfa",
            dataType: "json",
            data: $.param({
                email: $("#minimal-mfalogin-email").val(),
                password: $("#minimal-mfalogin-password").val()
            }),
            success: function(res) {
                console.log("MFA success::", res);
                $("#minimal-mfalogin-message").text("");
                if (res.SecondFactorAuthentication) {
                    if (res.SecondFactorAuthentication.IsGoogleAuthenticatorVerified === false) {
                        $("#minimal-mfalogin-qrcode").append('<img src="' + res.SecondFactorAuthentication.QRCode + '">');
                    }
                    $("#minimal-mfalogin-next")
                        .html('<table><tbody><tr>' +
                            '<td>Google Authenticator Code: </td><td><input type="text" id="minimal-mfalogin-googlecode"></td>' +
                            '</tr></tbody></table>' +
                            '<button id="btn-minimal-mfalogin-login">Login</button>');
                    $("#btn-minimal-mfalogin-login").on('click', function() {
                        validateGoogleCode(res.SecondFactorAuthentication.SecondFactorAuthenticationToken);
                    });
                } else {
                    getProfile(res.access_token, res.Profile.Uid);
                }
            },
            error: function(xhr,status, error) {
                console.log("MFA err::", xhr.responseText);
                var strEmail = $('#minimal-mfalogin-email').val();	
                var strPassword = $('#minimal-mfalogin-password').val();
                if(strEmail.replace(/\s/g,"") == ""){
                	$("#minimal-mfalogin-message").text("The email is a Required Paramter So its can not be null or empty");
                }else if(strPassword.replace(/\s/g,"") == ""){
                	$("#minimal-mfalogin-message").text("The Password is a Required Paramter So its can not be null or empty");
                }else{
                $("#minimal-mfalogin-message").text(xhr.responseText);
                }
                $("#minimal-mfalogin-message").attr("class", "error-message");
            }
        });
    });
}

function validateGoogleCode(gtoken) {
    $.ajax({
        type: "PUT",
        url: "/mfa/verify",
        dataType: "json",
        data: $.param({
            code: $("#minimal-mfalogin-googlecode").val(),
            token: gtoken
        }),
        success: function(res) {
            console.log("MFA Login success::", res);
            getProfile(res.access_token, res.Profile.Uid);
        },
        error: function(xhr) {
            console.log("MFA Login err::", xhr.responseText);
            $("#minimal-mfalogin-message").text(xhr.responseText);
            $("#minimal-mfalogin-message").attr("class", "error-message");
        }
    });
}

function login_passwordless() {
    $("#btn-minimal-pwless").click(function() {
        $.ajax({
            type: "GET",
            url: "/passwordless",
            dataType: "json",
            data: $.param({
                email: $("#minimal-pwless-email").val()
            }),
            success: function(res) {
                console.log("PwlessLogin success::", res);
                $("#minimal-pwless-message").text("Check your email for the login link.");
                $("#minimal-pwless-message").attr("class", "success-message");
            },
            error: function(xhr, status, error) {
                console.log("PwlessLogin err::", xhr.responseText);
                var strEmail = $('#minimal-pwless-email').val();	
                if(strEmail.replace(/\s/g,"") == ""){
                	$("#minimal-pwless-message").text("The Email is a Required Paramter So its can not be null or empty");
                }else{
                	$("#minimal-pwless-message").text(xhr.responseText);
                }
    
                $("#minimal-pwless-message").attr("class", "error-message");
            }
        });
    });
}

function login_social() { // uses js-library
    let social_script = $(
        '<script type="text/html" id="loginradiuscustom_tmpl">' +
        '<a class="lr-provider-label" href="javascript:void(0)" onclick="return LRObject.util.openWindow(\'<#= Endpoint #>\');" title="<#= Name #>" alt="Sign in with <#=Name#>">' +
        '<span class="lr-ls-icon lr-ls-icon-<#= Name #>"></span>' +
        '</a>&nbsp;&nbsp;&nbsp;' +
        '</script>'
    );

    $("#sociallogin").append(social_script);

    let custom_interface_option = {};
    let sl_options = {};

    sl_options.onSuccess = function(res) {
        console.log("Sociallogin success::", res);
        getProfile(res.access_token, res.Profile.Uid);
    };
    sl_options.onError = function(err) {
        console.log("Sociallogin err::", err);
    };

    custom_interface_option.templateName = 'loginradiuscustom_tmpl';
    sl_options.container = "sociallogin-container";

    LRObject.util.ready(function() {
        LRObject.customInterface(".interfacecontainerdiv", custom_interface_option);
        LRObject.init('socialLogin', sl_options);
    });
}

function register() {
    $("#btn-minimal-signup").click(function() {
        if ($("#minimal-signup-password").val() != $("#minimal-signup-confirmpassword").val()) {
            $("#minimal-signup-message").text("Passwords do not match!");
            $("#minimal-signup-message").attr("class", "error-message");
            return;
        }

        $.ajax({
            type: "POST",
            url: "/register",
            dataType: "json",
            data: $.param({
                email: $("#minimal-signup-email").val(),
                password: $("#minimal-signup-password").val()
            }),
            success: function(res) {
                console.log("Register success::", res);
                $("#minimal-signup-message").text("Check your email to verify your account.");
                $("#minimal-signup-message").attr("class", "success-message");
            },
            error: function(xhr, status, error) {
                console.log("Register err::", xhr.responseText);
                $("#minimal-signup-message").text(xhr.responseText);
                $("#minimal-signup-message").attr("class", "error-message");
            }
        });
    });
}

function forgotpassword() {
    $("#btn-minimal-forgotpassword").click(function() {
        $.ajax({
            type: "POST",
            url: "/password/forgot",
            dataType: "json",
            data: $.param({
                email: $("#minimal-forgotpassword-email").val()
            }),
            success: function(res) {
                console.log("Send success::", res);
                $("#minimal-forgotpassword-message").text("Check your email to start the password reset process.");
                $("#minimal-forgotpassword-message").attr("class", "success-message");
            },
            error: function(xhr, status, error) {
                console.log("Send err::", xhr.responseText);
                var strEmail = $('#minimal-forgotpassword-email').val();	
                if(strEmail.replace(/\s/g,"") == ""){
                	$("#minimal-forgotpassword-message").text("The Email is a Required Paramter So its can not be null or empty");
                }else{
                	$("#minimal-forgotpassword-message").text(xhr.responseText);
                }
                
                $("#minimal-forgotpassword-message").attr("class", "error-message");
            }
        });
    });
}

function getProfile(access_token, profile_uid) {
    localStorage.setItem('LRTokenKey', access_token);
    localStorage.setItem('lr-user-uid', profile_uid);
    window.location.href = "/profile";
}