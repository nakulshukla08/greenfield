package com.ms.metrics;

public abstract class Histogram {

	
static class Builder{
		
		


		public Histogram build()
		{
			//evaluate a condition here 
			return new PrometheusHistogram();
		}
	}
	
}


/**
nakuls
*/