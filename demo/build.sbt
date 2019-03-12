val ScalatraVersion = "2.6.3"

organization := "com.loginradius"

name := "demo"

scalaVersion := "2.12.6"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)

// https://mvnrepository.com/artifact/com.loginradius.sdk/java-sdk
libraryDependencies += "com.loginradius.sdk" % "java-sdk" % "4.2.0"

enablePlugins(ScalatraPlugin)
