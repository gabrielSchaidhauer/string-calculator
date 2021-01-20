#!/bin/bash
# export JAVA_HOME=/your/java/path
./gradlew build > /dev/null && \
echo "If you want to exit at any moment press Ctrl + C" && \
java -jar build/libs/string-calculator-1.0.jar