prometheus-starter -
------------------

This project shows how Prometheus instrumentation can be done in a Spring boot project.

Multiple REST endpoints are exposed in this Spring Boot application and performance matrics are scrapped by Prometheus. These metrics are available at  http://localhost:8080/prometheus.


This needs to be added as a maven dependency to an existing spring-boot application -

<dependency>
  <groupId>com.greenfield</groupId>
	<artifactId>prometheus-starter</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>
