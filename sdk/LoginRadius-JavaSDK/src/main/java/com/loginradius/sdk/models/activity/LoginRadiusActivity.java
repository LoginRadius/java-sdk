package com.loginradius.sdk.models.activity;

import java.util.List;

public class LoginRadiusActivity 
{
	public String ActivityId;
    public String ActivityUrl;
    public String Title;
    public String Published;
    public String Updated;
    public String Name;
    public String ProfileUrl;
    public String ImageUrl;
    public String TotalReply;
    public String ReplyUrl;
    public String TotalPlusOneRs;
    public String PlusOneRsUrl;
    public String TotalReShares;
    public String ReShareUrl;
    public String UserId;
    public String Source;
    public List<Attchments> Attchments;
    public class Attchments
    {
        public String AttchmentType;
        public String AttchmentName;
        public String AttchmentUrl;
    }
}
