package de.mukis

import sbt._
import sbt.Keys._

object AkkaBuild extends Build {

  lazy val baseSettings = Defaults.defaultSettings ++ Seq(
    resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/")
  
  lazy val buildSettings = Seq(
    organization := "de.mukis",
    version      := "0.1-SNAPSHOT",
    scalaVersion := "2.9.3"
  )

  lazy val sbtIssue = Project(
    id = "sbt-paxexam-example",
    base = file("."),
    settings = baseSettings ++ Seq(
      libraryDependencies ++= Dependencies.osgiTests
    )
    
  )

  object Dependencies {
    import Dependency._
    val osgiTests = Seq(osgiCore, Test.scalatest, Test.junit, Test.paxExamUnit , Test.paxInject, Test.paxExamRunner, Test.paxLinkAssembly, Test.paxExamForge, Test.paxRunner,    Test.javaxInject, Test.paxExamSpi )
  }

  object Dependency {
    // Compile
    val osgiCore      = "org.osgi"                    % "org.osgi.core"                % "4.2.0"       // ApacheV2

    // Test

    object Test {
      val junit       = "junit"                       % "junit"                        % "4.10"             % "test" // Common Public License 1.0
      val scalatest   = "org.scalatest"               % "scalatest"                    % "1.8"              % "test" cross CrossVersion.full // ApacheV2
        

      val paxExamUnit = "org.ops4j.pax.exam"          % "pax-exam-junit4"              % "2.5.0"            % "test" // TODO License
      val paxExamSpi  = "org.ops4j.pax.exam"          % "pax-exam-spi"                 % "2.5.0"            % "test"
      val paxInject   = "org.ops4j.pax.exam"          % "pax-exam-inject"              % "2.5.0"            % "test" // TODO License
      val paxExamRunner   = "org.ops4j.pax.exam"      % "pax-exam-container-paxrunner" % "2.5.0"            % "test" // TODO License
      val paxLinkAssembly = "org.ops4j.pax.exam"      % "pax-exam-link-assembly"       % "2.5.0"            % "test" // TODO License
      val paxExamForge    = "org.ops4j.pax.exam"      % "pax-exam-testforge"           % "2.5.0"            % "test" // TODO License
      val paxRunner   = "org.ops4j.pax.runner"        % "pax-runner-no-jcl"            % "1.7.6"            % "test" // TODO License
      val javaxInject = "javax.inject"                % "javax.inject"                 % "1"                % "test" // TODO License
   
    }
  }
}

