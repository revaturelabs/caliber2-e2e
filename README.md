# caliber2-e2e
Hold Cucumber tests for various features in caliber v2

# Building
To build the jar, run `maven install` in the root directory of the project. The jar will 
be output into the target directory.

# Running
To run the jar, from the directory it is in run `java -jar <jar name> <home page url>`.
For example, `java -jar .\caliber2-e2e-0.0.1-SNAPSHOT.jar http://example.com/caliber/vp/home`.
You can also run `java -jar .\caliber2-e2e-0.0.1-SNAPSHOT.jar --help` to print out 
text explaining parameters.

Note to developers:
Running from an editor requires the location of cucumber features in the runner 
class annotation to be changed to `src/main/resources/features`. The current setup 
is for finding features inside the jar file. You may also have to manually place the 
selenium driver in the root directory if running from the editor does not automatically 
export it there.