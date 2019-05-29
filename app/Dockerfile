# FROM tomcat
# COPY /target/app.war ${CATALINA_HOME}/webapps

#FROM payara/server-full
FROM payara/server-full:5.183 
EXPOSE 4848 8009 9009 8080 8181 8686 6001
COPY target/app.war $DEPLOY_DIR
