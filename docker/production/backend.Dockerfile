# Dockerfile

## Stage: Build Java
FROM gradle:jdk17-alpine AS build

COPY --chown=gradle:gradle . /home/gradle

RUN gradle build || return 1

RUN rm /home/gradle/server/build/libs/server-*-plain.jar

FROM bellsoft/liberica-runtime-container:jdk-17-stream-musl AS base

WORKDIR /app

ENV ARTIFACT_NAME=server-*.jar

COPY --from=build /home/gradle/server/build/libs/$ARTIFACT_NAME app.jar

#ENV PATH=$PATH:/usr/lib/jvm/default-jvm/bin
#
#COPY /usr/lib/jvm/default-jvm /usr/lib/jvm/default-jvm

EXPOSE 8080

ENV PORT=8080
## set hostname to localhost
ENV HOSTNAME="0.0.0.0"

ENTRYPOINT ["java","-jar","app.jar"]