package ru.malychev.jstasks.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class ThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int maxTasks = 15;

		List<Callable<String>> callableList = new ArrayList<>();
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

			Stream.iterate(0,
				count -> ++count)
				.map(count -> {
					return (Callable<String>) () -> {
						String taskName = "Задача №: " + count;
						try {
							Thread.sleep((long) (Math.random() * 5000));
							System.out.println(taskName + " запущена в потоке " + Thread.currentThread().getName());
							Thread.sleep((long) (Math.random() * 10000));
							System.out.println("Я " + taskName + ". Продолжаю работать в потоке " + Thread.currentThread().getName());
							Thread.sleep((long) (Math.random() * 5000));
						} catch (InterruptedException e) {
							System.out.println(taskName + " была прервана.");
						}
						System.out.println(taskName + " успешно завершена.");
						return taskName + " успешно завершена.";
					};
				})
				.limit(maxTasks)
				.forEach(callableList::add);

		List<Future<String>> resultsEndOfTask = threadPool.invokeAll(callableList);
		threadPool.shutdown();
		System.out.println("=====================================================");
		for (Future<String> resultTask : resultsEndOfTask)
			System.out.println(resultTask.get());
	}
}
