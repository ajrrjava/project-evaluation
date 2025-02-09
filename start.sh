#!/bin/sh

# USE the trap if you need to also do manual cleanup after the service is stopped,
#     or need to start multiple services in the one container
#trap "echo TRAPed signal" HUP INT QUIT TERM

# start service in background here
echo "Starting Spring Boot server"
nohup java -jar app.jar

echo "Starting NextJS"
nohup node server.js

#echo "[hit enter key to exit] or run 'docker stop <container>'"
#pause

#echo "exited $0"
