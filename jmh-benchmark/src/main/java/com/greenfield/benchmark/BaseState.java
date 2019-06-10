package com.greenfield.benchmark;

public class BaseState {
	
	protected double[] array;
	private int size;

	public void setSize(int size) {
		this.size = size;
	}

	protected double[] generateArray() {
		if (size <= 0 || size > Integer.MAX_VALUE)
			return null;

		double[] result = new double[size];
		for (int i = 0; i < size; i++)
			result[i] = Math.random();

		return result;
	}

}
