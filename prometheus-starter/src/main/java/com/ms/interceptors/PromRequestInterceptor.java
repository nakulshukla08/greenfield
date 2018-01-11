package com.ms.interceptors;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ms.metrics.Counter;
import com.ms.metrics.MetricsProvider;

import io.prometheus.client.CollectorRegistry;

/**
@author nakuls
*/

@Component
@ConditionalOnClass(CollectorRegistry.class)
public class PromRequestInterceptor extends HandlerInterceptorAdapter {

	// @formatter:off
	// Note (1)
	private static final Counter requestTotal = /*Counter.build().name("http_requests_total")
			.labelNames("method", "handler", "status").help("Http Request Total").register();*/
			MetricsProvider.createCounter().addLabels("method", "handler", "status").addName("http_requests_total").addHelpText("Http Request Total").build();
	// @formatter:on

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		
		System.out.println("request interceptor");
		// Update counters
		String handlerLabel = handler.toString();
		// get short form of handler method name
		if (handler instanceof HandlerMethod) {
			Method method = ((HandlerMethod) handler).getMethod();
			handlerLabel = method.getDeclaringClass().getSimpleName() + "." + method.getName();
		}
		// Note (2)
		requestTotal.labelAndInc(request.getMethod(), handlerLabel, Integer.toString(response.getStatus()));
	}
}