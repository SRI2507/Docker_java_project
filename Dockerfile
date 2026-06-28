FROM tomcat:9.0

MAINTAINER sri

EXPOSE 8080

COPY target/cake_app_java.war /usr/local/tomcat/webapps/
