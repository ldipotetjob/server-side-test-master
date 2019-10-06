name := "server-side-test"
 
version := "1.0" 
      
lazy val `server-side-test` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

// Don't add extra dependencies. You can change versions of given dependencies if needed

libraryDependencies ++= Seq( evolutions, guice,  specs2 % Test )

libraryDependencies ++= Seq(
  "com.typesafe.play"       %% "play-slick"            % "4.0.0",
  "com.typesafe.play"       %% "play-slick-evolutions" % "4.0.0",
  "com.h2database"          %  "h2"                    % "1.4.197",
  "org.scalatestplus.play"  %% "scalatestplus-play"    % "4.0.0"    % "test"
)

