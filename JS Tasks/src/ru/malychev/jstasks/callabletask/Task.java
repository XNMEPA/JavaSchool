package ru.malychev.jstasks.callabletask;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class Task<T> {

	private Callable<? extends T> callable;
	private Semaphore semaphore;
	private volatile T result = null;
	private boolean isInterrupted = false;

	public Task(Callable<? extends T> callable) {
		this.callable = callable;
		this.semaphore = new Semaphore(1);
	}

	public T get() {
		String currentThread = Thread.currentThread().getName();
		System.out.println(currentThread + " запускает процесс рассчета задачи.");

		if (result != null) {
			System.out.println(currentThread + " сообщает, что результат уже расчитан.");
			System.out.println(currentThread + " возращает ранее расчитанный результат.");
			System.out.println(currentThread + " завершил работу.");
			return result;
		}
		if (!isInterrupted) {
			try {
				System.out.println(currentThread + " ожидает разрешение на проведение расчетов.");
				semaphore.acquire();
				if (!isInterrupted) {
					System.out.println(currentThread + " получил разрешение на проведение расчета.");

					if (result != null) {
						System.out.println(currentThread + " сообщает, что результат уже был расчитан предыдущим потоком во время ожидания.");
						System.out.println(currentThread + " возращает ранее расчитанный результат.");
						System.out.println(currentThread + " завершил работу.");
						semaphore.release();
						return result;
					}

					System.out.println(currentThread + " выполняет расчет.");
					try {
						result = this.callable.call();
					} catch (Exception e) {
						if (e.getClass() == NegativeDecrementException.class) {
							System.err.println(currentThread + " сгенерировал исключение " + e.toString());
							System.out.println(currentThread + " был прерван.");
							System.err.println("Все потоки исполнения прерваны!");
							isInterrupted = true;
							semaphore.release();
							return result;
						} else e.printStackTrace();
					}

					System.out.println(currentThread + " выполнил расчет.");

				} else {
					System.out.println(currentThread + " был прерван.");
					semaphore.release();
					return result;
				}

			} catch (InterruptedException e) {
				System.err.println("Произошло прерывание " + currentThread + ".");
				e.printStackTrace();
			}

			System.out.println(currentThread + " возращает результат расчета.");
			System.out.println(currentThread + " завершил работу.");
			semaphore.release();

		} else {
			System.out.println(currentThread + " был прерван.");
			return result;
		}
		return result;
	}
}
