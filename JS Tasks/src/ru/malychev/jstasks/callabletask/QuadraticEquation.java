package ru.malychev.jstasks.callabletask;

import java.util.concurrent.Callable;

public class QuadraticEquation implements Callable<Double[]> {
	double a, b, c;

	QuadraticEquation(double[] coefficients) {
		this.a = coefficients[0];
		this.b = coefficients[1];
		this.c = coefficients[2];
	}

	@Override
	public Double[] call() throws NegativeDecrementException {
		double dec = b * b - 4 * a * c;
		Double[] squareRoots;
		if (dec < -0.e-10) throw new NegativeDecrementException();
		else if (dec >= -0.e-10 && dec <= 0.e-10) {
			squareRoots = new Double[1];
			squareRoots[0] = -b / (2 * a);
		} else {
			dec = Math.sqrt(dec);
			squareRoots = new Double[2];
			squareRoots[0] = (-b + dec) / (2 * a);
			squareRoots[1] = (-b - dec) / (2 * a);
		}
		return squareRoots;
	}
}
