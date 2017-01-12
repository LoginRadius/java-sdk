package com.loginradius.sdk.social.models.userprofile;

import java.util.Date;
import java.util.List;

public class LoginRadiusBasicUserProfile {
	 public String ID ;
     public String Provider;
     public String Prefix ;
     public String FirstName ;
     public String MiddleName ;
     public String LastName;
     public String Suffix;
     public String FullName ;
     public String NickName ;
     public String ProfileName ;
     public String BirthDate ;
     public String Gender;
     public String ImageUrl ;
     public String ThumbnailImageUrl ;

     public List<LoginRadiusEmail> Email ;
     public LoginRadiusCountry Country ;

   
     public Date CreatedDate;
  
     public Date ModifiedDate;


     public String LocalCountry;
     public String ProfileCountry;
}
