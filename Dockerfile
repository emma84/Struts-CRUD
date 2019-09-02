FROM jboss/wildfly:latest

COPY /target/DanmarSellSystem.war /opt/jboss/wildfly/standalone/deployments/

ENV JAVA_OPTS='-Xms64m -Xmx512m -XX:MaxPermSize=256m -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=org.jboss.byteman -Djava.awt.headless=true -agentlib:jdwp=transport=dt_socket,address=0.0.0.0:8787,server=y,suspend=n'

EXPOSE 8787

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug"]