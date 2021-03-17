let options = {
	redirecturl: {
		afterlogin: "/profile",
		afterreset: "/loginscreen"
	}
};

LRObject.util.ready(function() {
	LRObject.loginScreen("loginscreen-container", options);
});