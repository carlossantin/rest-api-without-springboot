FROM tomcat:9.0.17-jre8-alpine
COPY build/libs/rest-api-without-springboot-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps