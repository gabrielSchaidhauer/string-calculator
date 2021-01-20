# Expression based calculator

This project implements a calculator that performs sums based on a given expression.

## Requisites
Java 8 or higher.

## Running
If you are in a Unix Machine just run the run.sh file:

`./run.sh`

In case gradle tells you that tools.jar is missing it should be necessary to 
uncomment the first line on run.sh and set it to your java installation path.

In case you are on another operating system or anything unexpected happened I suggest building with Gradle:

`./gradlew build` on Unix or
`/gradlew.bat build` on Windows.

after that the jar should be on *build/libs* and you can just run:

`java -jar buid/libs/string-calculator-1.0.jar`

If you have any trouble running this project contact me at my [email](mailto:gabriel.schaidhauer@gmail.com).
