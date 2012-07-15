LoginRadius's Java SDK is used to implement Social Login on your Java website
==========

Description: LoginRadius's Java SDK is a development kit that lets you integrate Social Login through providers such as Facebook, Google, Twitter, and over 20 more on a Java website. The SDK also fetches user profile data and can be customized from your LoginRadius user account. Ex: social icon sets, login interface, provider settings, etc.

Steps to implement LoginRadius Java SDK
===

Step 1: Add SDK Jar files to your Java project website

Step 2: Create LoginRadius object in your Java file

  LoginRadius class has three overload constructors:
  1. Input two parameters: 'HttpServletRequest' (request object) and String (LoginRadius API secret)

          LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile user = new LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile();  
          LoginRadiusSDK.LoginRadius loginradius = new LoginRadiusSDK.LoginRadius(request, "Your API Secret key goes here"); 

  2. Input additional two parameters along with the above two parameters: String (Proxy host) and int (Proxy Port)

            LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile user = new LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile();
            LoginRadiusSDK.LoginRadius loginradius = new LoginRadiusSDK.LoginRadius(request, "Your API Secret key goes here", "your proxy host", proxyport );
            
  3. Input two more parameters along with the above mentioned four parameters: String (proxy server user name) and String (proxy server password)

            LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile user = new LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile();
            LoginRadiusSDK.LoginRadius loginradius = new LoginRadiusSDK.LoginRadius(request, "Your API Secret key goes here", "your proxy host", proxyport ,"proxy server user name","proxy server password");
            
Step 3: Validate, authenticate and store data from LoginRadius:

Validate LoginRadius 'IsAuthenticated' property. After successful validation, access user profile data such as ID, FirstName, Email, LastName, BirthDate, Country, NickName, Gender, ProfileName, etc. using getBasicUserprofile() method.

      <%  
      //you can call one from three overloads   
      LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile user = new LoginRadiusDataObject.Objects.BasicUserLoginRadiusUserProfile();  
      LoginRadiusSDK.LoginRadius loginradius = new LoginRadiusSDK.LoginRadius(request, "Your API Secret key goes here");  
        
      if (loginradius.IsAuthenticated) {  
          try {  
              user = loginradius.getBasicUserprofile();  
          } catch (Exception ex) {  
          }  
      %>  
      <p>FirstName: <%= user.FirstName%> </p>  
      <p>BirthDate: <%= user.BirthDate%> </p>  
      <p>FullName: <%= user.FullName%> </p>  
      <p>ID: <%= user.ID%> </p>  
      <p>LastName: <%= user.LastName%> </p>  
      <p>MiddleName: <%= user.MiddleName%> </p>  
      <p>Prefix: <%= user.Prefix%> </p>  
      <p>ProfileName: <%= user.ProfileName%> </p>  
      <p>Provider: <%= user.Provider%> </p>  
      <p>Suffix: <%= user.Suffix%> </p>  
      <%  
          if (user.Email != null) {  
              for (int i = 0; i < user.Email.size(); i++) {  
      %>  
      <p>Email : <%= user.Email.get(i).Value%> </p>  
      <%  
              }  
          }  
          if (user.Country != null) {  
              %>  
              <p>country name :<%= user.Country.Name %></p>  
              <p>country code :<%= user.Country.Code %></p>                
              <%  
          }  
      %>  
      <%  
          }  
      %>
      
Note: Few providers like Twitter, LinkedIn, etc. doesn't provide email address with User Profile data, so you need to handle these cases in your callback page.

These are the quick and easy steps to integrate Social Login on your Java website, if you have any questions or need a further assistance please contact us at hello@loginradius.com.