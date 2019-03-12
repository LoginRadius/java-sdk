var options = {
	redirecturl: {
		afterlogin: "/user/profile",
		afterreset: "/loginscreen"
	}
};

LRObject.util.ready(function() {
	LRObject.loginScreen("loginscreen-container", options);
});