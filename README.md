LoginRadius library for Java
=====
Java library for the LoginRadius API. Get social authentication, user profile data and send messages using many social network and email clients such as Facebook, Google, Twitter, Yahoo, LinkedIn, etc.

Installation
----
1. **Font-end interface:** Add social login interface code from your LoginRadius user account to your webpage.
2. **Call-back setup:** Set-up the callback URL in your LoginRadius user account, this is the URL where user would be redirected after authentication.
3. **Library set-up and installation:** Add the LoginRadius Jar into your Java project and follow the instructions to implement the Jar into your callback page.

Steps to call the library:

     1. Import the Library reference into your code file
     2. Call IsAuthenticated property to check for authentication validation
     3. If success, call getBasicUserProfile method to get user's profile data. [For Premium paid plans: You can call getExtendedUserProfile method to get Extended user profile data.] visit the link for more information to get list of data: https://www.loginradius.com/product/user-profile-data

**Sample code for authentication and get basic profile data**

      using LoginRadiusSDK;          //Import the library reference
      LoginRadius _loginradius = new LoginRadius(request,"Your-Login Radius-API-Secret-key"); 
        if(_loginradius.IsAuthenticated) 
            {
        	BasicUserLoginRadiusUserProfile userprofile=_loginradius.getBasicUserProfile();
    		//fetch all properties for profile data  
              //userprofile.birthdate -- Birth date of user  
              //if(userprofile.country != null)  
              //{  
              //    userprofile.country.code - country code  
              //    userprofile.country.name - country name  
              //}  
              //  
              //Email id generic list 
              //Iterator it=userprofile.emails.iterator();
                    while(it.hasNext())
                        it.next(i) -- Email id of user

              //userprofile.firstName -- first name of user  
              //userprofile.fullName -- full name of user   
              //userprofile.gender -- gender of user  
              //userprofile.id -- ID of user on provider   
              //userprofile.lastName -- last name of user  
              //userprofile.middleName -- middle name of user  
              //userprofile.nickName -- nick name of user  
              //userprofile.prefix -- prefix of user's name  
              //userprofile.profileName -- screenname/username of user   
              //userprofile.provider -- provider name from where user has authenticated   
              //userprofile.suffix -- suffix of user's name
    	}

**Sample code to get Extended user profile (Only for Paid plans - Premium)**
     
    if(_loginradius.IsAuthenticated)
    	UltimateUserLoginRadiusUserProfile userprofile = _loginradius.getExtendedUserprofile();


**Tip-1:** Few providers like Twitter doesn't provide email address with User Profile data, so you need to handle these cases in your callback page.

Advance features(for Paid customers only)
===

