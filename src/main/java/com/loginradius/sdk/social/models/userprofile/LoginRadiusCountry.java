package com.loginradius.sdk.social.models.userprofile;


    public class LoginRadiusCountry 
    {
        private String Code ;
        private String Name;
        
        
		public LoginRadiusCountry(String code, String name) {
			super();
			Code = code;
			Name = name;
		}


		public String getCode() {
			return Code;
		}


		public void setCode(String code) {
			Code = code;
		}


		public String getName() {
			return Name;
		}


		public void setName(String name) {
			Name = name;
		}
    }