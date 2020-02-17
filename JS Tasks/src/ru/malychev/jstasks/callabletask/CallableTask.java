package ru.malychev.jstasks.callabletask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableTask {

	public static void main(String[] args) {

		int poolCount = 10;
		double[] coefficients = {1, 2, -3};
		List<Thread> threadPool = new ArrayList<>();

		Callable<Double[]> quadraticEquation = new QuadraticEquation(coefficients);
		Task<Double[]> SquareRoots = new Task<>(quadraticEquation);

		for (int i =0; i < poolCount; i++) {
			Thread thread = new Thread( () -> {
				Double[] result = SquareRoots.get();
				if (result != null) {
					System.out.println("Корни квадратного уравнения: " + Arrays.toString(result));
				}
			});
			thread.setName("Поток №" + i);
			threadPool.add(thread);
		}

		for (Thread thread : threadPool) thread.start();

		for (Thread thread : threadPool) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Основной поток " + Thread.currentThread().getName() + " завершил работу.");
	}
}
