# MosquittoPI_NX

This a simple implementation and example of
an MosquittoHelper class in java. In order to use this class
you need to download the java libraries for rasberry PI
find out more at http://pi4j.com/

compile the java source files with the correct class path i.e:

javac -classpath .:classes:/opt/pi4j/lib/'*'  -d . TestClasses.java  (in directory: /home/anon/workspace/javaDev)

Execute the class files with this command:

sudo java -classpath .:classes:/opt/pi4j/lib/'*' TestClasses
