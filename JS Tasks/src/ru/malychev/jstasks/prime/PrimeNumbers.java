package ru.malychev.jstasks.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public static List<Integer> getPrimeNumbers(int numberLimit) {
		List<Integer> primeNumbers = new ArrayList<>();
		int firstPrimaryNumber = 2;
		primeNumbers.add(firstPrimaryNumber);

		return getPrimeNumbers(3, numberLimit, primeNumbers);
	}

	public static List<Integer> getPrimeNumbers(int count, int numberLimit, List<Integer> primeNumbers) {
		if (count > numberLimit) return primeNumbers;

		int lastDivider = count / 2;
		int indexLastDivider = 0;

		for (int i = lastDivider; i > 2; i--)
			if ((indexLastDivider = primeNumbers.indexOf(i)) != -1) break;

		for (int i = 0; i <=  indexLastDivider; i++) {
			if (count % primeNumbers.get(i) == 0) break;
			if (i == indexLastDivider) primeNumbers.add(count);
		}
		return getPrimeNumbers(++count, numberLimit, primeNumbers);
	}

	public static void main(String[] args) {
		int lastPrimaryNumber = 5000;
		List<Integer> primeNumbers;

		long beginRunTime = System.nanoTime();
		primeNumbers = getPrimeNumbers(lastPrimaryNumber);
		long endRunTime = System.nanoTime();

		System.out.println("Однопоточный расчет.");
		System.out.print("Перечень простых чисел до " + lastPrimaryNumber + " включительно.");
		for (int i = 0; i < primeNumbers.size(); i++) {
			if (i % 20 == 0) System.out.println();
			System.out.print(primeNumbers.get(i) + "   \t");
		}
		System.out.println("\nВсего чисел " + primeNumbers.size() + ".");
		System.out.println("Расчет проведен за " + (endRunTime - beginRunTime) + " наносекунд.");

		beginRunTime = System.nanoTime();
		PrimeNumbersFJT.initialize(lastPrimaryNumber);
		new PrimeNumbersFJT().invoke();
		endRunTime = System.nanoTime();

		System.out.println("\n====================================================\n");
		System.out.println("Многопоточный расчет с использованием Fork/Join API.");
		boolean[] primeNumbersFJT = PrimeNumbersFJT.getPrimeNumbers();
		System.out.print("Перечень простых чисел до " + lastPrimaryNumber + " включительно.");
		int count = 0;
		for (int i = 0; i < primeNumbersFJT.length; i++) {
			if (!primeNumbersFJT[i]) continue;

			if (count++ % 20 == 0) System.out.println();
			System.out.print(i+2 + "   \t");
		}
		System.out.println("\nВсего чисел " + count + ".");
		System.out.println("Расчет проведен за " + (endRunTime - beginRunTime) + " наносекунд.");

	}
}
