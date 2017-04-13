package com.loginradius.sdk.models.userprofile;


    public class LoginRadiusPosition 
    {
        /// <summary>
        /// Facebook : position and Linkedin : <title> node
        /// </summary>
        public String Position;

        /// <summary>
        /// Facebook : description and Linkedin : <summary> node
        /// </summary>
        public String Summary ;

        /// <summary>
        /// Facebook : start_date and Linkedin : <start-date> node
        /// </summary>
        public String StartDate;

        /// <summary>
        /// Facebook : end_date and Linkedin : <end-date> node
        /// </summary>
        public String EndDate ;

        /// <summary>
        /// Facebook : logic (if end date is null then isCurrent true) and Linkedin : <is-current> node
        /// </summary>
        public String IsCurrent ;


       


        public LoginRadiusPositionCompany Company ;

        /// <summary>
        /// Facebook : work.location
        /// </summary>
        public String Location;
    }

