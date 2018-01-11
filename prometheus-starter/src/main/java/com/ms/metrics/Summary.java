package com.ms.metrics;

public abstract class Summary {

	static class Builder{
		
	

		public Summary build()
		{
			//evaluate a condition here 
			return new PrometheusSummary();
		}
	}
}


/**
nakuls
*/