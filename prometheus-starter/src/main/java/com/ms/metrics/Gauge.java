package com.ms.metrics;

public abstract class Gauge extends Metrics{

	
	static class Builder{
		
		


		public Gauge build()
		{
			//evaluate a condition here 
			return new PrometheusGauge();
		}
	}
}


/**
nakuls
*/