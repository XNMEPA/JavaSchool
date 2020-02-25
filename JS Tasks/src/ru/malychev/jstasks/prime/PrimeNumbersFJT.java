package ru.malychev.jstasks.prime;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class PrimeNumbersFJT extends RecursiveAction {

	private int indexNextPrime;
	private static boolean[] primeNumbers;

	public static void initialize(int lastPrimaryNumber) {
		primeNumbers = new boolean[lastPrimaryNumber];
		Arrays.fill(primeNumbers, true);
	}

	PrimeNumbersFJT() {
		this(0);
	}

	PrimeNumbersFJT(int indexNextPrime) {
		this.indexNextPrime = indexNextPrime;
	}

	public static boolean[] getPrimeNumbers() {
		return primeNumbers;
	}

	@Override
	protected void compute() {
		for (; indexNextPrime < primeNumbers.length; indexNextPrime++)
			if (primeNumbers[indexNextPrime]) break;

		int primeNumber = indexNextPrime + 2;

		if (primeNumber * primeNumber < primeNumbers.length) {

			invokeAll(new PrimeNumbersFJT(++indexNextPrime));

			for (int i = primeNumber * primeNumber - 2; i < primeNumbers.length; i += primeNumber)
				primeNumbers[i] = false;
		}
	}
}
