prometheus-starter -
------------------

This project is an abstraction layer over any application monitoring apis. Presently the support is provided for Prometheus. Wrapper metrics are provided which internally use Prometheus metrics (instrumentation).

Users need to provide following property in monitoring.properties file which should be present at class path.

monitoring.scheme=prometheus


In order to create new metrics, use the factory class - MetricsProvider. For example -

private static final Counter requestTotal = MetricsProvider.createCounter().addLabels("method", "handler", "status").addName("http_requests_total")
														.addHelpText("Http Request Total").build();
			
Metrics are published through spring actuator custom endpoint ("/prometheus") on management port. These metrics are available at  http://{host}:{managementPort}/prometheus.


This needs to be added as a maven dependency to an existing spring-boot application -

<dependency>
  <groupId>com.greenfield</groupId>
	<artifactId>prometheus-starter</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>
