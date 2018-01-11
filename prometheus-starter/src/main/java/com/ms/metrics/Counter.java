package com.ms.metrics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.ms.util.Utility;

/**
 * nakuls
 */
public abstract class Counter extends Metrics{

	protected String name;

	protected String[] labels;
	protected String helpText;

	public Counter(String name, String[] labels, String helpText) {
		super();
		this.name = name;
		this.labels = labels;
		this.helpText = helpText;
	}

	// public abstract Counter labels(String... labels);

	public abstract void inc();

	public abstract void reset();

	public abstract void register();

	public abstract void labelAndInc(String... labels);

	public static class Builder extends AbstractBuilder {
		private String name = "";
		private String[] labels = new String[] {};
		private String helpText = "";
		

	

		public Builder addName(String name) {
			this.name = name;
			return this;
		}

		public Builder addLabels(String... labels) {

			this.labels = labels;

			return this;
		}

		public Builder addHelpText(String helpText) {
			this.helpText = helpText;
			return this;
		}

		public Counter build() {
			Counter counter = null;
			try {
				monitoringScheme = Utility.getInstance().getPropertyValueForKey("monitoring.scheme");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (monitoringScheme != null && monitoringScheme.equals("prometheus")) {
				System.out.println("Loading prometheus counter");
				counter = new PrometheusCounter(this.name, this.helpText, this.labels);
				counter.register();
			} else {
				System.out.println("no monitoring scheme");
			}
			return counter;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((helpText == null) ? 0 : helpText.hashCode());
		result = prime * result + Arrays.hashCode(labels);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		if (helpText == null) {
			if (other.helpText != null)
				return false;
		} else if (!helpText.equals(other.helpText))
			return false;
		if (!Arrays.equals(labels, other.labels))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
