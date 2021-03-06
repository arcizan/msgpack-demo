name := """msgpack-demo"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
// libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies ++= Seq(
  "org.msgpack" %% "msgpack-scala" % "0.6.11"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"
