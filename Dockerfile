FROM ubuntu:16.04

# Install OpenJDK
ENV LANG C.UTF-8
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

RUN apt-get update \
    && apt-get install -y --no-install-recommends openjdk-8-jdk-headless \
    && rm -rf /var/lib/apt/lists/*

# Add files
WORKDIR /app
COPY target/*.jar ./
COPY docker/docker-entrypoint.sh /usr/local/bin/
COPY src/main/resources/application.yml ./conf/

#Config
ENTRYPOINT ["docker-entrypoint.sh"]
EXPOSE 9010