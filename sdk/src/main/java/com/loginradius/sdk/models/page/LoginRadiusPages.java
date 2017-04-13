package com.loginradius.sdk.models.page;

import java.util.List;

import com.loginradius.sdk.models.page.LoginRadiusPage.Speciality;

  public class LoginRadiusPages
    {
        public String ID;
        public String Name;

        public String Url;
        public String Category;
        public String Likes;
        public String Phone;
        public String Image;
        public String Website;
        public String About;
        public String Description;
        public String Awards;
        public String CheckinCount;
        public String Founded;
        public String Mission;
        public String Products;
        public String ReleaseDate;
        public String TalkingAboutCount;
        public boolean Published;
        public String UserName;
        public List<LoginRadiusPageLocations> Locations ;
        public List<LoginRadiusPageCategoryList> CategoryList;
        public LoginRadiusPageCover CoverImage ;
        public LoginRadiusPageCodeName EmployeeCountRange ;
        public List<LoginRadiusPageCodeName> Industries ;
        public Speciality Specialties ;
        public LoginRadiusPageCodeName Status;
        public LoginRadiusPageCodeName StockExchange ;

    }