LoginRaidus Contacts API
-----
You can use this API to fetch contacts from users social networks/email clients - Facebook, Twitter, LinkedIn, Google, Yahoo.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.

	Contacts contact = new Contacts();
    LoginRadiusContact[] contactlist = contact.getContacts("-LoginRadius-session-Token-", "-Your-LoginRadius-Secret-key-");
               	if (contactlist!= null) {
                   	for (int i = 0; i < contactlist.length; i++) {
    		             //contactlist[i].id  - Contact ID
       	                 //contactlist[i].name – Contact Name
     		             //contactlist[i].emailId – Contact EmailId
    		             //contactlist[i].gender – Contact Gender
    		             //contactlist[i].phoneNumber – Contact PhoneNumber
    		             //contactlist[i].status – Contact Status
    		             //contactlist[i].industry – Contact Industry
                         //contactlist[i].imageUrl – Contact Image Url    			
                         //contactlist[i].profileUrl –Contact Profile Url
                   
               }

LoginRadius Post API
---
You can use this API to Post data to users social networks/email - Facebook, Twitter, LinkedIn, Google, Yahoo.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.

	LoginRadiusSDK.Statuses lrstatusmessage = new LoginRadiusSDK.Statuses();
    bool isstatusupdated = lrstatusmessage.postStatus("LoginRadius-session-token", "Your-LoginRadius-Secret-key",“To”,”Title”,”Url”,”imageurl-”,”status”,”caption”,”description”);

Get Posts
--
You can use this API to get posts from users social network - Facebook

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.

	LoginRadiusSDK.Posts lrPost= new LoginRadiusSDK.Posts();  
       	
    LoginRadiusPost[] PostList = lrPost.getPosts("LoginRadius-session-token", "Your-LoginRadius-API-secret-key");    
          if (PostList!= null) {
             //fetch all properties like
    	      for (int i = 0; i < PostList.length; i++) {
    		      // PostList[i].id       	-- id of Post
    		      // PostList[i].place    	-- Place of Post
    		      // PostList[i].name     	-- Name of Post
    		      // PostList[i].likes    	-– Likes of Post
    		      // PostList[i].startTime	-- Start Time of Post
    		      // PostList[i].message  	-- Message of Post
    		      // PostList[i].picture  	-- Picture in Post
    		      // PostList[i].title    	-– Title of Post
    		      // PostList[i].share    	-- Share  of Post
    		      // PostList[i].updateTime   -- UpdateTime of Post
    	       }     
        }
Get Twitter Mentions
--

You can use this API to get mentions from users social network - Twitter.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.


    LoginRadiusSDK.Mentions lrMention = new LoginRadiusSDK.Mentions();   
    LoginRadiusDataObject.LoginRadiusStatuses[] MentionList= lrMention.getMention("LoginRadius-session-Token","Your-LoginRadius-Secret-key");
     if (MentionList!= null)
     {
      	//fetch all properties like
           for(int i =0;i< MentionList.length;i++)
            {
    		// MentionList[i].id    	-- id of Mention
    		// MentionList[i].place 	-- Place of Mention
    		// MentionList[i].name  	-- Name of Mention
    		// MentionList[i].text  	-– Text of Mention
    		// MentionList[i].dateTime -- DateTime  of Mention
    		// MentionList[i].imageUrl  -- ImageUrl in Mention
    		// MentionList[i].likes 	-- Likes of Mention
    		// MentionList[i].linkUrl   -– LinkUrl of Mention
    		// MentionList[i].source	-- Source  of Mention
                     	
             }
    }
Facebook Groups
--
You can use this API to get groups from users social network - Facebook.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.


    LoginRadiusSDK.Groups lrGroups= new LoginRadiusSDK.Groups();   
         	
    LoginRadiusGroups[] GroupList= lrGroups.getGroups ("LoginRadius-session-Token","Your-LoginRadius-Secret-key");
    	if (GroupList!= null)
        {
               //fetch all properties like
    	      for(int i=0;i<GroupList.length;i++)
               {
    		      // GroupList[i].id -- id of event
    		      // GroupList[i].name -- Name of Event
               }
         }
Get LinkedIn follow companies
--
You can use this API to get followed companies list from users social network - LinkedIn.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.


    LoginRadiusSDK.Companies lrcompanies = new LoginRadiusSDK.Companies();

    LoginRadiusCompanyFollow[] companylist = lrcompanies.getCompanies("LoginRadius-session-Token","Your-LoginRadius-Secret-key");
      if (companylist!= null)
      {
         for(int i=0;i<companylist.length;i++)
         {
    		//companylist[i].id  - followcompany ID
            //companylist[i].name – followcompany Name	
         }
       }
Get Facebook events
--
You can use this API to get events from users social network - Facebook.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.


    LoginRadiusSDK.Events lrEvent = new LoginRadiusSDK.Events ();  
     
    LoginRadiusEvent[] EventList= lrEvent.getEvents ("LoginRadius-session-Token","Your-LoginRadius-Secret-key");
    
        if (EventList!= null)
        {
           //fetch all properties like
           for(int i=0;i<EventList.length;i++)
           {
     	  		//EventList[i].id     	-- id of event
     	 		//EventList[i].location   -- location of event
            	//EventList[i].name   	-- Name of Event
            	//EventList[i].rsvpStatus -– Status of event
            	//EventList[i].startTime  -- Start Time of Event
                    	
            }
        }
Get Status
---
You can use this API to get status messages from users social network - Facebook.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.


    LoginRadiusSDK.Statuses lrstatus = new LoginRadiusSDK.Statuses();
    LoginRadiusStatuses[] statuslist = lrstatus.getStatuses("LoginRadius-session-Token","Your-LoginRadius-Secret-key");
             if (statuslist!= null)
             {
               for(int i=0;i<statuslist.length;i++)
      	   		{
                	// statuslist[i].id  - status ID
                 	// statuslist[i].imageUrl– status Image Url  
    	    		// statuslist[i].likes – status Likes
                	// statuslist[i].text – status Text
                	// statuslist[i].linkUrl – status LinkUrl
    	    		// statuslist[i].place – status place
                	// statuslist[i].source – status source
                       	
               }
             }
Direct Message
---
You can use this API to send message to users social networks/email - Twitter, LinkedIn.

> LoginRadius generate a unique session token, when user logs in with
> any of social network. The lifetime of LoginRadius token is 15 mins, get/Save this Token to call this API.

	LoginRadiusSDK.DirectMessage lrdirectmessage = new LoginRadiusSDK.DirectMessage();

    boolean ismessagesent = lrstatusmessage.sendMessage("LoginRadius-session-token", "Your-LoginRadius-Secret-key",“SendTo”,”Subject”,”Message”);

 **Request:** Please let us know your feedback and comments. If you have any questions or need a further assistance please contact us at [hello@loginradius.com][1].


  [1]: hello@loginradius.com
