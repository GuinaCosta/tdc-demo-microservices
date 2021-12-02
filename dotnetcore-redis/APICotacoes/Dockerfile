# FROM mcr.microsoft.com/dotnet/aspnet:3.1 AS build
# RUN mkdir /home/src
# COPY . /home/src
# WORKDIR /home/src
# RUN ls -al
# RUN dotnet publish

FROM mcr.microsoft.com/dotnet/aspnet:3.1

RUN apt-get update
RUN apt-get install wget -y
RUN apt-get install gnupg2 -y
RUN echo 'deb http://apt.newrelic.com/debian/ newrelic non-free' | tee /etc/apt/sources.list.d/newrelic.list
RUN wget -O- https://download.newrelic.com/548C16BF.gpg | apt-key add -
RUN apt-get update
RUN apt-get install newrelic-netcore20-agent
ENV NEW_RELIC_DISTRIBUTED_TRACING_ENABLED=true
ENV NEW_RELIC_LICENSE_KEY=X
ENV NEW_RELIC_APP_NAME="cotacao-app"

ARG PUBLISH_FILES=bin/Debug/netcoreapp3.1/publish/*
COPY ${PUBLISH_FILES} App/
WORKDIR /App

ENTRYPOINT ["/usr/local/newrelic-netcore20-agent/run.sh", "dotnet", "APICotacoes.dll"]