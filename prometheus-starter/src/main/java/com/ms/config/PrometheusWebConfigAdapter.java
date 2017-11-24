package com.ms.config;



import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ms.interceptors.PromRequestInterceptor;
import com.ms.interceptors.PromTimingInterceptor;

/**
@author nakuls
*/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.amdocs.opensource")
@ConditionalOnWebApplication
@AutoConfigureAfter
public class PrometheusWebConfigAdapter extends WebMvcConfigurerAdapter {

//	private List<HandlerInterceptorAdapter> interceptors;

	public PrometheusWebConfigAdapter() {
		System.out.println("WebConfig Init here");
	}

/*	public WebConfig(List<HandlerInterceptorAdapter> interceptors) {
		System.out.println("WebConfig Init here - parameterized");
		this.interceptors = interceptors;
	}*/

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("Registering interceptors..");
		registry.addInterceptor(new PromRequestInterceptor());
		registry.addInterceptor(new PromTimingInterceptor());

/*		if (this.interceptors != null) {
			for (HandlerInterceptorAdapter interceptor : this.interceptors) {
				registry.addInterceptor(interceptor);
			}
		}*/
	}

}
