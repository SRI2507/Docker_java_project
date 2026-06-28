FROM tomcat:9.0
EXPOSE 8080
COPY target/web_app_java.war /usr/local/tomcat/webapps/
