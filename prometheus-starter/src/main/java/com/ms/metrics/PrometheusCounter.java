package com.ms.metrics;

import io.prometheus.client.Counter.Child;

public class PrometheusCounter extends Counter {

	private io.prometheus.client.Counter requestTotal;
	
	public PrometheusCounter(String name, String helpText,String... labels) {
		super(name, labels, helpText);
		// TODO Auto-generated constructor stub
	}

	public Child labels(String... labels)
	{
		if(requestTotal == null)
		{
			throw new IllegalStateException("Counter is not registered before calling method : labels");
		}
		
		 return requestTotal.labels(labels);
		
	}
	
	@Override
	public void inc() {
		// TODO Auto-generated method stub
		if(requestTotal == null)
		{
			throw new IllegalStateException("Counter is not registered before calling method : inc");
		}
		requestTotal.inc();

	}
	

	@Override
	public void reset() {

		if(requestTotal == null)
		{
			throw new IllegalStateException("Counter is not registered before calling method : reset");
		}
		requestTotal.clear();

	}

	@Override
	public void register() {
		requestTotal = io.prometheus.client.Counter.build().name(name)
				.labelNames(labels).help(helpText).register();
	}

	@Override
	public void labelAndInc(String... labels) {
		// TODO Auto-generated method stub
		labels(labels).inc();
	}
	
	

}


/**
nakuls
*/