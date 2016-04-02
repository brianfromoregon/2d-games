[![Build Status](https://travis-ci.org/brianfromoregon/2d-games.svg?branch=master)](https://travis-ci.org/brianfromoregon/2d-games)

#### Setup
1. Install [Oracle JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). 
1. Install an IDE. 
 * I prefer [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/) 
 * But [Eclipse](http://www.eclipse.org/downloads/) works too, pick "Eclipse IDE for Java Developers"
1. Download and install [Git](https://git-scm.com/downloads)
1. Git clone this repo, the URL is _https://github.com/brianfromoregon/2d-games.git_
1. (TODO explain better) Import maven project into IDE
1. (TODO explain better) Run the maven compile target one time to prepare native dependencies

#### Verify
1. (TODO explain better) Run main class pong.complete.PingPongGame and a pong game should pop up.
 * Read its javadoc for instruction on required JVM options.

#### FAQ


* When trying to run the main class I see this: Exception in thread "main" java.lang.UnsatisfiedLinkError: no lwjgl in java.library.path

 Did you forget to add this JVM option: -Djava.library.path=target/natives
 
 Did you forget to run maven's compile target?
