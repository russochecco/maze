Problem of how explore a Maze 

User Story 1
------------

As a world famous explorer of Mazes I would like a maze to exist
So that I can explore it

Acceptance Criteria

* A Maze (as defined in Maze1.txt consists of walls 'X', Empty spaces ' ', one and only one Start point 'S' and one and only one exit 'F'
* After a maze has been created the number of walls and empty spaces should be available to me
* After a maze has been created I should be able to put in a co ordinate and know what exists at that point


User Story 2
------------

As a world famous explorer of Mazes I would like to exist in a maze and be able to navigate it
So that I can explore it

Acceptance Criteria

* Given a maze the explorer should be able to drop in to the Start point
* An explorer on a maze must be able to:
    Move forward
    Turn left and right
    Understand what is in front of them
    Understand all movement options from their given location
    Have a record of where they have been
* Once an explorer has exited a maze they must be able to state the route they took in an understandable fashion


The solution implemented is based on a recursive backtracking approach where the pathway is found
is made analyzing the neighbourhood of each location inspected. 
To build and test the demo is sufficient to use the command "mvn clean install" under the root of the project.

This is an example of building:

francesco:maze francesco$ mvn clean install
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building maze 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ maze ---
[INFO] Deleting /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maze ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ maze ---
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files to /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ maze ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ maze ---
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maze ---
[INFO] Surefire report directory: /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running org.frusso.maze.MazeTest
XXXXXXXXXXXXXXX
X*************X
X*XXXXXXXXXXX*X
X*X*********X*X
X*XXXXXXXXX*X*X
X*XXXXXXXXX*X*X
X*XXXX******X*X
X*XXXX*XXXX X*X
X*XXXX*XXXX X*X
X*X****XXXXXX*X
X*X*XXXXXXXXX*X
X*X*XXXXXXXXX*X
X*X*********X*X
X*XXXXXXXXX***X
X?XXXXXXXXXXXXX

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.84 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maze ---
[INFO] Building jar: /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/target/maze.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ maze ---
[INFO] Installing /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/target/maze.jar to /Users/francesco/.m2/repository/org/frusso/maze/0.0.1-SNAPSHOT/maze-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/francesco/Documents/workspace-sts-3.6.4.RELEASE/maze/pom.xml to /Users/francesco/.m2/repository/org/frusso/maze/0.0.1-SNAPSHOT/maze-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 16.259 s
[INFO] Finished at: 2015-08-05T00:23:51+01:00
[INFO] Final Memory: 18M/65M
[INFO] ------------------------------------------------------------------------

