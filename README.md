# sdk-java-customer-identity
Customer Identity private repo for Java SDK

![Home Image](https://d2lvlj7xfpldmj.cloudfront.net/support/github/banner-1544x500.png)


## Introduction ##

LoginRadius Java Customer Registration wrapper provides access to LoginRadius Identity Management Platform API.

LoginRadius is an Identity Management Platform that simplifies user registration while securing data. LoginRadius Platform simplifies and secures your user registration process, increases conversion with Social Login that combines 30 major social platforms, and offers a full solution with Traditional User Registration. You can gather a wealth of user profile data from Social Login or Traditional User Registration. 

LoginRadius centralizes it all in one place, making it easy to manage and access. Easily integrate LoginRadius with all of your third-party applications, like MailChimp, Google Analytics, Livefyre and many more, making it easy to utilize the data you are capturing.

LoginRadius helps businesses boost user engagement on their web/mobile platform, manage online identities, utilize social media for marketing, capture accurate consumer data, and get unique social insight into their customer base.

Please visit [here](http://www.loginradius.com/) for more information.




# Installing

LoginRadius is now using Maven. At present the jars *are* available from a public [maven]( http://search.maven.org/#search%7Cga%7C1%7Cloginradius) repository.

Use the following dependency in your project:

```
<dependency>
  <groupId>com.loginradius.sdk</groupId>
  <artifactId>java-sdk</artifactId>
  <version>1.0.0</version>
</dependency>
```
You can also compile the source as follows. This will generate the javadocs in sdk-java-customer-identity/target/apidocs

    $ git clone https://github.com/LoginRadius/java-sdk.git
    $ cd java-sdk
    $ mvn install       # Requires maven, download from http://maven.apache.org/download.html
    $ mvn dependency:copy-dependencies   # This will generate all dependencies here: 
                                         # sdk-java-customer-identity/target/dependency  
  

  
The jars are also available [here](http://search.maven.org/#search%7Cga%7C1%7Cloginradius). Select the directory for
the latest version and download the jar files.
  
 ## Documentation

[Getting Started](http://apidocs.loginradius.com/docs/java-library) - Everything you need to begin using this SDK.
