package ru.malychev.jstasks.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
		int maxTasks = 15;
		ExecutorService threadPool = Executors.newCachedThreadPool();

		for (int i = 0; i < maxTasks; i++) {
			final int count = i;
			threadPool.execute (() -> {
				System.out.println("Задача №: " + count + " запущена в потоке " + Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
				} catch (InterruptedException e) {
					System.out.println("Работа задачи №: " + count + " была прервана.");
				}
				System.out.println("Я задача №: " + count + ". Продолжаю работать.");
				try {
					TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
				} catch (InterruptedException e) {
					System.out.println("Работа задачи №: " + count + " была прервана.");
				}
				System.out.println("Задача №: " + count + " успешно завершена.");
			});

		}
		threadPool.shutdown();
	}
}
