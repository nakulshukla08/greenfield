package com.ms.metrics;


/**
 * nakuls
 */


public class MetricsProvider {

	
	public  static Counter.Builder createCounter() {
		return new Counter.Builder();
	}
	
	public static Gauge.Builder createGauge() {
		return new Gauge.Builder();
	}
	
	public static Summary.Builder createSummary() {
		return new Summary.Builder();
	}
	
	public static Histogram.Builder createHistogram() {
		return new Histogram.Builder();
	}

}
