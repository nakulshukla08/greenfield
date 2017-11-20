package com.amdocs.ms.config;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.management.MalformedObjectNameException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.amdocs.ms.jmx.copy.JmxCollector;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.spring.boot.SpringBootMetricsCollector;

@Configuration
@ConditionalOnClass(CollectorRegistry.class)
public class PrometheusConfiguration {

	//@Value(value = "classpath:prometheus-config.yaml")
	//private Resource configYaml;

	@Bean
	@ConditionalOnMissingBean
	CollectorRegistry metricRegistry() {
		System.out.println("CollectorRegistry intializes..");
		File file;
		CollectorRegistry reigstry = null;
		try {
			// file = new ClassPathResource("prometheus-config.yaml").getFile();
			JmxCollector jmxCollector;

			jmxCollector = new JmxCollector("---");

			reigstry = CollectorRegistry.defaultRegistry;
			reigstry.register(jmxCollector);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reigstry;
	}

	@Bean
	ServletRegistrationBean registerPrometheusExporterServlet(CollectorRegistry metricRegistry) {
		System.out.println("Registering prometheus endpoint..");
		return new ServletRegistrationBean(new MetricsServlet(metricRegistry), "/prometheus");
	}

	@Bean
	@ConditionalOnMissingBean(SpringBootMetricsCollector.class)
	public SpringBootMetricsCollector springBootMetricsCollector(Collection<PublicMetrics> publicMetrics) {
		System.out.println("springBootMetricsCollector initializes..");

		SpringBootMetricsCollector springBootMetricsCollector = new SpringBootMetricsCollector(publicMetrics);

		springBootMetricsCollector.register();
		return springBootMetricsCollector;
	}

}