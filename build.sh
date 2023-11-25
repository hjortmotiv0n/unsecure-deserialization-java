#!/bin/bash
# Navigate to the project directory
# cd /path/to/your/project

# Build the project with Maven
mvn clean package

# Check if the build was successful
if [ $? -eq 0 ]
then
  echo "Build was successful!"
else
  echo "Build failed!" >&2
  exit 1
fi