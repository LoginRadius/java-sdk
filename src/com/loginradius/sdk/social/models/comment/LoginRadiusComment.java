package com.loginradius.sdk.social.models.comment;

import java.util.List;

	public class LoginRadiusComment 
    {
       public String CommentId;

       public String Published;
       public String Updated;
       public String Name;
       public String ProfileUrl;
       public String ImageUrl;
       public String UserId;
       public String Type;
       public String Comment;
       public List<ReplyList> ReplyList;
       public class ReplyList
       {
           public String ReplyId;
           public String ReplyUrl;
       }
    }
    

