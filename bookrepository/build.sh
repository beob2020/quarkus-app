#!/bin/sh

./mvnw package -Pnative

docker build -f src/main/docker/Dockerfile.native-micro -t quarkus/bookrepository .