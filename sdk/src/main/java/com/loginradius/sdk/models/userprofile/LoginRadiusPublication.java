package com.loginradius.sdk.models.userprofile;

import java.util.List;

   public class LoginRadiusPublication 
    {

        public String Id ;

        public String Title ;
      
        public String Publisher ;

        public List<LoginRadiusPublicationsAuthors> Authors;
        
        public String Date;
       
        public String Url ;
        
        public String Summary ;
        public class LoginRadiusPublicationsAuthors
        {
            
            public String Id;

            public String Name;
        }


    }

    

