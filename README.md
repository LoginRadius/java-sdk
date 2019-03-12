# LoginRadius Scala Demo


![Home Image](http://docs.lrcontent.com/resources/github/banner-1544x500.png)

## Introduction

LoginRadius Customer Registration wrapper provides access to LoginRadius Identity Management Platform API.

LoginRadius is an Identity Management Platform that simplifies user registration while securing data. LoginRadius Platform simplifies and secures your user registration process, increases conversion with Social Login that combines 30 major social platforms, and offers a full solution with Traditional Customer Registration. You can gather a wealth of user profile data from Social Login or Traditional Customer Registration. 

LoginRadius centralizes it all in one place, making it easy to manage and access. Easily integrate LoginRadius with all of your third-party applications, like MailChimp, Google Analytics, Livefyre and many more, making it easy to utilize the data you are capturing.

LoginRadius helps businesses boost user engagement on their web/mobile platform, manage online identities, utilize social media for marketing, capture accurate consumer data, and get unique social insight into their customer base.

Please visit [here](http://www.loginradius.com/) for more information.

# LoginRadius

A demo Scala web application using the Java SDK.

## Configuration

1. Install Java 8 [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). Ensure `java -version` and `javac -version` runs properly
2. Install sbt 0.13.13 or later [here](https://www.scala-sbt.org/0.13/docs/Setup.html)
3. Set your LoginRadius credentials on the client and server side:
	* Client side: `demo/src/main/webapp/assets/js/options.js`
	* Server side: `demo/src/main/scala/com/loginradius/demo/LrConfig.scala`
4. Navigate to the demo directory and run: `sbt ~jetty:start`
5. Demo will appear on `http://localhost:8080`

