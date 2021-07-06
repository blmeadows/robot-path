// Scala
val scalaV = "2.13.6"

// Scalameta
val munitV = "0.7.26"

// Java
val logbackClassicV = "1.2.3"

lazy val core = project
  .in(file("."))
  .settings(commonSettings)
  .settings(name := "robot-path")

lazy val commonSettings = Seq(
  scalaVersion := scalaV,
  publishArtifact := false, // https://www.scala-sbt.org/1.x/docs/Artifacts.html#Modifying+default+artifacts
  Global / cancelable := true, // cancel running task without existing sbt
  Test / parallelExecution := false, // https://scalameta.org/munit/docs/tests.html#run-tests-in-parallel
  libraryDependencies ++= Seq(
    // Logging
    "ch.qos.logback" % "logback-classic" % logbackClassicV, // http://logback.qos.ch/
    // Testing
    "org.scalameta" %% "munit"            % munitV % Test, // https://scalameta.org/munit/
    "org.scalameta" %% "munit-scalacheck" % munitV % Test // https://scalameta.org/munit/
  )
)
