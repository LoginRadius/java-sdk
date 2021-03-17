$(function() {
    verificationHandler();
});

function verificationHandler() {
    if (getUrlParameter("vtype") === "oneclicksignin") {
        $.ajax({
            type: "GET",
            url: "/passwordless/verify?token=" + getUrlParameter("vtoken"),
            dataType: "json",
            success: function(res) {
                console.log("Pwless Login success::", res);
                $("#emailverification-message").text("Passwordless Login success.");

                localStorage.setItem("LRTokenKey", res.access_token);
                localStorage.setItem("lr-user-uid", res.Profile.Uid);
                window.location.href = "/profile";
            },
            error: function(xhr) {
                console.log("Pwless Login err::", xhr.responseText);
                $("#minimal-verification-message").text(xhr.responseText);
                $("#minimal-verification-message").attr("class", "error-message");
            }
        });
    } else if (getUrlParameter("vtype") === "emailverification") {
        $.ajax({
            type: "GET",
            url: "/email/verify?token=" + getUrlParameter("vtoken"),
            dataType: "json",
            success: function(res) {
                console.log("Email verification success::", res);
                $("#minimal-verification-message").text("Email successfully verified.");
                $("#minimal-verification-message").attr("class", "success-message");
            },
            error: function(xhr) {
                console.log("Email verification err::", xhr.responseText);
                $("#minimal-verification-message").text(xhr.responseText);
                $("#minimal-verification-message").attr("class", "error-message");
            }
        });
    } else {
        window.location.href = "/minimal";
    }
}

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
}