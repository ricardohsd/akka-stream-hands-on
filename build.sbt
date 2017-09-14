name := "akka-stream-hands-on"

version := "1.0"

scalaVersion := "2.12.1"

resolvers ++= {
  Seq(
    "Confluent" at "http://packages.confluent.io/maven/",
    "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"
  )
}

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream"            % "2.5.4",

  "org.scalatest"     %% "scalatest"              % "3.0.4",
  "com.typesafe.akka" %% "akka-stream-testkit"    % "2.5.4"
)
