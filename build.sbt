scalaVersion := "2.12.2"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"


scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture"
  )

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core"   % "1.1.0" % Provided,
  "com.amazonaws" % "aws-lambda-java-events" % "1.1.0" % Provided
)

libraryDependencies ++= Seq(
  "io.github.mkotsur" % "aws-lambda-scala_2.12" % "0.0.10",
  "com.lifeway.aws" %% "scala-lambda-handler" % "0.1.0",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.4"
)

assemblyJarName in assembly := "test.jar"

mergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case _                             => MergeStrategy.first
   }
