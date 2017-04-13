package com.loginradius.sdk.models.userprofile;


   public class LoginRadiusJobBookmark 
    {
      
        public boolean IsApplied;

       
        public String ApplyTimestamp;

        
        public boolean IsSaved ;

       
        public String SavedTimestamp ;


        public LoginRadiusJob Job;

        public class LoginRadiusJobBookmarkPosition
        {
           
            public String Title ;

        }
        public class LoginRadiusJob
        {

            
            public boolean Active;

            
            public String Id ;

            public String DescriptionSnippet ;

            public LoginRadiusJobBookmarkCompany Company ;

            public LoginRadiusJobBookmarkPosition Position ;

           
            public String PostingTimestamp ;



        }

       public class LoginRadiusJobBookmarkCompany
        {

          
            public String Id ;

            public String Name ;

        }

        
    }



